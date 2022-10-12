package dbPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author apple
 */
public class dbConnection{
    Connection con;
    PreparedStatement pst;
 public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306?zeroDateTimeBehavior=convertToNull+kmc","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
