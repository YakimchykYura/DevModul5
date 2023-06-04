package org.example;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection CONNECTION;
    private Database() {
        try{
            String connectionUrl = PropertyReader.getConnectionUrl();
            this.CONNECTION = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            throw new RuntimeException("Connection error");
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public Connection getCONNECTION() {
        return CONNECTION;
    }
    public int executeUpdate(String query) {
        try (Statement statement = Database.getInstance().getCONNECTION().createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void closeConnection() {
        try{
            CONNECTION.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
