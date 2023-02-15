package ifpr.pgua.eic.projetointegrador.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class Computador {
    private String patrimonio;
    private String nome;
    private String ip;
    private String observacao;
    private LocalDate dataCadastro;
    //private Manutencao mtc;
    //private String ValorMTC;




    public Computador(String patrimonio, String nome, String ip, String observacao, LocalDate dataCadastro) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.ip = ip;
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        //this.ValorMTC = ValorMTC;
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

    public void setIp(String ip){
        this.ip = ip;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataCadastro(){
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro){
        this.dataCadastro = dataCadastro;
    }
    
}
