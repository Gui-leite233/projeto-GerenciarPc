package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Result;

import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.repositories.TecnicoRepositorio;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
    private LocalDateTime dpData_cadastro_funcionario;

    @FXML
    private TableView<Tecnico> tbTecnico;

    @FXML
    private TableColumn<Tecnico, String> tbcCpf;

    @FXML
    private TableColumn<Tecnico, String> tbcMatricula;

    @FXML
    private TableColumn<Tecnico, String> tbcNome;

    private Tecnico selecionado = null;

    private TecnicoRepositorio repositorio;

    public TelaTecnico(TecnicoRepositorio repositorio){
        this.repositorio = repositorio;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCpf.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCpf()));
        tbcMatricula.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMatricula()));
        tbcNome.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));

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
        String cpf = tfCpf.getText();
        String Matricula = tfMatricula.getText();

        Result result = null;

        if(atualizar){
            result = repositorio.atualizar(selecionado.getCpf(),cpf,dcf,Matricula,nome);
        } else{
            result = repositorio.cadastrar(nome, cpf, dcf,  Matricula);
        }
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfCpf.clear();
        tfMatricula.clear();
    }
}
