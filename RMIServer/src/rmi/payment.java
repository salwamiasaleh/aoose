/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Abdullah
 */
public class payment implements Serializable {
     public int trip_id ;
    public String pay_id ;
    public int amount ;
    public Boolean Visa ;
    public Boolean Cash ;
    
 
}
