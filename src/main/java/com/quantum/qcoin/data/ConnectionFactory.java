package com.quantum.qcoin.data;

import com.quantum.qcoin.core.QCoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static String databaseType;
    private static Connection connection = null;
    private final QCoin pl = QCoin.plugin;

    private ConnectionFactory() throws ClassNotFoundException, SQLException {
        if (databaseType.equals("sqlite")) {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + pl.getDataFolder() + "/qcoin.db");
        } else if (databaseType.equals("mysql")) {
            final String host = ConfigFile.getConfigFile().getString("database.host");
            final String database = ConfigFile.getConfigFile().getString("database.database");
            final String URL = "jdbc:mysql://" + host + "/" + database;
            final String driver = "com.mysql.jdbc.Driver";
            final String user = ConfigFile.getConfigFile().getString("database.user");
            final String password = ConfigFile.getConfigFile().getString("database.password");
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                new ConnectionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            if(connection.isClosed()){
                new ConnectionFactory();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
