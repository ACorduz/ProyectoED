/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;
import java.io.Serializable;
import Data.Product;

/**
 *
 * @author die_a
 */
public class AVLTree implements Serializable {
    public NodoAVL root;

    public AVLTree() {
        this.root = null;
    }

    void updateHeight(NodoAVL n) {
        n.altura = 1 + Math.max(height(n.izquierdo), height(n.derecho));
    }

    int height(NodoAVL n) {
        return n == null ? -1 : n.altura;
    }

    int getBalance(NodoAVL n) {
        return (n == null) ? 0 : height(n.derecho) - height(n.izquierdo);
    }

    NodoAVL rotateRight(NodoAVL y) {
        if (y == null || y.izquierdo == null) {
            return y; // No se puede realizar la rotación
        }
        NodoAVL x = y.izquierdo;
        NodoAVL z = x.derecho;
        x.derecho = y;
        y.izquierdo = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    NodoAVL rotateLeft(NodoAVL y) {
        NodoAVL x = y.derecho;
        NodoAVL z = x.izquierdo;
        x.izquierdo = y;
        y.derecho = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public NodoAVL rebalance(NodoAVL z) {
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

    public NodoAVL insert(NodoAVL node, Product producto) {
        if (node == null) {
            return new NodoAVL(producto);
        } else {
            int comparacion = producto.getNameProduct().compareTo(node.producto.getNameProduct());
            if (comparacion < 0) {
                node.izquierdo = insert(node.izquierdo, producto);
            } else if (comparacion > 0) {
                node.derecho = insert(node.derecho, producto);
            } else {
                // Si el nombre es igual, inserta el nuevo elemento en el lado izquierdo
                node.izquierdo = insert(node.izquierdo, producto);
            }
            return rebalance(node);
        }
    }

    public NodoAVL delete(NodoAVL node, String nombreProducto) {
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
                    NodoAVL mostLeftChild = mostLeftChild(node.derecho);
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

    NodoAVL mostLeftChild(NodoAVL node) {
        NodoAVL current = node;
        while (current.izquierdo != null) {
            current = current.izquierdo;
        }
        return current;
    }

    public NodoAVL find(String nombreProducto) {
        NodoAVL current = root;
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
    void inOrderTraversal(NodoAVL node) {
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
