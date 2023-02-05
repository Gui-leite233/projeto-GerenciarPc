package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
//import ifpr.pgua.eic.projetointegrador.model.entities.*;
import ifpr.pgua.eic.projetointegrador.model.entities.Computador;
import ifpr.pgua.eic.projetointegrador.model.entities.Setor;
import ifpr.pgua.eic.projetointegrador.model.entities.Tecnico;
import ifpr.pgua.eic.projetointegrador.model.entities.Manutencao;
import ifpr.pgua.eic.projetointegrador.model.repositories.*;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class TelaNovaManutencao extends BaseController implements Initializable{

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btFinalizar;

    @FXML
    private ComboBox<Computador> cbComputador;

    @FXML 
    private ComboBox<Tecnico> cbTecnico;

    @FXML
    private Label lbTotal;

    @FXML
    private TableView<Manutencao> tbMtcs;

    @FXML
    private TableColumn<Manutencao, String> tbcComputador;

    @FXML 
    private TableColumn<Manutencao, String> tbcValorMTC;

    @FXML
    private TableColumn<Manutencao, String> tbcQuantidade;

    @FXML
    private TextField tfData;

    @FXML
    private TextField tfQuantidade;

    private ComputadorRepositorio repositorioComputador;
    private TecnicoRepositorio repositorioTecnico;
    private SetorRepositorio repositorioSetor;

    private ArrayList<Manutencao> Mtcs;

    public TelaNovaManutencao(ComputadorRepositorio repositorioComputador, TecnicoRepositorio repositorioTecnico, SetorRepositorio repositorioSetor){
        this.repositorioComputador = repositorioComputador;
        this.repositorioSetor = repositorioSetor;
        this.repositorioTecnico = repositorioTecnico;
        this.Mtcs = new ArrayList<>();        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.cbTecnico.getItems().addAll(repositorioTecnico.mostrarTodos());
        this.cbComputador.getItems().addAll(repositorioComputador.mostrarTodos());

        tbcComputador.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getComputador().getNome()));
        tbcQuantidade.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getQuantidade()+""));
        //tbcValorMTC.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getComputador()*celula.getValue().getQuantidade()+""));

        tfData.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh.mm").format(LocalDateTime.now()));
    }

    private void atualizar(){
        tbMtcs.getItems().clear();
        tbMtcs.getItems().addAll(Mtcs);

        
    }

    private void limparEntradaItem(){
        cbComputador.getSelectionModel().clearSelection();
        tfQuantidade.clear();
    }
    
    @FXML
    private void adicionarItem(){

        Computador computador = cbComputador.getSelectionModel().getSelectedItem();
        String sQuantidade = tfQuantidade.getText();

        double quantidade = 0.0;

        try{
            quantidade = Double.valueOf(sQuantidade);
        }catch(NumberFormatException e){
            showMessage(Result.fail("Quantidade inválida!"));
        }

        if(quantidade <= 0){
            showMessage(Result.fail("Quantidade inválida!"));
        }

        Manutencao mtc = new Manutencao();
        mtc.setComputador(computador);
        mtc.setQuantidade(quantidade);
        //mtc.setValorMTC(Computador.getValorMTC());

        Mtcs.add(mtc);

        atualizar();
        limparEntradaItem();

    }
}
