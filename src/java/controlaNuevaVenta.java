import DAO.Bd;
import Modelo.Comerciales;
import Modelo.Producto;
import Modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlaNuevaVenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlaNuevaVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlaNuevaVenta at " + request.getContextPath() + "</h1>");
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
        ServletContext contexto =getServletContext();
        RequestDispatcher rd;
        
        try {
            String comercial = request.getParameter("comercial");
            String producto = request.getParameter("productos");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String fecha = request.getParameter("fecha");
            
            Bd.insertarVenta(producto, comercial, cantidad, fecha);
            rd=contexto.getRequestDispatcher("/ventasMenu.html");
            rd.forward(request, response);
        } catch(NumberFormatException | ParseException | SQLException e) {
            rd=contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
