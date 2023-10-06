
package functionalities;

import Data.Beneficiary;
import Data.Donnor;
import Estructure_LinkedList.LinkedList;
import Estructure_LinkedList.Node;


public class find {
    //78 Buscar, filtrar por parcial o total. Usuarios, productos
    
    public boolean findUser_listBeneficiaries_email(LinkedList<Beneficiary> listOfBeneficiaries, String email){
        // se va a recorrer las listas como un find
        // primero se saca el siguiente nodo al head 
        Node currentNodeBeneficiary = listOfBeneficiaries.getHead().getNext();
        // luego  miramos si ese nodo  es !=  null
        while(currentNodeBeneficiary != null){
            Beneficiary compareBeneficiary = (Beneficiary) currentNodeBeneficiary.getData();
            if(compareBeneficiary.getEmail().equals(email)){
                return(true);
            }
            // si no es igual al correo se pasa al siguiente nodo
            currentNodeBeneficiary = currentNodeBeneficiary.getNext();
        }
        // si ya rrecorrio todo y no lo encontro 
        return(false);
    }
    
    public void findUser_listOfDonors(LinkedList<Donnor> listOfDonors){
          
    }
    
}
