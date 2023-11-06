
package IU;


import Business.Main;
import static Business.Main.obtenerFechaHoraActualString;
import Data.Beneficiario;
import Data.DonadorCompania;
import Data.Donador;
import Data.Producto;
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
import java.util.ArrayList;
import java.util.List;

import Estructure_LinkedList.Queue;

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
            LinkedList<Beneficiario> listaBeneficiarios = (LinkedList<Beneficiario>) Serializador.deserializarObjeto("beneficiarios.dat");
            Beneficiario beneficiario=new Beneficiario(nombre,apellido,email,documento,clave);
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
            LinkedList<Donador> listaDonadores = (LinkedList<Donador>) Serializador.deserializarObjeto("donadores.dat");
            Donador donador=new Donador(nombre,apellido,email,documento,clave,direccion,localidad);
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
        LinkedList<DonadorCompania> listaEmpresas = (LinkedList<DonadorCompania>) Serializador.deserializarObjeto("empresas.dat");
        //LinkedList<CompanyDonor> listaEmpresas = (LinkedList<CompanyDonor>) Serializador.deserializarObjeto("empresa.dat");
        String nombre=readOptionString("Ingresa el nombre de la empresa:");
        String NIT=readOptionString("Ingresa el NIT:");
        String direccion=readOptionString("Ingresa la direccion");
        String localidad=readOptionString("Ingresa la localidad");
        String tipo=readOptionString("Ingresa el tipo de empresa ");
        String email=readOptionString("Ingresa el correo electronico: ");   
        String clave=readOptionString("Ingresa una clave");
        DonadorCompania empresa=new DonadorCompania(nombre,NIT,direccion,localidad,tipo,email, clave);
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
            LinkedList<Beneficiario> listaBeneficiarios = Serializador.deserializarObjeto("beneficiarios.dat");
            
            VerificacionLogin(listaBeneficiarios,null,null);
        }else if(rol==2){
            //verificar los objetos de donadores y guardarlos en un linkedList
            LinkedList<Donador> listaDonadores = Serializador.deserializarObjeto("donadores.dat");
            VerificacionLogin(null,listaDonadores,null);
            
        }else if (rol==3){
            //verificar los objetos de empresas y guardarlos en un linkedList
            LinkedList<DonadorCompania> listaEmpresas = Serializador.deserializarObjeto("empresas.dat");
            VerificacionLogin(null,null,listaEmpresas);
        }
        
        
    }
    public static void VerificacionLogin(LinkedList<Beneficiario> listaBeneficiarios,LinkedList<Donador> listaDonadores,LinkedList<DonadorCompania> listaEmpresas){
        boolean continuar = true;
        while (continuar) {
            String email = readOptionString("Ingresa el correo electronico: ");
            String clave = readOptionString("Ingresa la clave");

            boolean autenticado = false;
            // Verificar en la lista de empresas
            Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
            if (listaEmpresas != null && !listaEmpresas.empty()) {
                for (int i = 0; i < listaEmpresas.size(); i++) {
                    DonadorCompania empresa = listaEmpresas.get(i);
                    if (empresa.getEmail().equals(email) && empresa.getPassword().equals(clave)) {
                        autenticado = true;
                        System.out.println("Inicio de sesion exitoso para empresas.");
                        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+empresa.getEmail()+ " Inicio Sesion como Empresa");
                        Serializador.serializarObjeto(listActivity, "actividades.dat");
                        MenuRegistrarProducto(email);
                        continuar = false;
                        break; // Si se encuentra una coincidencia, no es necesario seguir buscando.
                        
                    }
                }
                System.out.println("Correo o contrasena, incorrecto.Volver a intentarlo");
            }

            // Si no se autenticó como empresa, verificar en la lista de beneficiarios
            else if (!autenticado && listaBeneficiarios != null && !listaBeneficiarios.empty()) {
                for (int i = 0; i < listaBeneficiarios.size(); i++) {
                    Beneficiario beneficiario = listaBeneficiarios.get(i);
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
                    Donador donador = listaDonadores.get(i);
                    if (donador.getEmail().equals(email) && donador.getPassword().equals(clave)) {
                        autenticado = true;
                        System.out.println("Inicio de sesion exitoso para donadores.");
                        listActivity.push(obtenerFechaHoraActualString()+": El usuario, "+donador.getEmail()+ " Inicio Sesion como Donador");
                        Serializador.serializarObjeto(listActivity, "actividades.dat");
                        MenuRegistrarProducto(email);
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
        DoubleLinkedList<Producto> listaProductos = Serializador.deserializarObjeto("productos.dat");
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
    public static void MenuRegistrarProducto(String email){
         Stack<String> listActivity=(Stack<String>) Serializador.deserializarObjeto("actividades.dat");
        // Obtener los datos existentes del archivo (si los hay)
        DoubleLinkedList<Producto> listaProductos = (DoubleLinkedList<Producto>) Serializador.deserializarObjeto("productos.dat");
        System.out.println("-----------------Registro de Productos--------------------------");
        String tipo=readOptionString("Ingresa el tipo de producto que deseas donar");
        String producto=readOptionString("Ingresa el nombre del producto que deseas donar");
        int cantidad = readIntegerOption("Ingresa la cantidad del producto, para mas de un beneficiario ");
        Producto productox = new Producto(tipo, producto,cantidad ,email);
         //Guardar productos serializable
         // Agregar la nueva instancia a la lista de datos existentes
        if (listaProductos == null) {
            listaProductos = new DoubleLinkedList<Producto>();
        }
        listaProductos.pushFront(productox);

         // Guardar la lista actualizada en el archivo
         Serializador.serializarObjeto(listaProductos, "productos.dat");
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
   

    
    // COSAS QUE faltan crear los metodos de funcionalidades 
    // En las estructuras falta crear el metodo delete;
    //
    // (probar)ya en data.serialization, Crear un metodo para crear en la serializacion de objestos, es decir mirar si existen las listas y guardarlas 
    // (probar)ya en data.serialization, crear un metodo para sacar la listas del archivos serializados 
   
}
