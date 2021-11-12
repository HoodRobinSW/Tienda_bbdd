import DAO.Bd;
import Modelo.Comerciales;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlaNuevoComercial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlaNuevoComercial</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlaNuevoComercial at " + request.getContextPath() + "</h1>");
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
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            double salario = Double.parseDouble(request.getParameter("salario"));
            String fecha = request.getParameter("fecha");
            int hijos = Integer.parseInt(request.getParameter("hijos"));
            Comerciales comercial = new Comerciales(codigo, nombre, salario, hijos, fecha);
            Bd.insertarComercial(comercial);
            rd=contexto.getRequestDispatcher("/comercialesMenu.html");
            rd.forward(request, response);
        } catch(NumberFormatException | ParseException | SQLException e) {
            rd=contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
