package ifpr.pgua.eic.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.projetointegrador.controllers.TelaComputador;
import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.controllers.TelaTecnico;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.ComputadorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCComputadorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCTecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.SetorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.TecnicoDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.ComputadorRepositorio;
import ifpr.pgua.eic.projetointegrador.model.repositories.SetorRepositorio;
import ifpr.pgua.eic.projetointegrador.model.repositories.TecnicoRepositorio;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.ScreenRegistryFXML;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private TecnicoDAO tecnicoDAO;
    private TecnicoRepositorio tecnicoRepositorio;
    private ComputadorRepositorio computadorRepositorio;
    private ComputadorDAO computadorDAO;
    private SetorDAO setorDAO;
    private SetorRepositorio setorRepositorio;
    private FabricaConexoes fabricaConexao = FabricaConexoes.getInstance();


    //DEFINIR A FABRICA DE CONEXÕES, DAOS e REPOSITÓRIOS

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
        tecnicoDAO = new JDBCTecnicoDAO(fabricaConexao);
        tecnicoRepositorio = new TecnicoRepositorio(tecnicoDAO);
        computadorDAO = new JDBCComputadorDAO(fabricaConexao);
        computadorRepositorio = new ComputadorRepositorio(computadorDAO);
        setorRepositorio = new SetorRepositorio(setorDAO);
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }



    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Projeto Integrador";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        
        registraTela("COMPUTADOR", new ScreenRegistryFXML(getClass(), "fxml/computador.fxml", (o)->new TelaComputador(computadorRepositorio)));

        registraTela("TECNICO", new ScreenRegistryFXML(getClass(), "fxml/tecnico.fxml", (o)->new TelaTecnico(tecnicoRepositorio)));

    }


}