package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Setor;
import ifpr.pgua.eic.projetointegrador.model.repositories.SetorRepositorio;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class TelaSetor {
    private Button btCadastrar;

    private Button btEditar;

    private Button btExcluir;

    private TextField tfCodigo;

    private TextField tfDescricao;

    private SetorRepositorio repositorio;

    private TableColumn<Setor, String> tbcCodigo;

    private TableColumn<Setor, String> tbcDescricao;

    private TableView<Setor> tbSetor;

    public TelaSetor(SetorRepositorio repositorio){
        this.repositorio = repositorio;
    }

    //@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        

        atualizarTabela();
        
    }

    private void atualizarTabela() {
        tbSetor.getItems().clear();
        tbSetor.getItems().addAll(repositorio.mostrarTodos());
    }
}
