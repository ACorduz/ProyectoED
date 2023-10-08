
package functionalities;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DoubleLinkedList.Node;
import Estructure_DinamicArray.DinamicArray;
import Logic.InputDataJSON;
import Business.Main;
import Data.Food;
import Data.serialization;


public class RegistroComida extends Main {
    private int typeOfFile = 1;
    private DoubleLinkedList doubleLinkedListJSON;
    private DinamicArray dinamicArrayJSON; 
    private serialization ser = new serialization();
    private int numberRowsRead;
    private int indexFileDoubleLL = ser.getIndexNamesFiles("listOfProductsSerialization.obj");
    private int indexFileDA = ser.getIndexNamesFiles("listOfProducts_DASerialization.obj");
    // primera Estructura a implementar sera una DoubleLinkedList, versatil y agil 

    
    public RegistroComida(int numberRowsRead) {
        this.numberRowsRead = numberRowsRead;
    }
    
    // creacion
    public void CreateRF_DoubleLinkedList(){
        ser.WriteSerializationInicialFile(indexFileDoubleLL);
    }
    
    public void InsertRFScan_DoubleLinkedList(String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        // crearObjeto
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        // insertarlo en lista
        doubleLinkedListFinal.pushBack(f);
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts(doubleLinkedListFinal);
        
    }
    
    public void InsertRFObject_DoubleLinkedList(Food food){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();

        // insertarlo en lista
        doubleLinkedListFinal.pushBack(food);
        
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts(doubleLinkedListFinal);
        
    }
    
    
    public void UpdateRF_DoubleLinkedList(Food obj,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay ){
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        boolean IsUpdate = doubleLinkedListFinal.updateNode(obj, f);
        
        if(IsUpdate){
            // guardar lista en main
            Main.setListOfProducts(doubleLinkedListFinal);
            System.out.println("Fue actualizado Correctamente");
                
        }else{
            System.out.println("No se encontro Obj");
        }
        
    }
    
    public void deleteRF_DoubleLinkedList(){
        // falta metodo para borrar un dato
    }
    
    // buscar si un objeto esta en la lista 
    public boolean findDataRF_DoubleLinkedList(Food foodCompare){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        boolean exist = doubleLinkedListFinal.find(foodCompare);
        if(exist){
            return(true);
        }
        return(false);
    }
    
    // consultar y obtener todos los productos por un mismo Donador
    public DoubleLinkedList<Food> consultDataForEmailDonnorRF_DoubleLinkedList(String emailDonnorInput){
        DoubleLinkedList DoubleLinkedListOutPut = new DoubleLinkedList();
        DoubleLinkedList listMain = Main.getListOfProducts();
        Node head = listMain.getHead().getNext();
        while(head != null){
            Food fCompare = (Food) head.getData();
            // si el email del objeto comparado es igual al de la entrada entonces entra a la lista final 
            if(fCompare.getEmailDonor().equals(emailDonnorInput)){
                DoubleLinkedListOutPut.pushFront(fCompare);
            }
            Node next = head.getNext();
            head = next;
        }
        
        // retornamos los productos que tengan esa caracteristica igual 
        return(DoubleLinkedListOutPut);
    }
    
    // guardar datos de la lista en la BD
    public void storeDataRF_DoubleLinkedList(){
        ser.saveStatusListProgram(indexFileDoubleLL);
    }
    
    
    // prueba de insertar comida con un numero de columnas
    public void proofInsertFood(int numberRowsRead){
        
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
        
            // traer datos ya creados o asegurarnos que ya se hayan traido 
            ser.SetListInProgramFromFile(1); // setListProgram 
            
        // obtener lista del main 
        DoubleLinkedList doubleLinkedListFinal = Main.getListOfProducts();
            
        int counterLoop =0;
        
        Node head = doubleLinkedListJSON.getHead().getNext();
        // rrecoorer el doubleLinkedListdeJson para ingresar correos y ingresar objetos a DinamicArrayFinal
        while(head != null){
            Food foodCompare =(Food) head.getData();
            foodCompare.setEmailDonor(ArrayUsers[counterLoop]);
            counterLoop++;
            
            // ahora utilizar metodo de ingresar objeto
            InsertRFObject_DoubleLinkedList(foodCompare);
            
            // cambiar el nodo al siguiente
            Node next = head.getNext();
            head = next;
        }
  
        //Ingresar los datos al BD 
        // como ya se ingresaron los datos al main, solo llamar a la serializacion
        System.out.print(Main.getListOfProducts().toString()); // mostrar que funciona
        
        ser.saveStatusListProgram(1);//"listOfProductsSerialization.obj" 
    }
    
    
        // creacion
    public void CreateRF_DinamicArray(){
        ser.WriteSerializationInicialFile(indexFileDA);
    }
  
        
    public void InsertRFScan_DinamicArray(String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // traer lista
        DinamicArray<Food> DinamicArrayFinal = Main.getListOfProducts_DA();
        // crearObjeto
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        // insertarlo en lista
        DinamicArrayFinal.add(f);
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts_DA(DinamicArrayFinal);
        
    }
    
    public void InsertRFObject_DinamicArray(Food food){
        // traer lista
        DinamicArray<Food> DinamicArrayFinal = Main.getListOfProducts_DA();

        // insertarlo en lista
        DinamicArrayFinal.add(food);
        
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts_DA(DinamicArrayFinal);
        
    }
    /*
    public void UpdateRF_DinamicArray(Food obj,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay ){
        DinamicArray<Food> DinamicArrayFinal = Main.getListOfProducts_DA();
        
        Food f = new Food("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        
        
        if(IsUpdate){
            // guardar lista en main
            Main.setListOfProducts(doubleLinkedListFinal);
            System.out.println("Fue actualizado Correctamente");
                
        }else{
            System.out.println("No se encontro Obj");
        }
        
    }
   */
    
    
}
