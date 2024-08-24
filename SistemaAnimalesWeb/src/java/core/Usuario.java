package core;

/**
 *
 * @author nkt
 */
public class Usuario {
    private int id;
    private String login;
    private String password;
    private String perfil;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPerfil(String perfil){
        this.perfil = perfil;
    }
    
    public String getPerfil(){
        return perfil;
    }
}
