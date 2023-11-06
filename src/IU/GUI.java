
package IU;


import Business.Main;
import static Business.Main.listOfProducts;
import static Business.Main.obtenerFechaHoraActualString;
import Data.Beneficiary;
import Data.CompanyDonor;
import Data.Donnor;
import Data.Product;
import Data.Serializador;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_DoubleLinkedList.Stack;
import Estructure_LinkedList.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Estructure_LinkedList.Queue;
import Trees.DisjointSet;

public class GUI {
   
    public static int readIntegerOption(String message){
        int option;
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        option = input.nextInt();
        return option;
    }
    
    public static int readIntegerOption(){
        int option;
        Scanner input = new Scanner(System.in);
        option = input.nextInt();
        return option;
    }
    
    public static String readOptionString(String message){
        String opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println(message);
        opcion = entrada.nextLine();
        return opcion;
    }
    
    public static String readOptionString(){
        String opcion;
        Scanner entrada = new Scanner(System.in);
        opcion = entrada.nextLine();
        return opcion;
    }
    
    public static Long readOptionLong(){
        Long opcion;
        Scanner entrada = new Scanner(System.in);
        opcion = entrada.nextLong();
        return opcion;
    }
    
    public static Boolean readOptionBoolean(String mensaje){
        Boolean opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println(mensaje);
        opcion = entrada.nextBoolean();
        return opcion;
    }
    
    public static void mostrarMenu(){
        System.out.println("--------------Menu General-------------------");
        System.out.println("Ingresa (1) para Crear Usuario, (2) para Iniciar Sesion o (3) para salir");
        int opcion= readIntegerOption("Ingresa una opcion: ");
        if (opcion==1){
            crearUsuario();
        }else if(opcion==2){
            IniciarSesion();
         
        }else if(opcion==3){
            salirMenu();
        }
        else{
            System.out.println("Opcion no valida, vuelve a intentarlo");
            mostrarMenu();
        }
    }
    public static void crearUsuario(){
        System.out.println("Ingresa como quieres registrarte, 1 como beneficiario, 2 como Donador ocasional y 3 como empresa");
        int opcion = readIntegerOption("Porfavor, ingrese alguna opcion: "); 
        if (opcion==1){
            MenuBeneficiario_Donador(1);
        }
        else if(opcion==2){
            MenuBeneficiario_Donador(2);
        }
        else if (opcion==3){
             MenuEmpresa();
        }
        else{
            System.out.println("Opcion no valida, vuelve a intentarlo");
            crearUsuario();
        }
    }
    public static void MenuBeneficiario_Donador(int tipo){
        String nombre=readOptionString("Ingresa tu nombre");
        String apellido=readOptionString("Ingresa tu Apellido");
        String email=readOptionString("Ingresa tu Correo");
        String documento = readOptionString("Ingresa tu documento: ");
        String clave=readOptionString("Ingresa una clave");
        Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        if(tipo==1){
            // Obtener los datos existentes del archivo (si los hay)
            LinkedList<Beneficiary> listaBeneficiarios = (LinkedList<Beneficiary>) Serializador.deserializarObjeto("beneficiarios.dat");
            Beneficiary beneficiario=new Beneficiary(nombre,apellido,email,documento,clave);
            if (listaBeneficiarios == null) {
            listaBeneficiarios = new LinkedList<>();
            }
        listaBeneficiarios.pushBack(beneficiario);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+beneficiario.getEmail()+ " se registro como Beneficiario");

        // Guardar la lista actualizada en el archivo
        Serializador.serializarObjeto(listaBeneficiarios, "beneficiarios.dat");
        System.out.println("Registro exitoso");
        Serializador.serializarObjeto(listActivity, "actividades.dat");
        mostrarMenu();    
        }
        
