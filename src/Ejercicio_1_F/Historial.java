// Historial.java
package Ejercicio_1_F;

import java.util.ArrayList;

/**
 * Clase del dominio: Gestiona lista de compras y total gastado.
 * Composición: contiene múltiples Compra.
 */
public class Historial {
    private ArrayList<Compra> compras = new ArrayList<>();

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    public void mostrarHistorial(Cliente cliente) {
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }
        System.out.println("\n┌────────────────────────────────────────────┐");
        System.out.println("│            HISTORIAL DE COMPRAS            │");
        System.out.println("├────────────────────────────────────────────┤");
        double total = 0;
        for (Compra c : compras) {
            System.out.printf("│ - %s (L%.2f)                │%n", c.producto.nombre, c.costo);
            total += c.costo;
        }
        System.out.printf("│ Total gastado: L%.2f                      │%n", total);
        System.out.println("└────────────────────────────────────────────┘");
    }
}