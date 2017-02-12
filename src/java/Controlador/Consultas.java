package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dmi99
 */
 public class Consultas {
        private String USERNAME = "root";
        private String PASSWORD = "n0m3l0";
        private String HOST = "localhost";
        private String PORT = "3306";
        private String DATABASE ="bd_potterstore";
        private String CLASSNAME = "com.mysql.jdbc.Driver";
        private String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        private Connection con;
        
        public Consultas() throws SQLException{
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
      
   public boolean autenticacion (String usuario, String contraseña) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rst = null;
        
        try{
        String consulta = "SELECT * FROM registro where usuario=? and pass=?";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, usuario);
        pst.setString(2, contraseña);
        rst = pst.executeQuery();
        
        if (rst.absolute(1)){
            return true;
        }
        
    }catch(Exception e){
            System.out.println("ERROR"+e);
    }finally{
            try{
               if(pst != null)pst.close();
               if(rst != null)rst.close();
            }catch (Exception e){
                System.err.println("ERROR"+ e);
            }
            
        }
   return false;
 }
   public boolean registrar (String nombre, String apellido, String usuario, String contraseña){
       
       PreparedStatement pst = null;
       
       try{
           String consulta = "INSERT INTO registro (nombre,apellido,usuario,pass) values (?,?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, apellido);
           pst.setString(3, usuario);
           pst.setString(4, contraseña);
                      
           if(pst.executeUpdate() == 1){
               return true;
           }
       }catch(Exception ex){
           System.err.println("ERROR"+ex);
       }finally{
           try{
               if(getConexion() != null) getConexion().close();
               if (pst != null)pst.close();
           }catch(Exception e){
               System.err.println("ERROR"+e);
           }
           
       }
       
       return false;
   }
      public boolean registrarProv (String nombre, String usuario, String contraseña){
       
       PreparedStatement pst = null;
       
       try{
           String consulta = "INSERT INTO tblProveedor (proveedor,usuario,pass) values (?,?,?)";
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombre);
           pst.setString(2, usuario);
           pst.setString(3, contraseña);
                      
           if(pst.executeUpdate() == 1){
               return true;
           }
       }catch(Exception ex){
           System.err.println("ERROR"+ex);
       }finally{
           try{
               if(getConexion() != null) getConexion().close();
               if (pst != null)pst.close();
           }catch(Exception e){
               System.err.println("ERROR"+e);
           }
           
       }
       
       return false;
   }
   public static void main (String[] args) throws SQLException{
       Consultas co = new Consultas ();
       System.out.println(co.registrar("Nadia", "López", "Nadia456", "1234"));
}
 }



