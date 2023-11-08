/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;

import Data.Producto;
import java.io.Serializable;

/**
 *
 * @author die_a
 */
public class NodoAVL implements Serializable {
    public Producto producto;
    public NodoAVL izquierdo;
    public NodoAVL derecho;
    public int altura;
    
    public NodoAVL(Producto producto) {
        this.producto = producto;
        this.altura = 0;
    }
}
