// Vehículo.java
package Ejercicio_1_F;

/**
 * Clase del dominio: Modela tipos de vehículos terrestres con subtipos.
 */
public class Vehículo {
    public String tipo;
    private String[] subTipos;

    public Vehículo(int tipoId) {
        switch (tipoId) {
            case 1 -> { tipo = "Moto"; subTipos = new String[]{"Scooter", "Deportiva", "Clásica"}; }
            case 2 -> { tipo = "Auto"; subTipos = new String[]{"Sedán", "SUV", "Camioneta"}; }
            case 3 -> { tipo = "Tren"; subTipos = new String[]{"Locomotora", "Vagón Pasajeros", "Vagón Carga"}; }
        }
    }

    public String[] getSubTipos() { return subTipos; }
}