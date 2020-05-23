package com.quantum.qcoin.core;

import com.quantum.qcoin.commands.Coin;
import org.bukkit.plugin.java.JavaPlugin;

public final class QCoin extends JavaPlugin {
    public static QCoin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new Coin(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
