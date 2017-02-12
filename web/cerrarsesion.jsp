<%-- 
    Document   : cerrarsesion
    Created on : 15/12/2016, 06:19:44 PM
    Author     : PERSONAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>La Session Se cerro Correctamente.....Regresa pronto!!</h1>
    <%
        HttpSession Sesion = request.getSession();
        Sesion.invalidate();//Invalidamos los datos del Usuario que esta en secion
        out.println("Se cerro Sesion");            
    %>
    <a href="usuario.jsp" ><button>Aceptar</button></a>
    </body>
</html>
