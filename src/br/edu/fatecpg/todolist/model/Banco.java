package br.edu.fatecpg.todolist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private static final String url = "jdbc:postgresql://localhost:5432/db_tarefa";
    private static final String user = "fatec";
    private static final String password = "fatec777";

    public static Connection connection() throws SQLException{
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            throw new SQLException(e);
        }
    }
}
