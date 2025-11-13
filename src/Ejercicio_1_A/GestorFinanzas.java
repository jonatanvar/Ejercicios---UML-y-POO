// GestorFinanzas.java
package Ejercicio_1_A;

public class GestorFinanzas {
    public void registrarTransacción(Usuario usuario, Transacción t) {
        usuario.agregarTransacción(t);
    }

    public double calcularBalance(Usuario usuario) {
        double ingresos = 0, gastos = 0;
        for (Transacción t : usuario.getTransacciones()) {
            if (t.getTipo().equals("INGRESO")) ingresos += t.getMonto();
            else gastos += t.getMonto();
        }
        return ingresos - gastos;
    }

    public void mostrarHistorial(Usuario usuario) {
        System.out.println("\n--- HISTORIAL COMPLETO ---");
        for (Transacción t : usuario.getTransacciones()) {
            System.out.println(t + " | Cat: " + t.getCategoría());
        }
    }

    public void filtrarPorTipo(Usuario usuario, String tipo) {
        System.out.println("\n--- FILTRADO POR " + (tipo != null ? tipo : "TODOS") + " ---");
        boolean encontrado = false;
        for (Transacción t : usuario.getTransacciones()) {
            if (tipo == null || t.getTipo().equals(tipo)) {
                System.out.println(t + " | Cat: " + t.getCategoría());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay transacciones de este tipo.");
    }
}