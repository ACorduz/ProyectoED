
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;


public class OccasionalDonor extends Donnor{

    public OccasionalDonor(String names, String lastNames, String email, String document, String password, String TypeUser, String adress, String locality, Queue<Product> ListDonations, Stack<Product> HistoryOfDonations) {
        super(names, lastNames, email, document, password, TypeUser, adress, locality, ListDonations, HistoryOfDonations);
    }

    
    //Esta clase esta por si se quieren poner mas funcionalidades al donadorOcasional
}
