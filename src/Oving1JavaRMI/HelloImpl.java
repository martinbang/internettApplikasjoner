/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */
package Oving1JavaRMI;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	public HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		return "Hei på deg!";
	}
	
	@Override
	public Person personTest(Person p) throws RemoteException {
		// TODO Auto-generated method stub
		p.setName("Server");
		System.out.println(p.getName());
		return p;
		
		
		//return p.getName();
	}
	
	

	public static void main(String args[]) {
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			HelloImpl obj = new HelloImpl();
			Naming.rebind("//localhost/HelloServer", obj);
			System.out.println("HelloServer is bound in registry");
		} catch (Exception e) {
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}

	

	
}
