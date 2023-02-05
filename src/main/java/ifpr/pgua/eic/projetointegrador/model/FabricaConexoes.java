package ifpr.pgua.eic.projetointegrador.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ifpr.pgua.eic.projetointegrador.utils.Env;

public class FabricaConexoes {
    private static final int MAX_CONEXOES=5;

    private static FabricaConexoes instance;

    private Connection[] conexoes;

    private FabricaConexoes(){
        conexoes = new Connection[MAX_CONEXOES];
    }

    public static FabricaConexoes getInstance(){
        if(instance == null){
            instance = new FabricaConexoes();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{

        String user = Env.get("info21_leocadio");
        String password = Env.get("info21_leocadio");
        String url = Env.get("mysql://wagnerweinert.com.br:3306/info21_leocadio");


        for(int i=0;i<conexoes.length;i++){
            if(conexoes[i]==null || conexoes[i].isClosed()){
                conexoes[i] = DriverManager.getConnection(url, 
                                                          user, 
                                                          password);
                return conexoes[i];
            }
        }
        throw new SQLException("Não há conexões disponíveis! Esqueceu de fechar?");
    }
}
