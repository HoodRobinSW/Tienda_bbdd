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
        <a href="comercialesMenu.html"><img src="images/comerciales.jpg" alt=""></a>
        <a href="listadoComerciales.jsp"><img src="images/listado-comerciales.jpg" alt=""></a>
        <a href="nuevoComercial.jsp"><img src="images/alta-comerciales.jpg" alt=""></a>
      </div>
    </div>
    <div class="middle-separator"></div>
    <div class="login">
        <h2>A�adir un nuevo comercial</h2>
        <form action="controlaNuevoComercial" method="post">
            <table>
                <tr><td>Codigo</td><td><input type="text" name="codigo"></td></tr>
                <tr><td>Nombre</td><td><input type="text" name="nombre"></td></tr>
                <tr><td>Salario</td><td><input type="text" name="salario"></td></tr>
                <tr><td>Fecha de Nacimiento</td><td><input type="text" name="fecha"></td></tr>
                <tr><td>Numero de hijos</td><td><input type="text" name="hijos"></td></tr>
            </table>
            <input type="submit" value="aceptar">
            <input type="reset" value="cancelar">
        </form>
    </div>
    <footer>
    </footer>
  </body>
</html>