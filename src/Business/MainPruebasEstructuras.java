
package Business;

// pruebas heapMinor
import java.util.Date;
import Data.Comida;
import EstructurasCorte2.HeapMinor_ComidaFecha;

// pruebas avl 
import EstructurasCorte2.AVLTree_ComidaNombre;
import EstructurasCorte2.NodoAVLComida;
import Data.Comida;

import Data.Usuario;
import EstructurasCorte2.AVLTree_UsuarioNombre;
import EstructurasCorte2.NodoAVLUsuario;
import EstructurasCorte2.AVLTree_ComidaFecha;

import EstructurasCorte2.AVLTree_UsuarioDocumento;

// Pruebas BST 
import EstructurasCorte2.BST_TreeComidaNombre;
import EstructurasCorte2.BST_TreeUsuarioDocumento;


public class MainPruebasEstructuras {

    
    public static void main(String[] args) {
       
        
        // COLA PRIORITARIA Comida
        Date fecha = new Date(2023, 1, 16);
 
        
        Comida f1 = new Comida(1,"Food", "Sopa enlatada", 65, "alejandragomez@example.com", 2024 ,2, 2); 
        Comida f2 = new Comida(2,"Food", "Avena", 65, "alejandragomez@example.com", 2025 ,2, 2); 
        Comida f3 = new Comida(3,"Food", "Garbanzo ", 65, "alejandragomez@example.com", 2013 ,5, 9);
        Comida f4 = new Comida(3,"Food", "Garbanzo ", 65, "alejandragomez@example.com", 2013 ,5, 9); 
        HeapMinor_ComidaFecha hc = new HeapMinor_ComidaFecha(4);
        
        
        hc.insert(f1);
        hc.insert(f2);
        hc.insert(f3);
        hc.insert(f4);
        
        // hay que ponerle un siftdown al final porque si no puede haber un caso donde no funcione
        hc.siftDown(0);
        
        
        for(int i =0; i < 4; i++ ){
           System.out.println(hc.getHeapArray()[i].toString());
       }
        
        System.out.println("");
        for(int i =0; i < 4; i++ ){
            System.out.println(hc.extractMin().toString());
        }
        
        // AVL COMIDA
        AVLTree_ComidaNombre avlTree = new AVLTree_ComidaNombre();

        // Insertar productos en el árbol
        
        
        avlTree.root = avlTree.insert(avlTree.root, f1);
        avlTree.root = avlTree.insert(avlTree.root, f2);
        avlTree.root = avlTree.insert(avlTree.root, f3);
        avlTree.root = avlTree.insert(avlTree.root, f1);
        
        avlTree.printInOrder();
        // Buscar un producto por nombre
        String nombreProductoABuscar = "Avena";
        NodoAVLComida resultadoBusqueda = avlTree.find(nombreProductoABuscar);
        if (resultadoBusqueda != null) {
            Comida productoEncontrado = resultadoBusqueda.producto;
            System.out.println("Producto encontrado: " + productoEncontrado.getNameProduct());
        } else {
            System.out.println("Producto no encontrado.");
        }
        

        // Eliminar un producto por nombre
        String nombreProductoAEliminar = "Limon";
        avlTree.root = avlTree.delete(avlTree.root, nombreProductoAEliminar);

        // Buscar el producto eliminado
        resultadoBusqueda = avlTree.find(nombreProductoAEliminar);
        if (resultadoBusqueda != null) {
            System.out.println("Producto encontrado después de eliminación: " + resultadoBusqueda.producto.getNameProduct());
        } else {
            System.out.println("Producto no encontrado después de eliminación.");
        }
        
        // OTRAS PRUEABS
        avlTree = null; 
        
        AVLTree_UsuarioNombre avlTree2 = new AVLTree_UsuarioNombre();
        
        // AVL COMIDA FECHA
        System.out.println();
        System.out.println("AVL COMIDA FECHA");
        
        AVLTree_ComidaFecha AVL_CF = new AVLTree_ComidaFecha();
        
        AVL_CF.root = AVL_CF.insert(AVL_CF.root, f1);
        AVL_CF.root = AVL_CF.insert(AVL_CF.root, f2);
        AVL_CF.root = AVL_CF.insert(AVL_CF.root, f3);
        AVL_CF.root = AVL_CF.insert(AVL_CF.root, f1);
        
        AVL_CF.printInOrder();
        NodoAVLComida bus  = AVL_CF.delete(AVL_CF.root, f1.getExpirationDateYear(), f1.getExpirationDateMonth(), f1.getExpirationDateDay(), f1.getEmailDonor(), f1.getNameProduct());
        if (bus != null) {
            System.out.println("Producto encontrado después de eliminación: " + bus.producto.getNameProduct() + bus.producto.toString());
        } else {
            System.out.println("Producto no encontrado después de eliminación.");
        }
        
        AVL_CF.printInOrder();
        
        System.out.println();
        System.out.println();
        // PRUEBAS AVL USUARIO NOMBRE
        Usuario u1 = new Usuario("Milena", "Reyes", "javier40@example.org", "RC", "800", "TAVP=^pauxI", "DONADOR","");
        Usuario u2 = new Usuario("Esteban", "Reyes", "javier40@example.org", "RC", "0900", "TAVP=^pauxI", "DONADOR", "");
        Usuario u3 = new Usuario("Julian", "Reyes", "javier40@example.org", "RC", "600", "TAVP=^pauxI", "DONADOR", "");
        Usuario u4 = new Usuario("Julian2", "Res", "javier40@example.org", "RC", "1000", "TAVP=^pauxI", "DONADOR", "");
        
        avlTree2.root = avlTree2.insert(avlTree2.root, u1);
        avlTree2.root = avlTree2.insert(avlTree2.root, u2);
        avlTree2.root = avlTree2.insert(avlTree2.root, u3);
        avlTree2.root = avlTree2.insert(avlTree2.root, u4);
        avlTree2.root = avlTree2.insert(avlTree2.root, u1);
        
        avlTree2.printInOrder();
        // Buscar un producto por nombre
        String nombreProductoABuscar2 = "Jukuian2";
        NodoAVLUsuario resultadoBusqueda2 = avlTree2.find(nombreProductoABuscar2, "Res");
        if (resultadoBusqueda2 != null) {
            Usuario productoEncontrado = resultadoBusqueda2.usuario;
            System.out.println("Producto encontrado: " + productoEncontrado.getName() + " "+ productoEncontrado.getLastName() );
        } else {
            System.out.println("Producto no encontrado.");
        }
        
        System.out.println("");
        System.out.println("AVL USUARIO DOCUMENTO");
        // AVL USUARIO DOCUMENTO 
        AVLTree_UsuarioDocumento avlTree3 = new AVLTree_UsuarioDocumento();
        
        avlTree3.root = avlTree3.insert(avlTree3.root, u1);
        avlTree3.root = avlTree3.insert(avlTree3.root, u2);
        avlTree3.root = avlTree3.insert(avlTree3.root, u3);
        avlTree3.root = avlTree3.insert(avlTree3.root, u4);
        avlTree3.root = avlTree3.insert(avlTree3.root, u1);
        
        avlTree3.printInOrder();
        
        // PRUEBAS BST COMIDA NOMBRE
        System.out.println("");
        System.out.println("BST Comida Nombre");
        
        BST_TreeComidaNombre BST_TCN = new BST_TreeComidaNombre();
        // OJO forma ded colocar el root 
        BST_TCN.root = BST_TCN.crearNodoRoot(f1);
        
        //System.out.println(tree.root.key);
        BST_TCN.insertar(f2);
        BST_TCN.insertar(f3);
        BST_TCN.insertar(f4);
                
        BST_TCN.inorder(BST_TCN.root);
        
        
        // PRUEBA BST USUARIOS DOCUMENTO
        System.out.println("");
        System.out.println("BST USUARIO DOCUMENTO");
        
        BST_TreeUsuarioDocumento bst_ud = new BST_TreeUsuarioDocumento();
        bst_ud.root = bst_ud.crearNodoRoot(u1);
        bst_ud.insertar(u2);
        bst_ud.insertar(u3);
        bst_ud.insertar(u4);
        bst_ud.insertar(u4);
        
        bst_ud.inorder(bst_ud.root);
        
        
        
    }
    
}
