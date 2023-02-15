package ifpr.pgua.eic.projetointegrador.model.entities;



import javafx.scene.control.DatePicker;



public class Tecnico {
    private String nome;
    private DatePicker dcf;
    private String cpf;
    private String matricula;

    public Tecnico(String nome, String matricula, DatePicker data_cadastro_funcionario, String cpf){
        this.nome = nome;
        this.dcf = data_cadastro_funcionario;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DatePicker getDataHora() {
        return dcf;
    }

    public void setDataHora(DatePicker dcf) {
        this.dcf = dcf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    
}
