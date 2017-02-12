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

public class ConsultasBD extends HttpServlet {

  public void init(ServletConfig conf)
    throws ServletException {
    super.init(conf);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {


    Connection conexion = null; //Objeto para la conexión a la BD
    Statement sentencia = null; //Objeto para la ejecutar una sentencia
    ResultSet resultados = null;//Objeto para guardar los resultados

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

	//Cogemos todos los datos de la asignaturas
	resultados=sentencia.executeQuery("SELECT * FROM tblProducto");

	//Escribimos la cabecera de la página
	out.println("<html>\n <body>\n <h1>Productos</h1>");

	//Mostramos las distintas asignaturas
	while(resultados.next()) { 
	   out.println("<br>id="+resultados.getString("idProd")+
		       " Nombre="+resultados.getString("producto")+
		       " Precio="+resultados.getString("precio"));
	}//Fin while

	//Escribimos el final de la página
	out.println("</body>\n </html>");
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

