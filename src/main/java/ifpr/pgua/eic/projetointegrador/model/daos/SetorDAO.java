package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Setor;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface SetorDAO {
    Result criar(Setor setor);
    Result editar(String codigo);
    Result remover(String codigo);
    List<Setor> ListarTodos();
    Setor buscarPorCodigoSetor(String codigo);

    Setor buscaSetor(String codigo);
}