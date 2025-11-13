// Usuario.java
package Ejercicio_1_A;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Transacción> transacciones;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.transacciones = new ArrayList<>();
    }

    public void agregarTransacción(Transacción t) { transacciones.add(t); }
    public ArrayList<Transacción> getTransacciones() { return transacciones; }
    public String getNombre() { return nombre; }
}