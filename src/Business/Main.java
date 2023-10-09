package Business;
import Data.Product;
import Data.Beneficiary;
import Data.CompanyDonor;
import Data.Donnor;
import Data.Serializador;
import Data.Food;
import Data.User;
import Estructure_LinkedList.Queue;
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DinamicArray.DinamicArray;
import Data.serialization;
import static IU.GUI.mostrarMenu;
import Estructure_DoubleLinkedList.Stack;
import Logic.ConectionAPI;
import Logic.InputDataJSON;
import functionalities.RegistroComida;
import Logic.InputDataJSON;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Main <T>{

    private static Queue<Beneficiary> listForChooseProduct = new Queue(); // primero una cola para poner los beneficiarios por orden de llegada
    private static Stack<String> listActivity=new Stack(); //Registro de Actividades
    private static DoubleLinkedList<Product> listOfProducts = new DoubleLinkedList(); // segundo una lista donde se van a poner todos los productos
    private static DinamicArray<Food> listOfProducts_DA = new DinamicArray();

    //private static LinkedList<Beneficiary> listOfBeneficiaries= new LinkedList();
    private static LinkedList<Donnor> listOfDonors = new LinkedList();
    private static LinkedList<CompanyDonor> listaEmpresas = new LinkedList();

    // lo de historial de acciones esta en la clase donador
    // luego cada donador tiene enlazado un producto



    public static void main(String[] args) {

        // PRUEBA LISTA DE OBJETOS
        Product producto = new Product("FOOD", "Harina", 5,"felipe@gmail");
        Product producto2 = new Product("FOOD", "Frijol", 5,"vivian@gmail");
        Product producto3 = new Product("Ropa", "Camiseta", 1, "antonio@gmail");
        //agregar productos
        listOfProducts.pushFront(producto);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto2);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto2.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto3);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto3.getEmailDonor()+ " agrego un producto");
        //Serializador.serializarObjeto(listOfProducts, "productos.dat");
         // Agregar empresas a la lista
        CompanyDonor empresa1 = new CompanyDonor("Surtifruver","545645-6","calle 43","Kennedy","super","surti@gmail.com","12345");
        listaEmpresas.pushBack(empresa1);
        listActivity.push(obtenerFechaHoraActualString()+": Se registo la empresa, "+empresa1.getName());
        // Guardar la lista de empresas en un archivo serializable
        //Serializador.serializarObjeto(listaEmpresas, "empresas.dat");
        //Agregar Beneficiarios a la lista
        Beneficiary beneficiario=new Beneficiary("Felipe","Alvarez Ramirez","felalvarez@gmail.com","52483767","12345");
        listForChooseProduct.enqueue(beneficiario);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+beneficiario.getEmail()+ " se registro como beneficiario");
        // Guardar la lista de beneficiarios en un archivo serializable
        //Serializador.serializarObjeto(listForChooseProduct, "beneficiarios.dat");
        //Agregar Donador a la lista
        Donnor donador=new Donnor("Alberto","Murillo Ramirez","murrami@gmail.com","3424242","12345","calle 45#56","Kennedy");
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador.getEmail()+ " se registro como donador ocasional");
        //Serializador.serializarObjeto(listOfDonors, "donador.dat");
        Serializador.serializarObjeto(listActivity, "actividades.dat");
        mostrarMenu();
        
        
        /*
        System.out.println(Runtime.getRuntime().maxMemory());
        serialization ser = new serialization();
        ser.deleteAllFiles();
        ser.WriteSerializationInicial_AllFiles(); // Crear todas las listas inciales vacias por si no lo esta
        // se crea un objeto Injson
        //PARA
        InputDataJSON injson = new InputDataJSON(1000000,1);
        injson.setYourComputer_pathToCarpet_fileJson(injson.PathJhoanComputer);

        //injson.ShowFoodByName("");

        String email1 = "camilasuarez@example.org";
        String email2 = "edwin56@example.org";
        // ahora se llama a ese metodo para crear datos
        //injson.ofJson_proof_MasiveData_RC_DLL(email1,email2);
        //ser.saveStatusListProgram(1);



        injson.ofJson_proof_MasiveData_RC_DA(email1,email2);
        // esto deberia guardarlos, pero creo ahi esta el error
        //ser.saveStatusListProgram(4);

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
/*
    public static LinkedList<Beneficiary> getListOfBeneficiaries() {
        return listOfBeneficiaries;
    }

    public static void setListOfBeneficiaries(LinkedList<Beneficiary> listOfBeneficiaries) {
        Main.listOfBeneficiaries = listOfBeneficiaries;
    }
*/
    public static LinkedList<Donnor> getListOfDonors() {
        return listOfDonors;
    }

    public static void setListOfDonors(LinkedList<Donnor> listOfDonors) {
        Main.listOfDonors = listOfDonors;
    }

    public static DinamicArray<Food> getListOfProducts_DA() {
        return listOfProducts_DA;
    }

    public static void setListOfProducts_DA(DinamicArray<Food> listOfProducts_DA) {
        Main.listOfProducts_DA = listOfProducts_DA;
    }
    public static String obtenerFechaHoraActualString() {
        // Obtener la fecha y hora actuales
        LocalDateTime fechaYHoraActual = LocalDateTime.now();

        // Crear un formateador de fecha y hora
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Formatear la fecha y hora actual como una cadena
        String fechaHoraFormateada = fechaYHoraActual.format(formateador);

        return fechaHoraFormateada;
    }

}

//Pruebas para ver que el codigo funcione bien


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
        //InputDataDB jsonEntrada2 = new InputDataDB("C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/",10000, 0 );

        //// con el objeto jsonEntrada
        // primero configuro la ruta de la carpeta ya la tengo guardada en el programa si no hacer lo mismo, guardar su path y ya hacer esto
        jsonEntrada.setYourComputer_pathToCarpet_fileJson(jsonEntrada.PathJhoanComputer);
        System.out.println(jsonEntrada.getYourComputer_pathToCarpet_fileJson()); // mostrar el path

        // luego si se coloco bien el path y existe un archivo de esos de 10000 datos entonces
        // para ver que los datos si se puedan obtener
        jsonEntrada.ShowJson_User();
        jsonEntrada.ShowUserByName("Jose");//Muestra la información de las personas llamadas 'Jose'
        // si queremos ver los datos del otro json hay que cambiar el TypeOfFileRead y otras cosas con este metodo
        jsonEntrada.change_TypeOfFileRead(1);
        jsonEntrada.ShowJson_Food();
        jsonEntrada.ShowFoodByName("Pasta");//Muestra la información de todos los productos con nombre 'Pasta'

        //Ahora probar otros metodos
        DoubleLinkedList listadoble = jsonEntrada.ofJson_getListProductsFood();
        System.out.println(listadoble.toString());
        Food f1 = (Food) listadoble.topFront();
        System.out.println(f1.getNameProduct());
        /*
        System.out.println("\n\n PRUEBA 2");
        // ahora cambiar de archivo otra vez
        jsonEntrada.change_TypeOfFileRead(0);

        LinkedList listaSimple = jsonEntrada.ofJson_getListDonnor();
        System.out.println(listaSimple.toString());
        Donnor d1 = (Donnor) listaSimple.topFront();
        System.out.println(d1.getEmail()+ "  "+d1.getLocality());
        
     */   
