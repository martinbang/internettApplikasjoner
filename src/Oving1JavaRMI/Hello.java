/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */
package Oving1JavaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	
	String sayHello() throws RemoteException;
	Person personTest(Person p) throws RemoteException;
}