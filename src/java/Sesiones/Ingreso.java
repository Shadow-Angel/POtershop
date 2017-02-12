package Sesiones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Manuel
 */
public class Ingreso extends HttpServlet {

    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conexion=null;
        Statement  sentencia= null;
        ResultSet resultado= null;
        String cadenaConexion="jdbc:mysql://127.0.0.1/bd_potterstore";
        String usuarioBD="root";
        String password="n0m3l0";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(cadenaConexion,usuarioBD,password);
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery("select * from registro where usuario=potter");
            String auxUsuario="";
            while(resultado.next()){
                auxUsuario=resultado.getString("usuario");
            }
            String usuario= request.getParameter("usuariohtml");
            if(auxUsuario.equals(usuario)){            
                HttpSession ses= request.getSession();            
               ses.setAttribute("usuario", usuario);
            
         /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Ingreso</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Ingreso at " + ses.getAttribute("usuario") + "</h1>");
                out.println("<a href=Bienvenida> Aplicacion</a>");
                out.println("</body>");
                out.println("</html>");
            }
            else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Ingreso</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>No jurula </h1>");
                out.println("<a href=Bienvenida> Aplicacion</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        catch (ClassNotFoundException ex) {
            out.println("No se encuentra el driver de la BD"+ex.getMessage());
        } catch (SQLException ex2) {
            out.println("No se encuentra la BD"+ex2.getMessage());
        }        
        finally{
    }

    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
