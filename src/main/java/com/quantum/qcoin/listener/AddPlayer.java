package com.quantum.qcoin.listener;

import com.quantum.qcoin.core.QCoin;
import com.quantum.qcoin.data.CoinData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class AddPlayer implements Listener {
    private final QCoin plugin;

    public AddPlayer(QCoin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent) {

        /**
         *  Tenta adicionar o player no banco de dados
         * caso ele ja existe apenas e ignorado
         */
        try {
            CoinData coindata = new CoinData();
            coindata.addPlayer(joinEvent.getPlayer());
        } catch (SQLException throwables) {

        }
    }


}
