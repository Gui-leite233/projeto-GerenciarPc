package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.repositories.ComputadorRepositorio;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private TextField tfObservacao;

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

    

    private boolean atualizar = false;

    private String msg;

    @FXML
    private TableColumn<Computador, String> tbcDataMTC;

    
    private ComputadorRepositorio repositorio;

    public TelaComputador(ComputadorRepositorio repositorio){
        this.repositorio = repositorio;
        dpDataMT = new DatePicker(LocalDate.now());
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcIp.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIp()+""));
        tbcPatrimonio.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPatrimonio()));
        tbcNome.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));
        //tbcMatricula.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));
        tbcDataMTC.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        dpDataMT.setValue(LocalDate.now());
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
        String ip = tfIp.getText();
        String patrimonio = tfPatrimonio.getText();
        String observacao = tfObservacao.getText();
        LocalDate data = dpDataMT.getValue();
        Result result = null;

       
        if(atualizar){
            result = repositorio.editar(patrimonio, nome, ip, observacao, data);
            msg = "Atualizado!!";
        } else{
            result = repositorio.cadastrar(patrimonio, nome, ip, observacao, data);
            msg = "Cadastrado!!";
        }
        //String Matricula = tfMatricula.getText();

        if(result instanceof SuccessResult){
            Limpar();
            atualizarTabela();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();

    }

    @FXML
    private void Limpar(){
        tfNome.clear();
        tfIp.clear();
        tfPatrimonio.clear();
        tfObservacao.clear();
        //tfMatricula.clear();
    }

    
    
}
