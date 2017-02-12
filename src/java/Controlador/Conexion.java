/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dmi99
 */
 public class Conexion {
        private String USERNAME = "root";
        private String PASSWORD = "n0m3l0";
        private String HOST = "localhost";
        private String PORT = "3306";
        private String DATABASE ="bd_potterstore";
        private String CLASSNAME = "com.mysql.jdbc.Driver";
        private String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        private Connection con;
        
        public Conexion() throws SQLException{
            try{
               Class.forName(CLASSNAME);
               con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e){
                System.out.println("ERROR"+e);
            }catch (SQLException e){
                System.out.println("ERROR"+e);
            }
        }
      public Connection getConexion(){
          return con;
      }
      
      public static void main (String[] args) throws SQLException{
          Conexion con = new Conexion ();
      }
}
