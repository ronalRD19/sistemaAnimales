package CRUDS;

// IMPORTAMOS OBJETOS Y CLASES REQUERIDOS PARA MANIPULAR CONSULTAS SQL
// CONTRA LA BASE DE DATOS
import conexion.BeanConnector;
import conexion.ConexionObjetos;
import core.Animal;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.sql.PreparedStatement;

/**
 *
 * @author nkt
 */
public class CRUDAnimales {
    private static ConexionObjetos Conn;
    
    public CRUDAnimales(){
        Conn = new ConexionObjetos();
    }
    
    //LISTAR ANIMALES
    public static LinkedList<Animal> listarAnimales(){
        LinkedList<Animal> listaAnimales = new LinkedList<>();
        //en el siguiente String defino la consulta a la base de datos
        String query = "SELECT * FROM animales";
        //siempre que hago consultas a base de datos, hay el riesgo de que se lance
        //multiples exceptions
        try{
            msg("revisar");
            //configuro un objeto que se encarga de enmascarar la consulta a la base de datos
            PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setIdTipoAnimal(rs.getInt("idTipoAnimal"));
                animal.setName(rs.getString("name"));
                animal.setTipoNacimiento(rs.getString("tipoNacimiento"));
                animal.setTipoSangre(rs.getString("tipoSangre"));
                animal.setTipoPiel(rs.getString("tipoPiel"));
                animal.setEntorno(rs.getString("entorno"));
                animal.setEsVertebrado(rs.getBoolean("esVertebrado"));
                listaAnimales.add(animal);
            }
            rs.close();
            msg("operacion de listado ejecutado exitosamente");
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaAnimales;
    }
    
    //INSERTAR ANIMAL
    public void insertarAnimal(Animal animal){
        int idTipoAnimal = animal.getIdTipoAnimal();
        String name = animal.getName();
        String tipoNacimiento = animal.getTipoNacimiento();
        String tipoSangre = animal.getTipoSangre();
        String tipoPiel = animal.getTipoPiel();
        String entorno = animal.getEntorno();
        boolean esVertebrado = animal.getEsVertebrado();
        
        //configuro la sentencia sql con símbolos para evitar ataques de hacking
        String query = "INSERT INTO animales(idTipoAnimal, name, tipoNacimiento, " +
                "tipoSangre, tipoPiel, entorno, esVertebrado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
            ps.setInt(1, idTipoAnimal);
            ps.setString(2, name);
            ps.setString(3, tipoNacimiento);
            ps.setString(4, tipoSangre);
            ps.setString(5, tipoPiel);
            ps.setString(6, entorno);
            ps.setString(7, Boolean.toString(esVertebrado));
            ps.executeUpdate();
            msg("operaciond de insercion ejecutada exitosamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //MODIFICAR un registro en la tabla animales
    public void actualizarAnimal(Animal animal){
        int idTipoAnimal = animal.getIdTipoAnimal();
        String name = animal.getName();
        String tipoNacimiento = animal.getTipoNacimiento();
        String tipoSangre = animal.getTipoSangre();
        String tipoPiel = animal.getTipoPiel();
        String entorno = animal.getEntorno();
        boolean esVertebrado = animal.getEsVertebrado();
        
        //configuro el query (consulta) a la base de datos para actualizar la tabla
        String query = "UPDATE animales SET idTipoAnimal = ?, name = ?, tipoNacimiento = ?, tipoSangre = ?, " +
                "tipoPiel = ?, entorno = ?, esVertebrado = ? WHERE name = ?";
        
        try{
            PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
            ps.setInt(1, idTipoAnimal);
            ps.setString(2, name);
            ps.setString(3, tipoNacimiento);
            ps.setString(4, tipoSangre);
            ps.setString(5, tipoPiel);
            ps.setString(6, entorno);
            ps.setString(7, Boolean.toString(esVertebrado));
            ps.setString(8, name);
            ps.executeUpdate();
            msg("operacion de actualizacion ejecutada exitosamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Eliminar un registro de la tabla animales
    public void eliminarAnimal(Animal animal){
        String name = animal.getName();
        
        //se elabora la sentencia sql para realizar la eliminación
        String query = "DELETE FROM animales WHERE name = ?";
        
        try{
            PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            msg("operacion de eliminacion ejecutada exitosamente");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void msg(String msg){
        System.out.println(msg);
    }
}
