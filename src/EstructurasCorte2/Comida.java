/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasCorte2;

/**
 *
 * @author die_a
 */
public class Comida {
    private String nombre;
    private String descripcion;
    // Otros atributos relevantes de un producto
    
    public Comida(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        // Inicializa otros atributos si es necesario
    }
    
    public String getNameProduct() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    // Otros métodos getters y setters
}
