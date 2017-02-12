<%-- 
    Document   : index
    Created on : 21/05/2016, 06:42:51 PM
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
            HttpSession Sesion = request.getSession();//Recuerda que las sesiones guardan objetos
        if(Sesion.getAttribute("Usher") == null){//por lo tanto puedes preguntar sin son nulos
            out.println("No Exite Usurio en Secion");
        }else{
            out.println("...:Bievenido: " + Sesion.getAttribute("Usher") +":...");            
        }
        %>
    <center><h1>Welcome to PotterStore</h1></center>
     <center><table border="0">
         <tbody>
            <tr>
                <td><img src="imagenes/libros.jpg" width="200" height="200" alt="libros"/>
                </td>
                <td><img src="imagenes/pelis.jpg" width="200" height="200" alt="pelis"/>
                </td>
                <td><img src="imagenes/varitas.jpg" width="200" height="200" alt="varitas"/>
                </td>
            </tr>
             <tr>
                 <td><center><a href="Libros">Libros</a></center>
                </td>
                <td><center><a href="Peliculas">Peliculas</a></center>
                </td>
                <td><center><a href="Varitas">Varitas</a></center>
                </td>
            </tr>
            <tr>
                <td><img src="imagenes/accesorios.jpg" width="200" height="200" alt="accesorios"/>
                </td>
                <td><img src="imagenes/juguetes.jpg" width="200" height="200" alt="juguetes"/>
                </td>
                <td><img src="imagenes/dulces.jpg" width="200" height="200" alt="dulces"/>
                </td>
            </tr>
                        <tr>
                <td><center><a href="Accesorios">Accesorios</a></center>
                </td>
                <td><center><a href="Juguetes">Juguetes</a></center>
                </td>
                <td><center><a href="Dulces">Dulces</a></center>
                </td>
            </tr>
        </tbody>
         </table></center>
    <br>
    <br>
    <br>
    <br>
    <br>
    <hr>
    <br>
    <br>
    <br>
    <br>
    <br>
    <h3><a href="cerrarsesion.jsp"><button>Cerrar Sesión</button></a></h3>
     </body>
</html>
