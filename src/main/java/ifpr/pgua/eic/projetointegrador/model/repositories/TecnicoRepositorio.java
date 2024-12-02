package ifpr.pgua.eic.projetointegrador.model.repositories;


import java.time.LocalDate;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.daos.TecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.results.Result;



public class TecnicoRepositorio {
    private TecnicoDAO dao;

    public TecnicoRepositorio(TecnicoDAO dao){
        this.dao = dao;
    }

    public Result cadastrar(String nome, LocalDate dcf, String cpf){
        if(cpf.isEmpty() || cpf.isBlank() ){
            return Result.fail("Cpf invalido!");
        }

        

        Tecnico tecnicos = new Tecnico(nome, dcf, cpf);

        return dao.criar(tecnicos);
    }

    public Result editar(String nome, LocalDate dcf, String cpf){
        Tecnico tecnico = new Tecnico(nome, dcf, cpf);

        return dao.editar(cpf, tecnico);
    }

    public List<Tecnico> mostrarTodos(){

        return dao.listarTodos();
    }
}
