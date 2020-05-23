package com.quantum.qcoin.subcommands;

import com.quantum.qcoin.Interfaces.SubCommand;
import com.quantum.qcoin.core.QCoin;
import com.quantum.qcoin.data.CoinData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Take implements SubCommand {
    private final QCoin plugin;

    public Take(QCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(String[] args, CommandSender sender) throws Exception {
        String prefix = plugin.getConfig().getString("prefix");
        CoinData coinData = new CoinData();

        try {
            Player p = Bukkit.getPlayer(args[1]);
            double amount = Double.parseDouble(args[2]);
            if (coinData.getCoin(p) < amount) {
                sender.sendMessage(format(prefix + "&cO player " + p.getName() + " nao possui a quantidade de ¢" + amount + " coins"));
                return;
            }
            coinData.takeCoin(p, amount);
            sender.sendMessage(format(prefix + "&cRemovido ¢" + amount + " coins do player " + p.getName()));
            p.sendMessage(format(prefix + "&cRetirados ¢" + amount + " coins"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sender.sendMessage(format(prefix + "&cUse the command /coin take <player> <amount>"));
        }
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}