        else{
            String direccion =readOptionString("Ingresa una direccion:");
            String localidad=readOptionString("Ingresa la localidad");
            LinkedList<Donnor> listaDonadores = (LinkedList<Donnor>) Serializador.deserializarObjeto("donadores.dat");
            Donnor donador=new Donnor(nombre,apellido,email,documento,clave,direccion,localidad);
            if (listaDonadores == null) {
                listaDonadores = new LinkedList<>();
            }
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador.getEmail()+ " se registro como Donador");
        listaDonadores.pushBack(donador);

        // Guardar la lista actualizada en el archivo
        Serializador.serializarObjeto(listaDonadores, "donadores.dat");
        Serializador.serializarObjeto(listActivity, "actividades.dat");
            System.out.println("Registro exitoso");
            mostrarMenu();
        }      
    }
    public static void MenuEmpresa(){
        // Obtener los datos existentes del archivo (si los hay)
        Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        LinkedList<CompanyDonor> listaEmpresas = (LinkedList<CompanyDonor>) Serializador.deserializarObjeto("empresas.dat");
        //LinkedList<CompanyDonor> listaEmpresas = (LinkedList<CompanyDonor>) Serializador.deserializarObjeto("empresa.dat");
        String nombre=readOptionString("Ingresa el nombre de la empresa:");
        String NIT=readOptionString("Ingresa el NIT:");
        String direccion=readOptionString("Ingresa la direccion");
        String localidad=readOptionString("Ingresa la localidad");
        String tipo=readOptionString("Ingresa el tipo de empresa ");
        String email=readOptionString("Ingresa el correo electronico: ");   
        String clave=readOptionString("Ingresa una clave");
        CompanyDonor empresa=new CompanyDonor(nombre,NIT,direccion,localidad,tipo,email, clave);
        //Guardar compañia serializable
         // Agregar la nueva instancia a la lista de datos existentes
        if (listaEmpresas == null) {
            listaEmpresas = new LinkedList<>();
        }
        
        listaEmpresas.pushBack(empresa);
        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+empresa.getEmail()+ " se registro como Empresa");

    // Guardar la lista actualizada en el archivo
    Serializador.serializarObjeto(listaEmpresas, "empresas.dat");
    Serializador.serializarObjeto(listActivity, "actividades.dat");
        System.out.println("Registro exitoso");
        mostrarMenu();
    }
    
    public static void IniciarSesion(){
        int rol = readIntegerOption("Ingresa 1 para ingresar como beneficiario, 2 como donador y 3 como empresa ");
        if (rol==1){
            //verificar los objetos de beneficiarios y guardarlos en un linkedList
            LinkedList<Beneficiary> listaBeneficiarios = Serializador.deserializarObjeto("beneficiarios.dat");
            
            VerificacionLogin(listaBeneficiarios,null,null);
        }else if(rol==2){
            //verificar los objetos de donadores y guardarlos en un linkedList
            LinkedList<Donnor> listaDonadores = Serializador.deserializarObjeto("donadores.dat");
            VerificacionLogin(null,listaDonadores,null);
            
        }else if (rol==3){
            //verificar los objetos de empresas y guardarlos en un linkedList
            LinkedList<CompanyDonor> listaEmpresas = Serializador.deserializarObjeto("empresas.dat");
            VerificacionLogin(null,null,listaEmpresas);
        }
        
        
    }
    public static void VerificacionLogin(LinkedList<Beneficiary> listaBeneficiarios,LinkedList<Donnor> listaDonadores,LinkedList<CompanyDonor> listaEmpresas){
        boolean continuar = true;
        while (continuar) {
            String email = readOptionString("Ingresa el correo electronico: ");
            String clave = readOptionString("Ingresa la clave");

            boolean autenticado = false;
            // Verificar en la lista de empresas
            Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
            if (listaEmpresas != null && !listaEmpresas.empty()) {
                for (int i = 0; i < listaEmpresas.size(); i++) {
                    CompanyDonor empresa = listaEmpresas.get(i);
                    if (empresa.getEmail().equals(email) && empresa.getPassword().equals(clave)) {
                        autenticado = true;
                        System.out.println("Inicio de sesion exitoso para empresas.");
                        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+empresa.getEmail()+ " Inicio Sesion como Empresa");
                        Serializador.serializarObjeto(listActivity, "actividades.dat");
                        MenuRegistrarProducto(email,2);
                        continuar = false;
                        break; // Si se encuentra una coincidencia, no es necesario seguir buscando.
                        
                    }
                }
                System.out.println("Correo o contrasena, incorrecto.Volver a intentarlo");
            }

            // Si no se autenticó como empresa, verificar en la lista de beneficiarios
            else if (!autenticado && listaBeneficiarios != null && !listaBeneficiarios.empty()) {
                for (int i = 0; i < listaBeneficiarios.size(); i++) {
                    Beneficiary beneficiario = listaBeneficiarios.get(i);
                    if (beneficiario.getEmail().equals(email) && beneficiario.getPassword().equals(clave)) {
                        autenticado = true;
                        System.out.println("Inicio de sesion exitoso para beneficiarios.");
                        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+beneficiario.getEmail()+ " Inicio Sesion como Beneficiario");
                        Serializador.serializarObjeto(listActivity, "actividades.dat");
                        menuProductos(email);
                        //Lo lleva al menu de ver los productos de la pila
                        continuar = false;
                        break; // Si se encuentra una coincidencia, no es necesario seguir buscando.
                    }
                }
                System.out.println("Correo o contrasena, incorrecto.Volver a intentarlo");
            }
            

            // Si no se autenticó como beneficiario, verificar en la lista de donadores
            else if (!autenticado && listaDonadores != null && !listaDonadores.empty()) {
                for (int i = 0; i < listaDonadores.size(); i++) {
                    Donnor donador = listaDonadores.get(i);
                    if (donador.getEmail().equals(email) && donador.getPassword().equals(clave)) {
                        autenticado = true;
                        System.out.println("Inicio de sesion exitoso para donadores.");
                        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador.getEmail()+ " Inicio Sesion como Donador");
                        Serializador.serializarObjeto(listActivity, "actividades.dat");
                        MenuRegistrarProducto(email,1);
                        continuar = false;
                        break; // Si se encuentra una coincidencia, no es necesario seguir buscando.
                    }
                }
                System.out.println("Correo o contrasena, incorrecto.Volver a intentarlo");
          
            }

        }
    }
    public static void menuProductos(String email){
        System.out.println("------------Estos son los productos que hay disponibles---------------");
         // Deserializar la lista de productos desde el archivo "productos.dat"
        DoubleLinkedList<Product> listaProductos = Serializador.deserializarObjeto("productos.dat");
        Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        // Verificar si la lista de productos se cargó correctamente
        if (listaProductos != null) {
            // Mostrar la lista de productos
            System.out.println(listaProductos.toString());
            String producto=readOptionString("Ingresa el nombre del producto que deseas");
            listaProductos.removeProductByQuantity(producto);
            System.out.println("Lista actualizada:");
            System.out.println(listaProductos.toString());
            Serializador.serializarObjeto(listaProductos, "productos.dat");
            System.out.println("Ya quedo apartado, te puedes contactar con el donador ");
            listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+email+ " Aparto "+producto);
            Serializador.serializarObjeto(listActivity, "actividades.dat");
             mostrarMenu();
            }
    }
    public static void MenuRegistrarProducto(String email,int rol){
         Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        // Obtener los datos existentes del archivo (si los hay)
        DoubleLinkedList<Product> listaProductos = (DoubleLinkedList<Product>) Serializador.deserializarObjeto("productos.dat");
        LinkedList<Product> indicesProductos = (LinkedList<Product>) Serializador.deserializarObjeto("indicesProductos.dat");
        LinkedList<Donnor> donadores = (LinkedList<Donnor>) Serializador.deserializarObjeto("donadores.dat");
        DisjointSet donanteSet = (DisjointSet)Serializador.deserializarObjeto("donantesset.dat");
        System.out.println("-----------------Registro de Productos--------------------------");
        String tipo=readOptionString("Ingresa el tipo de producto que deseas donar");
        String producto=readOptionString("Ingresa el nombre del producto que deseas donar");
        int cantidad = readIntegerOption("Ingresa la cantidad del producto, para mas de un beneficiario ");
        Product productox = new Product(tipo, producto,cantidad ,email);
         //Guardar productos serializable
         // Agregar la nueva instancia a la lista de datos existentes
        if (listaProductos == null) {
            listaProductos = new DoubleLinkedList<Product>();
        }
        listaProductos.pushFront(productox);
        indicesProductos.pushBack(productox);
        //Main.listOfProducts.pushFront(productox);
        //agregar producto al conjunto disyunto
        if (rol==1){
            // Obtiene el índice del donador en la lista de donadores
            //int indiceDonador = Main.listOfDonors.indexOf(donador);
            int indiceDonador = donadores.indexOfDonnorByEmail(email);
            // Obtiene el índice del producto en la lista de productos
            int indiceProducto=indicesProductos.indexOf(productox);
            // Une el producto con el donador utilizando sus índices en el conjunto disjunto
            //System.out.println("IndiceDonador:"+indiceDonador+", indice Producto:"+indiceProducto);
            //Main.donanteSet.union(indiceDonador, indiceProducto);
            donanteSet.union(indiceDonador, indiceProducto);
            Serializador.serializarObjeto(listaProductos, "productos.dat");
            Serializador.serializarObjeto(indicesProductos, "indicesProductos.dat");
            Serializador.serializarObjeto(donanteSet, "donantesset.dat");
            showProductsByDonor(obtenerDonadorPorEmail(email,donadores));
        }
        else{
             LinkedList<CompanyDonor> empresas = (LinkedList<CompanyDonor>) Serializador.deserializarObjeto("empresas.dat");
             DisjointSet empresaSet = (DisjointSet)Serializador.deserializarObjeto("empresaset.dat");
            int indiceEmpresa = empresas.indexOfCompanyByEmail(email);
            
            // Obtiene el índice del producto en la lista de productos
            //int indiceProducto=Main.listOfProducts.indexOf(productox);
            int indiceProducto=indicesProductos.indexOf(productox);
            // Une el producto con el donador utilizando sus índices en el conjunto disjunto
            empresaSet.union(indiceEmpresa, indiceProducto);
            Serializador.serializarObjeto(listaProductos, "productos.dat");
            Serializador.serializarObjeto(indicesProductos, "indicesProductos.dat");
            Serializador.serializarObjeto(empresaSet, "empresaset.dat");
            showProductsByCompanyDonor(obtenerCompanyDonorPorEmail(email,empresas));
        }
         // Guardar la lista actualizada en el archivo
         //Serializador.serializarObjeto(listaProductos, "productos.dat");
         //Serializador.serializarObjeto(indicesProductos, "indicesProductos.dat");
         System.out.println("Registro exitoso, gracias por tu donacion");
         listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+email+ " Registro "+producto);
         Serializador.serializarObjeto(listActivity, "actividades.dat");
         mostrarMenu();
    }
    
    public static void salirMenu(){
        Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        System.out.println("Gracias por utilizar el programa");
        System.out.println("-------------Lista de Actividades-----------------");
        while(!listActivity.empty()){
            System.out.println(listActivity.pop());
            //System.out.println("\n");
        }
        System.exit(0); // ACA HUBO CAMBIO
    }
    
    public static void showProductsByDonor(Donnor donador) {
        LinkedList<Product> indicesProductos = (LinkedList<Product>) Serializador.deserializarObjeto("indicesProductos.dat");
        DoubleLinkedList<Product> productsByDonor = new DoubleLinkedList<>();

        // Itera sobre la lista de productos para encontrar los asociados al donador
        for (int i = 0; i < indicesProductos.size(); i++) {
            Product product = indicesProductos.get(i);

            // Compara el correo electrónico del producto con el correo electrónico del donador
            if (product.getEmailDonor().equals(donador.getEmail())) {
                productsByDonor.pushBack(product);
            }
        }

        // Muestra los productos asociados al donador
        if (!productsByDonor.empty()) {
            System.out.println("Productos asociados al donador " + donador.getEmail() + ":");
            for (int i = 0; i < productsByDonor.size(); i++) {
                Product product = productsByDonor.get(i);
                System.out.println("Nombre: " + product.getNameProduct() + ", Categoría: " + product.getTypeProduct() + ", Cantidad: " + product.getQuantity());
            }
        } else {
            System.out.println("No hay productos asociados al donador " + donador.getName());
        }
    }

    public static void showProductsByCompanyDonor(CompanyDonor empresa) {
        LinkedList<Product> indicesProductos = (LinkedList<Product>) Serializador.deserializarObjeto("indicesProductos.dat");
        DoubleLinkedList<Product> productsByCompanyDonor = new DoubleLinkedList<>();

        // Itera sobre la lista de productos para encontrar los asociados a la empresa donadora
        for (int i = 0; i < indicesProductos.size(); i++) {
            Product product = indicesProductos.get(i);

            // Compara el correo electrónico del producto con el correo electrónico de la empresa donadora
            if (product.getEmailDonor().equals(empresa.getEmail())) {
                productsByCompanyDonor.pushBack(product);
            }
        }

        // Muestra los productos asociados a la empresa donadora
        if (!productsByCompanyDonor.empty()) {
            System.out.println("Productos asociados a la empresa donadora " + empresa.getEmail() + ":");
            for (int i = 0; i < productsByCompanyDonor.size(); i++) {
                Product product = productsByCompanyDonor.get(i);
                System.out.println("Nombre: " + product.getNameProduct() + ", Categoría: " + product.getTypeProduct() + ", Cantidad: " + product.getQuantity());
            }
        } else {
            System.out.println("No hay productos asociados a la empresa donadora " + empresa.getName());
        }
    }
    
    public static CompanyDonor obtenerCompanyDonorPorEmail(String email,LinkedList<CompanyDonor> listaEmpresas) {
        for (int i = 0; i < listaEmpresas.size(); i++) {
            CompanyDonor empresa = listaEmpresas.get(i); // Obtén la empresa en la posición i

            // Compara el correo electrónico de la empresa con el correo electrónico proporcionado
            if (empresa.getEmail().equals(email)) {
                return empresa; // Se encontró una empresa con el correo electrónico proporcionado
            }
        }

        // No se encontró una empresa con el correo electrónico proporcionado
        return null;
    }
    
    public static Donnor obtenerDonadorPorEmail(String email, LinkedList<Donnor> listOfDonors) {
        for (int i = 0; i < listOfDonors.size(); i++) {
            Donnor donador = listOfDonors.get(i); // Obtén el donador en la posición i

            // Compara el correo electrónico del donador con el correo electrónico proporcionado
            if (donador.getEmail().equals(email)) {
                return donador; // Se encontró un donador con el correo electrónico proporcionado
            }
        }

        // No se encontró un donador con el correo electrónico proporcionado
        return null;
    }
  
    
   

    
    // COSAS QUE faltan crear los metodos de funcionalidades 
    // En las estructuras falta crear el metodo delete;
    //
    // (probar)ya en data.serialization, Crear un metodo para crear en la serializacion de objestos, es decir mirar si existen las listas y guardarlas 
    // (probar)ya en data.serialization, crear un metodo para sacar la listas del archivos serializados 
   
}
