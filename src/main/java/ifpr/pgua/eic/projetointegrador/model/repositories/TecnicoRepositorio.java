package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.daos.TecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.scene.control.DatePicker;

public class TecnicoRepositorio {
    private List<Tecnico> tecnicos;
    private TecnicoDAO dao;

    public TecnicoRepositorio(TecnicoDAO dao){
        this.dao = dao;
    }

    public Result cadastrar(String nome, String matricula, DatePicker data_cadastro_funcionario, String cpf){
        if(cpf.isEmpty() || cpf.isBlank() ){
            return Result.fail("Cpf invalido!");
        }

        if(matricula.isEmpty() || matricula.isBlank()){
            return Result.fail("Matricula invalida!");
        }

        Tecnico tecnicos = new Tecnico(nome, matricula, data_cadastro_funcionario,cpf);

        return dao.criar(tecnicos);
    }

    public List<Tecnico> mostrarTodos(){
        return dao.listarTodos();
    }
}
