package ifpr.pgua.eic.projetointegrador.model.entities;

public class Computador {
    private String patrimonio;
    private String nome;
    private String ip;
    private String ValorMTC;




    public Computador(String patrimonio, String nome, String ip, String valorMTC) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.ip = ip;
        this.ValorMTC = ValorMTC;
    }




    public String getPatrimonio() {
        return patrimonio;
    }




    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }




    public String getNome() {
        return nome;
    }




    public void setNome(String nome) {
        this.nome = nome;
    }




    public String getIp() {
        return ip;
    }




    public void setIp(String ip) {
        this.ip = ip;
    }




    public String getValorMTC() {
        return ValorMTC;
    }




    public void setValorMTC(String valorMTC) {
        ValorMTC = valorMTC;
    }




    
    
}
