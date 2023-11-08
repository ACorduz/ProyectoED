

package PruebasCRUD;

import Data.Usuario;
import EntradaDatos.PruebaEntradaJson;
import EstructurasCorte2.AVLTree_UsuarioDocumento;
import EstructurasCorte2.BST_TreeUsuarioDocumento;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PruebasCRUD_Usuario {
    
    // ATRIBUTOS
    public PruebaEntradaJson  EntradaJSON = null;
    
    // CONSTRUCTOR
    public PruebasCRUD_Usuario(int numberRowsRead, int typeOfFileRead, String path){
        EntradaJSON = new PruebaEntradaJson(numberRowsRead, typeOfFileRead);
        EntradaJSON.setYourComputer_pathToCarpet_fileJson(path);
        
    }  
     
    //METODOS
    
    // metodo para mostrar los datos del archivo json con print
    public void ShowJson_User(){
        JSONObject jsonObject = null;
        try {
            // ver si el archivo existe y crear nombre de la ruta
            boolean exist = EntradaJSON.FileExist();
            if(!exist){
                throw new RuntimeException("ERROR: File Doesn't exist");
            }
            
            // Especifica la ruta del archivo JSON que deseas leer
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson();

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
    
    // prueba find usuarios en un BST por número de documento
     public BST_TreeUsuarioDocumento PruebaInsertBST(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 0){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray usuariosDocumento = jsonObject.getJSONArray("users"); // Obtiene el array "usuariosDocumentos"

            // Crear BST para insertar los usuarios
            BST_TreeUsuarioDocumento BST = new BST_TreeUsuarioDocumento();
            

            
            // colocar primero la raiz
            JSONObject ObjC = usuariosDocumento.getJSONObject(0);
            
            Usuario usu = new Usuario(
                    ObjC.getString("firs_name"),
                    ObjC.getString("last_name"),
                    ObjC.getString("email"),
                    ObjC.getString("document"),
                    ObjC.getString("numberDocument"),
                    ObjC.getString("password"),
                    ObjC.getString("adress"),
                    ObjC.getString("locality")
            );
            
            // Tiempo para medir el INSERT en el BST de usuarios por número de documento
            long startTime = System.nanoTime();
            
            BST.root = BST.crearNodoRoot(usu); // meter el root
            
            for (int i = 1; i < usuariosDocumento.length(); i++){        // Iterar sobre los objetos de usuarios
                JSONObject objetoUsuario = usuariosDocumento.getJSONObject(i);
                
                String  name = objetoUsuario.getString("firs_name");
                String  lastName = objetoUsuario.getString("last_name");
                String  email = objetoUsuario.getString("email");
                String  typeDocument = objetoUsuario.getString("document");
                String  document = objetoUsuario.getString("numberDocument");
                String  password = objetoUsuario.getString("password");
                String  adress = objetoUsuario.getString("adress");
                String  locality = objetoUsuario.getString("locality");

                //Crear objeto Usuario
                Usuario usuario = new Usuario(name, lastName, email, typeDocument, document,  password, adress, locality);
                //System.out.println(comida.toString());

                BST.insertar(usuario); // metodo insert del BST
            }
            
            
            ReaderJSON.close();// Cierra el lector de archivo

            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo en BST_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");

            return(BST);

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListUsers");// si se llega a esta linea algo no funciona bien
        
    }
     
    // prueba insert usuarios en un BST por número de documento
     public BST_TreeUsuarioDocumento PruebaFindBST(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 0){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray usuariosDocumento = jsonObject.getJSONArray("users"); // Obtiene el array "usuariosDocumentos"

            // Crear BST para insertar los usuarios
            BST_TreeUsuarioDocumento BST = new BST_TreeUsuarioDocumento();
            

            
            // colocar primero la raiz
            JSONObject ObjC = usuariosDocumento.getJSONObject(0);
            
            Usuario usu = new Usuario(
                    ObjC.getString("firs_name"),
                    ObjC.getString("last_name"),
                    ObjC.getString("email"),
                    ObjC.getString("document"),
                    ObjC.getString("numberDocument"),
                    ObjC.getString("password"),
                    ObjC.getString("adress"),
                    ObjC.getString("locality")
            );
            
            BST.root = BST.crearNodoRoot(usu); // meter el root
            
            for (int i = 1; i < usuariosDocumento.length(); i++){        // Iterar sobre los objetos de usuarios
                JSONObject objetoUsuario = usuariosDocumento.getJSONObject(i);
                
                String  name = objetoUsuario.getString("firs_name");
                String  lastName = objetoUsuario.getString("last_name");
                String  email = objetoUsuario.getString("email");
                String  typeDocument = objetoUsuario.getString("document");
                String  document = objetoUsuario.getString("numberDocument");
                String  password = objetoUsuario.getString("password");
                String  adress = objetoUsuario.getString("adress");
                String  locality = objetoUsuario.getString("locality");

                //Crear objeto Usuario
                Usuario usuario = new Usuario(name, lastName, email, typeDocument, document,  password, adress, locality);
                //System.out.println(comida.toString());

                BST.insertar(usuario); // metodo insert del BST
            }
            
            
            ReaderJSON.close();// Cierra el lector de archivo
            
            // Busqueda del elemento
                //Usuario a buscar
            Usuario usuFind = new Usuario("Catalina","Vanegas","forerogloria@example.net","TI","97822706","<3Q:x#OH&.","Cl. 115F # 5B-76","Pedraza");
                // Tiempo para medir el FIND en el BST de usuarios por número de documento
            long startTime = System.nanoTime();
            
            BST.findd(usuFind, BST.root);

            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo FIND masivo en BST_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");
            
            //DELETE
            //long startTime = System.nanoTime();
            
            //BST.borrar(usuFind);
            
            //long endTime = System.nanoTime();
            //Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            //System.out.println("El tiempo Transcurrido del metodo DELETE en BST_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");
            return(BST);

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListUsers");// si se llega a esta linea algo no funciona bien
       
    }
     
     // PRUEBAS AVL
     
         public AVLTree_UsuarioDocumento PruebaInsertAVL_Documento(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 0){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListUsers");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray usuariosDocumento = jsonObject.getJSONArray("users"); // Obtiene el array "usuariosDocumentos"

            // Crear HM para insertar productos 
            AVLTree_UsuarioDocumento AVL = new AVLTree_UsuarioDocumento();
            
            // PONER EL TIEMPO PARA COMENZAR A MEDIR EL INSERT 
            //long startTime = System.nanoTime();
            
            
            for (int i = 1; i < usuariosDocumento.length(); i++){        // Iterar sobre los objetos de usuarios
                JSONObject objetoUsuario = usuariosDocumento.getJSONObject(i);
                
                String  name = objetoUsuario.getString("firs_name");
                String  lastName = objetoUsuario.getString("last_name");
                String  email = objetoUsuario.getString("email");
                String  typeDocument = objetoUsuario.getString("document");
                String  document = objetoUsuario.getString("numberDocument");
                String  password = objetoUsuario.getString("password");
                String  adress = objetoUsuario.getString("adress");
                String  locality = objetoUsuario.getString("locality");

                //Crear objeto Usuario
                Usuario usuario = new Usuario(name, lastName, email, typeDocument, document,  password, adress, locality);
                
                // metodo insert del avl 
                AVL.root = AVL.insert(AVL.root, usuario);
            }
            
            
            ReaderJSON.close();// Cierra el lector de archivo

            // SALIDA DEL TIEMPO Insert Masivo
            //long endTime = System.nanoTime();
            //Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            //System.out.println("El tiempo Transcurrido del metodo INSERT en AVL_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");
            
            
            //Prueba Metodo FIND
            
            //long startTime = System.nanoTime();
            //AVL.find("97822706");
            //long endTime = System.nanoTime();
            //Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            //System.out.println("El tiempo Transcurrido del metodo FIND en AVL_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");
            
            //Prueba Metodo DELETE
            long startTime = System.nanoTime();
            AVL.delete(AVL.root, "22908718");
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo DELETE en AVL_TreeUsuariosDocumento es= " + tiempoTranscurrido + " ms");
            return(AVL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");// si se llega a esta linea algo no funciona bien
        
    }
    
}
