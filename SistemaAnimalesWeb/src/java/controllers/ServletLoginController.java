package controllers;

import CRUDS.CRUDUsuarios;
import core.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nkt
 */
public class ServletLoginController extends HttpServlet {

    CRUDUsuarios crudUsuarios;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        crudUsuarios = new CRUDUsuarios();
        Usuario usuario = new Usuario();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        usuario.setLogin(login);
        usuario.setPassword(password);
        usuario.setPerfil("");
        String perfil ="";
        try{
         perfil = crudUsuarios.validarUsuario(usuario);
        }catch(Exception e){
            System.out.println("error obteniendo el perfil");
        }
        if(perfil.equals("Usuario")){
            System.out.println("usuario encontrado");
            response.sendRedirect("animales.jsp");
        }else{
            System.out.println("error error error");
            response.sendError(0, "error de autenticacion");
        }
            
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
