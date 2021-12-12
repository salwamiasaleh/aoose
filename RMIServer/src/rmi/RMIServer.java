/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * 
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            // My remote object [Skeleton]
            Contractor_Interface c = new Contractor_Class(1);
            Client_Observer c2 = new Client(1);
            
//            Client g = new Client();
//             g.client_id = 1;
//             g.payments = new ArrayList<>();
//             g.trips = new ArrayList<>();
//             g.ussr_name = "mhmd";
//             g.add_client(g);


//con.client=new ArrayList<>();
//con.transport=new Transporter();
//con.trips=new ArrayList<>();
//con.name="abdo";
//con.Add_contractor(con);
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            //Add my object to the RMI Registry
            registry.bind("contractor", c);
            registry.bind("client", c2);
            System.out.println("RMI Server is ready...");   
        } catch (Exception ex) {
           System.out.println("Exception occured");
           System.out.println(ex.getLocalizedMessage().toString());
        }   
    }
}

