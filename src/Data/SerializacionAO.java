
package Data;

import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_LinkedList.LinkedList;
import Business.Main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Estructure_LinkedList.Queue;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import Estructure_DinamicArray.DinamicArray;



public class SerializacionAO <T>{
    String[] arrayRouteFiles = {"listForChooseProductSerialization.obj", "listOfProductsSerialization.obj", "listOfBeneficiariesSerialization.obj", "listOfDonorsSerialization.obj", "listOfProducts_DASerialization.obj"};

    public boolean fileExist(String nameFile){
        File file = new File(nameFile);
        return file.exists() && !file.isDirectory();
    }
    
    public int getIndexNamesFiles(String nameFile){
        
        for(int i=0; i < arrayRouteFiles.length; i++){
            if(arrayRouteFiles[i].equals(nameFile)){
                return(i);
            }
        }
        throw new RuntimeException("WRONG NAME in method getIndexNamesFiles");
    }
    
    public void deleteFile(String nameFile){
        File archivo = new File(nameFile);
        if (archivo.delete())
           System.out.println("El archivo ha sido borrado satisfactoriamente");
        else
           System.out.println("El archivo no puede ser borrado");
    }
    
    public void deleteAllFiles(){
        for(int i = 0; i < arrayRouteFiles.length; i++){
            deleteFile(arrayRouteFiles[i]);
        }
    }

    // el siguiente metodo es para crear los archivos o ver si ya estan creados; 
    public boolean WriteSerializationInicialFile(int indexArrayRouteFile){
        // se le pasa el indice del file y se verifica
        String fileName = arrayRouteFiles[indexArrayRouteFile]; 
        boolean isFileCreated = fileExist(fileName);
        if(!isFileCreated){
            try{
                // si compradores_ser no esta creado lo crea, file output stream sabe como crear y conectar archivos
                FileOutputStream fos= new FileOutputStream(fileName);
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                boolean notErrorWrite = true;
                // System.out.println("aqui llego antes switch");
                switch(indexArrayRouteFile){
                    case 0:
                        Queue  listForChooseProduct = Main.getListForChooseProduct();
                        oos.writeObject(listForChooseProduct);
                        break;
                    case 1:
                        DoubleLinkedList<Producto> listOfProducts = Main.getListOfProducts();
                        //System.out.println("aqui llego");
                        oos.writeObject(listOfProducts);
                        break;
                    case 2:
                        //LinkedList<Beneficiary> listOfBeneficiaries = Main.getListOfBeneficiaries();
                        //oos.writeObject(listOfBeneficiaries);
                        break;
                    case 3:
                        LinkedList<Donador> listOfDonors = Main.getListOfDonors();
                        oos.writeObject(listOfDonors);
                        break;
                    case 4: // nueva pruebas
                        DinamicArray <Comida> ListOfProducts_DA = Main.getListOfProducts_DA();
                        oos.writeObject(ListOfProducts_DA);
                        break;
                    default:
                        System.out.println("hubo un error escribirSerializacion_inicialArchivo--");
                        notErrorWrite = false;
                        
                }
                
                oos.close();
                fos.close();
                return(notErrorWrite); // regresa true si se pudo crear el file
            }catch(IOException ioe){
                System.out.print("Hubo un error tratando de serializar el array de compradores" + ioe);
            }        
        }
        // si el file ya ha sido creado entonces regresa false
        return(false);
    }
    
    // para crear todos los archivos incialmente ; 
    public void WriteSerializationInicial_AllFiles(){
        for(int i = 0; i < arrayRouteFiles.length; i++){
            System.out.print("file"+ i+ ", is writeCorrectly="+WriteSerializationInicialFile(i)+";");
        }
        System.out.println();
    
    }
    
    // Este metodo devuelve un objeto de los archivos serializados por lo que hay que hacerle un casting 
    public T getObjectFromSerializationFile(int indexArrayRouteFile){
        // se le pasa el indice del file y se verifica
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
    
    // guardar una lista del programa
    public void saveStatusListProgram(int indexArray){
        deleteFile(arrayRouteFiles[indexArray]);
        WriteSerializationInicialFile(indexArray);
    }
    
    // guardar todas las listas del programa
    public void saveStatusOfAllListProgram(){
        // necesitamos cambiar los archivos serializados entonces vamos a sobreescribirlos(borrar y volver a escribir). porque no sabemos si se borraron archivos, o agregaron. Se podria saber pero para ahorrar trabajo se hace de esta manera.
        // sin embargo, puede haber otra forma de optimizar esta parte, pues si no se cambia un file porque borrarlo;
        // ojo los metodos iniciales nos sirven, porque, primero debimos haber sacado las listas, luego si les agregamos algo, solo debemos traerlas otra vez y guardarlas
        for(int i = 0; i < arrayRouteFiles.length; i++){
            deleteFile(arrayRouteFiles[i]);
            WriteSerializationInicialFile(i);
        }
        
    }
    
    public String getNameArray(int indexArray){
        return(arrayRouteFiles[indexArray]);
    }
    
    // este metodo pone la lista del file que necesite en el programa, Es decir pone la lista del file que busque en las lista Main, para que luego pueda ser trabajada
    public boolean SetListInProgramFromFile(int indexArray){
        T object = null;
        if(indexArray >=0 && indexArray< arrayRouteFiles.length){
            object = getObjectFromSerializationFile(indexArray);
        }else{
            System.out.println("hubo un error indice incorrecto");
            return(false);
        }
        
        switch(indexArray){
            case 0:
                Queue listForChooseProduct =  (Queue) object;
                Main.setListForChooseProduct(listForChooseProduct);
                break;
            case 1:
                DoubleLinkedList<Producto> listOfProducts = (DoubleLinkedList<Producto>) object; 
                Main.setListOfProducts(listOfProducts);
                break;
            case 2:
                LinkedList<Beneficiario> listOfBeneficiaries = (LinkedList<Beneficiario>) object;
                //Main.setListOfBeneficiaries(listOfBeneficiaries);
                break;
            case 3:
                LinkedList<Donador> listOfDonors = (LinkedList<Donador>) object;
                Main.setListOfDonors(listOfDonors);
                break;
            case 4:
                DinamicArray<Comida> listOfProducts_DA = (DinamicArray<Comida> ) object;
                Main.setListOfProducts_DA(listOfProducts_DA);
                break;
            default:
                System.out.println("Hubo un problema casting SetListInProgramFromFile ");
                return(false);
                
        }
        return(true);
        
    }
    
    //Este metodo configura todas la listas del file dentro del programa
    public void SetAll_ListInProgramFromFile(){
        for(int i = 0; i < arrayRouteFiles.length; i++){
            System.out.print("lista"+ i+ ", is set="+SetListInProgramFromFile(i)+";");
        }
        System.out.println();
    }    
}
