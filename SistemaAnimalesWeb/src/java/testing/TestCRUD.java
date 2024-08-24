package testing;

import CRUDS.CRUDAnimales;
import core.Animal;
import java.util.Iterator;

/**
 *
 * @author nkt
 */
public class TestCRUD {
    
    
    public static void main(String[] args){
        CRUDAnimales crudAnimales = new CRUDAnimales();
        Iterator iteratorAnimales = crudAnimales.listarAnimales().iterator();
        Animal animal = null;
        while(iteratorAnimales.hasNext()){
            animal = (Animal)iteratorAnimales.next();
            msg("-----------------");
            msg("tipo animal >>> " + animal.getIdTipoAnimal());
            msg("nombre >>> " + animal.getName());
            msg("tipo nacimiento >>> " + animal.getTipoNacimiento());
            msg("tipo sangre >>> " + animal.getTipoSangre());
            msg("tipo piel >>> " + animal.getTipoPiel());
            msg("entorno >>> " + animal.getEntorno());
            msg("es vertebrado >>> " + Boolean.toString(animal.getEsVertebrado()));
        }
    }
    
    public static void msg(String msg){
        System.out.println(msg);
    }
}
