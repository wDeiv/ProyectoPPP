
package proyecto.com.modelo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyecto.com.modelo.daoImpl.UsuarioDaoImpl;
import proyecto.com.modelo.dto.LoginDTO;
import proyecto.com.modelo.dao.UsuarioDao;

/**
 *
 * @author angel
 */
public class LoginController extends HttpServlet {
    private UsuarioDao dao = new UsuarioDaoImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        HttpSession sesion = request.getSession();

        Integer fallos = (Integer) sesion.getAttribute("fallos");
        if (fallos == null) {
            fallos = 0;
        }
        
        List<LoginDTO> login = dao.login(usuario, clave);
        if (!login.isEmpty()) {
            LoginDTO log = login.get(0);
            
             if (log.getEstado().equals("I")) {
                request.setAttribute("error", "Usuario inactivo. Contacte al administrador.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

            sesion.setAttribute("fallos", 0);
            sesion.setAttribute("usuario", login.get(0).getUsuario());
            sesion.setAttribute("rol", login.get(0).getRol());
            sesion.setAttribute("carrera", login.get(0).getCarrera());

            int idrol = log.getIdrol();
            switch (idrol) {
                case 1 ->
                    
                    request.getRequestDispatcher("/main.jsp").forward(request, response);
                case 4 ->
                    request.getRequestDispatcher("/estudiante.jsp").forward(request, response);
                default ->
                    throw new AssertionError();
            }
        } else {
            fallos++;
            sesion.setAttribute("fallos", fallos);
            if (fallos >= 3) {
                dao.bloquear(usuario);
                request.setAttribute("error", "Su cuenta ha sido bloqueada comunicarse con el administrador");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Nombre de usuario o contraseña incorrectos.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
