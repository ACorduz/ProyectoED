package EstructurasCorte2;
import Data.Comida;

public class NodoAVLComida {
    public Comida producto;
    public NodoAVLComida izquierdo;
    public NodoAVLComida derecho;
    public int altura;
    
    public NodoAVLComida(Comida producto) {
        this.producto = producto;
        this.altura = 0;
    }
}
