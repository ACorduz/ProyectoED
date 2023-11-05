package EntradaDatos;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConectionAPI {
    // esos string  son la primera que nos sirva
    String urlDataUserString = "https://my.api.mockaroo.com/users.json?key=a5b47550";
    String urlDataProductString = "";
    // Estas variables son para cambiar con el constructor
    URL urlDataUser;
    URL urlDataProduct; 

    // la conexion del API cambiando el url 
    public ConectionAPI(String urlDataUser, String urlDataProduct) {
        try{
            this.urlDataUser = new URL(urlDataUser);
            this.urlDataProduct = new URL(urlDataProduct);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public ConectionAPI(){
    }
    
    public StringBuilder getDataUsers(){
        StringBuilder informationSting = null; 
        try{
            URL url = new URL("https://my.api.mockaroo.com/users.json?key=a5b47550");
            // crear objeto de conexion y hacerle un casting
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // solicitar atraves del metodo de peticion get la conexion
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.connect();

            //ahora leer esa respuesta
            StringBuilder informationString = new StringBuilder();   
            Scanner scanner = new Scanner(url.openStream());

            while(scanner.hasNext()){
                informationString.append(scanner.nextLine());
                
            }

            // una vez leido todo 
            scanner.close();
            System.out.println(informationString.toString());


        }catch(Exception e){
            e.printStackTrace();
        }
        return(informationSting);
    }
    
    // hace falta una para obtener productos 
    public StringBuilder getDataProduct(){
        StringBuilder informationSting = null; 
        return(informationSting);    
    }
  
 
}
