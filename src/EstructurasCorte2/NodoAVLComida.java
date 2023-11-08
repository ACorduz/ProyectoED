package EstructurasCorte2;
import Data.Food;

public class NodoAVLComida {
    public Food producto;
    public NodoAVLComida izquierdo;
    public NodoAVLComida derecho;
    public int altura;
    
    public NodoAVLComida(Food producto) {
        this.producto = producto;
        this.altura = 0;
    }
}
