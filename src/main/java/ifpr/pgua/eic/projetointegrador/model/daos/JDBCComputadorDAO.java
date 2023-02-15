package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.*;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

//import javafx.scene.control.DatePicker;

public class JDBCComputadorDAO implements ComputadorDAO{
    
    private FabricaConexoes fabricaConexoes;

    
    public JDBCComputadorDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }
    
    @Override
    public Result criar(Computador computador){
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement ptsm = con.prepareStatement("INSERT INTO tca_computador(patrimonio, data_cadastro, descricao, nome, ip) VALUES(?,?,?,?,?)");

            ptsm.setString(1, computador.getPatrimonio());
            ptsm.setTimestamp(2, Timestamp.valueOf(computador.getDataCadastro()));
            ptsm.setString(3, computador.getDescricao());
            ptsm.setString(4, computador.getNome());
            ptsm.setString(5, computador.getIp());
            
            ptsm.executeUpdate();

            ptsm.close();
            con.close();

            return Result.success("Computador cadastrado com sucesso!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }


    @Override
    public Result remover(String ip){
        return null;
    }

    @Override
    public List<Computador> listarTodos(){
        
        ArrayList<Computador> computadores = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM tca_computador");

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                String ip = rs.getString("Ip");
                LocalDateTime dataCadastro = timestamp.toLocalDateTime();
                String observacao = rs.getString("Matricula");
                String patrimonio = rs.getString("Patrimonio");
                String nome = rs.getString("Nome");

                
                Computador computador = new Computador(patrimonio, nome, ip, observacao, dataCadastro);

                computadores.add(computador);
            }
            rs.close();
            pstm.close();
            con.close();
            

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

        
        return Collections.unmodifiableList(computadores);

    }

    @Override
    public Result editar(String patrimonio, Computador novoComputador) {
        try{
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement ptsm = con.prepareStatement("UPDATE tca_computador set patrimonio=?, data_cadastro=?, nome=? WHERE ip=?");

            ptsm.setString(1, novoComputador.getNome());
            ptsm.setString(2, novoComputador.getIp());
            ptsm.setString(3, novoComputador.getPatrimonio());
            ptsm.setTimestamp(4, Timestamp.valueOf(novoComputador.getDataCadastro()));
            ptsm.setString(5, novoComputador.getDescricao());
            

            ptsm.execute();

            ptsm.close();
            con.close();

            return Result.success("Computador atualizado com sucesso!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    

    @Override
    public Computador buscarPorPatrimonio(String patrimonio) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Computador buscarComputadorItem(int itemPatrimonio) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
