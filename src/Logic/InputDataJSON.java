package Logic;
// librerias para el Json 
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// importamos estructuras para sacar listas de comida y demas
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Data.Beneficiary;
import Data.Donnor;
import Data.Comida;
//Traer Las funcionalidades
import functionalities.RegistroComida;

// Traer el Main
import Business.Main;
import Estructure_DinamicArray.DinamicArray;

import java.io.FileReader;

public class InputDataJSON {
    private String yourComputer_pathToCarpet_fileJson = null; // RUTA de carpeta de archivo Json
    // si lo siguiente  es la ruta completa del archivo "(ruta/a/tu/carpetaJson)/nameArchivo.json", entonces ingresar esto "ruta/a/tu/carpetaJson/"; OJO CON / al final
    
    // para crear nombre del archivoJson
    private String name_fileJson = null; 
    // para crear la ruta del archivo final
    private String finalPath_fileJson = null;
    // otros cosas que se necesitan 
    private int NumberRowsRead; // numero de filas a leer
    private int TypeOfFileRead; // este va desde 0 a  1; siendo 0 leer datos del json de comida, 1 leer datos del json de Productos_comida
    // Coloquen sus rutas para no tener que estar creandolas
    public String PathJhoanComputer = "C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/";
    

    public InputDataJSON(String pathYourComputerCarpetArchivoJson, int NumberRowsRead, int TypeOfFileRead) {
        this.yourComputer_pathToCarpet_fileJson = pathYourComputerCarpetArchivoJson;
        this.NumberRowsRead = NumberRowsRead;
        this.TypeOfFileRead = TypeOfFileRead;
        
    }

    public InputDataJSON( int NumberRowsRead, int TypeOfFileRead) {
        this.NumberRowsRead = NumberRowsRead;
        this.TypeOfFileRead = TypeOfFileRead;
    }
    
   
    
    // metodo para construir el nombre del archivo
    public void setNameOfFileJson(){
        
        String genericNameUser = "jsonFakeDataUsers_";
        String genericNameFood = "jsonFakeDataFood_";
        switch (TypeOfFileRead) {
            case 0:
                name_fileJson = genericNameUser + NumberRowsRead +".json";
                break;
            case 1:
                name_fileJson = genericNameFood + NumberRowsRead +".json";
                break;
            default:
                throw new RuntimeException("ERROR: type Of Field doesn't exist, the values are 0, 1");
        }
     }
    
    // metodo para construir la ruta final del archivo
    public void setFinalPathFile(){
        setNameOfFileJson();
        finalPath_fileJson = yourComputer_pathToCarpet_fileJson + name_fileJson;
    }
    
       // metodo para ver si el archivoExiste
    public boolean FileExist(){
        String filePath;
        // ver si en el cosntructor se ingreso un path
        if(finalPath_fileJson == null){
            // entonces
            setFinalPathFile();
        }
        
        filePath =  finalPath_fileJson;
        File file = new File(filePath);
        boolean exists = file.exists();
        
        if(exists){
            System.out.println("The file exists.");
            return(true);
        }else{
            System.out.println("The file does not exist.");
            return(false);
        }
    }
    
    // metodo para cambiar de tipo de archivo
    public void change_TypeOfFileRead(int i){
        TypeOfFileRead = i;
        name_fileJson = null; 
        finalPath_fileJson = null;  
    }
    
