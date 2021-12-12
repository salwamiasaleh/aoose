/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Abdullah
 */
public class Client  extends UnicastRemoteObject implements Client_Observer,Serializable{
    public int client_id;
 public   ArrayList<Trips> trips;
  public   ArrayList<payment> payments;
public String ussr_name;

public Client() throws RemoteException{
    try {
        

        
} catch (Exception e) {
    
    
}
}
public Client(int id) throws RemoteException{
    try {
        client_id = id;

        
} catch (Exception e) {
    
    
}
}
    @Override
      public void setTrips(int trip_id,int client_id,payment pay) throws RemoteException{
                  System.out.println("booking.");

          DB db = new DB();
        db.set_collection("trips");
        Trips trip = db.gettripByid(trip_id);
        db.set_collection("client");

        db.settrip(client_id,trip, pay);
          
      }
      
      @Override
    public ArrayList<Trips> getTrips() throws RemoteException{
        
        
  DB db = new DB();
        db.set_collection("trips");
       return db.gettrips();



    }
         @Override
    public ArrayList<Trips> get_userTrips() throws RemoteException{
        
        
  DB db = new DB();
        db.set_collection("client");
                System.out.println(client_id);

       return db.get_u_trips(client_id);

    }
      @Override
    public void delete_trip(int id) throws RemoteException{
    
    
    
}
    
    @Override
        public void SendNotification(Notification not) throws RemoteException{
        
        DB db = new DB();
        db.set_collection("notifications");
        db.insert_notification(not);
        
        
        }   
        
    @Override
         public Trips getTripById(int id) throws RemoteException{
              DB db = new DB();
               db.set_collection("trips");
                  return db.gettripByid(id);

         }
         public void add_client(Client_Observer ct) {
         DB db = new DB();
               db.set_collection("client");
                 db.add_Client(ct);
         }
                 @Override 
         public int get_id(){
                  return client_id;
                  }
        

    @Override
    public void Add_Feedb(feedback con) {
               System.out.println("feedback .");

              DB db = new DB();
               db.set_collection("feedbacks");
                      System.out.println("feedback cont.");

                  db.Add_feedbDB(con);   
            }
    @Override
    public void update(int trip_id) throws RemoteException{
    
    
    DB db = new DB();
    db.set_collection("notifications");
    db.send_notification(this.client_id,"trip has been added with trip_id :",trip_id);
    
    }
    @Override
    public ArrayList<Notification> get_notifications() throws RemoteException{
                System.out.println("got trips.333");

        DB db = new DB();
        db.set_collection("notifications");
        return db.get_notifications(this.get_id());
        
    }

}
