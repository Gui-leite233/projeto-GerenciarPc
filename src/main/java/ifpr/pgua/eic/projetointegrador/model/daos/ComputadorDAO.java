package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface ComputadorDAO {
    Result criar(Computador computador);
    Result editar(String patrimonio);
    Result remover(String patrimonio);
    List<Computador> listarTodos();
    Computador buscarPorPatrimonio(String patrimonio);
    
    Computador buscarComputadorItem(int itemPatrimonio);

    

}