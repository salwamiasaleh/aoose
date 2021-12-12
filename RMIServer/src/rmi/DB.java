/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * 
 */
public class DB {
    

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("BUE"); // Database name
        collection = database.getCollection("srs"); // Collection name
    }
    public void set_collection(String c){
      this.collection = database.getCollection(c);   
    }
//
//    public void insertStudent(Student s) {
//        collection.insertOne(Document.parse(gson.toJson(s)));
//        System.out.println("Student inserted.");
//    }

    public void deleteStudent(String email) {
        collection.deleteOne(Filters.eq("email", email));
    }
    public void ADD_Trip(Trips trip) {
        //collection.deleteOne(Filters.eq("email", email));
        
        collection.insertOne(Document.parse(gson.toJson(trip)));
       System.out.println("trip inserted.");
        
    }
    public Trips gettripByid(int id) {
               System.out.println("getting trip.");

        Document doc = collection.find(Filters.eq("ID", id)).first();
        Trips result = gson.fromJson(doc.toJson(), Trips.class);
                       System.out.println("got trip.");

        return result;
    }
    public void delete_trip(int id) {
               System.out.println("Deleting trip.");

              collection.deleteOne(Filters.eq("ID", id));
               System.out.println("trip Deleted.");

    }
    
    
    public void insert_notification(Notification not){
    
      
        collection.insertOne(Document.parse(gson.toJson(not)));
       System.out.println("notification inserted.");
    
    }
   
    
     public void add_Client(Client_Observer ct){
    
         set_collection("client");
        collection.insertOne(Document.parse(gson.toJson(ct)));
       System.out.println("Client inserted.");
    
    }
    
    public ArrayList<Trips> gettrips() {
               System.out.println("getting trip.");
               
               
               ArrayList<Trips> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Trips.class));
        }
        System.out.println("got trips.");
        return result;
       
                       

    }
    public ArrayList<Client_> get_clients() {
               System.out.println("getting trip.");
               
               
               ArrayList<Client_> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Client_.class));
        }
        System.out.println("got trips.");
        return result;
       
                       

    }
    public ArrayList<Notification> get_notifications(int client_id) {
               System.out.println("getting trip.");
               
               
               ArrayList<Notification> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("client_id", client_id)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Notification.class));
        }
        System.out.println("got trips.");
        return result;
       
                       

    }
    public ArrayList<Client> getclients() {
               System.out.println("getting trip.");
               
               this.set_collection("client");
               ArrayList<Client> result = new ArrayList<>();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        System.out.println(docs.size());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Client.class));
        }
        System.out.println("got trips.");
        return result;
       
                       

    }
    public ArrayList<feedback> get_feedbacks(int trip_id) {
               System.out.println(trip_id);
               
               
               ArrayList<feedback> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("trip_id", trip_id)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), feedback.class));
        }
        System.out.println("got trips2.");
        return result;
       
                       

    }
       public ArrayList< Trips >get_u_trips(int id ) {
         
               System.out.println("getting user trip.");
               

         Document doc = collection.find(Filters.eq("client_id", id)).first();
                       System.out.println("getting user trip.");

           Client result=gson.fromJson(doc.toJson(), Client.class);
        System.out.println("got trips.");
        return result.trips;
       
                       

    }
    
    public void settrip(int client_id,Trips trip,payment pay) {
try{
    
      

        Document doc = collection.find(Filters.eq("client_id", client_id)).first();
         System.out.println("booking trip.");
        Client result = gson.fromJson(doc.toJson(), Client.class);
     result.payments.add(pay);
     result.trips.add(trip);// result;
            System.out.println("booking trip.");

           Document   doc3 = Document.parse(gson.toJson(result));
          
             collection.replaceOne(Filters.eq("client_id", client_id), doc3);
        System.out.println("trip booked.");
}catch(Exception e){
            System.out.println(e.getMessage());

    
}
  }
    
    
    public void add_client(int client_id,int trip_id) {
try{
    this.set_collection("trips");
        Document doc = collection.find(Filters.eq("ID", trip_id)).first();
         System.out.println("booking trip.");
        Trips trip = gson.fromJson(doc.toJson(), Trips.class);
    this.set_collection("client");

         doc = collection.find(Filters.eq("client_id", client_id)).first();
         System.out.println("booking trip.");
        Client result = gson.fromJson(doc.toJson(), Client.class);
   //  result.payments.add(pay);
     result.trips.add(trip);// result;
            System.out.println("booking trip.");

           Document   doc3 = Document.parse(gson.toJson(result));
          
             collection.replaceOne(Filters.eq("client_id", client_id), doc3);
        System.out.println("trip booked.");
}catch(Exception e){
            System.out.println(e.getMessage());

    
}
  }
 public void Add_contractorDB(Contractor_Class con){
 collection.insertOne(Document.parse(gson.toJson(con)));
       System.out.println("Contractor inserted.");
 }   
    
    void Add_feedbDB(feedback con) {
        collection.insertOne(Document.parse(gson.toJson(con)));
       System.out.println("feedback inserted.");
    }
