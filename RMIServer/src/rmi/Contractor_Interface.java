/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Abdullah
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * 
 */

public interface Contractor_Interface extends Remote {
public void setTrips(Trips trip) throws RemoteException;
public Trips getTrips(int id) throws RemoteException;
public void delete_trip(int id) throws RemoteException;
public void Add_contractor(Contractor_Class con) throws RemoteException;
public int get_id() throws RemoteException;
public ArrayList<Trips> getTrips() throws RemoteException;
    public ArrayList<Client_> get_clients() throws RemoteException;
    public void add_client(int client_id,int trip_id) throws RemoteException;
    public void remove_client(int client_id,int trip_id) throws RemoteException;
    public ArrayList<feedback>  get_feedback(int trip_id) throws RemoteException;
public void send_notifications(int trip_id) throws RemoteException;


}
