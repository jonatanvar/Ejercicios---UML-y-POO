// Compra.java
package Ejercicio_1_F;

/**
 * Clase del dominio: Registra una transacción de compra.
 */
public class Compra {
    public Cliente cliente;
    public Producto producto;
    public double costo;

    public Compra(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.costo = producto.precio;
    }
}