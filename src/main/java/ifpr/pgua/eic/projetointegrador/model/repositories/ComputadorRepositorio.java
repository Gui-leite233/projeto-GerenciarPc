package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Result cadastrar(String patrimonio, String nome, String ip, String observacao, LocalDate dataCadastro){
        if(patrimonio.isEmpty() || patrimonio.isBlank() ){
            return Result.fail("Valor do Patrimonio invalido!");
        }

        if(ip.isEmpty() || ip.isBlank()){
            return Result.fail("Valor invalido!");
        }

        Computador computadores = new Computador(patrimonio, nome, ip, observacao, dataCadastro);

        return dao.criar(computadores);
    }

    public Result editar(String patrimonio, String nome, String ip, String observacao, LocalDate dataCadastro){
        Computador computador = new Computador(patrimonio, nome, ip, observacao, dataCadastro);

        return dao.editar(patrimonio, computador);
    }

    public List<Computador> mostrarTodos(){
        return dao.listarTodos();
    }
}
