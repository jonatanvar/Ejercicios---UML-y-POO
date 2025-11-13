// Categoría.java
package Ejercicio_1_A;

public class Categoría {
    private String nombre;

    public Categoría(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() { return nombre; }
    public String getNombre() { return nombre; }
}