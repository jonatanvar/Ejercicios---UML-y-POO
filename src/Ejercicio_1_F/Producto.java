// Producto.java
package Ejercicio_1_F;

/**
 * Clase del dominio: Representa un repuesto con precio y categoría.
 */
public class Producto {
    public String nombre;
    public double precio;
    public Categoría categoría;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, double precio, Categoría categoría) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoría = categoría;
    }
}