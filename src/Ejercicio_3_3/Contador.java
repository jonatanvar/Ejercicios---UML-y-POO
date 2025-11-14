public class Contador {

    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public Contador(int valorInicial) {
        this.setValor(valorInicial);
    }

    public Contador(Contador otroContador) {
        this.valor = otroContador.valor;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int nuevoValor) {
        if (nuevoValor >= 0) {
            this.valor = nuevoValor;
        } else {
            System.out.println("[Error] El valor no puede ser negativo. Asignación rechazada.");
        }
    }

    public void incrementar() {
        this.valor++;
    }

    public void decrementar() {
        if (this.valor > 0) {
            this.valor--;
        } else {
            System.out.println("[Advertencia] No se puede decrementar, el contador ya está en cero.");
        }
    }
}