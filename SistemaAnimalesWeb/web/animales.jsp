<%-- 
    Document   : animales
    Created on : 5/09/2023, 08:14:06 PM
    Author     : nkt
--%>
<%@page import="core.TipoAnimal"%>
<%@page import="core.Animal"%>
<%@page import="conexion.ConexionObjetos"%>
<%@page import="conexion.BeanConnector"%>
<%@page import="CRUDS.CRUDAnimales"%>
<%@page import="CRUDS.CRUDTipoAnimal"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos.css" rel="stylesheet" type="text/css">
        <title>Sistema Web de Gestión de Animales</title>
    </head>
    <body>
        <div align="center">
        <img src="images/banner.animales.001.png" width="768px" height="256px"></img>
        <h1 align="center" style="font-family: verdana; color: #336699;">Base de Datos de Animales</h1>
        <a href="index.html" style="font-family: verdana; color: #336699;"><h2>[inicio]</h2></a>
        <table id="datos" style="font-family: verdana; color: #113366; border-style: dashed;
               border-radius: 9px;">
            <tr>
                <td><b>Codigo Animal</b></td>
                <td><b>Tipo Animal</b></td>
                <td><b>Nombre Animal</b></td>
                <td><b>Tipo Nacimiento</b></td>
                <td><b>Tipo Sangre</b></td>
                <td><b>Tipo Piel</b></td>
                <td><b>Entorno</b></td>
                <td><b>Es Vertebrado</b></td>
            </tr>
            <%
                CRUDAnimales crudAnimales = new CRUDAnimales();
                LinkedList<Animal> listaAnimales = crudAnimales.listarAnimales();
                Iterator iteratorAnimales = listaAnimales.iterator();
                CRUDTipoAnimal crudTipoAnimal = new CRUDTipoAnimal();
                Animal animal;
                TipoAnimal tipoAnimal;
                while(iteratorAnimales.hasNext()){
                    animal = (Animal)iteratorAnimales.next();
                    out.println("<tr>");
                    out.println("<td>" + animal.getId() + "</td>");
                    Iterator iteratorTipoAnimal = crudTipoAnimal.listarTipoAnimal().iterator();
                    while(iteratorTipoAnimal.hasNext()){
                        tipoAnimal = (TipoAnimal)iteratorTipoAnimal.next();
                        if(tipoAnimal.getId()==animal.getIdTipoAnimal()){
                            out.println("<td>" + tipoAnimal.getName()+ "</td>");
                        }else{
                            //
                        }
                    }
                    out.println("<td>" + animal.getName() + "</td>");
                    out.println("<td>" + animal.getTipoNacimiento() + "</td>");
                    out.println("<td>" + animal.getTipoSangre() + "</td>");
                    out.println("<td>" + animal.getTipoPiel() + "</td>");
                    out.println("<td>" + animal.getEntorno() + "</td>");
                    out.println("<td>" + animal.getEsVertebrado() + "</td>");
                    out.println("</tr>");
                } 
            %>
        </table>
        </div>
        <hr>
        <div align="center">
        <form name="formularionanimales" action="ServletControladorAnimales" method="get">
            <table id="tablaFormulario" style="font-family: verdana; color: #113366; font-weight: bold;">
                <tr>
                    <td>Tipo Animal </td>
                    <td>
            <select name="idTipoAnimal" id="idTipoAnimal">
                <%
                    CRUDTipoAnimal crudTipoAnimalSelect = new CRUDTipoAnimal();
                    Iterator iteratorTipoAnimalSelect = crudTipoAnimalSelect.listarTipoAnimal().iterator();
                    TipoAnimal tipoAnimalSelect;
                    while(iteratorTipoAnimalSelect.hasNext()){
                        tipoAnimalSelect = (TipoAnimal)iteratorTipoAnimalSelect.next();
                        out.println("<option value=\"" + Integer.toString(tipoAnimalSelect.getId()) + "\">" +
                                tipoAnimalSelect.getName() + "</option>");
                        }
                %>
            </select></td></tr>
                <tr>
                    <td>Nombre Animal </td><td><input type="text" name="name" maxlength="30" id="idName"></td>
                </tr>
                <tr>
                    <td>Tipo Nacimiento </td>
                    <td>
            <select name="tipoNacimiento" id="idTipoNacimiento">
                <option value="viviparo">Viviparo</option>
                <option value="oviparo">Oviparo</option>
                <option value="celular">Celular</option>
            </select></td></tr>
                <tr>
                    <td>Tipo Sangre </td>
                    <td>
            <select name="tipoSangre" id="idTipoSangre">
                <option value="caliente">Caliente</option>
                <option value="fria">Fria</option>
                <option value="hemolinfa">Hemolinfa</option>
                <option value="plasma">Plasma</option>
            </select></td></tr>
                <tr>
                    <td>Tipo Piel </td>
                    <td>
            <select name="tipoPiel" id="idTipoPiel">
                <option value="pelaje">Pelaje</option>
                <option value="plumaje">Plumaje</option>
                <option value="escamas">Escamas</option>
                <option value="piel desnuda">Piel Desnuda</option>
                <option value="exoesqueleto">Exoesqueleto</option>
                <option value="membrana">Membrana</option>
            </select></td></tr>
                <tr>
                    <td>Entorno </td>
                    <td>
            <select name="entorno" id="idEntorno">
                <option value="terrestre">Terrestre</option>
                <option value="aereo">Aereo</option>
                <option value="acuatico">Acuatico</option>
                <option value="anfitrion">anfitrion</option>
                <option value="mixto">Mixto</option>
            </select></td></tr> 
                <tr>
                    <td>Sistema Oseo </td>
                    <td>
            <select name="esVertebrado" id="idEsVertebrado">
                <option value="true">Vertebrado</option>
                <option value="false">Invertebrado</option>
            </select></td></tr>
            </table>
            <input type="submit" name="buscaranimal" value="buscar">
            <input type="submit" name="ingresaranimal" value="ingresar">
            <input type="submit" name="editaranimal" value="actualizar">
            <input type="submit" name="eliminaranimal" value="eliminar">
        </form>
        </div>
        <hr>
        <h4 align="center">elaborado por [nkt]</h4>

    </body>
</html>
