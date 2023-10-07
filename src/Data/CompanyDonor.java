
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import java.io.Serializable;


public class CompanyDonor extends Donnor implements Serializable{
    private String typeCompany; // las compañias pueden ser de ropa, comida, 
    
    // esta clase esta por si se quiere poner mas funciones al Donador de la compañia;

    public CompanyDonor(String name,String lastName, String email, String document, String password, String adress, String locality) {
        super(name, lastName,email, document, password, adress, locality);
    }
    
    
    
    

    
    
}
