package EstructurasCorte2;
import Data.Usuario;

public class NodoAVLUsuario {
    public Usuario usuario;
    public NodoAVLUsuario izquierdo;
    public NodoAVLUsuario derecho;
    public int altura;
    
    public NodoAVLUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.altura = 0;
    }
}
