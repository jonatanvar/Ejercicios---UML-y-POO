package Ejercicio_3_1.Fuentes;

/**
 * PROMPT UTILIZADO:
 *
 * Ahora agente con todo el contexto que hemos dado con mi compañero, habiendo realizado
 * el diagrama UML presenta el código de dicho Ejercicio_3_1, con el diseño modular
 * adecuado y elegante posible.
 *
 * Siempre valida las entradas al usuario, siempre da Menús fáciles de usar al usuario,
 * muestra el sello personal al final de la ejecución del programa, el sistema deberá de
 * ir usando POO.
 *
 * El código debe ser en base al diagrama que hemos realizado anteriormente, no debe de
 * faltar nada de lo que anteriormente diseñamos, ni deberá de ir mas de lo que ya esta.
 *
 * En la estructura modular recuerda poner este prompt como comentario en el Main, tal cual
 * lo escribí, que sea fácil de usar el sistema, que las salidas sean elegantes al usuario
 * dentro de menús fáciles de usar, y lo mas importante que sea este sistema el código del
 * diagrama anteriormente hecho.
 *
 * Ya tienes el enunciado, proporciona de manera ordenada el código del sistema.
 */

/**
 * Clase principal del sistema de gestión de personas
 * Ejercicio 3.1 - Cálculo de IMC y validación de datos
 *
 * @author Jonatan Varela - jivarela@unah.hn
 * @author Erinson Álvarez - erinson.alvarez@unah.hn
 * @version 1.0
 * @date 2025-11-03
 */
public class Main {

    public static void main(String[] args) {

        // Mostrar banner de bienvenida
        Utilidades.mostrarBanner();

        // ═══════════════════════════════════════════════════════
        // CAPTURA DE DATOS PARA LA PRIMERA PERSONA
        // ═══════════════════════════════════════════════════════

        Menús.mostrarMenuCaptura(1);
        String nombre1 = Menús.pedirNombre();
        int edad1 = Menús.pedirEdad();
        char sexo1 = Menús.pedirSexo();
        double peso1 = Menús.pedirPeso();
        double altura1 = Menús.pedirAltura();
        Menús.cerrarMenuCaptura();

        // Crear primera persona con todos los datos
        Persona persona1 = new Persona(nombre1, edad1, sexo1);
        persona1.setPeso(peso1);
        persona1.setAltura(altura1);

        // ═══════════════════════════════════════════════════════
        // CAPTURA DE DATOS PARA LA SEGUNDA PERSONA
        // ═══════════════════════════════════════════════════════

        Menús.mostrarMenuCaptura(2);
        String nombre2 = Menús.pedirNombre();
        int edad2 = Menús.pedirEdad();
        char sexo2 = Menús.pedirSexo();
        Menús.cerrarMenuCaptura();

        // Crear segunda persona sin peso ni altura
        Persona persona2 = new Persona(nombre2, edad2, sexo2);

        // ═══════════════════════════════════════════════════════
        // CREAR TERCERA PERSONA CON VALORES POR DEFECTO
        // ═══════════════════════════════════════════════════════

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║   PERSONA 3: Creada con valores por defecto     ║");
        System.out.println("║   Se asignarán valores usando métodos set       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Crear tercera persona con constructor por defecto
        Persona persona3 = new Persona();

        // Asignar valores usando setters
        persona3.setNombre("María González");
        persona3.setEdad(30);
        persona3.setSexo('M');
        persona3.setPeso(65.0);
        persona3.setAltura(1.68);

        // ═══════════════════════════════════════════════════════
        // MOSTRAR RESULTADOS DE TODAS LAS PERSONAS
        // ═══════════════════════════════════════════════════════

        Utilidades.mostrarSeparador();
        System.out.println("\n          RESULTADOS DEL ANÁLISIS DE PERSONAS");
        Utilidades.mostrarSeparador();

        // Resultados Persona 1
        System.out.println("\n" + persona1.toString());
        Utilidades.mostrarResultadoIMC(persona1, 1);
        Utilidades.mostrarMayoriaEdad(persona1, 1);

        // Resultados Persona 2
        System.out.println("\n" + persona2.toString());
        Utilidades.mostrarResultadoIMC(persona2, 2);
        Utilidades.mostrarMayoriaEdad(persona2, 2);

        // Resultados Persona 3
        System.out.println("\n" + persona3.toString());
        Utilidades.mostrarResultadoIMC(persona3, 3);
        Utilidades.mostrarMayoriaEdad(persona3, 3);

        // ═══════════════════════════════════════════════════════
        // MOSTRAR SELLO FINAL
        // ═══════════════════════════════════════════════════════

        Utilidades.mostrarSello();

        System.out.println("Programa finalizado exitosamente.");
    }
}