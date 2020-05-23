package com.quantum.qcoin.api;

import com.quantum.qcoin.data.CoinData;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class QCoinAPI {
    public static double getCoin(Player player) {
        CoinData coinData = new CoinData();
        try {
            return coinData.getCoin(player);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public static void setCoin(Player player, double amount) {
        CoinData coinData = new CoinData();
        try {
            coinData.setCoin(player, amount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addCoin(Player player, double amount) {
        CoinData coinData = new CoinData();
        try {
            coinData.addCoin(player, amount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
