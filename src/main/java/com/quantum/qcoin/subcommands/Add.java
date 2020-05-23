package com.quantum.qcoin.subcommands;

import com.quantum.qcoin.Interfaces.SubCommand;
import com.quantum.qcoin.core.QCoin;
import com.quantum.qcoin.data.CoinData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Add implements SubCommand {
    private final QCoin plugin;

    public Add(QCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(String[] args, CommandSender sender) throws Exception {
        String prefix = plugin.getConfig().getString("prefix");
        CoinData coinData = new CoinData();
        try {
            Player p = Bukkit.getPlayer(args[1]);
            double amount = Double.parseDouble(args[2]);
            coinData.addCoin(p, amount);
            sender.sendMessage(format(prefix + "&aAdicionado ¢" + amount + " coins para o player " + p.getName()));
            p.sendMessage(format(prefix + "&aRecebidos ¢" + amount + " coins"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sender.sendMessage(format(prefix + "&cUse o comando /coin add <Nick> <Quantidade>"));
        }

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
