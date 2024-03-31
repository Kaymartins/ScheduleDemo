package com.codejr.schedule.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/schedule?useSSL=false&useTimezone=true&serverTimezone=UTC";

    public static Connection createConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL JDBC não encontrado", e);
        }
    }

    public static void main(String[] args) throws Exception {

        Connection connection = createConnection();
        try {
            if(connection != null) {
                System.out.println("Conexão obtida com sucesso!");
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro SQLException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}