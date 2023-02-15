package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Result;

import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.repositories.TecnicoRepositorio;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
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

    private Tecnico selecionado = null;

    private TextField tfNumero;

    //String sNumero = tfNumero.getText();

    private Result msg;

    private boolean atualizar = false;

    private TecnicoRepositorio repositorio;

    public TelaTecnico(TecnicoRepositorio repositorio){
        this.repositorio = repositorio;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCpf.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCpf()));
        tbcMatricula.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMatricula()));
        tbcNome.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));
        dpData_cadastro_funcionario.setValue(LocalDate.now());

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
            result = repositorio.editar(Matricula,cpf, selecionado.getDataHora(),nome);
        } else{
            result = repositorio.cadastrar(nome, cpf, dpData_cadastro_funcionario,  Matricula);
        }

        //Nao sei o porque de naoa estar reconhecendo o BaseController.java
        //showMessage(result);


        if(result instanceof SuccessResult){
            limpar();
            atualizar();
        }
    }

    


    @FXML
    private void limpar(){
        tfNome.clear();
        tfCpf.clear();
        tfMatricula.clear();

        atualizar = false;
        
    }

    /*private void atualizarTabela(){

            
        tbTecnico.getItems().clear();
        tbTecnico.getItems().addAll(repositorio.mostrarTodos());
        
        
    }*/
}
