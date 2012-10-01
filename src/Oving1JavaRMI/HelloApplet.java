package Oving1JavaRMI;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class HelloApplet extends JApplet {
	boolean isStandalone = false;
	String message = "blank";
	// "obj" is the identifier that we'll use to refer
	// to the remote object that implements the "Hello"
	// interface
	Hello obj = null;

	// Get a parameter value
	public String getParameter(String key, String def) {
		return isStandalone ? System.getProperty(key, def)
				: (getParameter(key) != null ? getParameter(key) : def);
	}

	// Construct the applet
	public HelloApplet() {
	}

	// Initialize the applet
	public void init() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		this.setSize(new Dimension(400, 300));
		// obj = (Hello)Naming.lookup("//localhost"
		obj = (Hello) Naming.lookup("//" + getCodeBase().getHost()
				+ "/HelloServer");
		message = obj.sayHello();
		
		Person p = new Person("Arne er en Klient");
		obj.personTest(p);
		message = p.getName();
		System.out.println(p.getName());
		
	}

	public void paint(Graphics g) {
		g.drawString(message, 25, 50);
	}

	// Get Applet information
	public String getAppletInfo() {
		return "Applet Information";
	}

	// Get parameter info
	public String[][] getParameterInfo() {
		return null;
	}

	// static initializer for setting look and feel
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel
			// (UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
	}
}
