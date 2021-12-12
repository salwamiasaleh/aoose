/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

/**
 *
 * @author Abdullah
 */
public class Notification implements Serializable{
    
    int client_id;
    int trip_id;
    String msg;
    
    
    
}
