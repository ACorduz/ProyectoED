
package EstructurasCorte2;
// import LinkedList_generico.LinkedList;
import Data.Usuario;

public class BST_TreeUsuarioDocumento{
    
    // atributos y constructor
    public NodeBSTUsuario root;
    public int counterNodes; 
    
    
    public NodeBSTUsuario crearNodoRoot(Usuario key){
        return(new NodeBSTUsuario(key));
    }
    
    // metodo find
    public NodeBSTUsuario find(Usuario keyFind, NodeBSTUsuario rootFind){
        int comparacion = Integer.parseInt(rootFind.usuario.getDocument()) - Integer.parseInt(keyFind.getDocument());
        if(comparacion == 0){        // si el nodo raiz es igual al que se busca se devuelve el mismo 
            return(rootFind);
        }
        else if(comparacion > 0){ // si raiz > a lo que se busca, buscar izquierda
            if(rootFind.izquierdo != null){ // si no es nulo seguir buscando recursivamente
                return(find(keyFind, rootFind.izquierdo));
            }
            return(rootFind); // se devuelve para igual si algo se ingresa ahi 
        }
        // luego seguir los mismos pero contrario (rootFind.Dato < keyFind)
        else{  
            if(rootFind.derecho != null){
                return(find(keyFind, rootFind.derecho));
            }
            return(rootFind);
        }      
    }
    
public NodeBSTUsuario findd(Usuario keyFind, NodeBSTUsuario rootFind) {
    if (rootFind == null) {
        return null; // No se encontró el nodo
    }

    int comparacion = keyFind.getDocument().compareTo(rootFind.usuario.getDocument());

    if (comparacion == 0) {
        return rootFind; // Nodo encontrado
    } else if (comparacion < 0) {
        // El usuario buscado es menor, buscar en el subárbol izquierdo
        return findd(keyFind, rootFind.izquierdo);
    } else {
        // El usuario buscado es mayor, buscar en el subárbol derecho
        return findd(keyFind, rootFind.derecho);
    }
}

    
    // encontrar nodos mas izq o der de forma recursiva
    public NodeBSTUsuario leftDescendant(NodeBSTUsuario node){
        // retornamos el nodo que encontremos mas cercano a la izquierda que sea diferente de null
        if(node.izquierdo == null){
            return node;
        }else{// si el hijo izq no es nulo hay un valor mas a su izquierda
            return leftDescendant(node.izquierdo) ;
        }
    }
    
    public NodeBSTUsuario rightAntecesor(NodeBSTUsuario node){
        // retornamos el nodo que encontremos mas cercano a la izquierda que sea diferente de null
        if(node.derecho == null){
            return node;
        }else{// si el hijo izq no es nulo hay un valor mas a su izquierda
            return rightAntecesor(node.derecho);
        }
    }
    

    
    // El nodo en el arbol con la llave mas grande
    public NodeBSTUsuario next(NodeBSTUsuario node){
        NodeBSTUsuario resultNode;
         // caso 1 si tiene hijoDer
        if(node.derecho != null){
            resultNode = leftDescendant(node.derecho); 
        }
        // caso 2 si no tiene hijoDer
        else{ 
            resultNode= rightAntecesor(node.izquierdo); 
        }
        return(resultNode);
        
        //recuerde caso 2 todo a la derecha
    }
    
    
    /*
    // search es igual a rangeSearch 
    // una lista de nodos con una llave entre x y y
    public LinkedList rangeSearch(NodeBSTComida root, int x, int y){
        LinkedList list = new LinkedList();
        NodeBSTComida N = find(x,root);
        while(N.Dato <= y){
            // verificar que N este dentro de los limietes
            if(N.Dato >= x){
                list.pushFront(N);
            }
            // cambiar el nodo N al siguiente 
            N = next(N);
        }
        
        return(list);
    }*/
    
    // metodo insertar Coursera
    public void insertarCoursera(Usuario key, NodeBSTUsuario N){
        NodeBSTUsuario father = find(key, N);
    
        // ahora mirar si se ingresa a la izquierda o la derecha
        int comparacion = Integer.parseInt(key.getDocument()) - Integer.parseInt(father.usuario.getDocument());
        if(comparacion < 0){
            father.izquierdo = new NodeBSTUsuario(key);
            //System.out.print("Insercion a la izquierda:" + father.Dato);
        }else{
            father.derecho = new NodeBSTUsuario(key);
            // System.out.print("Insercion a la der:" + father.Dato);
        }
    }
    
    public void insertar(Usuario key){
        insertarCoursera(key, root);  
    }
    

    
    // Metodo borrar
    public NodeBSTUsuario borrarNodoRecursivo(NodeBSTUsuario nodo, Usuario valor) {
        if (nodo == null) {
            return nodo; // Nodo no encontrado
        }

        int comparacion = valor.getDocument().compareTo(nodo.usuario.getDocument());

        // Recursivamente, busca el nodo a borrar en el subárbol izquierdo o derecho
        if (comparacion < 0) {
            nodo.izquierdo = borrarNodoRecursivo(nodo.izquierdo, valor);
        } else if (comparacion > 0) {
            nodo.derecho = borrarNodoRecursivo(nodo.derecho, valor);
        } else {
            // Si el nodo tiene uno o ningún hijo, simplemente devuelve el otro hijo (o nulo)
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Si el nodo tiene dos hijos, obtén el sucesor inmediato
            NodeBSTUsuario sucesorInmediato = findSmallestNode(nodo.derecho);

            // Copia el valor del sucesor inmediato al nodo actual
            nodo.usuario = sucesorInmediato.usuario;

            // Borra el sucesor inmediato
            nodo.derecho = borrarNodoRecursivo(nodo.derecho, sucesorInmediato.usuario);
        }

        return nodo;
    }

    public NodeBSTUsuario borrar(Usuario key){
        return borrarNodoRecursivo(root, key);
    }

    private NodeBSTUsuario findSmallestNode(NodeBSTUsuario nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
    
    
    // Function to do inorder traversal of BST_TreeComidaNombre 
    public void inorder(NodeBSTUsuario root) 
    { 
        if (root != null) { 
            inorder(root.izquierdo); 
            System.out.println(" " + root.usuario.toString()); 
            inorder(root.derecho); 
        } 
    }
    
}



//Propiedades de un BST_TreeComidaNombre;
// La raiz es la mas grande que cualaquier decendiente de su hijo izquierdo
// La raiz es mas pequeña que cualquier decendiente de su hijo derecho.
// A la izquieda menores que el padre,
// A la derecha mayores que el padre