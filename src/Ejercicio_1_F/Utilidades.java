// Utilidades.java
package Ejercicio_1_F;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(H).repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrar("SELLO PERSONALIZADO - GUÍA #2 POO") + "│");
        System.out.println("│" + centrar("Jonatan Varela | jivarela@unah.hn | 1-F | 2025-11-05") + "│");
        System.out.println("└" + String.valueOf(H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarDespedida() {
        System.out.println("\n┌" + String.valueOf(H).repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrar("*** Operaciones completadas exitosamente ***") + "│");
        System.out.println("└" + String.valueOf(H).repeat(ANCHO - 2) + "┘");
    }

    private static String centrar(String texto) {
        int pad = (ANCHO - 2 - texto.length()) / 2;
        return " ".repeat(Math.max(0, pad)) + texto + " ".repeat(Math.max(0, pad));
    }
}