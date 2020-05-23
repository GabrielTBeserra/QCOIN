package com.quantum.qcoin.data;

import java.sql.SQLException;
import java.sql.Statement;

public class LoadTables {
    public LoadTables() {
        try {
            load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void load() throws SQLException {
        String coinBase = "create table if not exists coins(" +
                "    uuid varchar(100) primary key," +
                "    amount DOUBLE default 0 not null " +
                ")";


        Statement statement = ConnectionFactory.getConnection().createStatement();
        statement.execute(coinBase);
    }
}
