package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.*;
import java.time.LocalDate;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

            PreparedStatement ptsm = con.prepareStatement("INSERT INTO tca_computador(patrimonio, data_cadastro, observacao, nome, ip) VALUES(?,?,?,?,?)");

            ptsm.setString(1, computador.getPatrimonio());
            ptsm.setTimestamp(2, Timestamp.valueOf( LocalDateTime.of(computador.getDataCadastro(),LocalTime.of(0, 0))));
            ptsm.setString(3, computador.getObservacao());
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
        LocalDate now = LocalDate.now();
        
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM tca_computador");

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                String ip = rs.getString("ip");
                LocalDate dataCadastro = rs.getTimestamp("data_cadastro").toLocalDateTime().toLocalDate();
                String observacao = rs.getString("observacao");
                String patrimonio = rs.getString("patrimonio");
                String nome = rs.getString("nome");

                
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
            ptsm.setDate(2, Date.valueOf(novoComputador.getDataCadastro()));
            ptsm.setString(5, novoComputador.getObservacao());
            

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
