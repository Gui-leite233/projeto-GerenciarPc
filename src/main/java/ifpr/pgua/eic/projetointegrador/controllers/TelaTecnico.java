package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.google.protobuf.Message;
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
//import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Tecnico ,LocalDate> dataCad;

    
    @FXML
    private TableView<Tecnico> tbTecnico;

    @FXML
    private DatePicker dpDcf;

    @FXML
    private TableColumn<Tecnico, String> tbcCpf;

    @FXML
    private TableColumn<Tecnico, String> tbcData;

    @FXML
    private TableColumn<Tecnico, String> tbcNome;

    private Tecnico selecionado = null;

    //private TextField tfNumero;

    //String sNumero = tfNumero.getText();

    private String msg;

    private boolean atualizar = false;

    private TecnicoRepositorio repositorio;
    

    public TelaTecnico(TecnicoRepositorio repositorio){
        this.repositorio = repositorio;
        dpDcf = new DatePicker(LocalDate.now());
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCpf.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCpf()));
        //tbcMatricula.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMatricula()));
        tbcNome.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNome()));
        tbcData.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        dpDcf.setValue(LocalDate.now());

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
        //String matricula = tfMatricula.getText();
        LocalDate data = dpDcf.getValue();
        Result result = null;

        if(atualizar){
            result = repositorio.editar(cpf, selecionado.getDataHora(),nome);
            msg = "Atualizado!!";
        } else{
            result = repositorio.cadastrar(nome, data, cpf);
            msg = "Cadastrado!!";
        }

        


        if(result instanceof SuccessResult){
            limpar();
            atualizar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();
    }

    


    


    @FXML
    private void limpar(){
        tfNome.clear();
        tfCpf.clear();
        //tfMatricula.clear();

        atualizar = false;
        
    }

    /*private void atualizarTabela(){

            
        tbTecnico.getItems().clear();
        tbTecnico.getItems().addAll(repositorio.mostrarTodos());
        
        
    }*/
}
