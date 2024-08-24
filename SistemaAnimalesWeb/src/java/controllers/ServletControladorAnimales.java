package controllers;

import CRUDS.CRUDAnimales;
import core.Animal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nkt
 */
public class ServletControladorAnimales extends HttpServlet {
    
    private CRUDAnimales crudAnimales;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        crudAnimales = new CRUDAnimales();
        
        System.out.println(
            request.getParameter("idTipoAnimal") + "/ " +
            request.getParameter("name") + "/ " +
            request.getParameter("tipoNacimiento")  + "/ " +
            request.getParameter("tipoSangre")  + "/ " +
            request.getParameter("tipoPiel")  + "/ " +
            request.getParameter("entorno")  + "/ " +
            request.getParameter("esVertebrado")
        );
        
        int idTipoAnimal = Integer.parseInt(request.getParameter("idTipoAnimal"));
        String name = request.getParameter("name");
        String tipoNacimiento = request.getParameter("tipoNacimiento");
        String tipoSangre = request.getParameter("tipoSangre");
        String tipoPiel = request.getParameter("tipoPiel");
        String entorno = request.getParameter("entorno");
        boolean esVertebrado = false;
        if(request.getParameter("esVertebrado").equals("true")){
            esVertebrado = true;
        }else if(request.getParameter("esVertebrado").equals("false")){
            esVertebrado = false;
        }else{
            System.out.println("Error de tipo boolean en esVertebrado");
        }
        System.out.println(request.getParameter("esVertebrado") +" / " + esVertebrado);
        
        //obtengo el parametro que me define la operación que se va realizar
        //listar, ingresar, editar, eliminar
        Enumeration <String> parametros = request.getParameterNames();
        parametros.nextElement();
        parametros.nextElement();
        parametros.nextElement();
        parametros.nextElement();
        parametros.nextElement();
        parametros.nextElement();
        parametros.nextElement();
        String operacion = parametros.nextElement();
        
        Animal animal = new Animal();
        animal.setIdTipoAnimal(idTipoAnimal);
        animal.setName(name);
        animal.setTipoNacimiento(tipoNacimiento);
        animal.setTipoSangre(tipoSangre);
        animal.setTipoPiel(tipoPiel);
        animal.setEntorno(entorno);
        animal.setEsVertebrado(esVertebrado); 
        
        //acciones de acuerdo a la selección del usuario
        if(operacion.equals("ingresaranimal")){
            crudAnimales.insertarAnimal(animal);
            msg("animal insertado");
        }
        if(operacion.equals("buscaranimal")){
            
        }
        if(operacion.equals("editaranimal")){
            crudAnimales.actualizarAnimal(animal);
            msg("animal actualizado");
        }
        if(operacion.equals("eliminaranimal")){
            crudAnimales.eliminarAnimal(animal);
            msg("animal eliminado");
        }
        
        //redirijo la salida hacia el jsp donde se carga la información
        response.sendRedirect("animales.jsp");
        response.setContentType("text/html;charset=UTF-8");

    }
    
    public void msg(String msg){
        System.out.println(msg);
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
