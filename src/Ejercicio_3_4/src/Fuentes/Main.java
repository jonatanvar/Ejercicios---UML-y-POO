public class Main {
    // Atributos privados
    private int dia;
    private int mes;
    private int anio;

    // Constructor por defecto: inicializa con la fecha actual (simulado: 1/1/2025)
    public Main() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 2025;
    }

    // Constructor con parámetros
    public Main(int dia, int mes, int anio) {
        if (esFechaValida(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        } else {
            // Si la fecha es inválida, se asigna una por defecto
            this.dia = 1;
            this.mes = 1;
            this.anio = 2025;
            System.out.println("Fecha inválida. Se asignó 1/1/2025 por defecto.");
        }
    }

    // Método para establecer la fecha completa con validación
    public boolean setFecha(int dia, int mes, int anio) {
        if (esFechaValida(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
            return true;
        }
        return false;
    }

    // Setters
    public void setDia(int dia) {
        if (dia >= 1 && dia <= diasEnMes(this.mes, this.anio)) {
            this.dia = dia;
        }
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
            // Ajustar día si excede los días del nuevo mes
            int maxDias = diasEnMes(mes, this.anio);
            if (this.dia > maxDias) {
                this.dia = maxDias;
            }
        }
    }

    public void setAnio(int anio) {
        if (anio >= 1) {
            this.anio = anio;
            // Ajustar día si febrero 29 y no es bisiesto
            if (this.mes == 2 && this.dia == 29 && !esBisiesto(anio)) {
                this.dia = 28;
            }
        }
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    // Método toString: devuelve la fecha en formato dd/mm/aaaa
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    // Método para verificar si la fecha es válida
    public boolean esFechaValida(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) return false;
        if (dia < 1 || dia > diasEnMes(mes, anio)) return false;
        if (anio < 1) return false;
        return true;
    }

    // Método auxiliar: devuelve el número de días en un mes dado
    private int diasEnMes(int mes, int anio) {
        return switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> esBisiesto(anio) ? 29 : 28;
            default -> 31;
        };
    }

    // Método auxiliar: verifica si un año es bisiesto
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    // Método para avanzar un día
    public void siguiente() {
        dia++;
        if (dia > diasEnMes(mes, anio)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Main f1 = new Main();
        System.out.println("Fecha por defecto: " + f1);

        Main f2 = new Main(31, 12, 2025);
        System.out.println("Fecha creada: " + f2);

        Main f3 = new Main(29, 2, 2023); // Año no bisiesto → ajusta a 1/1/2025
        System.out.println("29/02/2023 (inválida): " + f3);

        f2.setDia(15);
        f2.setMes(6);
        System.out.println("Después de modificar: " + f2);

        System.out.println("¿Es válida 30/02/2025? " + f2.esFechaValida(30, 2, 2025));
    }
}