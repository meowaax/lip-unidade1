package programs;

public class Emprestimo {

    private double valor;
    private double juros;
    private int meses;

    public Emprestimo(double valor, double juros, int meses) {
        this.valor = valor;
        this.juros = juros;
        this.meses = meses;

    }

    public double calcularJuros() {
        return (valor * (juros / 100)) * meses;
    }

    public double calcularValorTotal() {
        return valor + calcularJuros();
    }

    public double getValor() {
        return valor;
    }

    public double getJuros() {
        return juros;
    }

    public int getMeses() {
        return meses;
    }
}
