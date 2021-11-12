import DAO.Bd;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class validarLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validarLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validarLogin at " + request.getContextPath() + "</h1>");
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
        ServletContext contexto=getServletContext();
        RequestDispatcher rd;
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        boolean loged = false;
        try {
            ArrayList<Usuario> usuarios = Bd.getUsuarios();
            for (Usuario u:usuarios) {
                if (usuario.equals(u.getUsuario()) && pass.equals(u.getPassword()))
                    loged = true;
            }
            if (loged) {
                rd=contexto.getRequestDispatcher("/acceso.html");
                rd.forward(request, response);   
            } else {
                rd=contexto.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(validarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