    // metodo para mostrar los datos del archivo json con print
    public void ShowJson_User(){
        JSONObject jsonObject = null;
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;

            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);

            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);

            // Obtiene el array "users"
            JSONArray usuarios = jsonObject.getJSONArray("users");
            
            
            
            // Iterar sobre los objetos de los usuarios
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);

                // Accede a los campos de los usuarios
                int index = usuario.getInt("index");
                String firstName = usuario.getString("firs_name"); // Nota la falta de la "t" en "firs_name" LUEGO me da me da pereza cambiar el python 
                String lastName = usuario.getString("last_name");
                String email = usuario.getString("email");
                String document = usuario.getString("document");
                String password = usuario.getString("password");
                String address = usuario.getString("adress"); 
                String locality = usuario.getString("locality");

                // Imprime los datos de los usuarios
                System.out.print("Usuario #" + index);
                System.out.print("Nombre: " + firstName);
                System.out.print("Apellido: " + lastName);
                System.out.print("Email: " + email);
                System.out.print("Documento: " + document);
                System.out.print("Contraseña: " + password);
                System.out.print("Dirección: " + address);
                System.out.print("Localidad: " + locality);
                System.out.println("");
            }
            
            // Cierra el lector de archivo
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void ShowUserByName(String name){
        JSONObject jsonObject = null;
        try {
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            String pathFileJSON = finalPath_fileJson;
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            JSONTokener tokener = new JSONTokener(ReaderJSON);

            jsonObject = new JSONObject(tokener);

            JSONArray usuarios = jsonObject.getJSONArray("users");
            
            
            
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);
                
                String firstName = usuario.getString("firs_name");
                if(firstName.equals(name)){
                    int index = usuario.getInt("index");
                    String lastName = usuario.getString("last_name");
                    String email = usuario.getString("email");
                    String document = usuario.getString("document");
                    String password = usuario.getString("password");
                    String address = usuario.getString("adress"); 
                    String locality = usuario.getString("locality");

                    // Imprime los datos de los usuarios
                    System.out.print("Usuario #" + index+"  ");
                    System.out.print("Nombre: " + firstName+"  ");
                    System.out.print("Apellido: " + lastName+"  ");
                    System.out.print("Email: " + email+"  ");
                    System.out.print("Documento: " + document+"  ");
                    System.out.print("Contraseña: " + password+"  ");
                    System.out.print("Dirección: " + address+"  ");
                    System.out.print("Localidad: " + locality+"  ");
                    System.out.println("");
                }
                
            }
            
            // Cierra el lector de archivo
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    // metodo para mostrar los datos del archivo json con print
    public void ShowJson_Food(){
        JSONObject jsonObject = null;
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;

            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);

            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);

            // Obtiene el array "productFood"
            JSONArray productFood = jsonObject.getJSONArray("productFood");
            

            // Iterar sobre los objetos de comida
            for (int i = 0; i < productFood.length(); i++) {
                JSONObject comida = productFood.getJSONObject(i);

                // Accede a los campos del comida
                int index = comida.getInt("index");
                String typeProduct = comida.getString("typeProduct");  
                String nameProduct = comida.getString("nameProduct");
                int quantity = comida.getInt("quantity");
                String emailDonor = null;
                int expirationDateYear = comida.getInt("expirationDateYear");
                int expirationDateMonth = comida.getInt("expirationDateMonth"); 
                int expirationDateDay = comida.getInt("expirationDateDay");

                // Imprime los datos del comida
                System.out.print("Usuario #" + index);
                System.out.print("typeProduct: " + typeProduct);
                System.out.print("nameProduct: " + nameProduct);
                System.out.print("quantity: " + quantity);
                System.out.print("emailDonor: " + emailDonor);
                System.out.print("expirationDateYear: " + expirationDateYear);
                System.out.print("expirationDateMonth: " + expirationDateMonth);
                System.out.print("expirationDateDay: " + expirationDateDay);
                System.out.println("");
                
            }

            // Cierra el lector de archivo
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    // metodo para mostrar la comida por nombre
    public void ShowFoodByName(String name){
        JSONObject jsonObject = null;
        try {
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            String pathFileJSON = finalPath_fileJson;

            FileReader ReaderJSON = new FileReader(pathFileJSON);

            JSONTokener tokener = new JSONTokener(ReaderJSON);

            jsonObject = new JSONObject(tokener);

            JSONArray productFood = jsonObject.getJSONArray("productFood");
            
            int sumador = NumberRowsRead/10;
            int comparador =NumberRowsRead/10;
            
            for (int i = 0; i < productFood.length(); i++) {
                JSONObject comida = productFood.getJSONObject(i);
                int index = comida.getInt("index");
                String emailDonor = comida.getString("emailDonor");
                String nameProduct = comida.getString("nameProduct");
                if(index == comparador){
                    System.out.println(index +"  "+emailDonor );
                    comparador+= sumador;
                }
                /*
                if(nameProduct.equals(name)){ 
                    //unicamente imprime los productos que tengan el mismo nombre 
                    int index = comida.getInt("index");
                    String typeProduct = comida.getString("typeProduct");  
                    int quantity = comida.getInt("quantity");
                    String emailDonor = null;
                    int expirationDateYear = comida.getInt("expirationDateYear");
                    int expirationDateMonth = comida.getInt("expirationDateMonth"); 
                    int expirationDateDay = comida.getInt("expirationDateDay");

                    System.out.print("Usuario #" + index+"  ");
                    System.out.print("typeProduct: " + typeProduct+"  ");
                    System.out.print("nameProduct: " + nameProduct+ "  ");
                    System.out.print("quantity: " + quantity +"  ");
                    System.out.print("emailDonor: " + emailDonor+"  ");
                    System.out.print("expirationDateYear: " + expirationDateYear+"  ");
                    System.out.print("expirationDateMonth: " + expirationDateMonth+"  ");
                    System.out.print("expirationDateDay: " + expirationDateDay+"  ");
                    System.out.println("");
                } */  
            }
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    // metodo para obtener correos de usuarios
    public String[] ofJson_getArrayUser(){
        JSONObject jsonObject = null;
        String[] arrayUser = new String[NumberRowsRead];
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            if(TypeOfFileRead != 0){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getArrayUser");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;

            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);

            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);

            // Obtiene el array "users"
            JSONArray usuarios = jsonObject.getJSONArray("users");
            
            // Iterar sobre los objetos de los usuarios
            int counterLoop = 0;
            
            for (int i = usuarios.length()-1; i >=0; i--) { // para no obtener correos iguales
                JSONObject usuario = usuarios.getJSONObject(i);
                
                // Accede a los campos del usuario
                String email = usuario.getString("email");
  
                // agregar el email al array
                arrayUser[counterLoop] = email;
                // sumar al contador
                counterLoop += 1;

            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(arrayUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListBeneficiary");
  
        
    }
    
    // Este metodo da una linkedlist de beneficiarios para utilzarlos como prueba
    public LinkedList ofJson_getListBeneficiary(){
        JSONObject jsonObject = null;
        LinkedList<Beneficiary> listOfBeneficaries;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            if(TypeOfFileRead != 0){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListBeneficiary");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;

            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);

            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);

            // Obtiene el array "users"
            JSONArray usuarios = jsonObject.getJSONArray("users");
            
            // inicializar la lista de comida
            listOfBeneficaries= new LinkedList<>();
            //crear un comida provisional 
            Beneficiary beneficiary;
            
            // Iterar sobre los objetos de los usuarios
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);

                // Accede a los campos del usuario
                int index = usuario.getInt("index");
                String firstName = usuario.getString("firs_name"); // Nota la falta de la "t" en "firs_name" LUEGO me da me da pereza cambiar el python 
                String lastName = usuario.getString("last_name");
                String email = usuario.getString("email");
                String document = usuario.getString("document");
                String password = usuario.getString("password");
                String address = usuario.getString("adress"); 
                String locality = usuario.getString("locality");

                
                // Crear el beneficiario con algunos valores en 0
                beneficiary = new Beneficiary(0,0,firstName,lastName,email,document,password);
                // Ingresar el beneficiario a la lista provisional 
                listOfBeneficaries.pushFront(beneficiary); // es O(1)
                
            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(listOfBeneficaries);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListBeneficiary");
  
        
    }
    
    // Este metodo da Una linkedlist de donadores, para utilizar como datos de prueba
    public LinkedList ofJson_getListDonnor(){
        JSONObject jsonObject = null;
        LinkedList<Donnor> listOfDonnor;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            if(TypeOfFileRead != 0){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListDonnor");
            }
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;

            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);

            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);

            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);

            // Obtiene el array "users"
            JSONArray usuarios = jsonObject.getJSONArray("users");
            
            // inicializar la lista de comida
            listOfDonnor= new LinkedList<>();
            //crear un comida provisional 
            Donnor donnor;
            
            // Iterar sobre los objetos de usuarios
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);

                // Accede a los campos del usuario
                int index = usuario.getInt("index");
                String firstName = usuario.getString("firs_name"); // Nota la falta de la "t" en "firs_name" LUEGO me da me da pereza cambiar el python 
                String lastName = usuario.getString("last_name");
                String email = usuario.getString("email");
                String document = usuario.getString("document");
                String password = usuario.getString("password");
                String adress = usuario.getString("adress"); 
                String locality = usuario.getString("locality");
               
                
                // Crear el donador con algunos valores en nulo
                donnor = new Donnor(firstName,lastName,email,document, password, adress, locality, null, null);
                // Ingresar el donador a la lista provisional 
                listOfDonnor.pushFront(donnor); // es O(1)
                
            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(listOfDonnor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListDonnor");      
    }
    
    //ESTE METODO ES PARA PROBAR LA INSERCION MASIVA DE REGISTROS DE COMIDA
    // RG = registroComida_ DLL = DoubleLinkedList
    
    public String ofJson_proof_MasiveData_RC_DLL(String email1, String email2){
        JSONObject jsonObject = null;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            if(TypeOfFileRead != 1){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;
            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);
            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);
            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);
            // Obtiene el array "productFood"
            JSONArray productFood = jsonObject.getJSONArray("productFood");
            
            // Utilizar la funcionalidad, crear un objeto para utilizar los metodos
            RegistroComida registroComida = new RegistroComida(); 
            

            //PONER EL TIEMPO Insert Masivo
            long startTime = System.nanoTime();
            // Iterar sobre los objetos de comida
            for (int i = 0; i < productFood.length(); i++) {
                JSONObject comida = productFood.getJSONObject(i);

                // Accede a los campos del comida
                String nameProduct = comida.getString("nameProduct");
                int quantity = comida.getInt("quantity");
                String emailDonor = comida.getString("emailDonor");
                int expirationDateYear = comida.getInt("expirationDateYear");
                int expirationDateMonth = comida.getInt("expirationDateMonth"); 
                int expirationDateDay = comida.getInt("expirationDateDay");

                //registroComida.InsertRFScan_DoubleLinkedList(nameProduct, quantity, emailDonor, expirationDateYear, expirationDateMonth, expirationDateDay);
    
            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            
            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo en DLL es= " + tiempoTranscurrido);
            
            //prueba find 
            InsideFind_ofJson_proof_MasiveData_RC_DLL(email1, email2);
            
            
            // lista DoubleLinkedList final
            DoubleLinkedList DLL = Main.getListOfProducts();
            
            long startTime2 = System.nanoTime();
            // PRUEBA ELIMINACION DE DATOS
            while(!DLL.empty()){
                DLL.popFront();
            }
            
            long endTime2 = System.nanoTime();
            Double tiempoTranscurrido2 = (endTime2 - startTime2)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Borrar(popFornt) masivo En DLL es= " + tiempoTranscurrido2);
            
            return("PruebaConcluidaExitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");      
    }
    
    
    public String ofJson_proof_MasiveData_RC_DA(String email1, String email2){
        JSONObject jsonObject = null;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            if(TypeOfFileRead != 1){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = finalPath_fileJson;
            // Crea un FileReader para leer el archivo JSON
            FileReader ReaderJSON = new FileReader(pathFileJSON);
            // Crea un JSONTokener para analizar el contenido del archivo JSON
            JSONTokener tokener = new JSONTokener(ReaderJSON);
            // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            jsonObject = new JSONObject(tokener);
            // Obtiene el array "productFood"
            JSONArray productFood = jsonObject.getJSONArray("productFood");
            
            // Utilizar la funcionalidad, crear un objeto para utilizar los metodos
            RegistroComida registroComida = new RegistroComida(); 
           
            //PONER EL TIEMPO Insertar Masivo
            long startTime = System.nanoTime();
            // Iterar sobre los objetos de comida
            for (int i = 0; i < productFood.length(); i++) {
                JSONObject comida = productFood.getJSONObject(i);

                // Accede a los campos del comida
                String nameProduct = comida.getString("nameProduct");
                int quantity = comida.getInt("quantity");
                // colocar el email del donador
                String emailDonor = comida.getString("emailDonor"); 
                int expirationDateYear = comida.getInt("expirationDateYear");
                int expirationDateMonth = comida.getInt("expirationDateMonth"); 
                int expirationDateDay = comida.getInt("expirationDateDay");

                registroComida.InsertRFScan_DinamicArray(nameProduct, quantity, emailDonor, expirationDateYear, expirationDateMonth, expirationDateDay);
            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            // SALIDA DEL TIEMPO Insertar Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo En DA es= " + tiempoTranscurrido);
            
            
            // PRUEBA BUSCAR DATOS
            InsideFind_ofJson_proof_MasiveData_RC_DA(email1,email2);
            
            //Arreglo Dinamico Final
            DinamicArray DA = Main.getListOfProducts_DA();
            
            
            // PRUEBA ELIMINACION DE DATOS
            long startTime2 = System.nanoTime();
            
            /*
            //Eliminacion Masiva al Inicio
            int counterDelete = 0;
            while(!DA.isEmpty()){
                DA.remove(counterDelete);
                counterDelete += 1; 
                //System.out.println(counterDelete);
            }
            long endTime2 = System.nanoTime();
            Double tiempoTranscurrido2 = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Borrar(Al inicio) masivo En DA es= " + tiempoTranscurrido);
            */
            
            //SI QUIER AL FINAL ELIMINAR ESTE COMENTARIO Y COMENTAR LO OTRO
            // Elimininacion masiva al Final
            
            
            while(!DA.isEmpty()){
                DA.removeLast();
            }
            
            long endTime2 = System.nanoTime();
            Double tiempoTranscurrido2 = (endTime2 - startTime2)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Borrar(Al Final) masivo En DA es= " + tiempoTranscurrido2);
            
            
           
            return("PruebaConcluidaExitosamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");      
    }
    
    public void InsideFind_ofJson_proof_MasiveData_RC_DLL(String email1, String email2){
        long startTime = System.nanoTime();
        DoubleLinkedList DLL = Main.getListOfProducts();
        RegistroComida rComida = new RegistroComida();
        boolean a=rComida.findData_Email_RF_DoubleLinkedList(email1);
        boolean b = rComida.findData_Email_RF_DoubleLinkedList(email2);
        System.out.println(a+" , "+b);
        long endTime = System.nanoTime();
        Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
        System.out.println("El tiempo Transcurrido del metodo Find En DLL es= " + tiempoTranscurrido);
    }
    
    public void InsideFind_ofJson_proof_MasiveData_RC_DA(String email1, String email2){
        long startTime = System.nanoTime();
        DinamicArray DA = Main.getListOfProducts_DA();
        RegistroComida rComida = new RegistroComida();
        boolean a = rComida.FindData_emailRF_DinamicArray(email1);
        boolean b = rComida.FindData_emailRF_DinamicArray(email2);
        System.out.println(a+" , "+b);
        long endTime = System.nanoTime();
        Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
        System.out.println("El tiempo Transcurrido del metodo Find En DA es= " + tiempoTranscurrido);
    }
    
    public String getYourComputer_pathToCarpet_fileJson() {
        return yourComputer_pathToCarpet_fileJson;
    }

    public void setYourComputer_pathToCarpet_fileJson(String yourComputer_pathToCarpet_fileJson) {
        this.yourComputer_pathToCarpet_fileJson = yourComputer_pathToCarpet_fileJson;
    }

    public String getName_fileJson() {
        return name_fileJson;
    }

    public void setName_fileJson(String name_fileJson) {
        this.name_fileJson = name_fileJson;
    }

    public String getFinalPath_fileJson() {
        return finalPath_fileJson;
    }

    public void setFinalPath_fileJson(String finalPath_fileJson) {
        this.finalPath_fileJson = finalPath_fileJson;
    }

    public int getNumberRowsRead() {
        return NumberRowsRead;
    }

    public void setNumberRowsRead(int NumberRowsRead) {
        this.NumberRowsRead = NumberRowsRead;
    }

    public int getTypeOfFileRead() {
        return TypeOfFileRead;
    }

    public void setTypeOfFileRead(int TypeOfFileRead) {
        this.TypeOfFileRead = TypeOfFileRead;
    }


}
