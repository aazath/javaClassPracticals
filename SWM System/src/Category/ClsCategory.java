package Category;


import db.ConnectionProvider;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apple
 */

    
 public class ClsCategory {
    private String ID;
    private String Name;
    private String Type;
    private double TodayCollection;
    private Date date; 
    
    
  	String query = "";
        
    	Connection con = ConnectionProvider.getCon();
    	PreparedStatement pst = null;
        ResultSet rs = null;
        String message;
        
        long millis = System.currentTimeMillis();  
        java.sql.Date today =new java.sql.Date(millis); 

     public ResultSet LoadType()
     {
         query = "Select * from TYPE";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return rs;
     }
     
      public ResultSet LoadZone()
     {
         query = "Select * from ZONE";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
     }
      
     public String InstCategory(String ID, String Name, String Type){
       this.ID = ID;
       this.Name=Name;
       this.Type=Type;
       
       
       
        query = "Insert into CATEGORY values(?,?,?)";
        
        try {
            pst = con.prepareStatement(query);
            pst.setString(1,ID);
            pst.setString(2,Name);
            pst.setString(3,Type);
            pst.executeUpdate();
            message = "Successfully Inserted";
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
            message = "Failed to Insert";
        }
        return message;
         
     }
     
     public ResultSet EditCat(String id){
         this.ID = id;
         
         query = "select * from CATEGORY where ID =?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
             return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
         
     }
     
     public String DeleteCat(String id){
         
         query = "Delete from CATEGORY where ID= '"+id+"'";
         
        try {
            pst = con.prepareStatement(query);
           
            pst.executeUpdate();
            message = "Category Deleted Successfully";
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
            message = "Category cannot be deleted";
        }
         return message;
     }
     
     public ResultSet LoadCat(){
        try {
            query = "Select * from CATEGORY";
            rs = pst.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
     }
    
     public String UpdateCat(String Id, String Name, String Type){
        
        this.Name=Name;
        this.Type=Type;
        TodayCollection = 0.0;
       
       
        query = "Update CATEGORY set Name='"+Name+"',Type='"+Type+"' Where ID= '"+Id+"'";
        
        try {
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            message = "Successfully Updated";
        } catch (SQLException ex) {
            Logger.getLogger(ClsCategory.class.getName()).log(Level.SEVERE, null, ex);
            message = "Failed to Update";
        }
        return message;
     }
}

