package Business;

// pruebas crud
import PruebasCRUD.PruebasCRUD_Productos;

// para guardar los datos insertados
import EstructurasCorte2.AVLTree_ComidaFecha;
import EstructurasCorte2.BST_TreeComidaNombre;
import EstructurasCorte2.HeapMinor_ComidaFecha;

import Data.Comida;
import java.util.List;


public class MainPruebasCRUD_Productos {

    // Guardar las estructuras luego del insert 
    public static AVLTree_ComidaFecha AVL; 
    public static BST_TreeComidaNombre BST; 
     public static HeapMinor_ComidaFecha HM; 
    
    public static void main(String[] args) {
        // Creacion obj de pruebas
        int numberRowsRead = 10; 
        int typeOfFileRead = 1;
        String path = "C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/";
        PruebasCRUD_Productos ObjPruebas = new PruebasCRUD_Productos(numberRowsRead, typeOfFileRead, path);
        
        // PRUEBAS AVL  
        // Insert 
        AVL = ObjPruebas.PruebaInsertAVL_fecha();// SE CORRE la prueba y se guarda el AVL para otras pruebas
        // Metodo Ordenamiento Ascendente
        List<Comida> list = ObjPruebas.OrdenamientoAVL(AVL);
       
        for(int i =0; i < list.size(); i++ ){
            System.out.println(list.get(i).toString());
        }
        // PRUEBAS Heap Minor
        // Insert
        HM = ObjPruebas.PruebaInsertHeapMinor();
        // Metodo Ordenamiento Ascendente
        Comida[] array = ObjPruebas.OrdenamientoHeapMinor(HM);
       
        for(int i =0; i < array.length; i++ ){
            System.out.println(array[i].toString());
        }
        
        
        
        // PRUEBAS BST
        // Insert 
        BST = ObjPruebas.PruebaInsertBST();
    }
    
}
