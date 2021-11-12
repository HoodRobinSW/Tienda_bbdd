<%@page import="Modelo.Producto"%>
<%@page import="DAO.Bd"%>
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
        <img src="images/ventas.jpg" alt="">
        <a href="listadoVentas.jsp"><img src="images/listado-ventas.jpg" alt=""></a>
        <a href="nuevaVenta.jsp"><img src="images/nueva-venta.jpg" alt=""></a>
      </div>
      <div id="image2">
        <a href="productosMenu.html"><img src="images/productos.jpg" alt=""></a>
      </div>
      <div id="image3">
        <a href="comercialesMenu.html"><img src="images/comerciales.jpg" alt=""></a>
      </div>
    </div>
    <div class="middle-separator"></div>
    <div class="login">
      <h2>Listado de ventas</h2>
      <form action="listadoVentasTable.jsp" method="post">
        <label for="productos">Productos:</label>
        <select name="productos">
          <option value="" hidden>Seleccione un producto</option>
          <%
             ArrayList<Producto> listaProductos = Bd.getListaPodructos();
              for (Producto prod:listaProductos) {%>
              <option value="<%=prod.getNombre()%>"><%=prod.getNombre()%></option>
          <%    }
          %>
        </select><br>
        <input type="submit" value="aceptar">
        <input type="reset" value="cancelar">
      </form>
    </div>
    <footer>
    </footer>
  </body>
</html>
