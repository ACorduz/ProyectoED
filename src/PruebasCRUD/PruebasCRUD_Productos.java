
package PruebasCRUD;

// Liberias necesarias para leer el JSON 
import EntradaDatos.PruebaEntradaJson;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Librerias de Estructuras a probar
import EstructurasCorte2.AVLTree_ComidaFecha;
import EstructurasCorte2.BST_TreeComidaNombre; 
import EstructurasCorte2.HeapMinor_ComidaFecha;

// Librerias ObjetosData
import Data.Comida;
import EstructurasCorte2.NodoAVLComida;
import java.util.List;



public class PruebasCRUD_Productos {
    // ATRIBUTOS
    public PruebaEntradaJson  EntradaJSON = null;
    
    // CONSTRUCTOR
    public PruebasCRUD_Productos(int numberRowsRead, int typeOfFileRead, String path){
        EntradaJSON = new PruebaEntradaJson(numberRowsRead, typeOfFileRead);
        EntradaJSON.setYourComputer_pathToCarpet_fileJson(path);
        
    }  
     
    //METODOS
    
    // Prueba Insert HM la propiedad se verifica o organiza por nombre de los productos
    public AVLTree_ComidaFecha PruebaInsertAVL_fecha(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 1){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray productFood = jsonObject.getJSONArray("productFood"); // Obtiene el array "productFood"

            // Crear HM para insertar productos 
            AVLTree_ComidaFecha AVL = new AVLTree_ComidaFecha();
            
            // PONER EL TIEMPO PARA COMENZAR A MEDIR EL INSERT 
            long startTime = System.nanoTime();
            
            
            for (int i = 0; i < productFood.length(); i++){        // Iterar sobre los objetos de comida
                JSONObject objetoComida = productFood.getJSONObject(i);
                
                int     index = objetoComida.getInt("index");
                String  typeProduct = objetoComida.getString("typeProduct");
                String  nameProduct = objetoComida.getString("nameProduct");
                int     quantity = objetoComida.getInt("quantity");
                String  emailDonor = objetoComida.getString("emailDonor");     
                int     expirationDateYear = objetoComida.getInt("expirationDateYear");
                int     expirationDateMonth = objetoComida.getInt("expirationDateMonth"); 
                int     expirationDateDay = objetoComida.getInt("expirationDateDay");

                // crear objeto comida
                Comida comida = new Comida(index, typeProduct, nameProduct, quantity, emailDonor,  expirationDateYear,  expirationDateMonth, expirationDateDay);
                //System.out.println(comida.toString());
                // metodo insert del avl 
                AVL.root = AVL.insert(AVL.root, comida);
            }
            
            
            ReaderJSON.close();// Cierra el lector de archivo

            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo en AVLTree_ComidaFecha es= " + tiempoTranscurrido);

            return(AVL);
            /*
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
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");// si se llega a esta linea algo no funciona bien
        
    }
    
    // prueba insert HM,  la propiedad se verifica o organiza por nombre de los productos
    public BST_TreeComidaNombre PruebaInsertBST(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 1){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray productFood = jsonObject.getJSONArray("productFood"); // Obtiene el array "productFood"

            // Crear HM para insertar productos 
            BST_TreeComidaNombre BST = new BST_TreeComidaNombre();
            
            // PONER EL TIEMPO PARA COMENZAR A MEDIR EL INSERT 
            long startTime = System.nanoTime();
            
            // colocar primero la raiz
            JSONObject ObjC = productFood.getJSONObject(0);
            Comida com = new Comida(
                    ObjC.getInt("index"), ObjC.getString("typeProduct"),ObjC.getString("nameProduct"),
                    ObjC.getInt("quantity"), ObjC.getString("emailDonor"), ObjC.getInt("expirationDateYear"),
                    ObjC.getInt("expirationDateMonth"), ObjC.getInt("expirationDateDay"));
            
            BST.root = BST.crearNodoRoot(com); // meter el root
            
            for (int i = 1; i < productFood.length(); i++){        // Iterar sobre los objetos de comida
                JSONObject objetoComida = productFood.getJSONObject(i);
                
                int     index = objetoComida.getInt("index");
                String  typeProduct = objetoComida.getString("typeProduct");
                String  nameProduct = objetoComida.getString("nameProduct");
                int     quantity = objetoComida.getInt("quantity");
                String  emailDonor = objetoComida.getString("emailDonor");     
                int     expirationDateYear = objetoComida.getInt("expirationDateYear");
                int     expirationDateMonth = objetoComida.getInt("expirationDateMonth"); 
                int     expirationDateDay = objetoComida.getInt("expirationDateDay");

                // crear objeto comida
                Comida comida = new Comida(index, typeProduct, nameProduct, quantity, emailDonor,  expirationDateYear,  expirationDateMonth, expirationDateDay);
                //System.out.println(comida.toString());

                BST.insertar(comida); // metodo insert del HM 
            }
            
            
            ReaderJSON.close();// Cierra el lector de archivo

            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo en BST_TreeComidaNombre es= " + tiempoTranscurrido);

            return(BST);

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");// si se llega a esta linea algo no funciona bien
        
    }
    
    // insert en Cola prioritaria
    public HeapMinor_ComidaFecha PruebaInsertHeapMinor(){
        JSONObject jsonObject = null;
        try {
            boolean exist = EntradaJSON.FileExist(); // ver si el archivo existe y crear nombre de la ruta
            if(!exist){
                throw new RuntimeException("ERROR: Archivo no existe");
            }
            
            if(EntradaJSON.getTypeOfFileRead() != 1){ // Se esta leyendoe el archivo correcto
                throw new RuntimeException("ERROR: TypeOfFileRead incorrect for use method ofJson_getListProductsFood");
            }
             
            String pathFileJSON = EntradaJSON.getFinalPath_fileJson(); // Especifica la ruta del archivo JSON que deseas leer
            
            FileReader ReaderJSON = new FileReader(pathFileJSON);   // Crea un FileReader para leer el archivo JSON
            
            JSONTokener tokener = new JSONTokener(ReaderJSON); // Crea un JSONTokener para analizar el contenido del archivo JSON
            
            jsonObject = new JSONObject(tokener); // Crea un objeto JSONObject o JSONArray según la estructura del JSON
            
            JSONArray productFood = jsonObject.getJSONArray("productFood"); // Obtiene el array "productFood"

            // Crear HM para insertar productos 
            HeapMinor_ComidaFecha HM = new HeapMinor_ComidaFecha(EntradaJSON.getNumberRowsRead());
            
            // PONER EL TIEMPO PARA COMENZAR A MEDIR EL INSERT 
            long startTime = System.nanoTime();
            
            
            for (int i = 0; i < productFood.length(); i++){        // Iterar sobre los objetos de comida
                JSONObject objetoComida = productFood.getJSONObject(i);
                
                int     index = objetoComida.getInt("index");
                String  typeProduct = objetoComida.getString("typeProduct");
                String  nameProduct = objetoComida.getString("nameProduct");
                int     quantity = objetoComida.getInt("quantity");
                String  emailDonor = objetoComida.getString("emailDonor");     
                int     expirationDateYear = objetoComida.getInt("expirationDateYear");
                int     expirationDateMonth = objetoComida.getInt("expirationDateMonth"); 
                int     expirationDateDay = objetoComida.getInt("expirationDateDay");

                // crear objeto comida
                Comida comida = new Comida(index, typeProduct, nameProduct, quantity, emailDonor,  expirationDateYear,  expirationDateMonth, expirationDateDay);
                //System.out.println(comida.toString());

                HM.insert(comida); // metodo insert del HM 
            }
            HM.siftDown(0);
            
            ReaderJSON.close();// Cierra el lector de archivo

            // SALIDA DEL TIEMPO Insert Masivo
            long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo Insertar masivo en HeapMinor_ComidaFecha es= " + tiempoTranscurrido);

            return(HM);

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("ERROR: Tratando de escribir la lista  en el metodo ofJson_getListProductsFood");// si se llega a esta linea algo no funciona bien
        
    }
    
    // metodo de ordenamiento Ascendente AVL 
    public List<Comida> OrdenamientoAVL(AVLTree_ComidaFecha AVL){
        long startTime = System.nanoTime();
    
        List<Comida>  list = AVL.recorrerEnOrden();
        long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo metodo de ordenamiento Ascendente masivo en AVLTree_ComidaFecha es= " + tiempoTranscurrido);

        return(list);    
    }
    

    // metodo de ordenamiento Ascendente Heap minor 
    public Comida[] OrdenamientoHeapMinor(HeapMinor_ComidaFecha Hm){
        long startTime = System.nanoTime();
    
        Comida[] array = Hm.heapSort();
         
        long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo  de ordenamiento Ascendente masivo en HeapMinor_ComidaFecha es= " + tiempoTranscurrido);
        return(array); 
    }
    
    // metodo para eliminar un valor de AVL Fecha
    public void PruebaDeleteAVL_fecha(AVLTree_ComidaFecha AVL, int year, int month, int day, String emailDonnor, String nameProduct ) {
        long startTime = System.nanoTime();
            String email =AVL.delete(AVL.root, year, month, day, emailDonnor, nameProduct).producto.getEmailDonor();
            System.out.print(email);
        long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo delete  en AVLTree_ComidaFecha es= " + tiempoTranscurrido);
    }
    
    // metodo para eliminar un valor de HeapMinor Fecha
    public void PruebaDeleteHeapMinor(HeapMinor_ComidaFecha hm, int year, int month, int day, String emailDonnor, String nameProduct ) {
        long startTime = System.nanoTime();
            hm.remove(year, month, day, emailDonnor, nameProduct);                   
                 
        long endTime = System.nanoTime();
            Double tiempoTranscurrido = (endTime - startTime)/1000000.0;
            System.out.println("El tiempo Transcurrido del metodo delete en HeapMinor_ComidaFecha es= " + tiempoTranscurrido);
    }
    
}
