package Business;
import Data.Producto;
import Data.Beneficiario;
import Data.DonadorCompania;
import Data.Donador;
import Data.Serializador;
import Data.Comida;
import Data.Usuario;
import Estructure_LinkedList.Queue;
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DinamicArray.DinamicArray;

import static IU.GUI.mostrarMenu;
import Estructure_DoubleLinkedList.Stack;

import EstructurasCorte2.DisjointSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Main <T>{

    private static Queue<Beneficiario> listForChooseProduct = new Queue(); // primero una cola para poner los beneficiarios por orden de llegada
    private static Stack<String> listActivity=new Stack(); //Registro de Actividades
    public static DoubleLinkedList<Producto> listOfProducts = new DoubleLinkedList(); // segundo una lista donde se van a poner todos los productos
    public static LinkedList<Producto> indicesProductos= new LinkedList();
    private static DinamicArray<Comida> listOfProducts_DA = new DinamicArray();
    public static DisjointSet donanteSet;
    public static DisjointSet empresaSet;

    //private static LinkedList<Beneficiary> listOfBeneficiaries= new LinkedList();
    private static LinkedList<Donador> listOfDonors = new LinkedList();
    private static LinkedList<DonadorCompania> listaEmpresas = new LinkedList();

    // lo de historial de acciones esta en la clase donador
    // luego cada donador tiene enlazado un producto



    public static void main(String[] args) {

        // PRUEBA LISTA DE OBJETOS
        /*
        Producto producto = new Producto("FOOD", "Harina", 5,"murrami@gmail.com");
        Producto producto2 = new Producto("FOOD", "Frijol", 5,"murrami@gmail.com");
        Producto producto3 = new Producto("Ropa", "Camiseta", 1, "carmar@gmail.com");
        Producto producto4 = new Producto("FOOD", "Cebolla", 5, "surti@gmail.com");
        Producto producto5 = new Producto("FOOD", "Arveja", 5, "surti@gmail.com");
         Producto producto6 = new Producto("FOOD", "Atun", 5, "losreyes@gmail.com");
        //agregar productos
        listOfProducts.pushFront(producto);
        indicesProductos.pushBack(producto);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto2);
        indicesProductos.pushBack(producto2);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto2.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto3);
        indicesProductos.pushBack(producto3);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto3.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto4);
        indicesProductos.pushBack(producto4);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto4.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto5);
        indicesProductos.pushBack(producto5);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto5.getEmailDonor()+ " agrego un producto");
        listOfProducts.pushFront(producto6);
        indicesProductos.pushBack(producto6);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto6.getEmailDonor()+ " agrego un producto");
        Serializador.serializarObjeto(listOfProducts, "productos.dat");
        Serializador.serializarObjeto(indicesProductos, "indicesProductos.dat");
         // Agregar empresas a la lista
        DonadorCompania empresa1 = new DonadorCompania("Surtifruver","545645-6","calle 43","Kennedy","super","surti@gmail.com","12345");
        listaEmpresas.pushBack(empresa1);
        listActivity.push(obtenerFechaHoraActualString()+": Se registo la empresa, "+empresa1.getName());
        DonadorCompania empresa2 = new DonadorCompania("Los Reyes","745542-4","calle 36","Kennedy","super","losreyes@gmail.com","12345");
        listaEmpresas.pushBack(empresa2);
        listActivity.push(obtenerFechaHoraActualString()+": Se registo la empresa, "+empresa2.getName());
        // Guardar la lista de empresas en un archivo serializable
        Serializador.serializarObjeto(listaEmpresas, "empresas.dat");
        //Agregar Beneficiarios a la lista
        Beneficiario beneficiario=new Beneficiario("Felipe","Alvarez Ramirez","felalvarez@gmail.com","52483767","12345");
        listForChooseProduct.enqueue(beneficiario);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+beneficiario.getEmail()+ " se registro como beneficiario");
        // Guardar la lista de beneficiarios en un archivo serializable
        Serializador.serializarObjeto(listForChooseProduct, "beneficiarios.dat");
        //Agregar Donador a la lista
        Donador donador=new Donador("Alberto","Murillo Ramirez","murrami@gmail.com","3424242","12345","calle 45#56","Kennedy");
        Donador donador1=new Donador("Carlos","Martinez Ramirez","carmar@gmail.com","34243532","12345","calle 65#13","Chapinero");
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador.getEmail()+ " se registro como donador ocasional");
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador1.getEmail()+ " se registro como donador ocasional");
        listOfDonors.pushBack(donador);
        listOfDonors.pushBack(donador1);
        Serializador.serializarObjeto(listOfDonors, "donadores.dat");
        Serializador.serializarObjeto(listActivity, "actividades.dat");
       
        int numDonantes = 100; // El número de donantes max
        int numEmpresa = 50; // El número de empresas max
        //int numProductos = 100; // El número de productos
        
        donanteSet = new DisjointSet(numDonantes);
        empresaSet = new DisjointSet(numEmpresa);
        //DisjointSet productoSet = new DisjointSet(numProductos);
        // Obtén los índices del donante y del producto en sus respectivas listas.
        int indiceDonante = listOfDonors.indexOfDonnorByEmail("murrami@gmail.com");
        int indiceDonante1 = listOfDonors.indexOfDonnorByEmail("carmar@gmail.com");
        int indiceProducto = listOfProducts.indexOf(producto);
        int indiceProducto1 = listOfProducts.indexOf(producto2);
        int indiceProducto2 = listOfProducts.indexOf(producto3);
        //indice empresa
        int indiceEmpresa=listaEmpresas.indexOfCompanyByEmail("surti@gmail.com");
        System.out.println("Indice empresa"+indiceEmpresa);
        int indiceProducto3 = listOfProducts.indexOf(producto4);
        int indiceProducto4 = listOfProducts.indexOf(producto5);
        // Une el producto con el donante utilizando sus índices en los conjuntos disjuntos.
        donanteSet.union(indiceDonante, indiceProducto);
        donanteSet.union(indiceDonante, indiceProducto1);
        donanteSet.union(indiceDonante1, indiceProducto2);
        Serializador.serializarObjeto(donanteSet, "donantesset.dat");
        //unir producto con la empresa
        empresaSet.union(indiceEmpresa, indiceProducto3);
        empresaSet.union(indiceEmpresa, indiceProducto4);
        Serializador.serializarObjeto(empresaSet, "empresaset.dat");

        //Donnor donadorEspecifico = donador1; // Obtén el donador de alguna manera (puede ser por email, por ejemplo)

        // Llama al método que obtiene y muestra los productos asociados al donador
        //showProductsByDonor(donadorEspecifico);
        // Supongamos que deseas saber a qué donante se asignó un producto en particular.
        */
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
     /*
    public static Donador obtenerDonadorPorEmail(String email) {
        for (int i = 0; i < listOfDonors.size(); i++) {
            Donador donador = listOfDonors.get(i); // Obtén el donador en la posición i

            // Compara el correo electrónico del donador con el correo electrónico proporcionado
            if (donador.getEmail().equals(email)) {
                return donador; // Se encontró un donador con el correo electrónico proporcionado
            }
        }

        // No se encontró un donador con el correo electrónico proporcionado
        return null;
    }
   
    public static DonadorCompania obtenerCompanyDonorPorEmail(String email) {
        for (int i = 0; i < listaEmpresas.size(); i++) {
            DonadorCompania empresa = listaEmpresas.get(i); // Obtén la empresa en la posición i

            // Compara el correo electrónico de la empresa con el correo electrónico proporcionado
            if (empresa.getEmail().equals(email)) {
                return empresa; // Se encontró una empresa con el correo electrónico proporcionado
            }
        }

        // No se encontró una empresa con el correo electrónico proporcionado
        return null;
    }
    */

    public static Queue getListForChooseProduct() {
        return listForChooseProduct;
    }

    public static void setListForChooseProduct(Queue listForChooseProduct) {
        Main.listForChooseProduct = listForChooseProduct;
    }

    public static DoubleLinkedList<Producto> getListOfProducts() {
        return listOfProducts;
    }

    public static void setListOfProducts(DoubleLinkedList<Producto> listOfProducts) {
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
    public static LinkedList<Donador> getListOfDonors() {
        return listOfDonors;
    }

    public static void setListOfDonors(LinkedList<Donador> listOfDonors) {
        Main.listOfDonors = listOfDonors;
    }

    public static DinamicArray<Comida> getListOfProducts_DA() {
        return listOfProducts_DA;
    }

    public static void setListOfProducts_DA(DinamicArray<Comida> listOfProducts_DA) {
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
        Comida f1 = (Comida) listadoble.topFront();
        System.out.println(f1.getNameProduct());
        /*
        System.out.println("\n\n PRUEBA 2");
        // ahora cambiar de archivo otra vez
        jsonEntrada.change_TypeOfFileRead(0);

        LinkedList listaSimple = jsonEntrada.ofJson_getListDonnor();
        System.out.println(listaSimple.toString());
        Donador d1 = (Donador) listaSimple.topFront();
        System.out.println(d1.getEmail()+ "  "+d1.getLocality());
        
     */   
