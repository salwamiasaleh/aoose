/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Abdullah
 */
public class Contractor_Class extends UnicastRemoteObject implements Contractor_Interface {
    public int ID;
public ArrayList<Client> client = new ArrayList<>();  // Create an ArrayList object
public ArrayList<Trips> trips = new ArrayList<>();
public Transporter transport;
 public String name;
 public ArrayList<Client_Observer> observers;
public Contractor_Class() throws RemoteException{
    try {
        DB db = new DB();
        client = new ArrayList<>();
        observers = new ArrayList<>();
        ArrayList<Client> observers_tmp = db.getclients();
        for (Client object : observers_tmp) {
           observers.add(object);
        }
} catch (Exception e) {
    
    
}
}
public Contractor_Class(int id) throws RemoteException{
    try {

        this.ID = id;
         DB db = new DB();
        client = new ArrayList<>();
        observers = new ArrayList<>();
        ArrayList<Client> observers_tmp = db.getclients();
        System.out.println(observers_tmp.size());
        for (Client object : observers_tmp) {
                System.out.println(object.client_id);

           observers.add(object);
        }
                        


} catch (Exception e) {
            System.out.println(e.getMessage());

    
}
}
//+acceptOffers():void
    @Override
    public void setTrips(Trips trip) throws RemoteException{
    System.out.println("heloooooo Exception occured");
DB db = new DB();
db.set_collection("trips");
db.ADD_Trip(trip);
    this.send_notifications(trip.ID);
}
    
@Override 
public ArrayList<Trips> getTrips() throws RemoteException{
        
        DB db = new DB();
        db.set_collection("trips");
        return db.gettrips();
        
        
        }

    @Override
    public int get_id() throws RemoteException{
  return this.ID;
    
}
    @Override
         public Trips getTrips(int id) throws RemoteException{
              DB db = new DB();
               db.set_collection("trips");
                  return db.gettripByid(id);

         }
    @Override
        public void delete_trip(int id) throws RemoteException{
        
         DB db = new DB();
               db.set_collection("trips");
                  db.delete_trip(id);
        
        }
    @Override
            public void Add_contractor(Contractor_Class con) {
              DB db = new DB();
               db.set_collection("contractor");
                  db.Add_contractorDB(con);   
            }

//+getTrips:Trips
//+getTransport:Transporter
//+setTransport(transport
//Transporter):void
//+setID:int
//+setTime:int
////+setDate:int
//public int getID(){
//return ID;
//}
//+getDate():int
//+getTime():int


    @Override
    public ArrayList<Client_> get_clients() throws RemoteException{
    
    
     DB db = new DB();
               db.set_collection("client");
                  return db.get_clients();   
    
    
    }
    @Override
    public void add_client(int client_id,int trip_id) throws RemoteException{
    
    
         DB db = new DB();
               db.set_collection("client");
                db.add_client(client_id,trip_id);   
    
    
    
    }
@Override
    public void remove_client(int client_id,int trip_id) throws RemoteException{
    
    
    DB db = new DB();
    db.set_collection("client");
    db.remove_client(client_id, trip_id);
    
    
    }
    @Override
    public ArrayList<feedback>  get_feedback(int trip_id) throws RemoteException{
        System.out.println("got trips2.");
    DB db = new DB();
    db.set_collection("feedbacks");
   return db.get_feedbacks(trip_id);
    
    
    
    }
    @Override
    public void send_notifications(int trip_id) throws RemoteException{
    
        for (Client_Observer observer : observers) {
               
        System.out.println(observer.get_id());

            observer.update(trip_id);
        }
    
    }

}
