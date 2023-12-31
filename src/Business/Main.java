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
import Trees.AVLTree;
import Trees.DisjointSet;
import Trees.BinaryHeap;
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
        AVLTree avlTree = new AVLTree();
        //Product producto = new Producto("FOOD", "Harina", 5,"murrami@gmail.com");
        Producto producto = new Producto("Food", "Sopa enlatada", 65, "murrami@gmail.com", 2024 ,2, 2); 
        avlTree.root = avlTree.insert(avlTree.root, producto);
        //avlTree.printInOrder();
        Producto producto2 = new Producto("Food", "Avena", 65, "murrami@gmail.com", 2025 ,2, 2);
        //avlTree.root = avlTree.insert(avlTree.root, producto2);
        Producto producto3 = new Producto("Food", "Garbanzo ", 65, "murrami@gmail.com", 2023 ,12, 29);
        //avlTree.root = avlTree.insert(avlTree.root, producto3);
        Producto producto4 = new Producto("Food", "Frijol ", 65, "carmar@gmail.com", 2023 ,12, 11);
        //avlTree.root = avlTree.insert(avlTree.root, producto4);
        Producto producto5 = new Producto("Food", "Pollo ", 65, "surti@gmail.com", 2023 ,12, 9);
        //avlTree.root = avlTree.insert(avlTree.root, producto5);
        Producto producto6 = new Producto("FOOD", "Atun", 5, "losreyes@gmail.com",2024,5,22);
        Producto producto7 = new Producto("FOOD", "Aceite", 10, "losreyes@gmail.com",2024,5,22);
        Producto producto8 = new Producto("FOOD", "Zanahoria", 6, "surti@gmail.com",2024,2,12);
        Producto producto9 = new Producto("FOOD", "Banano", 12, "surti@gmail.com",2023,12,12);
        Producto producto10 = new Producto("FOOD", "Limon", 14, "surti@gmail.com",2023,12,15);
        Producto producto11 = new Producto("FOOD", "Kiwi", 9, "surti@gmail.com",2024,3,11);
        Producto producto12 = new Producto("FOOD", "Lenteja", 23, "murrami@gmail.com",2023,12,19);
        Producto producto13 = new Producto("FOOD", "Cabezona", 45, "murrami@gmail.com",2023,12,22);
        //avlTree.root = avlTree.insert(avlTree.root, producto6);
        //BinaryHeap hc=new BinaryHeap();
        /*
        hc.insert(producto);
        hc.insert(producto2);
        hc.insert(producto3);
        hc.insert(producto4);
        hc.insert(producto5);
        hc.insert(producto6);
        System.out.println("Elementos del montículo:");
        hc.printHeap();
        */
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
        listOfProducts.pushFront(producto7);
        indicesProductos.pushBack(producto7);
        listOfProducts.pushFront(producto8);
        indicesProductos.pushBack(producto8);
        listOfProducts.pushFront(producto9);
        indicesProductos.pushBack(producto9);
        listOfProducts.pushFront(producto10);
        indicesProductos.pushBack(producto10);
         listOfProducts.pushFront(producto11);
        indicesProductos.pushBack(producto11);
         listOfProducts.pushFront(producto12);
        indicesProductos.pushBack(producto12);
         listOfProducts.pushFront(producto13);
        indicesProductos.pushBack(producto13);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+producto6.getEmailDonor()+ " agrego un producto");
        Serializador.serializarObjeto(listOfProducts, "productos.dat");
        Serializador.serializarObjeto(indicesProductos, "indicesProductos.dat");
        //Serializador.serializarObjeto(avlTree, "productosAVL.dat");
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
        Beneficiario beneficiario=new Beneficiario("Felipe","Alvarez Ramirez","felalvarez@gmail.com","CC","52483767","12345");
        listForChooseProduct.enqueue(beneficiario);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+beneficiario.getEmail()+ " se registro como beneficiario");
        // Guardar la lista de beneficiarios en un archivo serializable
        Serializador.serializarObjeto(listForChooseProduct, "beneficiarios.dat");
        //Agregar Donador a la lista
        Donador donador=new Donador("Alberto","Murillo Ramirez","murrami@gmail.com","CC","3424242","12345","calle 45#56","Kennedy");
        Donador donador1=new Donador("Carlos","Martinez Ramirez","carmar@gmail.com","CC", "34243532","12345","calle 65#13","Chapinero");
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
        
        /*
        Comida f1 = new Comida("Comida", "Sopa enlatada", 65, "alejandragomez@example.com", 2024 ,2, 2); 
        Comida f2 = new Comida("Comida", "Avena", 65, "alejandragomez@example.com", 2025 ,2, 2); 
        Comida f3 = new Comida("Comida", "Garbanzo ", 65, "alejandragomez@example.com", 2013 ,5, 9);
        Comida f4 = new Comida("Comida", "Frijol ", 65, "alejandragomez@example.com", 2018 ,5, 9);
        Comida f5 = new Comida("Comida", "Pollo ", 65, "alejandragomez@example.com", 2023 ,5, 9);
        BinaryHeap hc=new BinaryHeap();
        
        hc.insert(f1);
        hc.insert(f2);
        hc.insert(f3);
        hc.insert(f4);
        hc.insert(f5);
        //hc.siftDown(0);
        System.out.println("Elementos del montículo:");
        hc.printHeap();
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
    public static int obtenerIndiceDonnorEnLista(Donador donador) {
        return listOfDonors.indexOf(donador);
    }
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
