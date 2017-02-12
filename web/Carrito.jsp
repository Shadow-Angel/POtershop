<%-- 
    Document   : Carrito
    Created on : 29/05/2016, 12:05:29 PM
    Author     : dmi99
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession Sesion = request.getSession();//Traemos los datos de la sesion creada anteriormente                  
        %>
        <a href="ConsultaCarrito">Ver carrito</a>
        <a href="menu.jsp">Ver mas productos</a>
        <h1>Compra tu Producto</h1>
        <form method = "POST" action="Carrito">
        Codigo del Producto:<input type="text" name="idProd">  Cantidad:<input type="text" name="numerito">  <input type="submit"></form>
        </form>
    </body>
</html>
