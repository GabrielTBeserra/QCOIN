package com.quantum.qcoin.data;

import com.quantum.qcoin.entity.DataEntity;
import org.bukkit.entity.Player;

public class CoinData implements DataEntity {
    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public boolean hasPlayer(Player player) {
        return false;
    }

    @Override
    public void addCoin(Player player, double amount) {

    }

    @Override
    public void setCoin(Player player, double amount) {

    }

    @Override
    public void takeCoin(Player player, double amount) {

    }

    @Override
    public double getCoin(Player player) {
        return 0;
    }
}
