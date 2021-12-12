/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Abdullah
 */
public class Contractor extends UnicastRemoteObject {
    private static Contractor con;
    private Contractor_Interface c  ;
      private Contractor()  throws RemoteException{
          
          

      }
public Contractor_Interface getContract() throws RemoteException{

return c;
}
public void setContract(Contractor_Class con) throws RemoteException{

   try {
       if(c == null)
       c = new Contractor_Class() ;
        c = con;
        } catch (Exception ex) {
           System.out.println("Exception occured");
           System.out.println(ex.getLocalizedMessage().toString());
        }   

}
public static Contractor getContractor()throws RemoteException{
    
    
      try {
       if(con == null)
           con = new Contractor();
           

           
           return con;
           } catch (Exception ex) {
           System.out.println("Exception occured");
           System.out.println(ex.getLocalizedMessage().toString());
        }   
           return con;

}
}
