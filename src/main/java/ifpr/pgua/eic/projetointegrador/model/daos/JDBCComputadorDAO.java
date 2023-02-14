package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCComputadorDAO {
    private FabricaConexoes fabricaConexoes;

    public JDBCComputadorDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }
    
    @Override
    public Result criar(Computador computador){
        try{

            Connection con = fabricaConexoes.getConnection();

            PreparedStatement ptsm = con.prepareStatement("INSERT INTO tca_computador(patrimonio, data_cadastro_funcionario, descricao, nome, ip) VALUES(?,?,?,?.?)" );

            ptsm.setString(1, computador.getPatrimonio());
            ptsm.setString(2, computador.getDescricao());
            ptsm.setString(3, computador.getNome());
        }
    }
}