public void remove_client(int client_id,int trip_id){

try{
 

       Document  doc = collection.find(Filters.eq("client_id", client_id)).first();
         System.out.println("booking trip.");
        Client result = gson.fromJson(doc.toJson(), Client.class);
   //  result.payments.add(pay);
   //  result.trips.add(trip);// result;
            System.out.println("booking trip.");
            for (int i = 0; i < result.trips.size(); i++) {
        if(result.trips.get(i).ID == trip_id){
        result.trips.remove(i);
        }
    }
            for (int i = 0; i < result.payments.size(); i++) {
        if(result.payments.get(i).pay_id == String.valueOf(trip_id )+ String.valueOf(client_id)){
        result.trips.remove(i);
        }
    }

           Document   doc3 = Document.parse(gson.toJson(result));
          
             collection.replaceOne(Filters.eq("client_id", client_id), doc3);
        System.out.println("trip booked.");
}catch(Exception e){
            System.out.println(e.getMessage());

    
}


}
//
//    public Student getStudentByMail(String email) {
//        Document doc = collection.find(Filters.eq("email", email)).first();
//        Student result = gson.fromJson(doc.toJson(), Student.class);
//        return result;
//    }
//
//    public ArrayList<Student> getStudentsByYear(int year) {
//        ArrayList<Student> result = new ArrayList();
//        ArrayList<Document> docs = collection.find(Filters.eq("year", year)).into(new ArrayList<Document>());
//        for (int i = 0; i < docs.size(); i++) {
//            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
//        }
//        return result;
//    }
//
//    public ArrayList<Student> getStudentsByYearLT(int year) {
//        ArrayList<Student> result = new ArrayList();
//        ArrayList<Document> docs = collection.find(Filters.lt("year", year)).into(new ArrayList<Document>());
//        for (int i = 0; i < docs.size(); i++) {
//            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
//        }
//        return result;
//    }
//
//    public ArrayList<Student> getStudentsByCourse(String courseID) {
//        ArrayList<Student> result = new ArrayList();
//        ArrayList<Document> docs = collection.find(Filters.eq("courses.courseID", courseID)).into(new ArrayList<Document>());
//        for (int i = 0; i < docs.size(); i++) {
//            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
//        }
//        return result;
//    }
//
//    public ArrayList<Student> getAllStudents() {
//        ArrayList<Student> result = new ArrayList();
//        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
//        for (int i = 0; i < docs.size(); i++) {
//            result.add(gson.fromJson(docs.get(i).toJson(), Student.class));
//        }
//        return result;
//    }
//
//    public void updateStudent(Student s) {
//        Document doc = Document.parse(gson.toJson(s));
//        collection.replaceOne(Filters.eq("email", s.getEmail()), doc);
//    }

    public void close() {
        client.close();
    }
    public  void send_notification(int client_id,String msg,int trip_id) {
        
        Notification not = new Notification();
        not.client_id = client_id;
        not.msg = msg;
        not.trip_id = trip_id;
          collection.insertOne(Document.parse(gson.toJson(not)));
       System.out.println("feedback inserted.");
    }
    

}
