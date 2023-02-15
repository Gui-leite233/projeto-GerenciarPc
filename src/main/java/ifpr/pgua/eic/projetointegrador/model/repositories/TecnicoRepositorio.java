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

    public Result cadastrar(String nome, String matricula, DatePicker dcf, String cpf){
        if(cpf.isEmpty() || cpf.isBlank() ){
            return Result.fail("Cpf invalido!");
        }

        if(matricula.isEmpty() || matricula.isBlank()){
            return Result.fail("Matricula invalida!");
        }

        Tecnico tecnicos = new Tecnico(nome, matricula, dcf, cpf);

        return dao.criar(tecnicos);
    }

    public Result editar(String nome, String matricula, DatePicker dcf, String cpf){
        Tecnico tecnico = new Tecnico(nome, matricula, dcf, cpf);

        return dao.editar(cpf, tecnico);
    }

    public List<Tecnico> mostrarTodos(){

        return dao.listarTodos();
    }
}
