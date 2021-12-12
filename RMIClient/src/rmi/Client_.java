/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Abdullah
 */
public class Client_  implements Serializable{
    public int client_id;
 public   ArrayList<Trips> trips;
  public   ArrayList<payment> payments;
public String ussr_name;


    
}
