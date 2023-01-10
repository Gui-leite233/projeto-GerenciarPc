package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface TecnicoDAO {
    Result criar(Tecnico tecnico);
    Result editar(String cpf);
    Result remover(String cpf);
    List<Tecnico> listarTodos();
    Tecnico buscarPorCpfTecnico(String cpf);
    
    Tecnico buscarTecnico(int matricula);

    

}