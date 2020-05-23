package com.quantum.qcoin.data;

import com.quantum.qcoin.Interfaces.DataEntity;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinData implements DataEntity {
    @Override
    public void addPlayer(Player player) throws SQLException {
        String newPlayer = "insert into coins (uuid, amount) values (? , ?)";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(newPlayer);
        preparedStatement.setString(1, player.getUniqueId().toString());
        preparedStatement.setDouble(2, 0);
        preparedStatement.execute();
    }


    @Override
    public void addCoin(Player player, double amount) throws SQLException {
        String newPlayer = "update coins set amount = amount + " + amount + " where uuid = '" + player.getUniqueId().toString() + "'";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(newPlayer);

        preparedStatement.executeUpdate();
    }

    @Override
    public void setCoin(Player player, double amount) throws SQLException {
        String newPlayer = "update coins set amount = " + amount + " where uuid = '" + player.getUniqueId().toString() + "'";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(newPlayer);

        preparedStatement.execute();
    }

    @Override
    public void takeCoin(Player player, double amount) throws SQLException {
        String newPlayer = "update coins set amount = amount - " + amount + " where uuid = '" + player.getUniqueId().toString() + "'";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(newPlayer);

        preparedStatement.execute();
    }

    @Override
    public double getCoin(Player player) throws SQLException {
        double ret = 0;
        String query = "select * from coins where uuid = ?";

        PreparedStatement sets = ConnectionFactory.getConnection().prepareStatement(query);
        sets.setString(1, player.getUniqueId().toString());

        ResultSet results = sets.executeQuery();


        while (results.next()) {
            ret = results.getDouble("amount");
        }

        return ret;
    }
}
