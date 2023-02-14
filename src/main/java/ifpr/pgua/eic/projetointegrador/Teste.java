package ifpr.pgua.eic.projetointegrador;

import java.time.LocalDateTime;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCTecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.TecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;

public class Teste {
    

    public static void main(String[] args) {
        
        TecnicoDAO dao = new JDBCTecnicoDAO(FabricaConexoes.getInstance());

        Tecnico tecnico = new Tecnico("Zé", "12345", LocalDateTime.now(), "9870123");

        dao.criar(tecnico);


    }
}
