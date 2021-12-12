/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
Contractor_Interface c = (Contractor_Interface) registry.lookup("contractor");
Client_Observer c2 = (Client_Observer) registry.lookup("client");
Client_Observer c3 = (Client_Observer) registry.lookup("client");
//Contractor cont=(Contractor) registry.lookup("Contractor_Class");


            NewJFrame obj = new NewJFrame();
            obj.con = c;
            obj.co = c2;
            //obj.contrc=cont;
            obj.setVisible(true);
                    // Connecting to the RMI Registry created on the server

            // Search for the stub "calc"
            

//c.setTrips(t);
        /*    // Invoke the remote methods on the remote object
            System.out.println("The last result was " + c.getLastResult());
            System.out.println("The new result is " + c.add(5, 2));
            Result r = c.sub(10, 5);
            System.out.println("Sub = " + r.getResult());*/
        } catch (Exception ex) {
            System.out.println("Exception occured");
                       System.out.println(ex.getLocalizedMessage().toString());


        }
    }
}
