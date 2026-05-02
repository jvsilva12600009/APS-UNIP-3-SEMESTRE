
package javaapplication1;

public class Plastico {
    private String nome;
    private int quantidade;
    private double consumoUnitario;

    public Plastico(String nome, int quantidade, double consumoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.consumoUnitario = consumoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getConsumoUnitario() {
        return consumoUnitario;
    }
}