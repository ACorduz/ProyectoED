
package EstructurasCorte2;
import EstructurasCorte2.NodoAVLComida;
import Data.Comida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AVLTree_ComidaFecha {
    public NodoAVLComida root;

    public AVLTree_ComidaFecha() {
        this.root = null;
    }

    public void updateHeight(NodoAVLComida n) {
        n.altura = 1 + Math.max(height(n.izquierdo), height(n.derecho));
    }

    public int height(NodoAVLComida n) {
        return n == null ? -1 : n.altura;
    }

    public int getBalance(NodoAVLComida n) {
        return (n == null) ? 0 : height(n.derecho) - height(n.izquierdo);
    }

    public NodoAVLComida rotateRight(NodoAVLComida y) {
        if (y == null || y.izquierdo == null) {
            return y; // No se puede realizar la rotación
        }
        NodoAVLComida x = y.izquierdo;
        NodoAVLComida z = x.derecho;
        x.derecho = y;
        y.izquierdo = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public NodoAVLComida rotateLeft(NodoAVLComida y) {
        NodoAVLComida x = y.derecho;
        NodoAVLComida z = x.izquierdo;
        x.izquierdo = y;
        y.derecho = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public NodoAVLComida rebalance(NodoAVLComida z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.derecho.derecho) > height(z.derecho.izquierdo)) {
                z = rotateLeft(z);
            } else {
                z.derecho = rotateRight(z.derecho);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.izquierdo.izquierdo) > height(z.izquierdo.derecho))
                z = rotateRight(z);
            else {
                z.izquierdo = rotateLeft(z.izquierdo);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public NodoAVLComida insert(NodoAVLComida node, Comida producto) {
        if (node == null) {
            return new NodoAVLComida(producto);
        } else {
            Date d1 = new Date(producto.getExpirationDateYear(), producto.getExpirationDateMonth(), producto.getExpirationDateDay());
            Date d2  = new Date(node.producto.getExpirationDateYear(), node.producto.getExpirationDateMonth(), node.producto.getExpirationDateDay());
            
            int comparacion = d1.compareTo(d2);
            if (comparacion < 0) {
                node.izquierdo = insert(node.izquierdo, producto);
            } else if (comparacion > 0) {
                node.derecho = insert(node.derecho, producto);
            } else {
                node.derecho = insert(node.derecho, producto);
            }
            return rebalance(node);
        }
    }

    public NodoAVLComida delete(NodoAVLComida node, int year, int month, int day, String emailDonnor, String nameProduct ) {
        if (node == null) {
            return node;
        } else {
            Date d1 = new Date( year, month, day);
            Date d2  = new Date(node.producto.getExpirationDateYear(), node.producto.getExpirationDateMonth(), node.producto.getExpirationDateDay());
            int comparacion = d1.compareTo(d2);
            if (comparacion < 0) {
                node.izquierdo = delete(node.izquierdo,   year,  month,  day,  emailDonnor,  nameProduct );
            } else if (comparacion > 0) {
                node.derecho = delete(node.derecho, year,  month,  day,  emailDonnor,  nameProduct );
            } else {
                if (node.izquierdo == null || node.derecho == null) {
                    node = (node.izquierdo == null) ? node.derecho : node.izquierdo;
                } else {
                    
                    if(node.producto.getEmailDonor().compareTo(emailDonnor) == 0 && node.producto.getNameProduct().compareTo(nameProduct)== 0){
                        NodoAVLComida mostLeftChild = mostLeftChild(node.derecho);
                        node.producto = mostLeftChild.producto;
                        node.derecho = delete(node.derecho, mostLeftChild.producto.getExpirationDateYear(), mostLeftChild.producto.getExpirationDateMonth(),mostLeftChild.producto.getExpirationDateDay(),mostLeftChild.producto.getEmailDonor(),mostLeftChild.producto.getNameProduct() );

                    }
                }
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    public NodoAVLComida mostLeftChild(NodoAVLComida node) {
        NodoAVLComida current = node;
        while (current.izquierdo != null) {
            current = current.izquierdo;
        }
        return current;
    }

    public NodoAVLComida find(String nombreProducto, int year, int month, int day, String emailDonnor) {
        NodoAVLComida current = root;
        while (current != null) {
            Date d1 = new Date( year, month, day);
            Date d2  = new Date(current.producto.getExpirationDateYear(), current.producto.getExpirationDateMonth(), current.producto.getExpirationDateDay());
            int comparacion = d1.compareTo(d2);
            if (comparacion == 0 && nombreProducto == current.producto.getNameProduct() && emailDonnor == current.producto.getNameProduct()) {
                break;
            }
            current = comparacion < 0 ? current.izquierdo : current.derecho;
        }
        return current;
    }
      // Agrega un método que realice un recorrido en orden (in-order traversal)
    void inOrderTraversal(NodoAVLComida node) {
        if (node != null) {
            inOrderTraversal(node.izquierdo);
            System.out.println("Nombre del Producto: " + node.producto.getNameProduct() + node.producto.getEmailDonor() + node.producto.getExpirationDateYear());
            // Aquí puedes agregar cualquier otra lógica de impresión que desees
            inOrderTraversal(node.derecho);
        }
    }

    // Agrega un método público para iniciar el recorrido en orden
    public void printInOrder() {
        inOrderTraversal(root);
    }
    
    public List<Comida> recorrerEnOrden() {
        List<Comida> listaEnOrden = new ArrayList<>();
        recorrerEnOrden(root, listaEnOrden);
        return listaEnOrden;
    }

    private void recorrerEnOrden(NodoAVLComida nodo, List<Comida> listaEnOrden) {
        if (nodo != null) {
            recorrerEnOrden(nodo.izquierdo, listaEnOrden);
            listaEnOrden.add(nodo.producto);
            recorrerEnOrden(nodo.derecho, listaEnOrden);
        }
    }
}
