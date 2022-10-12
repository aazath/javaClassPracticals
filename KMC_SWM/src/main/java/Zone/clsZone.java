package Zone;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import db.ConnectionProvider;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author apple
 */
public class clsZone {
    
    String id;
    String name;
    String location;
    String incharge;
    
    
    Connection con = null;
    PreparedStatement pst = null;
    String query = "";
    ResultSet rs = null;
    
  public ResultSet Loader(){
      query = "Select * from ZONE";
        try {
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(clsZone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
  }
    public String DeleteZone(String id){
        query = "Delete from ZONE where ID ='"+id+"'";
        
        String msg = "";
        try {
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            con.close();
            msg = "Deleted Successfully";
        } catch (SQLException ex) {
            Logger.getLogger(clsZone.class.getName()).log(Level.SEVERE, null, ex);
            msg = "Unable to Delete";
        }
        return msg;
    }
    
    public String UpdateZone(String id, String name,String location, String incharge){
        
        this.name  = name;
        this.location = location;
        this.incharge = incharge;
       
        query = "update ZONE name =?, location =?,incharge=? where ID = '"+id+"'";
        String msg = "";
        
        try {
            con = ConnectionProvider.getCon();
            con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, location);
            pst.setString(3, incharge);
            pst.executeUpdate();
            msg = "Updated Successfully";
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(clsZone.class.getName()).log(Level.SEVERE, null, ex);
            msg = "Unable to Update";
        }
        return msg;
        
    }
}
