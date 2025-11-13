// Main.java
package Ejercicio_1_F;

import java.util.Scanner;

/*
 * PROMPT ENVIADO AL ASISTENTE IA (Grok):
 * "¿Cuáles son las clases que un sistema para venta de repuestos para vehículos terrestres requerirá?
 * Forma de respuesta: Haz una tabla donde la primera columna contenga el nombre de la clase y la segunda una breve descripción de su función dentro del sistema.
 * Esta tabla deberá mostrarse al inicio del programa, después del sello personal."
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Cliente cliente;
    private static Inventario inventario;
    private static Historial historial;

    public static void main(String[] args) {
        Utilidades.mostrarSello();
        mostrarTablaClasesDominio();

        String nombre = ingresarNombreValido("Ingrese su nombre: ");
        double saldo = ingresarDouble("Saldo disponible (LPS): ");
        cliente = new Cliente(nombre, saldo);
        inventario = new Inventario();
        historial = new Historial();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = ingresarEntero("Seleccione una opción: ", 1, 5);
            switch (opcion) {
                case 1, 2, 3 -> procesarCompra(opcion);
                case 4 -> historial.mostrarHistorial(cliente);
            }
        } while (opcion != 5);

        Utilidades.mostrarDespedida();
    }

    // Tabla solo con clases del dominio (modelo POO real)
    private static void mostrarTablaClasesDominio() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║              CLASES DEL DOMINIO (MODELO POO)                           ║");
        System.out.println("╠══════════════════════╦═════════════════════════════════════════════════╣");
        System.out.println("║ Clase                ║ Descripción                                     ║");
        System.out.println("╠══════════════════════╬═════════════════════════════════════════════════╣");
        System.out.println("║ Cliente              ║ Usuario que realiza compras; tiene saldo        ║");
        System.out.println("║ Vehículo             ║ Tipos: moto, auto, tren con subtipos            ║");
        System.out.println("║ Producto             ║ Repuesto con nombre, precio y categoría         ║");
        System.out.println("║ Categoría            ║ Clasifica productos: lubricantes, limpieza, etc.║");
        System.out.println("║ Compra               ║ Transacción: cliente, producto, costo           ║");
        System.out.println("║ Historial            ║ Lista de compras del cliente con total          ║");
        System.out.println("╚══════════════════════╩═════════════════════════════════════════════════╝");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n┌────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                MENÚ PRINCIPAL - REPUESTOS VEHÍCULOS                │");
        System.out.println("├────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Moto                                                            │");
        System.out.println("│ 2. Auto                                                            │");
        System.out.println("│ 3. Tren                                                            │");
        System.out.println("│ 4. Ver historial de compras                                        │");
        System.out.println("│ 5. Salir                                                           │");
        System.out.println("└────────────────────────────────────────────────────────────────────┘");
    }

    private static void procesarCompra(int tipoVehiculo) {
        Vehículo vehículo = new Vehículo(tipoVehiculo);
        mostrarSubMenuTipo(vehículo);
        int subTipo = ingresarEntero("Seleccione subtipo: ", 1, vehículo.getSubTipos().length);

        mostrarCategorías();
        int categoríaIndex = ingresarEntero("Seleccione categoría: ", 1, 4);
        Producto producto = seleccionarProducto(categoríaIndex - 1);

        if (producto != null && cliente.getSaldo() >= producto.precio) {
            if (confirmarCompra(producto)) {
                cliente.restarSaldo(producto.precio);
                Compra compra = new Compra(cliente, producto);
                historial.agregarCompra(compra);
                System.out.println("Compra realizada exitosamente.");
            }
        } else {
            System.out.println("Saldo insuficiente o producto no disponible.");
        }
    }

    private static void mostrarSubMenuTipo(Vehículo vehículo) {
        System.out.println("\nSubtipos de " + vehículo.tipo + ":");
        for (int i = 0; i < vehículo.getSubTipos().length; i++) {
            System.out.printf("%d. %s%n", i + 1, vehículo.getSubTipos()[i]);
        }
    }

    private static void mostrarCategorías() {
        System.out.println("\nCategorías de productos:");
        System.out.println("1. Lubricantes");
        System.out.println("2. Productos de limpieza");
        System.out.println("3. Herramientas");
        System.out.println("4. Accesorios");
    }

    private static Producto seleccionarProducto(int catIndex) {
        String[] productos = inventario.getProductosPorCategoría(catIndex);
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.length; i++) {
            double precio = 100 + i * 50.0;
            System.out.printf("%d. %s (L%.2f)%n", i + 1, productos[i], precio);
        }
        int sel = ingresarEntero("Seleccione producto: ", 1, productos.length);
        double precio = 100 + (sel - 1) * 50.0;
        String catNombre = obtenerNombreCategoría(catIndex);
        return new Producto(productos[sel - 1], precio, new Categoría(catNombre));
    }

    private static String obtenerNombreCategoría(int index) {
        return switch (index) {
            case 0 -> "Lubricantes";
            case 1 -> "Productos de limpieza";
            case 2 -> "Herramientas";
            case 3 -> "Accesorios";
            default -> "Otros";
        };
    }

    private static boolean confirmarCompra(Producto producto) {
        System.out.printf("Confirmar compra: %s por L%.2f? (s/n): ", producto.nombre, producto.precio);
        String conf = scanner.nextLine().trim().toLowerCase();
        return conf.equals("s") || conf.equals("sí");
    }

    // Validaciones
    private static String ingresarNombreValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            if (input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,}")) return input;
            System.out.println("Nombre inválido. Ej: Juan Pérez");
        }
    }

    private static double ingresarDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim());
                if (valor >= 0) return valor;
                System.out.println("Saldo no puede ser negativo. Ej: 5000.00");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ej: 1500.50");
            }
        }
    }

    private static int ingresarEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.printf("Debe ser entre %d y %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese número.");
            }
        }
    }
}