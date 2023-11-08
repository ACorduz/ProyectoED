
package EstructurasCorte2;
import EstructurasCorte2.NodoAVLComida;
import Data.Food;


public class AVLTree_ComidaNombre {
    public NodoAVLComida root;

    public AVLTree_ComidaNombre() {
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

    public NodoAVLComida insert(NodoAVLComida node, Food producto) {
        if (node == null) {
            return new NodoAVLComida(producto);
        } else {
            int comparacion = producto.getNameProduct().compareTo(node.producto.getNameProduct());
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

    public NodoAVLComida delete(NodoAVLComida node, String nombreProducto) {
        if (node == null) {
            return node;
        } else {
            int comparacion = nombreProducto.compareTo(node.producto.getNameProduct());
            if (comparacion < 0) {
                node.izquierdo = delete(node.izquierdo, nombreProducto);
            } else if (comparacion > 0) {
                node.derecho = delete(node.derecho, nombreProducto);
            } else {
                if (node.izquierdo == null || node.derecho == null) {
                    node = (node.izquierdo == null) ? node.derecho : node.izquierdo;
                } else {
                    NodoAVLComida mostLeftChild = mostLeftChild(node.derecho);
                    node.producto = mostLeftChild.producto;
                    node.derecho = delete(node.derecho, mostLeftChild.producto.getNameProduct());
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

    public NodoAVLComida find(String nombreProducto) {
        NodoAVLComida current = root;
        while (current != null) {
            int comparacion = nombreProducto.compareTo(current.producto.getNameProduct());
            if (comparacion == 0) {
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
            System.out.println("Nombre del Producto: " + node.producto.getNameProduct());
            // Aquí puedes agregar cualquier otra lógica de impresión que desees
            inOrderTraversal(node.derecho);
        }
    }

    // Agrega un método público para iniciar el recorrido en orden
    public void printInOrder() {
        inOrderTraversal(root);
    }
}
