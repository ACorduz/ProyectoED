

package PruebasCRUD;

import EntradaDatos.PruebaEntradaJson;
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
    
}
