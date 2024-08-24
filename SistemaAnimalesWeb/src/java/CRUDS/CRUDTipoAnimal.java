package CRUDS;

import conexion.ConexionObjetos;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.sql.PreparedStatement;
import core.TipoAnimal;

/**
 *
 * @author nkt
 */
public class CRUDTipoAnimal {
    private static ConexionObjetos Conn;
    
    public CRUDTipoAnimal(){
        Conn = new ConexionObjetos();
    }
    
    //listar tipo de animal
    public static LinkedList<TipoAnimal> listarTipoAnimal(){
        LinkedList<TipoAnimal> listaTipoAnimal = new LinkedList<>();
        String query = "SELECT * FROM tipoanimal";
        TipoAnimal tipoAnimal;
        try{
            PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tipoAnimal = new TipoAnimal();
                tipoAnimal.setId(rs.getInt("id"));
                tipoAnimal.setName(rs.getString("name"));
                listaTipoAnimal.add(tipoAnimal);
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaTipoAnimal;
    }
}
