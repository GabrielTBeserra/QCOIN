package com.quantum.qcoin.core;

import com.quantum.qcoin.api.QCoinAPI;
import com.quantum.qcoin.commands.Coin;
import com.quantum.qcoin.data.LoadTables;
import com.quantum.qcoin.listener.AddPlayer;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class QCoin extends JavaPlugin {
    public static QCoin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        plugin.saveDefaultConfig();

        new LoadTables();
        new Coin(this);
        new AddPlayer(this);

        this.getServer().getConsoleSender().sendMessage(format("&aQCoin has enable!"));
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(format("&cQCoin has disable!"));
        HandlerList.unregisterAll(this);
    }


    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


}
