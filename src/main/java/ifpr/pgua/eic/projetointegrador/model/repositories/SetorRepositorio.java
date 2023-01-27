package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.daos.SetorDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Setor;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.scene.control.DatePicker;

public class SetorRepositorio {
    private List<Setor> setores;
    private SetorDAO dao;

    public SetorRepositorio(SetorDAO dao){
        this.dao = dao;
    }

    public Result cadastrar(String codigo, String descricao){
        if(codigo.isEmpty() || codigo.isBlank() ){
            return Result.fail("Codigo invalido!");
        }

        if(descricao.isEmpty() || descricao.isBlank()){
            return Result.fail("Descricao invalida!");
        }

        Setor Setores = new Setor(codigo, descricao);

        return dao.criar(Setores);
    }

    public List<Setor> mostrarTodos() {
        return dao.ListarTodos();
    }

    


}
