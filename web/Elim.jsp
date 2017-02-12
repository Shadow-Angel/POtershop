<%-- 
    Document   : Elim
    Created on : 29/05/2016, 09:15:58 PM
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
        <h1>Elimina tu cuenta</h1>
        <form action="ElimProv" method="POST">
            Ingresa tu usuario: <input type="text" name="usuario" value="" />
            <input type="submit" value="Eliminar" />
        </form>
                <%
            HttpSession Sesion = request.getSession();
            Sesion.invalidate();//Invalidamos los datos del Usuario que esta en secion
            out.println("Se cerro Sesion");            
        %>
        
    </body>
</html>
