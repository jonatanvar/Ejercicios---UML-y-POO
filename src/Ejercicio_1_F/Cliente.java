// Cliente.java
package Ejercicio_1_F;

/**
 * Clase del dominio: Representa al cliente que compra repuestos.
 * Encapsulamiento: saldo privado.
 */
public class Cliente {
    private String nombre;
    private double saldo;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public void restarSaldo(double monto) { saldo -= monto; }
    public double getSaldo() { return saldo; }
    public String getNombre() { return nombre; }
}