package Ejercicio_3_1.Fuentes;

/**
 * Clase para utilidades de presentación y mensajes
 */
public class Utilidades {

    private static final int ANCHO = 70;
    private static final char BORDE_H = '═';

    /**
     * Muestra el banner de bienvenida del sistema
     */
    public static void mostrarBanner() {
        System.out.println("\n╔" + repetir(BORDE_H, ANCHO - 2) + "╗");
        System.out.println("║" + centrar("SISTEMA DE GESTIÓN DE PERSONAS") + "║");
        System.out.println("║" + centrar("Cálculo de IMC y Verificación de Datos") + "║");
        System.out.println("╚" + repetir(BORDE_H, ANCHO - 2) + "╝");
    }

    /**
     * Muestra el resultado del IMC de una persona
     */
    public static void mostrarResultadoIMC(Persona persona, int numeroPersona) {
        int resultadoIMC = persona.calcularIMC();
        String mensaje = "";
        String estado = "";

        switch (resultadoIMC) {
            case -1:
                estado = "PESO BAJO";
                mensaje = "⚠️  La persona está por debajo de su peso ideal";
                break;
            case 0:
                estado = "PESO IDEAL";
                mensaje = "✅ La persona está en su peso ideal";
                break;
            case 1:
                estado = "SOBREPESO";
                mensaje = "⚠️  La persona tiene sobrepeso";
                break;
        }

        System.out.println("\n┌" + repetir('─', ANCHO - 2) + "┐");
        System.out.println("│ RESULTADO IMC - PERSONA " + numeroPersona + ": " + estado + espacios(ANCHO - 32 - estado.length()) + "│");
        System.out.println("│ " + mensaje + espacios(ANCHO - 4 - mensaje.length()) + "│");
        System.out.println("└" + repetir('─', ANCHO - 2) + "┘");
    }

    /**
     * Muestra si una persona es mayor de edad
     */
    public static void mostrarMayoriaEdad(Persona persona, int numeroPersona) {
        String mensaje = persona.esMayorDeEdad()
                ? "✅ La persona ES mayor de edad"
                : "❌ La persona NO es mayor de edad";

        System.out.println("┌" + repetir('─', ANCHO - 2) + "┐");
        System.out.println("│ MAYORÍA DE EDAD - PERSONA " + numeroPersona + espacios(ANCHO - 30) + "│");
        System.out.println("│ " + mensaje + espacios(ANCHO - 4 - mensaje.length()) + "│");
        System.out.println("└" + repetir('─', ANCHO - 2) + "┘");
    }

    /**
     * Muestra un separador visual
     */
    public static void mostrarSeparador() {
        System.out.println("\n" + repetir('═', ANCHO));
    }

    /**
     * Muestra el sello personalizado al final del programa
     */
    public static void mostrarSello() {
        System.out.println("\n\n╔" + repetir(BORDE_H, ANCHO - 2) + "╗");
        System.out.println("║" + centrar("SELLO PERSONALIZADO - GUÍA #2 POO Y UML") + "║");
        System.out.println("╠" + repetir(BORDE_H, ANCHO - 2) + "╣");
        System.out.println("║" + centrar("Jonatan Varela | jivarela@unah.hn") + "║");
        System.out.println("║" + centrar("Erinson Álvarez | erinson.alvarez@unah.hn") + "║");
        System.out.println("╠" + repetir(BORDE_H, ANCHO - 2) + "╣");
        System.out.println("║" + centrar("Sección: 3-1") + "║");
        System.out.println("║" + centrar("Fecha: 2025-11-03") + "║");
        System.out.println("╚" + repetir(BORDE_H, ANCHO - 2) + "╝\n");
    }

    /**
     * Centra un texto en el ancho especificado
     */
    private static String centrar(String texto) {
        int espacios = (ANCHO - 2 - texto.length()) / 2;
        return " ".repeat(espacios) + texto + " ".repeat(ANCHO - 2 - texto.length() - espacios);
    }

    /**
     * Repite un carácter n veces
     */
    private static String repetir(char caracter, int veces) {
        return String.valueOf(caracter).repeat(veces);
    }

    /**
     * Genera espacios para alineación
     */
    private static String espacios(int cantidad) {
        return " ".repeat(Math.max(0, cantidad));
    }

    /**
     * Pausa el programa esperando Enter
     */
    public static void pausar() {
        System.out.print("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignorar excepción
        }
    }
}