package com.herbst.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection connectionDB;

    public static Connection getConnection(){
        if(connectionDB == null){
            connectionDB = initConnection();
            return connectionDB;
        } else {
            try {
                if(connectionDB != null && connectionDB.isClosed()){
                    connectionDB = initConnection();
                    return connectionDB;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connectionDB;
    }

    private static Connection initConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoCadastro", "postgres", "80085");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
