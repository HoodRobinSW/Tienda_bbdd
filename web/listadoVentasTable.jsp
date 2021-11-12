<%@page import="Modelo.ListadoVentas"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Modelo.Comerciales"%>
<%@page import="Modelo.Producto"%>
<%@page import="Modelo.Venta"%>
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
        <%
            String producto = request.getParameter("productos");
            ArrayList<Producto> listaProductos = Bd.getListaPodructos();
            DecimalFormat df = new DecimalFormat("####.##");
            ArrayList<ListadoVentas> listadoVentas = Bd.getListadoVentas(producto);
        %>
      <table class="lista">
        <tr>
            <th>Fecha</th>
            <th>Comercial</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Total</th>
            <th>Descuento</th>
            <th>Total Descuento</th>
        </tr>
      <%
          for (ListadoVentas lv:listadoVentas){
              double total = lv.getCantidad()*lv.getPrecio();
              double totalDescuento = total - (total*(lv.getDescuento()/100));
      %>
          <tr>
              <td><%=lv.getFecha()%></td>
              <td><%=lv.getComercial()%></td>
              <td><%=lv.getCantidad()%></td>
              <td><%=lv.getPrecio()%></td>
              <td><%=df.format(total)%></td>
              <td><%=lv.getDescuento()%></td>
              <td><%=df.format(totalDescuento)%></td>
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
