package Servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Carrito extends HttpServlet {

  public void init(ServletConfig conf)
    throws ServletException {
    super.init(conf);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
      HttpSession ses = req.getSession();//Traemos Coneccion

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
        String UsrC = (String) ses.getAttribute("Usher");
        String a=req.getParameter("numerito");
        String b=req.getParameter("idProd");


	//Cogemos todos los datos de la asignaturas        
	int n=sentencia.executeUpdate("call AgregarCarrito('" + UsrC + "', " + b + " , " + a +");");
        

	//Escribimos la cabecera de la página
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Productos agregados al carrito</h1>");
            out.println("<table border=" + "0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>¿Que deseas hacer?</th>");

                out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
               out.println(" <tr>");
            out.println("<td><a href="+"ConsultaCarrito"+">Ver Carrito"+"</a></td>");
            out.println("<td><a href=" + "menu.jsp" + ">Ver mas productos" + "</a></td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");

	//Mostramos las distintas asignaturas

	/*//Mostramos las distintas asignaturas
	while(resultados.next()) { 
	   String nombre = resultados.getString(1);
      	   int creditos = resultados.getInt(2)+resultados.getInt(3);
      	   String cuatrimestre = resultados.getString("cuatrimestre");
      	   String tipo = resultados.getString("tipo");
	  
	   out.println("<br>Nombre="+nombre)+
		       " Créditos totales="+tipo+
		       " Tipo="+tipo+" Cuatrimestre="+cuatrimestre);
	}//Fin while*/

	//Escribimos el final de la página
    	out.println("</body>");
	out.println("</html>");

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
