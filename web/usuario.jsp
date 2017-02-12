<%-- 
    Document   : usuario
    Created on : 22/05/2016, 07:48:56 PM
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
    <center><h1>Inicia Sesión</h1></center>
    <form method = "POST" name="iniciar" action="IniciarSesion">
        <center>Usuario<input type="text" name="usuario" value="" /></center><br>
        <center>Contraseña<input type="password" name="pass" value="" /></center><br>
        <center><input type="submit" value="Inicia" /></center>
        <center>No tienes una cuenta....<a href="registro.jsp">Registrate</a></center><br><br>
    </form>
        <center>¿Eres proveedor? Checa tus productos</center>
        <form method = "POST" name="proveedor" action="IniciaProveedor">
        <center>Usuario<input type="text" name="usuario" value="" /></center><br>
        <center>Contraseña<input type="password" name="pass" value="" /></center><br>
        <center><input type="submit" value="Inicia" /></center>
        <center>Si aun no eres parte de nuestro equipo...¿Qué esperas?<a href="registroProv.jsp">Únete</a></center>
    </form>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <hr>
    <br>
        <h1><a href="Admin.jsp"><button>¿Eres admin?</button></a></h1>
    </body>
</html>
