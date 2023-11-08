
package EstructurasCorte2;
import Data.Usuario;

public class NodeBSTUsuario {
    public Usuario usuario;
    public NodeBSTUsuario izquierdo, derecho; 
    
    // constructor
    NodeBSTUsuario(Usuario usuario){
        this.usuario = usuario;
        izquierdo = derecho = null;
    }       

    
    
}
