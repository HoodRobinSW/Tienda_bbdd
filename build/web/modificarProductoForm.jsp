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
        <img src="images/productos.jpg" alt="">
        <a href="listadoProductos.jsp"><img src="images/listado-productos.jpg" alt=""></a>
        <a href="nuevoProducto.jsp"><img src="images/nuevo-producto.jpg" alt=""></a>
        <a href="modificarProducto.jsp"><img src="images/modificar-producto.jpg" alt=""></a>
      </div>
      <div id="image3">
          <a href="comercialesMenu.html"><img src="images/comerciales.jpg" alt=""></a>
      </div>
    </div>
    <div class="middle-separator"></div>
    <div class="login">
      <h2>Modificar producto</h2>
      <form action="controlaModificarProducto" method="post">
          <%
              String referencia = request.getParameter("productos");
          %>
          <table>
              <tr><td><input type="text" name="referencia" value="<%=referencia%>" hidden></td></tr>
              <tr><td>Nombre</td><td><input type="text" name="nombre"></td></tr>
              <tr><td>Descripcion</td><td><input type="text" name="descripcion"></td></tr>
              <tr><td>Precio</td><td><input type="text" name="precio"></td></tr>
              <tr><td>Descuento</td><td><input type="text" name="descuento"></td></tr>
          </table>
        <input type="submit" value="aceptar">
        <input type="reset" value="cancelar">
      </form>
    </div>
    <footer>
    </footer>
  </body>
</html>
