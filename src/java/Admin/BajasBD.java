/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BajasBD extends HttpServlet {

  public void init(ServletConfig conf)
    throws ServletException {
    super.init(conf);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {


    Connection conexion = null; //Objeto para la conexión a la BD
    Statement sentencia = null; //Objeto para la ejecutar una sentencia

    //Variables conexión
    String cadenaConexion="jdbc:mysql://localhost:3306/bd_potterstore";
    String usuario="root";
    String clave="n0m3l0";

    //La salida será una página HTML
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    try {
	//Leemos el driver de Oracle
	Class.forName("com.mysql.jdbc.Driver");

	//Nos conectamos a la BD
	conexion = DriverManager.getConnection (cadenaConexion,usuario,clave);
	
	//Creamos una sentencia a partir de la conexión
	sentencia=conexion.createStatement();
        String c=req.getParameter("producto");
	//Cogemos todos los datos de la asignaturas
	int n=sentencia.executeUpdate("delete from tblProducto where producto = '"+c+"'"); 
	} catch (ClassNotFoundException e1) {
		out.println("No encuentro el driver de la BD: "+e1.getMessage());
	
	} catch (SQLException e2) {
		out.println("Fallo en SQL: "+e2.getMessage());
	
	} 

	finally {
		try {
			if (conexion!=null)
				conexion.close();
		} catch (SQLException e3) {
		out.println("Fallo al desconectar SQL: "+e3.getMessage());
		}
	}

  }//fin método doGet

  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    doGet(req, res);
  }
}

