package Business;

// pruebas crud
import PruebasCRUD.PruebasCRUD_Productos;

// para guardar los datos insertados
import EstructurasCorte2.AVLTree_ComidaNombre;
import EstructurasCorte2.BST_TreeComidaNombre;

public class MainPruebasCRUD_Productos {

    // Guardar las estructuras luego del insert 
    public static AVLTree_ComidaNombre AVL; 
    public static BST_TreeComidaNombre BST; 
    
    public static void main(String[] args) {
        // Creacion obj de pruebas
        int numberRowsRead = 10000; 
        int typeOfFileRead = 1;
        String path = "C:\\Users\\JHOAN FRANCO\\OneDrive\\respaldo datos\\Documentos\\PROGRAMACION\\proyectoEstructuras\\ProyectoED\\data/";
        PruebasCRUD_Productos ObjPruebas = new PruebasCRUD_Productos(numberRowsRead, typeOfFileRead, path);
        
        // PRUEBAS AVL  
        // Insert 
        AVL = ObjPruebas.PruebaInsertAVL();// SE CORRE la prueba y se guarda el AVL para otras pruebas
        
       
        // PRUEBAS BST
        // Insert 
        BST = ObjPruebas.PruebaInsertBST();
    }
    
}
