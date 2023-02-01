package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCTecnicoDAO implements TecnicoDAO{

    private FabricaConexoes fabricaConexoes;    

    public JDBCTecnicoDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result criar(Tecnico tecnico) {
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO tca_tecnico(cpf,data_cadastro_funcionario,nome) VALUES (?,?,?)");
       
            pstm.setString(1, tecnico.getCpf());
            pstm.setString(2, tecnico.getData_cadastro_funcionario());
            pstm.setString(3, tecnico.getNome());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Tecnico Cadastrado");

            }catch(SQLException e){
                System.out.println(e.getMessage());
                return Result.fail(e.getMessage());
            }
        }
        
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result editar(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result remover(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tecnico> listarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tecnico buscarPorCpfTecnico(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tecnico buscarTecnico(int matricula) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
