/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class accesorios extends HttpServlet {

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
        String a=req.getParameter("libro");
	//Cogemos todos los datos de la asignaturas
	resultados=sentencia.executeQuery("SELECT * FROM tblProducto where idTPr=4");

	//Escribimos la cabecera de la página
        out.println("<nav class="+"navbar navbar-inverse"+">");
  out.println("<div class="+"container-fluid>");
    out.println("<div class="+"navbar-header>");
      out.println("<button type="+"button class="+"navbar-toggle data-toggle="+"collapse data-target="+"#myNavbar>");
        out.println("<span class="+"icon-bar></span>");
        out.println("<span class="+"icon-bar></span>");
        out.println("<span class="+"icon-bar></span>");                      
      out.println("</button>");
      out.println("<a class="+"navbar-brand href="+"index.jsp><img src="+"imagenes/coollogo_com-192477670.jpg width="+"250 height="+"35 alt=Potter Store/>");
    out.println("</div>");
    out.println("<div class="+"collapse navbar-collapse" +"id="+"myNavbar"+">");
      out.println("<ul class="+"nav navbar-nav"+">");
      out.println(" <li class="+"active"+"><a href="+"#"+">Home</a></li>");
        out.println("<li><a href="+"#"+">Products</a></li>");
        out.println("<li><a href="+"#"+">Products</a></li>");
        out.println("<li><a href="+"#"+">Products</a></li>");
        out.println("<li><a href="+"#"+">Products</a></li>");
      out.println("</ul>");
      out.println("<ul class="+"nav navbar-nav navbar-right"+">");
        out.println("<li><a href="+"#"+"><span class="+"glyphicon glyphicon-user"+"></span> Your Account</a></li>");
        out.println("<li><a href="+"#"+"><span class="+"glyphicon glyphicon-shopping-cart"+"></span> Cart</a></li>");
      out.println("</ul>");
    out.println("</div>");
      out.println("</div>");
    out.println("</nav>");

	out.println("<html>\n <body>\n <h1>Productos</h1>");
        out.println("<td><h2>Accesorios</h2></td>");
        out.println("<br><br><form method="+"get"+ " action="+"usuario.jsp"+">");
        out.println("<input type="+"submit"+" value="+"Comprar"+">"+"</input>");
        out.println("</form>");
        out.println("<table border=" + "1>");
            out.println("<tr>");
            out.println("<td>N° del producto</td>");
            out.println("<td>Producto</td>");
            out.println("<td>Precio</td>");
            out.println("</tr>");
            while (resultados.next()) {
                out.println("<tr><td>");
                out.println(resultados.getString("idProd"));
                out.println("</td><td>");
                out.println(resultados.getString("producto"));
                out.println("</td><td>");
                out.println(resultados.getString("precio"));
                out.println("</td></tr>");
                
            }//Fin while
            out.println("</table>");

	//Mostramos las distintas asignaturas
	

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

