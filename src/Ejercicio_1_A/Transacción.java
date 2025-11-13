// Transacción.java
package Ejercicio_1_A;

public class Transacción {
    private double monto;
    private String tipo; // INGRESO o GASTO
    private String descripción;
    private Categoría categoría;
    private String fecha;

    public Transacción(double monto, String tipo, String descripción, Categoría categoría) {
        this.monto = monto;
        this.tipo = tipo;
        this.descripción = descripción;
        this.categoría = categoría;
        this.fecha = java.time.LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return String.format("%s | L%.2f | %s | %s", fecha, monto, tipo, descripción);
    }

    public double getMonto() { return monto; }
    public String getTipo() { return tipo; }
    public Categoría getCategoría() { return categoría; }
}