package EstructurasCorte2;
import Data.User;

public class NodoAVLUsuario {
    public User usuario;
    public NodoAVLUsuario izquierdo;
    public NodoAVLUsuario derecho;
    public int altura;
    
    public NodoAVLUsuario(User usuario) {
        this.usuario = usuario;
        this.altura = 0;
    }
}
