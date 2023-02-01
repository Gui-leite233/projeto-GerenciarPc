package ifpr.pgua.eic.projetointegrador.model.entities;

public class Manutencao {
    private int id;
    private Computador computador;
    //private double valorMTC;
    private double quantidade;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    /*public double getValorMTC() {
        return valorMTC;
    }

    public void setValorMTC(double valorMTC) {
        this.valorMTC = valorMTC;
    }*/

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
