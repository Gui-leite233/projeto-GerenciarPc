package ifpr.pgua.eic.projetointegrador.model.entities;



import java.time.LocalDate;




public class Tecnico {
    private String nome;
    private LocalDate dcf;
    private String cpf;
    //private String matricula;

    public Tecnico(String nome, LocalDate data_cadastro_funcionario, String cpf){
        this.nome = nome;
        this.dcf = data_cadastro_funcionario;
        this.cpf = cpf;
        //this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataHora() {
        return dcf;
    }

    public void setDataHora(LocalDate dcf) {
        this.dcf = dcf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    


    
}
