package Admin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ConsultaVentas extends HttpServlet {

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
    String cadenaConexion2="jdbc:mysql://127.0.0.1:3306/bd_potterstore";
    String usuario="root";
    String clave="n0m3l0";

    //La salida será una página HTML
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    try {
	//Leemos el driver de Oracle
	Class.forName("com.mysql.jdbc.Driver");

	//Nos conectamos a la BD
	conexion = DriverManager.getConnection (cadenaConexion2,usuario,clave);
	
	//Creamos una sentencia a partir de la conexión
	sentencia=conexion.createStatement();

	//Cogemos todos los datos de la asignaturas
	resultados=sentencia.executeQuery("select  registro.usuario,tblproducto.producto, cantidad,tblproducto.precio, tblproveedor.proveedor from carrito\n" +
"inner join tblproducto\n" +
"on carrito.idProd= tblproducto.idProd\n" +
"INNER JOIN tblproveedor\n" +
"on tblproducto.idProv = tblproveedor.idProv\n" +
"INNER JOIN registro\n" +
"on registro.usuario = carrito.usuario;");

	//Escribimos la cabecera de la página
	out.println("<html>\n <body>\n <h1>Productos en el carrito</h1>");
            out.println("<table border=" + "1>");
            out.println("<tr>");
            out.println("<td>Cantidad</td>");
            out.println("<td>Producto</td>");
            out.println("<td>Precio</td>");
            out.println("<td>Subtotal</td>");
            out.println("</tr>");
        int x = 0;
	//Mostramos las distintas asignaturas
	while(resultados.next()) { 
                            out.println("<tr><td>");
	   out.println(resultados.getString("cantidad"));
		       out.println("</td><td>");
                        out.println(resultados.getString("producto"));
		        out.println("</td><td>");
                        out.println(resultados.getString("precio"));
                       out.println("</td><td>");
                        out.println(resultados.getInt("cantidad")*resultados.getInt("precio"));
           
           x=resultados.getInt("cantidad")*resultados.getInt("precio") + x;          
	}//Fin while
        out.println("</table>");
        out.println("<br>");
        out.println ("total: " + x);
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