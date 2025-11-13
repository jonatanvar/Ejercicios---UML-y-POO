// Inventario.java
package Ejercicio_1_F;

/**
 * Clase técnica: Provee datos de productos (no en tabla de dominio).
 */
public class Inventario {
    private String[][] productos = {
            {"Aceite Motor 10W40", "Grasa Litio", "Líquido Frenos"},
            {"Limpiador Motor", "Cera Coche", "Desengrasante"},
            {"Llave Inglesa", "Destornillador", "Alicate"},
            {"Casco Moto", "Tapetes Auto", "Luces LED"}
    };

    public String[] getProductosPorCategoría(int index) {
        return productos[index];
    }
}