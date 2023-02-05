package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.repositories.TecnicoRepositorio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaTecnico implements Initializable{
    @FXML
    private Button btCadastar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfMatricula;

    @FXML
    private DatePicker dpData_cadastro_funcionario;

    @FXML
    private TableView<Tecnico> tbTecnico;

    @FXML
    private TableColumn<Tecnico, String> tbcCpf;

    @FXML
    private TableColumn<Tecnico, String> tbcMatricula;

    @FXML
    private TableColumn<Tecnico, String> tbcNome;

    
    private TecnicoRepositorio repositorio;

    public TelaTecnico(TecnicoRepositorio repositorio){
        this.repositorio = repositorio;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        tbcMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));

        atualizar();
        
    }

    @FXML
    private void atualizar() {
        tbTecnico.getItems().clear();
        tbTecnico.getItems().addAll(repositorio.mostrarTodos());
    }

    @FXML
    private void cadastrar(){
        String nome = tfNome.getText();
        String Ip = tfCpf.getText();
        String Matricula = tfMatricula.getText();
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfCpf.clear();
        tfMatricula.clear();
    }
}
