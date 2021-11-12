<%@page import="DAO.Bd"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
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
        <a href="productosMenu.html"></a><img src="images/productos.jpg" alt="">
        <a href=""><img src="images/listado-productos.jpg" alt=""></a>
        <a href="nuevoProducto.jsp"><img src="images/nuevo-producto.jpg" alt=""></a>
        <a href="modificarProducto.jsp"><img src="images/modificar-producto.jpg" alt=""></a>
      </div>
      <div id="image3">
        <a href="comercialesMenu.html"><img src="images/comerciales.jpg" alt=""></a>
      </div>
    </div>
    <div class="middle-separator"></div>
    <div class="login">
        <table class="lista">
            <tr>
                <th>Referencia</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th>Descuento</th>
            </tr>
            <%
                ArrayList<Producto> productos = Bd.getListaPodructos();
                
                for (Producto producto:productos) { 
            %>
                <tr>
                    <td><%=producto.getReferencia()%></td>
                    <td><%=producto.getNombre()%></td>
                    <td><%=producto.getDescripcion()%></td>
                    <td><%=producto.getPrecio()%></td>
                    <td><%=producto.getDescuento()%></td>
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
