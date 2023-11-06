package EstructurasCorte2;
import Data.Comida;


public class NodeBSTComida {
    public Comida comida;
    public NodeBSTComida izquierdo, derecho; 
    
    // constructor
    NodeBSTComida(Comida comida){
        this.comida = comida;
        izquierdo = derecho = null;
    }       

    
    
}
