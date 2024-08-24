package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author nkt
 */
public class BeanConnector {
    private String driver;
    private String url;
    private String user;
    private String password;
    //el objeto conexion es el canal para enviar consultas
    //y recibir resultados de la base de datos
    private Connection conexion;
    //los statement me permiten enviar consultas sql a través del objeto Connection
    //el prepared statement me permite hacer consultas seguras para evitar
    //ataques contra la base de datos
    private PreparedStatement st;
    
    //declaración del constructor
    public BeanConnector(){
        
    }
    
    public String getDriver(){
        return driver;
    }
    
    public void setDriver(String driver){
        this.driver = driver;
        try{
            Class.forName(driver);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public PreparedStatement getSt(){
        return st;
    }
    
    public void setStatement(PreparedStatement st){
        this.st = st;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
    public void conectar(){
        try{
            conexion = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try{
            st.close();
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
