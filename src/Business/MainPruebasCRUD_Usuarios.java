
package Business;
import EstructurasCorte2.BST_TreeUsuarioDocumento;
import PruebasCRUD.PruebasCRUD_Usuario;

public class MainPruebasCRUD_Usuarios {

    public static BST_TreeUsuarioDocumento BST; 
    
    public static void main(String[] args) {
        
        //Creación del object de pruebas
        int numberRowsRead = 10000; 
        int typeOfFileRead = 0;
        String pathDataJson = "C:\\Users\\pipec\\Escritorio\\ED\\DatosEntrega2/";
        PruebasCRUD_Usuario objPruebasUsuarios = new PruebasCRUD_Usuario(numberRowsRead, typeOfFileRead,pathDataJson );
        
        //Pruebas BST
        
            //Prueba Insert
        //BST = objPruebasUsuarios.PruebaInsertBST();
        
            //Prueba Find
        //objPruebasUsuarios.PruebaFindBST();
        
            //Prueba Delete
        //objPruebasUsuarios.PruebaFindBST();
        
        //Pruebas AVL
            //Prueba Insert
        //objPruebasUsuarios.PruebaInsertAVL_Documento();
        
            //Prueba Find
        //objPruebasUsuarios.PruebaInsertAVL_Documento();
        
            //Prueba Delete
        objPruebasUsuarios.PruebaInsertAVL_Documento();
    }
    
    
}
