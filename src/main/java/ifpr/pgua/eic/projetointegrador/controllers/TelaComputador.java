package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.repositories.ComputadorRepositorio;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaComputador extends BaseController implements Initializable{

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfIp;

    @FXML
    private TextField tfPatrimonio;

    @FXML
    private DatePicker dpDataMT;

    @FXML
    private TableView<Computador> tbComputador;

    @FXML
    private TableColumn<Computador, String> tbcIp;

    @FXML
    private TableColumn<Computador, String> tbcPatrimonio;

    @FXML
    private TableColumn<Computador, String> tbcNome;

    @FXML
    private TableColumn<Computador, String> tbcDataMTC;

    
    private ComputadorRepositorio repositorio;

    public TelaComputador(ComputadorRepositorio repositorio){
        this.repositorio = repositorio;
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcIp.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIp()+""));
        tbcPatrimonio.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getComputador().getNome()));
        tbcNome.setCellValueFactory(cell -> new PropertyValueFactory<>("Nome"));
        tbcDataMTC.setCellFactory(cell -> new SimpleStringProperty(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(cell.getValue().getDataHora())));

        atualizarTabela();
        
    }

    @FXML
    private void atualizarTabela() {
        tbComputador.getItems().clear();
        tbComputador.getItems().addAll(repositorio.mostrarTodos());
    }

    @FXML
    private void adicionar(){
        String nome = tfNome.getText();
        String Ip = tfIp.getText();
        String Patrimonio = tfPatrimonio.getText();

    }

    @FXML
    private void Limpar(){
        tfNome.clear();
        tfIp.clear();
        tfPatrimonio.clear();
    }

    
    
}
