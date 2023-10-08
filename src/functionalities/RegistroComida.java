
package functionalities;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DoubleLinkedList.Node;
import Logic.InputDataJSON;
import Business.Main;
import Data.Food;
import Data.serialization;

public class RegistroComida {
    private int typeOfFile = 1;
    private DoubleLinkedList doubleLinkedListJSON;
    // primera Estructura a implementar sera una DoubleLinkedList, versatil y agil 

    
    public RegistroComida(int numberRowsRead) {
        
    }
    
    // creacion
    public void Create_DoubleLinkedList(){
        serialization ser = new serialization();
        ser.WriteSerializationInicialFile(1);
    }
    
    public void Insert_DoubleLinkedList(String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        // crearObjeto
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        doubleLinkedListFinal.pushBack(f);
    }
    
    public void UpdateData_DoubleLinkedList(Food obj,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay ){
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        boolean IsUpdate = doubleLinkedListFinal.updateNode(obj, f);
        
        if(IsUpdate){
            System.out.println("Fue actualizado Correctamente");
                
        }else{
            System.out.println("No se encontro Obj");
        }
        
    }
    
    public void deleteData_DoubleLinkedList(){
    
    }
    
    
    public void CreateFood(int numberRowsRead){
        // llamar al objeto jason para traer datos
        InputDataJSON InJson = new InputDataJSON(numberRowsRead ,typeOfFile);
        InJson.setYourComputer_pathToCarpet_fileJson(InJson.PathJhoanComputer);
        // obtener double Linked List de Json 
        doubleLinkedListJSON = InJson.ofJson_getListProductsFood();
        
        // ahora agregarle los donadores a la double LinkedList;
            // primero cambiar tipo de archivo
        InJson.change_TypeOfFileRead(0);
        // obtener arreglo de usarios
        String[] ArrayUsers =InJson.ofJson_getArrayUser();
        // obtener lista del main 
            // crear archivo de serializacaion traer datos ya creados
            serialization ser = new serialization();
            ser.SetListInProgramFromFile(1); // setListProgram 
        
        DoubleLinkedList doubleLinkedListFinal = Main.getListOfProducts();
            
        int counterLoop =0;
        Node head = doubleLinkedListJSON.getHead().getNext();
        // rrecoorer el doubleLinkedListdeJson para ingresar correos y ingresar objetos a doubleLinkedListFinal
        while(head != null){
            Food foodCompare =(Food) head.getData();
            foodCompare.setEmailDonor(ArrayUsers[counterLoop]);
            counterLoop++;
            // ahora ingresar objeto a lista
            doubleLinkedListFinal.pushFront(foodCompare);
            Node next = head.getNext();
            head = next;
        }
  
        //Ingresar los datos al BD 
        // primero pasar la dobleLinkedListFinal Al Main
        Main.setListOfProducts(doubleLinkedListFinal);
        System.out.print(Main.getListOfProducts().toString());
        // e siguiente metodo guarda el estado de esa lista
        ser.saveStatusListProgram(1);//"listOfProductsSerialization.obj" 
        
    }
    
    public void UpdateData
    
   
    
    
}
