<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Bd"%>
<%@page import="Modelo.Comerciales"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="tiendacss.css">
  </head>
  <body>
    <div class="black-border"></div>
    <header>
      <h1>APLICACION DE GESTION COMERCIAL</h1>
    </header>
    <div class="images">
      <div id="image1">
          <a href="ventasMenu.html"><img src="images/ventas.jpg" alt=""></a>
      </div>
      <div id="image2">
        <a href="productosMenu.html"><img src="images/productos.jpg" alt=""></a>
      </div>
      <div id="image3">
        <img src="images/comerciales.jpg" alt="">
        <a href="listadoComerciales.jsp"><img src="images/listado-comerciales.jpg" alt=""></a>
        <a href="nuevoComercial.jsp"><img src="images/alta-comerciales.jpg" alt=""></a>

      </div>
    </div>
    <div class="middle-separator"></div>
    <div class="login">
        <h2>Listado de comerciales</h2>
        <table class="lista">
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Salario</th>
                <th>Hijos</th>
            </tr>
            <%
                ArrayList<Comerciales> comerciales = Bd.getListaComerciales();
                
                for (Comerciales comercial:comerciales) { 
            %>
                <tr>
                    <td><%=comercial.getCodigo()%></td>
                    <td><%=comercial.getNombre()%></td>
                    <td><%=comercial.getSalario()%></td>
                    <td><%=comercial.getHijos()%></td>
                </tr>
            <%
            }
            %>
        </table>
    </div>
    <footer>
    </footer>
  </body>
</html>
