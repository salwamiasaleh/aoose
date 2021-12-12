/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;

/**
 *
 * @author Abdullah
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Client_Observer extends Remote {


    public void setTrips(int trip_id,int client_id,payment pay) throws RemoteException;
    public ArrayList<Trips> getTrips() throws RemoteException;
    public void delete_trip(int id) throws RemoteException;   
    public void SendNotification(Notification not) throws RemoteException;   
     public Trips getTripById(int id) throws RemoteException;
    public void add_client(Client_Observer ct)  throws RemoteException;
             public int get_id()  throws RemoteException;
             public ArrayList<Trips> get_userTrips() throws RemoteException;
public void Add_Feedb(feedback con) throws RemoteException;
public void update(int trip_id) throws RemoteException;
public ArrayList<Notification> get_notifications() throws RemoteException;





}
