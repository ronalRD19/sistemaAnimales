package core;
//POJO para la clase Animal
/**
 *
 * @author nkt
 */
public class Animal {
    private int id;
    private int idTipoAnimal;
    private String name;
    private String tipoNacimiento;
    private String tipoSangre;
    private String tipoPiel;
    private String entorno;
    private boolean esVertebrado;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setIdTipoAnimal(int idTipoAnimal){
        this.idTipoAnimal = idTipoAnimal;
    }
    
    public int getIdTipoAnimal(){
        return idTipoAnimal;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setTipoNacimiento(String tipoNacimiento){
        this.tipoNacimiento = tipoNacimiento;
    }
    
    public String getTipoNacimiento(){
        return tipoNacimiento;
    }
    
    public void setTipoSangre(String tipoSangre){
        this.tipoSangre = tipoSangre;
    }
    
    public String getTipoSangre(){
        return tipoSangre;
    }
    
    public void setTipoPiel(String tipoPiel){
        this.tipoPiel = tipoPiel;
    }
    
    public String getTipoPiel(){
        return tipoPiel;
    }
    
    public void setEntorno(String entorno){
        this.entorno = entorno;
    }
    
    public String getEntorno(){
        return entorno;
    }
    
    public void setEsVertebrado(boolean esVertebrado){
        this.esVertebrado = esVertebrado;
    }
    
    public boolean getEsVertebrado(){
        return esVertebrado;
    }
}
