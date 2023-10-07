
package Business;
import Data.Product;
import Data.Beneficiary;
import Data.Donnor;
import Data.Food;
import Estructure_LinkedList.Queue;
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Data.serialization;
import Logic.ConectionAPI;
import Logic.InputDataDB;


public class Main <T>{
    private static Queue listForChooseProduct = new Queue(); // primero una cola para poner los beneficiarios por orden de llegada
    private static DoubleLinkedList<Product> listOfProducts = new DoubleLinkedList(); // segundo una lista donde se van a poner todos los productos
    private static LinkedList<Beneficiary> listOfBeneficiaries= new LinkedList();
    private static LinkedList<Donnor> listOfDonors = new LinkedList(); 

    // lo de historial de acciones esta en la clase donador
    // luego cada donador tiene enlazado un producto
    
    
    
    public static void main(String[] args) {
        //Pruebas para ver que el codigo funcione bien 
        
        
        // PRUEBA LISTA DE OBJETOS
        Product producto = new Product("FOOD", "Harina", 5,"@gmail");
        Product producto2 = new Product("FOOD", "Frijol", 5,"@gmail");
        Queue<Product> cola = new Queue();
        cola.enqueue(producto);
        cola.enqueue(producto2);
        Product product2 =cola.dequeue();
        System.out.println(product2.toString());
        System.out.println(cola.find(producto2));
        
        
        
        // PRUEBAS DE SERIALIZACION
        // se crea un objeto para utilizar los metodos
        serialization ser = new serialization();
        
        // creacion inicial de un archivos, en este caso el 1
        ser.deleteFile(ser.getNameArray(1));
        System.out.println("Serializacion = "+ ser.WriteSerializationInicialFile(1));
        
        // como agregar elementos a la lista
        // primero se pude sacar de la lista de los archivos que queremos,pero Hay que guardarlo en el programa, es decir las listas Main .
        // para que funcionen los demas metodos. Por ello muy raramente utilizar getObjectFromSerializationFile
        ser.SetListInProgramFromFile(1);
        Main.listOfProducts.pushBack(product2);
        ser.saveStatusListProgram(1);
        
        //Ahora poner lista en main = null; para ver si funciona el guardado
        Main.listOfProducts = null;
        System.out.println("listaMain es igual  a = "+Main.listOfProducts);
        // luego ahora si traer poner la lista y mostrarla, para ver si funciono el guardado
        ser.SetListInProgramFromFile(1);
        System.out.println("listaMain es igual a = "+ Main.listOfProducts.topFront().toString());
        // luego SI FUNCIONA
        ser.WriteSerializationInicial_AllFiles();// Va a decir que la 2 no se creo porque ya fue creada anteriormente para la prueba anterior
        //ser.deleteAllFiles();
        
        
        
        /*
        // PRUEBAS DE CONEXION API
        // conecccion API pruebas
        ConectionAPI conApi = new ConectionAPI();
        conApi.getDataUsers();
        */
        
        /*
        // PRUEBAS TRAIDA DE DATOS JSON  
        // que se debe de hacer, primero crear un objeto 
        InputDataDB jsonEntrada = new InputDataDB(10000,0);
        InputDataDB jsonEntrada2 = new InputDataDB("C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/",10000, 0 );
        
        //// con el objeto jsonEntrada
        // primero configuro la ruta de la carpeta ya la tengo guardada en el programa si no hacer lo mismo, guardar su path y ya hacer esto 
        jsonEntrada.setYourComputer_pathToCarpet_fileJson(jsonEntrada.PathJhoanComputer);
        System.out.println(jsonEntrada.getYourComputer_pathToCarpet_fileJson()); // mostrar el path 
        
        // luego si se coloco bien el path y existe un archivo de esos de 10000 datos entonces
        // para ver que los datos si se puedan obtener
        jsonEntrada.ShowJson_User();
        // si queremos ver los datos del otro json hay que cambiar el TypeOfFileRead y otras cosas con este metodo
        jsonEntrada.change_TypeOfFileRead(1);
        jsonEntrada.ShowJson_Food();
        
        //Ahora probar otros metodos
        DoubleLinkedList listadoble = jsonEntrada.ofJson_getListProductsFood();
        System.out.println(listadoble.toString());
        Food f1 = (Food) listadoble.topFront();
        System.out.println(f1.getNameProduct());
        
        System.out.println("\n\n PRUEBA 2");
        // ahora cambiar de archivo otra vez
        jsonEntrada.change_TypeOfFileRead(0);
        
        LinkedList listaSimple = jsonEntrada.ofJson_getListDonnor();
        System.out.println(listaSimple.toString());
        Donnor d1 = (Donnor) listaSimple.topFront();
        System.out.println(d1.getEmail()+ "  "+d1.getLocality());
        
     */   
        
    }
    
    // setter y getter de Main

    public static Queue getListForChooseProduct() {
        return listForChooseProduct;
    }

    public static void setListForChooseProduct(Queue listForChooseProduct) {
        Main.listForChooseProduct = listForChooseProduct;
    }

    public static DoubleLinkedList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public static void setListOfProducts(DoubleLinkedList<Product> listOfProducts) {
        Main.listOfProducts = listOfProducts;
    }

    public static LinkedList<Beneficiary> getListOfBeneficiaries() {
        return listOfBeneficiaries;
    }

    public static void setListOfBeneficiaries(LinkedList<Beneficiary> listOfBeneficiaries) {
        Main.listOfBeneficiaries = listOfBeneficiaries;
    }

    public static LinkedList<Donnor> getListOfDonors() {
        return listOfDonors;
    }

    public static void setListOfDonors(LinkedList<Donnor> listOfDonors) {
        Main.listOfDonors = listOfDonors;
    }

    
    
}