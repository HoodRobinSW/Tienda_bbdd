import DAO.Bd;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlaModificarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlaModificarProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlaModificarProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        try {
            String referencia = request.getParameter("referencia");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int descuento = Integer.parseInt(request.getParameter("descuento"));
            Producto producto = new Producto(referencia, nombre, descripcion, precio, descuento);
            Bd.modificarProducto(producto);
            rd=contexto.getRequestDispatcher("/productosMenu.html");
            rd.forward(request, response);
        } catch(NumberFormatException | SQLException e) {
            rd=contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
