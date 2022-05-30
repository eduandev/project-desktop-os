package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {
    public static Connection conector() {
        //criando uma variável especial para 
        //estabelecer uma conexão com o banco
        java.sql.Connection conexao = null;
        //carregando o driver correspondente
        //ao banco (não esqueça de importar ele
        // em libraries 
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenando informações referente ao 
        //banco de dados
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "1234567";
        //estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;

        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            System.out.println(e);
            return null;
        }

    
    }
    
}
