/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.sql.*;
import java.util.Random;
import Category.ClsCategory;
import db.ConnectionProvider;
import Zone.clsZone;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author apple
 */
public class CollectionDAO {
    Date currentDate; //set LocalDateTime.now()
    String collectionID; //assign random double number
    double amount; //
    String category;
    String zone;
    
    
    Random random = new Random();
    String query = "";
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    
    clsZone zones;
    ClsCategory categories;
    
    CollectionDAO(){
        con = ConnectionProvider.getCon();
        zones = new clsZone();
        categories = new ClsCategory();
    }
   
   
    public ResultSet ZoneValues()
    {
       return zones.Loader();
    }
    
    
    String officer;
    public String getZoneIncharge(String zoneName){
        //String name = "";
        try {
            query = "Select incharge from ZONE where name = '"+zoneName+"'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                officer = rs.getString("incharge");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return officer;
    }
    
    //String zoneID;
    public String getZoneID(String zoneName){
        //String name = "";
        try {
            query = "Select ID from ZONE where name = '"+zoneName+"'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                zone = rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zone;
    }
    
    public String UpdateTypeAmount(double bioDG, double nonBDG){
            double current1 = 0.0;
            double current2 = 0.0;
            String msg = "";
        try {
            query = "Select Amount from TYPE where ID = 1";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                current1 = rs.getDouble("Amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            query = "Select Amount from TYPE where ID = 2";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                current2 = rs.getDouble("Amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        current1 += (current1 + bioDG);
        current2 +=(current2 + nonBDG);
        
        try {
             query = "update TYPE set Amount = '"+current1+"' where ID = 1";
             pst = con.prepareStatement(query);
             pst.executeUpdate();
              msg = "BD Updated successfully";
             
        }
        catch(Exception e){
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, e);
            msg = "Unable update BD";
        }
        
        try {
             query = "update TYPE set Amount = '"+current2+"' where ID = 2";
             pst = con.prepareStatement(query);
             pst.executeUpdate();
              msg = "Updated successfully";
             
        }
        catch(Exception e){
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, e);
            msg = "Unable update";
        }
       
        return msg;
    }
   
    
    public String insertCollection(String zone){
        double nextDouble = random.nextDouble();
        collectionID = String.valueOf(nextDouble);
        
        currentDate = Date.valueOf(LocalDate.now());
        this.amount = amount;
        String msg;
        query ="insert into COLLECTION values('"+currentDate+"','"+collectionID+"','"+zone+"')";
        try {
            pst = con.prepareStatement(query);
            pst.execute();
            msg = "Collection Details Saved Successfully";
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
             msg = "Unable to Save the Collectin Details";
        }
        
        return msg;
    }
    
    public void insertCollectionDetails(String catID, double amount){
        
        query = "insert into collectcate values('"+collectionID+"','"+catID+"','"+amount+"',null)";
       
        try {
            pst = con.prepareStatement(query);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void SearchCollection(){
        
    }
    
    public void UpdateCollection(){
        
    }
    
    public void DeleteCollection(){
        
    }
    
}
