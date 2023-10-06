
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import java.io.Serializable;


public class OccasionalDonor extends Donnor implements Serializable{

    public OccasionalDonor(String name,String lastName, String email, String document, String password, String adress, String locality) {
        super(name, lastName, email, document, password, adress, locality);
    }

    

    
    //Esta clase esta por si se quieren poner mas funcionalidades al donadorOcasional
}
