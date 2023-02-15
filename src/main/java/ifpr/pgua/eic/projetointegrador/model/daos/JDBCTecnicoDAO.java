package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
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

            PreparedStatement pstm = con.prepareStatement("INSERT INTO tca_tecnico(cpf, data_cadastro_funcionario, matricula, nome) VALUES (?,?,?,?)");
       
            pstm.setString(1, tecnico.getCpf());
            //Descobrir equivalente do setString() para datePicker()!!
            pstm.setTimestamp(2, Timestamp.valueOf(tecnico.getDataHora()));
            pstm.setString(3, tecnico.getMatricula());
            pstm.setString(4, tecnico.getNome());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Tecnico Cadastrado");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
        
        
    


    @Override
    public Result remover(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tecnico> listarTodos() {
        
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM tca_tecnico");

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                String cpf = rs.getString("cpf");
                LocalDateTime dcf = timestamp.toLocalDateTime();
                String matricula = rs.getString("Matricula");
                String nome = rs.getString("nome");

                
                Tecnico tecnico = new Tecnico(cpf, matricula, dcf, nome);

                tecnicos.add(tecnico);
            }
            rs.close();
            pstm.close();
            con.close();
            

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

        //List tecnico;
        return Collections.unmodifiableList(tecnicos);

    }

    @Override
    public Tecnico buscarPorCpfTecnico(String cpf) {
        return null;
        
    }

    @Override
    public Tecnico buscarTecnico(String matricula) {
        // TODO Auto-generated method stub
        return null;
    }

    public Result atualizar(String cpf, Tecnico tecnico) {
        try{
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("UPDATE tca_tecnico set cpf=?, data_cadastro_tecnico=?, nome=? WHERE id=?");

            return Result.success("Cliente atualizado com sucesso!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
        //return null;
    }

    @Override
    public Result editar(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    

    
    
}
