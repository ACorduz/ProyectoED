/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;

import Data.Product;
import java.io.Serializable;

/**
 *
 * @author die_a
 */
public class NodoAVL implements Serializable {
    public Product producto;
    public NodoAVL izquierdo;
    public NodoAVL derecho;
    public int altura;
    
    public NodoAVL(Product producto) {
        this.producto = producto;
        this.altura = 0;
    }
}
