<%-- 
    Document   : registro
    Created on : 22/05/2016, 11:55:38 PM
    Author     : dmi99
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarme</title>
    </head>
    <body>
        <h1>Formulario de Registro</h1>
    <center><form action="RegistrarUsuarios" method ="POST">
            Nombre:<input type="text" name="nombre" value="" /><br><br>
            Apellido:<input type="text" name="apellido" value="" /><br><br>
            Usuario:<input type="text" name="usuario" value="" /><br><br>
            Contraseña:<input type="password" name="pass" value="" /><br><br>
            <input type="submit" value="Registrarme" />
        </form></center>   
    </body>
</html>
