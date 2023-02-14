package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.scene.control.DatePicker;

public class JDBCComputadorDAO {
    private FabricaConexoes fabricaConexoes;

    DatePicker date;

    public JDBCComputadorDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }
    
    @Override
    public Result criar(Computador computador){
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement ptsm = con.prepareStatement("INSERT INTO tca_computador(patrimonio, data_cadastro, descricao, nome, ip) VALUES(?,?,?,?.?)" );

            ptsm.setString(1, computador.getPatrimonio());
            ptsm.setString(2, computador.getDescricao());
            ptsm.setString(3, computador.getNome());
            ptsm.setString(4, computador.getIp());
            

            ptsm.executeUpdate();

            ptsm.close();
            con.close();

            return Result.success("Computador cadastrado com sucesso!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
