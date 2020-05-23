package com.quantum.qcoin.data;

import com.quantum.qcoin.core.QCoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFacotry {
    private static Connection connection = null;
    private final QCoin pl = QCoin.plugin;

    private ConnectionFacotry() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + pl.getDataFolder() + "/coin.db");
    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                new ConnectionFacotry();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}