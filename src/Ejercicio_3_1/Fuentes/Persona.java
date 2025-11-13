package Ejercicio_3_1.Fuentes;

import java.util.Random;

/**
 * Clase que representa a una persona con sus datos personales
 * y métodos para calcular IMC y verificar mayoría de edad
 */
public class Persona {

    // Atributos privados
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    // Constantes
    private static final char SEXO_DEFECTO = 'H';
    private static final int PESO_BAJO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;

    // Constructor por defecto
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_DEFECTO;
        this.peso = 0.0;
        this.altura = 0.0;
        generaDNI();
    }

    // Constructor con nombre, edad y sexo
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0.0;
        this.altura = 0.0;
        comprobarSexo(sexo);
        generaDNI();
    }

    // Métodos públicos

    /**
     * Calcula el Índice de Masa Corporal (IMC)
     * @return -1 si peso bajo, 0 si peso ideal, 1 si sobrepeso
     */
    public int calcularIMC() {
        if (altura == 0) return PESO_BAJO;

        double imc = peso / Math.pow(altura, 2);

        if (imc < 20) {
            return PESO_BAJO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }

    /**
     * Verifica si la persona es mayor de edad
     * @return true si tiene 18 años o más
     */
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    /**
     * Retorna toda la información del objeto
     */
    @Override
    public String toString() {
        String info = "╔══════════════════════════════════════════════════╗\n";
        info += "║            INFORMACIÓN DE LA PERSONA             ║\n";
        info += "╠══════════════════════════════════════════════════╣\n";
        info += String.format("║ Nombre:  %-39s ║\n", nombre);
        info += String.format("║ DNI:     %-39s ║\n", dni);
        info += String.format("║ Edad:    %-39d ║\n", edad);
        info += String.format("║ Sexo:    %-39c ║\n", sexo);
        info += String.format("║ Peso:    %-36.2f kg ║\n", peso);
        info += String.format("║ Altura:  %-37.2f m ║\n", altura);
        info += "╚══════════════════════════════════════════════════╝";
        return info;
    }

    // Métodos privados

    /**
     * Comprueba que el sexo sea H o M, si no asigna H por defecto
     */
    private void comprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEFECTO;
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Genera un DNI aleatorio de 8 dígitos con su letra correspondiente
     */
    private void generaDNI() {
        Random random = new Random();
        int numeroDNI = 10000000 + random.nextInt(90000000);
        char letra = generaLetrasDNI(numeroDNI);
        this.dni = numeroDNI + "-" + letra;
    }

    /**
     * Calcula la letra del DNI según el algoritmo español
     * @param numero Número del DNI
     * @return Letra correspondiente
     */
    private char generaLetrasDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numero % 23;
        return letras.charAt(indice);
    }

    // Métodos setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Métodos getters (sin getDNI según especificaciones)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}