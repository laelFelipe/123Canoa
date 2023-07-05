/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller.DAO;

/**
 *
 * @author erico
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMVC  {
    
    public Connection getConnection() {
    Connection conn = null;
    
    try{
         Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException e){
         e.printStackTrace();
                
    }
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canoa123?useSSL=false", "root", "Senha123@");
    }catch (SQLException e){
        e.printStackTrace();
    }
    
    
    return conn;
    }

    Connection conectaBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    

