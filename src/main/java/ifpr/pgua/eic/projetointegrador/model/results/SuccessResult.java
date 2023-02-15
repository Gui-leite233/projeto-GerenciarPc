package ifpr.pgua.eic.projetointegrador.model.results;

import java.util.Iterator;

import com.mysql.cj.xdevapi.Warning;

public class SuccessResult extends Result {

    /**
     * Cria um objeto que representa um resultado
     * com sucesso.
     * 
     * @param msg Mensagem de sucesso.
     */
    public SuccessResult(String msg) {
        super(msg);
    }

    @Override
    public long getAffectedItemsCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Warning> getWarnings() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getWarningsCount() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
