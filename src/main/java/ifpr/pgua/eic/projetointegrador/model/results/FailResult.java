package ifpr.pgua.eic.projetointegrador.model.results;

import java.util.Iterator;

import com.mysql.cj.xdevapi.Warning;

/***
 * Classe responsável por representar um resultado
 * falho de uma operação. 
 */

public class FailResult extends Result {

    /**
     * Cria um objeto que representa um resultado falho de uma
     * operação.
     * 
     * @param msg Mensagem de falha.
     */
    public FailResult(String msg) {
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
