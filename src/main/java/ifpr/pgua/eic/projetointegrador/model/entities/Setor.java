package ifpr.pgua.eic.projetointegrador.model.entities;

//import javafx.scene.control.DatePicker;

public class Setor {
    private String codigo;
    private String descricao;

    public Setor(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
