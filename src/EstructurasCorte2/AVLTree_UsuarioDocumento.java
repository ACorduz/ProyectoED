
package EstructurasCorte2;
import EstructurasCorte2.NodoAVLUsuario;
import Data.User;


public class AVLTree_UsuarioDocumento {
    public NodoAVLUsuario root;

    public AVLTree_UsuarioDocumento() {
        this.root = null;
    }

    
    public void updateHeight(NodoAVLUsuario n) {
        n.altura = 1 + Math.max(height(n.izquierdo), height(n.derecho));
    }

    public int height(NodoAVLUsuario n) {
        return n == null ? -1 : n.altura;
    }

    public int getBalance(NodoAVLUsuario n) {
        return (n == null) ? 0 : height(n.derecho) - height(n.izquierdo);
    }

    public NodoAVLUsuario rotateRight(NodoAVLUsuario y) {
        if (y == null || y.izquierdo == null) {
            return y; // No se puede realizar la rotación
        }
        NodoAVLUsuario x = y.izquierdo;
        NodoAVLUsuario z = x.derecho;
        x.derecho = y;
        y.izquierdo = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public NodoAVLUsuario rotateLeft(NodoAVLUsuario y) {
        NodoAVLUsuario x = y.derecho;
        NodoAVLUsuario z = x.izquierdo;
        x.izquierdo = y;
        y.derecho = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public NodoAVLUsuario rebalance(NodoAVLUsuario z) {
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

    public NodoAVLUsuario insert(NodoAVLUsuario node, User usuario) {
        if (node == null) {
            return new NodoAVLUsuario(usuario);
        } else {
            int comparacion = Integer.parseInt(usuario.getDocument()) - Integer.parseInt(node.usuario.getDocument());
            if (comparacion < 0) {
                node.izquierdo = insert(node.izquierdo, usuario);
            } else if (comparacion > 0) {
                node.derecho = insert(node.derecho, usuario);
            } else {
                node.derecho = insert(node.derecho, usuario);
            }
            return rebalance(node);
        }
    }
    
  
    public NodoAVLUsuario delete(NodoAVLUsuario node, String numeroDocumento) {
        if (node == null) {
            return node;
        } else {
            int comparacion = Integer.parseInt(numeroDocumento) - Integer.parseInt(node.usuario.getDocument());
            if (comparacion < 0) {
                node.izquierdo = delete(node.izquierdo, numeroDocumento);
            } else if (comparacion > 0) {
                node.derecho = delete(node.derecho, numeroDocumento);
            } else {
                if (node.izquierdo == null || node.derecho == null) {
                    node = (node.izquierdo == null) ? node.derecho : node.izquierdo;
                } else {
                    NodoAVLUsuario mostLeftChild = mostLeftChild(node.derecho);
                    node.usuario = mostLeftChild.usuario;
                    node.derecho = delete(node.derecho, mostLeftChild.usuario.getName());
                }
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    public NodoAVLUsuario mostLeftChild(NodoAVLUsuario node) {
        NodoAVLUsuario current = node;
        while (current.izquierdo != null) {
            current = current.izquierdo;
        }
        return current;
    }

    public NodoAVLUsuario find(String numeroDocumento) {
        NodoAVLUsuario current = root;
        while (current != null) {
            int comparacion1 = Integer.parseInt(numeroDocumento) - Integer.parseInt(current.usuario.getDocument());
            if (comparacion1 == 0) {
                break;
            }
            current = comparacion1 < 0 ? current.izquierdo : current.derecho;
        }
        return current;
    }
      // Agrega un método que realice un recorrido en orden (in-order traversal)
    public void inOrderTraversal(NodoAVLUsuario node) {
        if (node != null) {
            inOrderTraversal(node.izquierdo);
            System.out.println("Nombre del Producto: " + node.usuario.getName());
            // Aquí puedes agregar cualquier otra lógica de impresión que desees
            inOrderTraversal(node.derecho);
        }
    }

    // Agrega un método público para iniciar el recorrido en orden
    public void printInOrder() {
        inOrderTraversal(root);
    }


}
