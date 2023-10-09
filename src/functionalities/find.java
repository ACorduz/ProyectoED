
package functionalities;

import Data.Beneficiary;
import Data.Donnor;
import Data.User;
import Estructure_DoubleLinkedList.Stack;
import Estructure_LinkedList.LinkedList;
import Estructure_LinkedList.Node;
import Estructure_LinkedList.Queue;


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
    
    public boolean findUser_listOfUsers(Queue<User> listOfUsers, String email){
        // se va a recorrer las listas como un find
        // primero se saca el siguiente nodo al head 
        Node currentNodeUser= listOfUsers.getHead().getNext();
        // luego  miramos si ese nodo  es !=  null
        long tiempoInicio = System.nanoTime();
        while(currentNodeUser != null){
            User compareUser = (User) currentNodeUser.getData();
            if(compareUser.getEmail().equals(email)){
                long tiempoFin = System.nanoTime();
                long tiempoTranscurrido = tiempoFin - tiempoInicio;
                double segundos = (double) tiempoTranscurrido / 1000000.0;
                System.out.println(segundos);
                return(true);

            }
            // si no es igual al correo se pasa al siguiente nodo
            currentNodeUser = currentNodeUser.getNext();
        }
        // si ya rrecorrio todo y no lo encontro 
        return(false);
    }
    
    public boolean findUser_listOfUsersS(Stack<User> listOfUsers, String email){
        // se va a recorrer las listas como un find
        // primero se saca el siguiente nodo al head 
        Estructure_DoubleLinkedList.Node currentNodeUser= listOfUsers.getHead().getNext();
        // luego  miramos si ese nodo  es !=  null
        long tiempoInicio = System.nanoTime();
        while(currentNodeUser != null){
            User compareUser = (User) currentNodeUser.getData();
            if(compareUser.getEmail().equals(email)){
                long tiempoFin = System.nanoTime();
                long tiempoTranscurrido = tiempoFin - tiempoInicio;
                double segundos = (double) tiempoTranscurrido / 1000000.0;
                System.out.println(segundos);
                return(true);

            }
            // si no es igual al correo se pasa al siguiente nodo
            currentNodeUser = currentNodeUser.getNext();
        }
        // si ya rrecorrio todo y no lo encontro 
        return(false);
    }
    
}
