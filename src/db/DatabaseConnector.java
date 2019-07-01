/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author anita
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
         public static Connection databaseConnector(){
             try{
                 //the driver class for mysql database is as given below
                 Class.forName("com.mysql.jdbc.Driver");
                 /*The connection URL for the mysql database is as given below where jdbc is the API
                 mysql is the databse, localhost is the srver name on which mysql is running, we may also 
                 use IP address, 3306 is the port number and ElectricShopManagement is the database name*/ 
                 //username and password
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricShopManagement","root","Root!605");
                 System.out.println("Connection Established");
                 return connection;
             }catch(SQLException e){
                 e.printStackTrace();
             }catch(ClassNotFoundException e){
                 e.printStackTrace();
             }
             return null;
         }    
}
