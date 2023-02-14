package ifpr.pgua.eic.projetointegrador.model.entities;

import javafx.scene.control.DatePicker;

public class Computador {
    private String patrimonio;
    private String nome;
    private String ip;
    private String descricao;
    private DatePicker dataCadastro;
    //private String ValorMTC;




    public Computador(String patrimonio, String nome, String ip, String observacao) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.ip = ip;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DatePicker setDataCadastro(){
        return dataCadastro;
    }

    public void setDataCadastro(DatePicker dataCadastro){
        this.dataCadastro = dataCadastro;
    }
    
}
