
package EstructurasCorte2;
// import LinkedList_generico.LinkedList;
import Data.Comida;

public class BST_TreeComidaNombre{
    
    // atributos y constructor
    public  NodeBSTComida root;
    public int counterNodes; 
    
    
    public NodeBSTComida crearNodoRoot(Comida key){
        return(new NodeBSTComida(key));
    }
    
    // metodo find
    public NodeBSTComida find(Comida keyFind, NodeBSTComida rootFind){
        int comparacion = root.comida.getNameProduct().compareTo(keyFind.getNameProduct());
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
    
    // encontrar nodos mas izq o der de forma recursiva
    public NodeBSTComida leftDescendant(NodeBSTComida node){
        // retornamos el nodo que encontremos mas cercano a la izquierda que sea diferente de null
        if(node.izquierdo == null){
            return node;
        }else{// si el hijo izq no es nulo hay un valor mas a su izquierda
            return leftDescendant(node.izquierdo) ;
        }
    }
    
    public NodeBSTComida rightAntecesor(NodeBSTComida node){
        // retornamos el nodo que encontremos mas cercano a la izquierda que sea diferente de null
        if(node.derecho == null){
            return node;
        }else{// si el hijo izq no es nulo hay un valor mas a su izquierda
            return rightAntecesor(node.derecho);
        }
    }
    

    
    // El nodo en el arbol con la llave mas grande
    public NodeBSTComida next(NodeBSTComida node){
        NodeBSTComida resultNode;
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
    public void insertarCoursera(Comida key, NodeBSTComida N){
        NodeBSTComida father = find(key, N);
    
        // ahora mirar si se ingresa a la izquierda o la derecha
        int comparacion = key.getNameProduct().compareTo(father.comida.getNameProduct());
        if(comparacion < 0){
            father.izquierdo = new NodeBSTComida(key);
            //System.out.print("Insercion a la izquierda:" + father.Dato);
        }else{
            father.derecho = new NodeBSTComida(key);
            // System.out.print("Insercion a la der:" + father.Dato);
        }
    }
    
    public void insertar(Comida key){
        insertarCoursera(key, root);  
    }
    

    
    // Metodo borrar
    public NodeBSTComida borrarNodoRecursivo(NodeBSTComida nodo, Comida valor) {
        if (nodo == null) {
            return nodo; // Nodo no encontrado
        }
        int comparacion = valor.getNameProduct().compareTo(nodo.comida.getNameProduct());
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

            // Si el nodo tiene dos hijos, obtén el sucesor inmediato (nodo más pequeño en el subárbol derecho)
            nodo.comida = leftDescendant(nodo.derecho).comida;

            // Borra el sucesor inmediato
            nodo.derecho = borrarNodoRecursivo(nodo.derecho, nodo.comida);
        }

        return nodo;
    }
    
    public NodeBSTComida borrar(Comida key){
        return borrarNodoRecursivo(root, key);
    }
    
    
    // Function to do inorder traversal of BST_TreeComidaNombre 
    public void inorder(NodeBSTComida root) 
    { 
        if (root != null) { 
            inorder(root.izquierdo); 
            System.out.println(" " + root.comida.getNameProduct()); 
            inorder(root.derecho); 
        } 
    }
    
}



//Propiedades de un BST_TreeComidaNombre;
// La raiz es la mas grande que cualaquier decendiente de su hijo izquierdo
// La raiz es mas pequeña que cualquier decendiente de su hijo derecho.
// A la izquieda menores que el padre,
// A la derecha mayores que el padre