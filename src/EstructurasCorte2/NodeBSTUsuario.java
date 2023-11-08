
package EstructurasCorte2;
import Data.User;

public class NodeBSTUsuario {
    public User usuario;
    public NodeBSTUsuario izquierdo, derecho; 
    
    // constructor
    NodeBSTUsuario(User usuario){
        this.usuario = usuario;
        izquierdo = derecho = null;
    }       

    
    
}
