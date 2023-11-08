package Business;

// pruebas crud
import PruebasCRUD.PruebasCRUD_Productos;

// para guardar los datos insertados
import EstructurasCorte2.AVLTree_ComidaFecha;
import EstructurasCorte2.BST_TreeComidaNombre;
import EstructurasCorte2.HeapMinor_ComidaFecha;

import EstructurasCorte2.NodoAVLComida;

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
        
        // usuario para el borrado 
        int year = 2023; int month = 2; int day=8; String emailDonnor = "crodriguez@example.com"; String nameProduct ="Arroz";
        int year2 = 2025; int month2 = 11; int day2=7; String emailDonnor2 = "gonzalezharold@example.com"; String nameProduct2 = "Yogur";
        int year3 = 2024; int month3 = 9; int day3=24; String emailDonnor3 = "lauracastrillon@example.com"; String nameProduct3 = "Carne de res";
    
 
           
        // PRUEBAS AVL  
        // Insert 
        
        AVL = ObjPruebas.PruebaInsertAVL_fecha();// SE CORRE la prueba y se guarda el AVL para otras pruebas
        // metodo delete 
        ObjPruebas.PruebaDeleteAVL_fecha(AVL,  year2,  month2,  day2,  emailDonnor2,  nameProduct2);
         

        // Metodo Ordenamiento Ascendente
        
        List<Comida> list = ObjPruebas.OrdenamientoAVL(AVL);
        for(int i =0; i < list.size(); i++ ){
            System.out.println(list.get(i).toString());
        }
        // metodo delete 
        ObjPruebas.PruebaDeleteAVL_fecha(AVL,  year,  month,  day,  emailDonnor,  nameProduct);
       
        // PRUEBAS Heap Minor
        // Insert
        HM = ObjPruebas.PruebaInsertHeapMinor();
        // metodo delete
        ObjPruebas.PruebaDeleteHeapMinor(HM,  year3,  month3,  day3,  emailDonnor3,  nameProduct3);
      
        // Metodo Ordenamiento Ascendente
        Comida[] array = ObjPruebas.OrdenamientoHeapMinor(HM);
        
        for(int i =0; i < array.length; i++ ){
            System.out.println(array[i].toString());
        }
        
        // PRUEBAS BST
        // Insert 
        BST = ObjPruebas.PruebaInsertBST();
        // metodo delete 
        
    }
    
}

/*Producto en 5000
        {
            "index": 5000,
            "typeProduct": "Food",
            "nameProduct": "Arroz",
            "quantity": 44,
            "emailDonor": "crodriguez@example.com",
            "expirationDateYear": 2023,
            "expirationDateMonth": 2,
            "expirationDateDay": 8
        },
*/

/* producto 50 000
        {
            "index": 50000,
            "typeProduct": "Food",
            "nameProduct": "Yogur",
            "quantity": 33,
            "emailDonor": "gonzalezharold@example.com",
            "expirationDateYear": 2025,
            "expirationDateMonth": 11,
            "expirationDateDay": 7
        },

*/

/*Producto en 500 000
        {
            "index": 506331,
            "typeProduct": "Food",
            "nameProduct": "Carne de res",
            "quantity": 9,
            "emailDonor": "lauracastrillon@example.com",
            "expirationDateYear": 2024,
            "expirationDateMonth": 9,
            "expirationDateDay": 24
        },
*/