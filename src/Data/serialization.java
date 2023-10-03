
package Data;

import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_LinkedList.LinkedList;
import Estructure_LinkedList.Queue;
import Business.Main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Estructure_LinkedList.Queue;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class serialization <T>{
    String[] arrayRouteFiles = {"listForChooseProductSerialization.obj", "listOfProductsSerialization.obj", "listOfBeneficiariesSerialization.obj", "listOfDonorsSerialization.obj"};

    public boolean fileExist(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists() && !archivo.isDirectory();
    }
    
    public void borrarArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.delete())
           System.out.println("El archivo ha sido borrado satisfactoriamente");
        else
           System.out.println("El archivo no puede ser borrado");
    }

    // el siguiente metodo es para crear los archivos o ver si ya estan creados; 
    public boolean WriteSerializationInicialFile(int indexArrayRouteFile){
        // se le pasa el indice del archivo y se verifica
        String fileName = arrayRouteFiles[indexArrayRouteFile]; 
        boolean isFileCreated = fileExist(fileName);
        if(!isFileCreated){
            try{
                // si compradores_ser no esta creado lo crea, file output stream sabe como crear y conectar archivos
                FileOutputStream fos= new FileOutputStream(fileName);
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                boolean notErrorWrite = true; 
                switch(indexArrayRouteFile){
                    case 0:
                        Queue  listForChooseProduct = Main.getListForChooseProduct();
                        oos.writeObject(listForChooseProduct);
                        break;
                    case 1:
                        DoubleLinkedList<Product> listOfProducts = Main.getListOfProducts();
                        oos.writeObject(listOfProducts);
                        break;
                    case 2:
                        LinkedList<Beneficiary> listOfBeneficiaries = Main.getListOfBeneficiaries();
                        oos.writeObject(listOfBeneficiaries);
                        break;
                    case 3:
                        LinkedList<Donnor> listOfDonors = Main.getListOfDonors();
                        oos.writeObject(listOfDonors);
                        break;
                    default:
                        System.out.println("hubo un error escribirSerializacion_inicialArchivo--");
                        notErrorWrite = false;
                        
                }
                
                oos.close();
                fos.close();
                return(notErrorWrite); // regresa true si se pudo crear el archivo
            }catch(IOException ioe){
                System.out.print("Hubo un error tratando de serializar el array de compradores" + ioe);
            }        
        }
        // si el archivo ya ha sido creado entonces regresa false
        return(false);
    }
    
     //FALTA     
    // crear metodos para sacar el archivos, ya
    
    // Este metodo devuelve un objeto de los archivos serializados por lo que hay que hacerle un casting 
    public T getObjectFromSerializationFile(int indexArrayRouteFile){
        // se le pasa el indice del archivo y se verifica
        String fileName = arrayRouteFiles[indexArrayRouteFile];
        T object = null;
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object =  (T) ois.readObject();
            ois.close();
            fis.close();
            return(object); // al regresar el objeto solo hay que hacerle un casting a lista que estemos utilizando 
            
        }catch(IOException ioe){
             ioe.printStackTrace();
        }catch(ClassNotFoundException c){
             System.out.println("Clase no encontrada");
             c.printStackTrace();
            
        }
        //Este return no se deberia devolver 
        return(null);
    }
    
    public void guardarEstadoAgenda(){
        // necesitamos cambiar los archivos serializados entonces vamos a sobreescribirlos(borrar y volver a escribir). porque no sabemos si se borraron archivos, o agregaron. Se podria saber pero para ahorrar trabajo se hace de esta manera.
        // sin embargo, puede haber otra forma de optimizar esta parte, pues si no se cambia un archivo porque borrarlo;
        // ojo los metodos iniciales nos sirven, porque, primero debimos haber sacado las listas, luego si les agregamos algo, solo debemos traerlas otra vez y guardarlas
        for(int i = 0; i < arrayRouteFiles.length; i++){
            borrarArchivo(arrayRouteFiles[i]);
            WriteSerializationInicialFile(i);
        }
   
    }
    
    
    
}
