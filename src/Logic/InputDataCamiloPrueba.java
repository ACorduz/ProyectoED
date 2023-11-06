package Logic;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// importamos estructuras para sacar listas de comida
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Data.Beneficiary;
import Data.Donnor;
import Data.Comida;
import Data.User;
import Estructure_DoubleLinkedList.Stack;
import functionalities.find;

import java.io.FileReader;

public class InputDataCamiloPrueba {
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
    public String PathJhoanComputer = "C:\\Users\\pipec\\Escritorio\\ProyectoED\\Data/";
    

    public InputDataCamiloPrueba(String pathYourComputerCarpetArchivoJson, int NumberRowsRead, int TypeOfFileRead) {
        this.yourComputer_pathToCarpet_fileJson = pathYourComputerCarpetArchivoJson;
        this.NumberRowsRead = NumberRowsRead;
        this.TypeOfFileRead = TypeOfFileRead;
        
    }

    public InputDataCamiloPrueba(int NumberRowsRead, int TypeOfFileRead) {
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
                System.out.print("Usuario #" + index+" ");
                System.out.print("Nombre: " + firstName+" ");
                System.out.print("Apellido: " + lastName+" ");
                System.out.print("Email: " + email+" ");
                System.out.print("Documento: " + document+" ");
                System.out.print("Contraseña: " + password+" ");
                System.out.print("Dirección: " + address+" ");
                System.out.print("Localidad: " + locality+" ");
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
                System.out.print("Usuario #" + index+" ");
                System.out.print("typeProduct: " + typeProduct+" ");
                System.out.print("nameProduct: " + nameProduct+ " ");
                System.out.print("quantity: " + quantity +" ");
                System.out.print("emailDonor: " + emailDonor+" ");
                System.out.print("expirationDateYear: " + expirationDateYear+" ");
                System.out.print("expirationDateMonth: " + expirationDateMonth+" ");
                System.out.print("expirationDateDay: " + expirationDateDay+" ");
                System.out.println("");
                
            }

            // Cierra el lector de archivo
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
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
            

            for (int i = 0; i < productFood.length(); i++) {
                JSONObject comida = productFood.getJSONObject(i);

                String nameProduct = comida.getString("nameProduct");
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
                }   
            }
            ReaderJSON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
    
    // metodo para obtener Una lista doblemente enlzada de productos de comida
     public DoubleLinkedList ofJson_getListProductsFood(){
        JSONObject jsonObject = null;
        DoubleLinkedList<Comida> listOfFood = new DoubleLinkedList<>();
        
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
            
            // inicializar la lista de comida
            listOfFood = new DoubleLinkedList<>();
            //crear un comida provisional 
            Comida food;
            
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

                
                // Crear la comida
                food = new Comida(typeProduct, nameProduct, quantity, emailDonor, expirationDateYear, expirationDateMonth, expirationDateDay);
                // Ingresar la comida a la lista provisional 
                listOfFood.pushFront(food); // es O(1)
                
            }
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(listOfFood);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");      
    }
     /*
        // metodo para obtener Una cola de usuarios nuevos
     public Queue ofJson_getListUsersQ(){
        JSONObject jsonObject = null;
        Queue <User> listOfUsers;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            if(TypeOfFileRead != 0){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListUsers");
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
            JSONArray users = jsonObject.getJSONArray("users");
            
            // inicializar la lista de comida
            listOfUsers = new Queue<>();
            //crear un comida provisional 
            User user;
            //long tiempoInicio = System.nanoTime();
            // Iterar sobre los objetos de usuarios
            for (int i = 0; i < users.length(); i++) {
                JSONObject usuario = users.getJSONObject(i);

                // Accede a los campos del usuario
                String name = usuario.getString("firs_name");  
                String lastName = usuario.getString("last_name");
                String email = usuario.getString("email");
                String document = usuario.getString("document");
                String password = usuario.getString("password");
                String TypeUser = null;
                
                //Crear el usuario
                user = new User(name, lastName, email, document, password, TypeUser);
                //Ingresar el usuario a la lista provisional
                listOfUsers.enqueue(user);
                
            }
            //long tiempoFin = System.nanoTime();
            //long tiempoTranscurrido = tiempoFin - tiempoInicio;
            //double segundos = (double) tiempoTranscurrido / 1000000.0;
            //System.out.println(segundos);
            
            //Prueba de eliminación de datos
            //long tiempoInicio = System.nanoTime();
            //while(!listOfUsers.empty()){
                //listOfUsers.dequeue();
                //System.out.println("Desencolando");
            //}
            //long tiempoFin = System.nanoTime();
            //long tiempoTranscurrido = tiempoFin - tiempoInicio;
            //double segundos = (double) tiempoTranscurrido / 1000000.0;
            //System.out.println(segundos);
            
            //Prueba de busqueda de elemento
            find busquedaUsuariosQ = new find();
            //User Suser = new User("Edinson", "Bastidas", "kquintero@example.net", "TI 80841066", "wN,HO5IKd9", null);
            //busquedaUsuariosQ.findUser_listOfUsers(listOfUsers,"alix93@example.org");
            
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(listOfUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListUsers");      
    }*/
  
    // metodo para obtener Una pila de usuarios nuevos
     public Stack ofJson_getListUsersSt(){
        JSONObject jsonObject = null;
        Stack <User> listOfUsers;
        
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            if(TypeOfFileRead != 0){
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListUsers");
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
            JSONArray users = jsonObject.getJSONArray("users");
            
            // inicializar la lista de comida
            listOfUsers = new Stack<>();
            //crear un comida provisional 
            User user;
            //long tiempoInicio = System.nanoTime();
            // Iterar sobre los objetos de usuarios
            for (int i = 0; i < users.length(); i++) {
                JSONObject usuario = users.getJSONObject(i);

                // Accede a los campos del usuario
                String name = usuario.getString("firs_name");  
                String lastName = usuario.getString("last_name");
                String email = usuario.getString("email");
                String document = usuario.getString("document");
                String password = usuario.getString("password");
                String TypeUser = null;
                
                //Crear el usuario
                user = new User(name, lastName, email, document, password, TypeUser);
                //Ingresar el usuario a la lista provisional
                listOfUsers.push(user);
                
                
            }
            //long tiempoFin = System.nanoTime();
            //long tiempoTranscurrido = tiempoFin - tiempoInicio;
            //double segundos = (double) tiempoTranscurrido / 1000000.0;
            //System.out.println(segundos);
            /*
            //Prueba de eliminación de datos
            long tiempoInicio = System.nanoTime();
            while(!listOfUsers.empty()){
                listOfUsers.pop();
            }
            long tiempoFin = System.nanoTime();
            long tiempoTranscurrido = tiempoFin - tiempoInicio;
            double segundos = (double) tiempoTranscurrido / 1000000.0;
            System.out.println(segundos);
            */
            
            //Prueba de busqueda de elemento
            find busquedaUsuariosQ = new find();
            //User Suser = new User("Edinson", "Bastidas", "kquintero@example.net", "TI 80841066", "wN,HO5IKd9", null);
            busquedaUsuariosQ.findUser_listOfUsersS(listOfUsers, "ciroherrera@example.org");
            
            
            // Cierra el lector de archivo
            ReaderJSON.close();
            // se retorna la lista
            return(listOfUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si la lista es nula este metodo no esta funcionando bien o algo paso
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListUsers");      
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
