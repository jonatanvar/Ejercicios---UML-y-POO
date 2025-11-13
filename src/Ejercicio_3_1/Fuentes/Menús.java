package Ejercicio_3_1.Fuentes;

import java.util.Scanner;

/**
 * Clase para gestionar la captura de datos del usuario
 */
public class Menús {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Solicita el nombre al usuario
     */
    public static String pedirNombre() {
        System.out.println("│                                                  │");
        System.out.print("│ Ingrese el nombre: ");
        String nombre = scanner.nextLine().trim();

        while (nombre.isEmpty()) {
            System.out.print("│ ⚠️  El nombre no puede estar vacío. Intente nuevamente: ");
            nombre = scanner.nextLine().trim();
        }

        return nombre;
    }

    /**
     * Solicita la edad al usuario con validación
     */
    public static int pedirEdad() {
        int edad = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("│                                                  │");
                System.out.print("│ Ingrese la edad (ejemplo: 25): ");
                edad = Integer.parseInt(scanner.nextLine());

                if (edad < 0 || edad > 120) {
                    System.out.println("│ ⚠️  La edad debe estar entre 0 y 120 años.      │");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("│ ⚠️  Por favor ingrese un número válido.          │");
            }
        }

        return edad;
    }

    /**
     * Solicita el sexo al usuario con validación
     */
    public static char pedirSexo() {
        char sexo = ' ';
        boolean valido = false;

        while (!valido) {
            System.out.println("│                                                  │");
            System.out.print("│ Ingrese el sexo (H/M): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 && (input.charAt(0) == 'H' || input.charAt(0) == 'M')) {
                sexo = input.charAt(0);
                valido = true;
            } else {
                System.out.println("│ ⚠️  Ingrese 'H' para hombre o 'M' para mujer.   │");
            }
        }

        return sexo;
    }

    /**
     * Solicita el peso al usuario con validación
     */
    public static double pedirPeso() {
        double peso = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("│                                                  │");
                System.out.print("│ Ingrese el peso en kg (ejemplo: 70.5): ");
                peso = Double.parseDouble(scanner.nextLine());

                if (peso <= 0 || peso > 500) {
                    System.out.println("│ ⚠️  El peso debe estar entre 0 y 500 kg.        │");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("│ ⚠️  Ingrese un número válido (use punto).        │");
            }
        }

        return peso;
    }

    /**
     * Solicita la altura al usuario con validación
     */
    public static double pedirAltura() {
        double altura = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("│                                                  │");
                System.out.print("│ Ingrese la altura en metros (ejemplo: 1.75): ");
                altura = Double.parseDouble(scanner.nextLine());

                if (altura <= 0 || altura > 3.0) {
                    System.out.println("│ ⚠️  La altura debe estar entre 0 y 3.0 metros.  │");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("│ ⚠️  Ingrese un número válido (use punto).        │");
            }
        }

        return altura;
    }

    /**
     * Muestra el menú principal y captura todos los datos de una persona
     */
    public static void mostrarMenuCaptura(int numeroPersona) {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║       CAPTURA DE DATOS - PERSONA " + numeroPersona + "             ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
    }

    /**
     * Cierra el footer del menú
     */
    public static void cerrarMenuCaptura() {
        System.out.println("│                                                  │");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}