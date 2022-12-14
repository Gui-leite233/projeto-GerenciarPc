package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.repositories.ComputadorRepositorio;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaComputador extends BaseController implements Initializable{

    private Button btCadastar;

    private Button btEditar;

    private Button btExcluir;

    private TextField tfNome;

    private TextField tfIp;

    private TextField tfPatrimonio;

    private DatePicker dpDataMT;

    private TableView<Computador> tbComputador;

    private TableColumn<Computador, String> tbcIp;

    private TableColumn<Computador, String> tbcPatrimonio;

    private TableColumn<Computador, String> tbcNome;


    private ComputadorRepositorio repositorio;

    public TelaComputador(ComputadorRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcIp.setCellValueFactory(new PropertyValueFactory<>("Ip"));
        tbcPatrimonio.setCellValueFactory(new PropertyValueFactory<>("Patrimonio"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));

        atualizarTabela();
        
    }

    private void atualizarTabela() {
        tbComputador.getItems().clear();
        tbComputador.getItems().addAll(repositorio.mostrarTodos());
    }

    private void adicionar(){
        String nome = tfNome.getText();
        String Ip = tfIp.getText();
        String Patrimonio = tfPatrimonio.getText();
    }

    private void Limpar(){
        tfNome.clear();
        tfIp.clear();
        tfPatrimonio.clear();
    }

    
    
}
