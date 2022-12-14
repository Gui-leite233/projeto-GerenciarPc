package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.daos.ComputadorDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class ComputadorRepositorio {
    private List<Computador> computadores;
    private ComputadorDAO dao;

    public ComputadorRepositorio(ComputadorDAO dao){
        this.dao = dao;
    }

    public Result cadastrar(String nome, String patrimonio, String ip){
        if(patrimonio.isEmpty() || patrimonio.isBlank() ){
            return Result.fail("Valor do Patrimonio invalido!");
        }

        if(ip.isEmpty() || ip.isBlank()){
            return Result.fail("Valor invalido!");
        }

        Computador computador = new Computador(nome, patrimonio, ip);

        return dao.criar(computador);
    }

    public List<Computador> mostrarTodos(){
        return dao.listarTodos();
    }
}
