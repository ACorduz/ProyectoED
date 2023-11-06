
package Business;

// pruebas heapMinor
import java.util.Date;
import Data.Comida;
import EstructurasCorte2.HeapMinor_ComidaFecha;

// pruebas avl 
import EstructurasCorte2.AVLTree_ComidaNombre;
import EstructurasCorte2.NodoAVLComida;
import Data.Comida;

public class MainPruebasEstructuras {

    
    public static void main(String[] args) {
        
        // COLA PRIORITARIA Comida
        Date fecha = new Date(2023, 1, 16);
        System.out.println(fecha.hashCode());
        
        Comida f1 = new Comida(1,"Food", "Sopa enlatada", 65, "alejandragomez@example.com", 2024 ,2, 2); 
        Comida f2 = new Comida(2,"Food", "Sopa ", 65, "alejandragomez@example.com", 2025 ,2, 2); 
        Comida f3 = new Comida(3,"Food", "garbanzo ", 65, "alejandragomez@example.com", 2013 ,5, 9); 
        HeapMinor_ComidaFecha hc = new HeapMinor_ComidaFecha(4);
        
        hc.insert(f1);
        hc.insert(f2);
        hc.insert(f3);
        
        for(int i =0; i < 3; i++ ){
            System.out.println(hc.extractMin().toString());
        }
        
        // AVL COMIDA
                AVLTree_ComidaNombre avlTree = new AVLTree_ComidaNombre();

        // Insertar productos en el árbol
        
        
        avlTree.root = avlTree.insert(avlTree.root, f1);
        avlTree.root = avlTree.insert(avlTree.root, f2);
        avlTree.root = avlTree.insert(avlTree.root, f3);

        
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
        
        
    }
    
}
