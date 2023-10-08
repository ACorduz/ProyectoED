
package IU;


import Business.Main;
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
        System.out.println("Ingresa (1) para Crear Usuario o (2) para Iniciar Sesion");
        int opcion= readIntegerOption("Ingresa una opcion: ");
        if (opcion==1){
            //crearUsuario();
        }else if(opcion==2){
            //IniciarSesion();
        }else{
            System.out.println("Opcion no valida, vuelve a intentarlo");
            mostrarMenu();
        }
    }
    
    public static void salirMenu(){
        System.out.println("Gracias por utilizar el programa");
        System.exit(0); // ACA HUBO CAMBIO
    }
   

    
    // COSAS QUE faltan crear los metodos de funcionalidades 
    // En las estructuras falta crear el metodo delete;
    //
    // (probar)ya en data.serialization, Crear un metodo para crear en la serializacion de objestos, es decir mirar si existen las listas y guardarlas 
    // (probar)ya en data.serialization, crear un metodo para sacar la listas del archivos serializados 
   
}
