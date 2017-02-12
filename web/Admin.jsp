<%-- 
    Document   : Admin
    Created on : 23/05/2016, 12:42:02 AM
    Author     : dmi99
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <div><h1>Altas</h1></div>
       <form method="POST" action="AltasBD">
           Producto:<input type="text" name="producto" value="" /><br><br>
           Precio:<input type="text" name="precio" value="" /><br><br>
           Tipo:<input type="text" name="idTPr" value="" /><br><br>
           Proveedor:<input type="text" name="idProv" value="" /><br><br>
      <input type="submit"></form>
        <div><h1>Cambios</h1></div>
       <form method="POST" action="CambiosBD">
           idProducto: <input type="text" name="id" value="" />
           Producto: <input type="text" name="producto" value="" />
           Precio: <input type="text" name="precio" value="" />
      <input type="submit"></form>
        <form method="POST" action="ConsultasBD">
        <div><h1>Consultas</h1></div>
      <input type="submit"></form>
        <form method="POST" action="BajasBD">
        <div><h1>Borrar</h1></div>
        Producto a borrar: <input type="text" name="producto" value="" /><br><br>
        <input type="submit"></form>
    </body>    
</html>
<%-- 
anexar Servlets para Admin, uno de compras cliente y consultas el mismo
--%>