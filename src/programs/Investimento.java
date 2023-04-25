package programs;

public class Investimento {
    private double valor;
    private double juros;
    private int anos;

    public Investimento(double valor, double juros, int anos) {
        this.valor = valor;
        this.juros = juros;
        this.anos = anos;

    }

    public double calcularJuros() {
        return (valor * (juros / 100)) * anos;
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

    public int getAnos() {
        return anos;

    }
}
