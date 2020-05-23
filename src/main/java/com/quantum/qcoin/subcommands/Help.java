package com.quantum.qcoin.subcommands;

import com.quantum.qcoin.Interfaces.SubCommand;
import com.quantum.qcoin.core.QCoin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Help implements SubCommand {
    private final QCoin plugin;

    public Help(QCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(String[] args, CommandSender sender) throws Exception {
        if (sender.hasPermission("qcoin.admin")) {
            sender.sendMessage(format("&6/coin set &a<player> &2<amount> &a- &eSet the coins of the player"));
            sender.sendMessage(format("&6/coin add &a<player> &2<amount> &a- &eAdd coins to the player"));
            sender.sendMessage(format("&6/coin take &a<player> &2<amount> &a- &eTake coins of the player"));
        }

        sender.sendMessage(format("&6/coin <player> &a- &eTo see coins of the player"));
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
