
package ArchivosBorrarAlFinalSegundaEntrega;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DoubleLinkedList.Node;
import Estructure_DinamicArray.DinamicArray;
import ArchivosBorrarAlFinalSegundaEntrega.InputDataJSON;
import Business.Main;
import Data.Comida;
import Data.SerializacionAO;


public class RegistroComida extends Main {
    private int typeOfFile = 1;
    private DoubleLinkedList doubleLinkedListJSON;
    private DinamicArray dinamicArrayJSON; 
    private SerializacionAO ser = new SerializacionAO();
    private int numberRowsRead;
    private int indexFileDoubleLL = ser.getIndexNamesFiles("listOfProductsSerialization.obj");
    private int indexFileDA = ser.getIndexNamesFiles("listOfProducts_DASerialization.obj");
    // primera Estructura a implementar sera una DoubleLinkedList, versatil y agil 

    
    public RegistroComida() {
        
    }
    
    //OPERACIONES FUNCIONALES
    
    // creacion
    public void CreateRF_DoubleLinkedList(){
        ser.WriteSerializationInicialFile(indexFileDoubleLL);
    }
    /*
    // Insertar
    public void InsertRFScan_DoubleLinkedList(String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        // crearObjeto
        Comida f = new Comida("Comida", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        // insertarlo en lista
        doubleLinkedListFinal.pushBack(f);
        
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts(doubleLinkedListFinal);
        //storeDataRF_DoubleLinkedList(1)
    }
    
    public void InsertRFObject_DoubleLinkedList(Comida food){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();

        // insertarlo en lista
        doubleLinkedListFinal.pushBack(food);
        
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts(doubleLinkedListFinal);
        
    }
    
    // actualizar
    public void UpdateRF_DoubleLinkedList(Comida obj,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay ){
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        Comida f = new Comida("Comida", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
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
    public boolean findDataRF_DoubleLinkedList(Comida foodCompare){
        // traer lista
        DoubleLinkedList<Food> doubleLinkedListFinal = Main.getListOfProducts();
        boolean exist = doubleLinkedListFinal.find(foodCompare);
        if(exist){
            return(true);
        }
        return(false);
    }
    */
    
    public boolean findData_Email_RF_DoubleLinkedList(String email){
        // traer lista
  
        DoubleLinkedList listMain = Main.getListOfProducts();
        Node head = listMain.getHead().getNext();
        while(head != null){
            Comida fCompare = (Comida) head.getData();
            // si el email del objeto comparado es igual al de la entrada entonces entra a la lista final 
            if(fCompare.getEmailDonor().equals(email)){
                return(true);
            }
            Node next = head.getNext();
            head = next;
        }
        return(false);
    }
    
    // consultar y obtener todos los productos por un mismo Donador
    public DoubleLinkedList<Comida> consultDataForEmailDonnorRF_DoubleLinkedList(String emailDonnorInput){
        DoubleLinkedList DoubleLinkedListOutPut = new DoubleLinkedList();
        DoubleLinkedList listMain = Main.getListOfProducts();
        Node head = listMain.getHead().getNext();
        while(head != null){
            Comida fCompare = (Comida) head.getData();
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
    
   
    
        // creacion
    public void CreateRF_DinamicArray(){
        ser.WriteSerializationInicialFile(indexFileDA);
    }
  
        
    public void InsertRFScan_DinamicArray(String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // traer lista
        DinamicArray<Comida> DinamicArrayFinal = Main.getListOfProducts_DA();
        // crearObjeto
        Comida f = new Comida("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        // insertarlo en lista
        DinamicArrayFinal.add(f);
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts_DA(DinamicArrayFinal);
        
    }
    
    public void InsertRFObject_DinamicArray(Comida food){
        // traer lista
        DinamicArray<Comida> DinamicArrayFinal = Main.getListOfProducts_DA();

        // insertarlo en lista
        DinamicArrayFinal.add(food);
        
        // guardarlo la lista en el Main- para luego poder ser guardado en la BD
        Main.setListOfProducts_DA(DinamicArrayFinal);
        
    }
    
    public void UpdateRF_DinamicArray(Comida obj,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay ){
        DinamicArray<Comida> DinamicArrayFinal = Main.getListOfProducts_DA();
        
        Comida f = new Comida("Food", nameProduct,  quantity, emailDonor,  expirationDateYear,  expirationDateMonth,  expirationDateDay);
        boolean IsUpdate = DinamicArrayFinal.update(obj, f);
        if(IsUpdate){
            // guardar lista en main
            Main.setListOfProducts_DA(DinamicArrayFinal);
            System.out.println("Fue actualizado Correctamente");
                
        }else{
            System.out.println("No se encontro Obj");
        }
        
    }
    
    public void deleteRF_DinamicArray(Comida obj){
        DinamicArray<Comida> DinamicArrayFinal = Main.getListOfProducts_DA();
        int index = DinamicArrayFinal.getIndexFromValue(obj);
        if(index >= 0 && index < DinamicArrayFinal.size()){
            DinamicArrayFinal.remove(index);
        }else{
            System.out.println("No se encontro Obj");
        }
    }
    
    
    public boolean FindData_emailRF_DinamicArray(String emailCompare){
        DinamicArray<Comida> DinamicArrayFinal = Main.getListOfProducts_DA();
        
        for(int i =0; i < DinamicArrayFinal.size(); i++){
            Comida food = (Comida) DinamicArrayFinal.get(i);
            if(food.getEmailDonor().equals(emailCompare)){
                return(true);
            }
        }
        return(false);
    }
    
    // guardar datos de la lista en la BD
    public void storeDataRF_DinamicArray(){
        ser.saveStatusListProgram(indexFileDA);
    }
    
    
}