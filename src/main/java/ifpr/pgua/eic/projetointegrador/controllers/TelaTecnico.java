package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.repositories.TecnicoRepositorio;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaTecnico {
    private Button btCadastar;

    private Button btEditar;

    private Button btExcluir;

    private TextField tfNome;

    private TextField tfCpf;

    private TextField tfMatricula;

    private DatePicker dpData_cadastro_funcionario;

    private TableView<Tecnico> tbTecnico;

    private TableColumn<Tecnico, String> tbcCpf;

    private TableColumn<Tecnico, String> tbcMatricula;

    private TableColumn<Tecnico, String> tbcNome;

    private TecnicoRepositorio repositorio;

    public TelaTecnico(TecnicoRepositorio repositorio){
        this.repositorio = repositorio;
    }


    //@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        tbcMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));

        atualizarTabela();
        
    }

    
    private void atualizarTabela() {
        tbTecnico.getItems().clear();
        tbTecnico.getItems().addAll(repositorio.mostrarTodos());
    }

    private void adicionar(){
        String nome = tfNome.getText();
        String Ip = tfCpf.getText();
        String Matricula = tfMatricula.getText();
    }

    private void Limpar(){
        tfNome.clear();
        tfCpf.clear();
        tfMatricula.clear();
    }
}
