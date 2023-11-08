package EstructurasCorte2;
import Data.Food;


public class NodeBSTComida {
    public Food comida;
    public NodeBSTComida izquierdo, derecho; 
    
    // constructor
    NodeBSTComida(Food comida){
        this.comida = comida;
        izquierdo = derecho = null;
    }       

    
    
}
