package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    /*@FXML
    private void carregarClientes(){
        App.changeScreenRegion("CLIENTES", BorderPaneRegion.CENTER);
    }*/

    @FXML
    private void carregarComputador(){
        App.changeScreenRegion("COMPUTADOR", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregarTecnico(){
        App.changeScreenRegion("TECNICO", BorderPaneRegion.CENTER);
    }

    /*@FXML
    private void carregarNovaVenda(){
        App.changeScreenRegion("NOVAVENDA", BorderPaneRegion.CENTER);
    }*/



}
