package com.quantum.qcoin.subcommands;

import com.quantum.qcoin.Interfaces.SubCommand;
import com.quantum.qcoin.core.QCoin;
import com.quantum.qcoin.data.CoinData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Pay implements SubCommand {
    private final QCoin plugin;

    public Pay(QCoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(String[] args, CommandSender sender) throws Exception {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command only for players!");
            return;
        }
        Player player = (Player) sender;

        String prefix = plugin.getConfig().getString("prefix");
        CoinData coinData = new CoinData();

        try {
            Player p = Bukkit.getPlayer(args[1]);
            double amount = Double.parseDouble(args[2]);
            if (coinData.getCoin(player) < amount) {
                sender.sendMessage("Voce nao possui essa quantidade de coins");
                return;
            }
            coinData.addCoin(p, amount);
            coinData.takeCoin(player, amount);
            player.sendMessage(format(prefix + "&aVoce pagou ¢" + amount + " coins para o player " + p.getName()));
            p.sendMessage(format(prefix + "&aVou recebeu ¢" + amount + " coins de " + player.getName()));
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
