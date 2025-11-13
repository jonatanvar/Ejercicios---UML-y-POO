// Main.java
package Ejercicio_1_A;

import java.util.Scanner;

/*
 * PROMPT ENVIADO AL ASISTENTE IA (Grok):
 * "Agente ahora tenemos que hacer la segunda parte
 *  de ejercicios en Java pero en POO, te proporciono el enunciado del Ejercicio#1-A:
 * Desarrollo de una aplicación para el control de gastos e ingresos
 * personales, que la moneda sea en LPS (lempiras Hondureños).
 * Que el usuario ingrese su nombre y en base a eso le das tu el
 * manejo de sus ingresos y gastos, que el programa tenga estos métodos:
 * * Registrar Ingreso
 * * Registrar Gasto
 * * Calcular Balance
 * * Mostrar Historial
 * * Filtrar Por Tipo
 * Estas opciones que sea parte del Menú central junto con la opción
 * de salir del programa, que sea fácil de manejar como por ejemplo:
 * 1. Registrar Ingreso
 * 2. Registrar Gasto
 * ¿Cuáles son las clases que el sistema requerirá?
 * (haga una tabla donde la primera columna contenga el nombre de la
 * clase y la segunda la descripción de esta)."
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuario;
    private static GestorFinanzas gestor;
    private static final String[] CATEGORIAS_VALIDAS = {
            "Salario", "Freelance", "Inversión", "Regalo", // Ingresos
            "Comida", "Transporte", "Entretenimiento", "Salud", "Educación", "Otros" // Gastos
    };

    public static void main(String[] args) {
        Utilidades.mostrarSello();

        String nombre = ingresarNombreValido("Ingrese su nombre (solo letras y espacios): ");
        usuario = new Usuario(nombre);
        gestor = new GestorFinanzas();

        int opcion;
        do {
            mostrarMenu();
            opcion = ingresarEntero("Seleccione una opción: ", 1, 6);
            ejecutarOpcion(opcion);
        } while (opcion != 6);

        Utilidades.mostrarDespedida();
    }

    private static void mostrarMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                     MENÚ PRINCIPAL - FINANZAS PERSONALES           │");
        System.out.println("├────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Registrar Ingreso                                               │");
        System.out.println("│ 2. Registrar Gasto                                                 │");
        System.out.println("│ 3. Calcular Balance                                                │");
        System.out.println("│ 4. Mostrar Historial                                               │");
        System.out.println("│ 5. Filtrar Por Tipo                                                │");
        System.out.println("│ 6. Salir                                                           │");
        System.out.println("└────────────────────────────────────────────────────────────────────┘");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarIngreso();
            case 2 -> registrarGasto();
            case 3 -> calcularBalance();
            case 4 -> mostrarHistorial();
            case 5 -> filtrarPorTipo();
        }
    }

    private static void registrarIngreso() {
        double monto = ingresarDouble("Monto del ingreso (LPS): ");
        String descripción = ingresarDescripciónValida("Descripción (máx. 50 caracteres): ");
        String categoría = elegirCategoría("INGRESO");
        gestor.registrarTransacción(usuario, new Transacción(monto, "INGRESO", descripción, new Categoría(categoría)));
        System.out.println("Ingreso registrado exitosamente.");
    }

    private static void registrarGasto() {
        double monto = ingresarDouble("Monto del gasto (LPS): ");
        String descripción = ingresarDescripciónValida("Descripción (máx. 50 caracteres): ");
        String categoría = elegirCategoría("GASTO");
        gestor.registrarTransacción(usuario, new Transacción(monto, "GASTO", descripción, new Categoría(categoría)));
        System.out.println("Gasto registrado exitosamente.");
    }

    private static void calcularBalance() {
        if (usuario.getTransacciones().isEmpty()) {
            System.out.println("No hay transacciones registradas aún. Registre al menos una para calcular el balance.");
            System.out.println("Ejemplo: Opción 1 → Ingrese monto 5000 → 'Salario de noviembre'");
            return;
        }
        double balance = gestor.calcularBalance(usuario);
        String estado = balance >= 0 ? "POSITIVO" : "NEGATIVO";
        System.out.printf("Balance actual: L%.2f [%s]%n", balance, estado);
    }

    private static void mostrarHistorial() {
        if (usuario.getTransacciones().isEmpty()) {
            System.out.println("No hay transacciones para mostrar. Registre ingresos o gastos primero.");
            System.out.println("Ejemplo: Opción 2 → Gasto de 150 → 'Almuerzo'");
            return;
        }
        gestor.mostrarHistorial(usuario);
    }

    private static void filtrarPorTipo() {
        if (usuario.getTransacciones().isEmpty()) {
            System.out.println("No hay transacciones para filtrar. Registre al menos una transacción.");
            System.out.println("Ejemplo: Opción 1 → Ingreso de 3000 → 'Freelance'");
            return;
        }
        String tipo = ingresarTexto("Filtrar por tipo (INGRESO/GASTO): ").toUpperCase();
        if (!tipo.equals("INGRESO") && !tipo.equals("GASTO")) {
            System.out.println("Tipo inválido. Mostrando todos.");
            tipo = null;
        }
        gestor.filtrarPorTipo(usuario, tipo);
    }

    // --- Validaciones mejoradas ---
    private static String ingresarNombreValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,}")) {
                return input;
            }
            System.out.println("Nombre inválido. Use solo letras y espacios (mín. 2 caracteres). Ej: Jonatan Varela");
        }
    }

    private static String ingresarDescripciónValida(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.length() <= 50) {
                return input;
            }
            System.out.println("Descripción inválida. Debe tener entre 1 y 50 caracteres. Ej: 'Compra en supermercado'");
        }
    }

    private static String elegirCategoría(String tipoOperacion) {
        System.out.println("\nCategorías disponibles para " + tipoOperacion + ":");
        for (int i = 0; i < CATEGORIAS_VALIDAS.length; i++) {
            System.out.printf("%d. %s%n", i + 1, CATEGORIAS_VALIDAS[i]);
        }
        while (true) {
            int opción = ingresarEntero("Elija una categoría (número): ", 1, CATEGORIAS_VALIDAS.length);
            String seleccionada = CATEGORIAS_VALIDAS[opción - 1];
            System.out.println("Categoría seleccionada: " + seleccionada);
            return seleccionada;
        }
    }

    private static String ingresarTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Entrada vacía. Intente de nuevo.");
        }
    }

    private static double ingresarDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                double valor = Double.parseDouble(input);
                if (valor > 0) return valor;
                System.out.println("El monto debe ser mayor a 0. Ej: 250.50");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido. Ej: 1500.75");
            }
        }
    }

    private static int ingresarEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(input);
                if (valor >= min && valor <= max) return valor;
                System.out.printf("Opción debe estar entre %d y %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }
}