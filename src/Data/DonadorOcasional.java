
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import java.io.Serializable;


public class DonadorOcasional extends Donador implements Serializable{

    public DonadorOcasional(String name,String lastName, String email, String typeDocument,String document, String password, String adress, String locality) {
        super(name, lastName, email, typeDocument,document, password, adress, locality);
    }

    

    
    //Esta clase esta por si se quieren poner mas funcionalidades al donadorOcasional
}
