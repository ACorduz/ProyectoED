
package Data;

import Estructure_LinkedList.Queue;
import Estructure_LinkedList.Stack;
import java.io.Serializable;


public class CompanyDonor extends Donnor implements Serializable{

    // esta clase esta por si se quiere poner mas funciones al Donador de la compañia;
    public CompanyDonor(String typeCompany, String names, String lastNames, String email, String document, String password, String TypeUser, String adress, String locality, Queue<Product> ListDonations, Stack<Product> HistoryOfDonations) {
        super(names, lastNames, email, document, password, TypeUser, adress, locality, ListDonations, HistoryOfDonations);
        this.typeCompany = typeCompany;
    }
    
    
    private String typeCompany; // las compañias pueden ser de ropa, comida, 
    
    
}
