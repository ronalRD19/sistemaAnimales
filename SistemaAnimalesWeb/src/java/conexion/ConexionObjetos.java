package conexion;

/**
 *
 * @author nkt
 */
public class ConexionObjetos {
    private static BeanConnector bConn;
    
    public static BeanConnector getConexionObjetos(){
        return bConn;
    }
    
    public static void setConexionObjetos(BeanConnector bc){
        bConn = bc;
    }
    
    public ConexionObjetos(){
        try{
            bConn = new BeanConnector();
            bConn.setDriver("com.mysql.jdbc.Driver");
            bConn.setUser("root");
            bConn.setPassword("root");
            bConn.setUrl("jdbc:mysql://localhost:3306/sistemaanimales?serverTimezone=UTC");
            bConn.conectar();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public BeanConnector getbConn(){
        return bConn;
    }
}
