package ifpr.pgua.eic.projetointegrador.model.entities;

import javafx.scene.control.DatePicker;

public class Tecnico {
    private String nome;
    private DatePicker data_cadastro_funcionario;
    private String cpf;
    private String matricula;

    public Tecnico(String nome, String matricula, DatePicker data_cadastro_funcionario, String cpf){
        this.nome = nome;
        this.data_cadastro_funcionario = data_cadastro_funcionario;
        this.cpf = cpf;
        this.matricula = matricula;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public DatePicker getData_cadastro_funcionario(){
        return data_cadastro_funcionario;
    }

    public void setData_cadastro_funcionario(DatePicker data_cadastro_funcionario){
        this.data_cadastro_funcionario = data_cadastro_funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
