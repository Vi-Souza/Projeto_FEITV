package com.mycompany.projetofeitv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // Dados de conexão 
    private static final String URL = "jdbc:postgresql://localhost:5432/feitv";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Souza@"; 

    // Método para obter a conexão
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com PostgreSQL estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
