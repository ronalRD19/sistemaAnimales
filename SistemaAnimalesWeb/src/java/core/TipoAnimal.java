package core;

//POJO - plain old java objects
//una clase para mapear una tabla
/**
 *
 * @author nkt
 */
public class TipoAnimal {
    private int id;
    private String name;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }       
}
