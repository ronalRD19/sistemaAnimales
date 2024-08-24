package core;

/**
 *
 * @author nkt
 */
public class TipoAnimalCaracteristicaAnimal {
    private int id;
    private int idCaracteristicaAnimal;
    private int idAnimal;
    private String valor;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setIdCaracteristicaAnimal(int idCaracteristicaAnimal){
        this.idCaracteristicaAnimal = idCaracteristicaAnimal;
    }
    
    public int getIdCaracteristicaAnimal(){
        return idCaracteristicaAnimal;
    }
    
    public void setIdAnimal(int idAnimal){
        this.idAnimal = idAnimal;
    }
    
    public int getIdAnimal(){
        return idAnimal;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return valor;
    }
}
