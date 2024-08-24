package CRUDS;

import conexion.ConexionObjetos;
import core.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * originalmente LISTAR, INGRESAR, MODIFICA, ELIMINAR
 * @author nkt
 */
public class CRUDUsuarios {
    
    private static ConexionObjetos Conn;
    
    public CRUDUsuarios(){
        Conn = new ConexionObjetos();
    }
    
    public static String validarUsuario(Usuario usuario){
        String login = usuario.getLogin();
        String password = usuario.getPassword();
        String perfil = null;
        String query = "SELECT * FROM usuarios WHERE login = ? AND password = ?"; 
        System.out.println(query);
        try{
           PreparedStatement ps = Conn.getbConn().getConexion().prepareStatement(query);
           ps.setString(1, login);
           ps.setString(2, password);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
                perfil = rs.getString("perfil");
                System.out.println(perfil);
           }
           rs.close();
        }catch(Exception e){
            System.out.println("error en la autenticacion");
            e.printStackTrace();
        }
        return perfil;
    }
    
}
