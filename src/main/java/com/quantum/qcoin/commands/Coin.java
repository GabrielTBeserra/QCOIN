package com.quantum.qcoin.commands;

import com.quantum.qcoin.Interfaces.SubCommand;
import com.quantum.qcoin.core.QCoin;
import com.quantum.qcoin.data.CoinData;
import com.quantum.qcoin.subcommands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Coin implements CommandExecutor, TabCompleter {
    private final QCoin plugin;
    private final HashMap<String, SubCommand> subCommands = new HashMap<String, SubCommand>();

    public Coin(QCoin plugin) {
        subCommands.put("add", new Add(plugin));
        subCommands.put("set", new Set(plugin));
        subCommands.put("take", new Take(plugin));

        if (plugin.getConfig().getBoolean("pay")) {
            subCommands.put("pay", new Pay(plugin));
        }

        subCommands.put("help", new Help(plugin));

        this.plugin = plugin;
        this.plugin.getCommand("coin").setExecutor(this);
        this.plugin.getCommand("coin").setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = args[0].toLowerCase();


        /**
         * Verifica se o usuario/player possui permissao para os comandos
         */

        if (subCommands.containsKey(cmd)) {
            try {
                if (sender.hasPermission("qcoin.admin")) {
                    subCommands.get(cmd).execute(args, sender);
                } else {
                    sender.sendMessage("Voce nao tem permissao man");
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (args.length == 0) {
            CoinData coinData = new CoinData();
            double playerCoinValue = 0;
            try {
                playerCoinValue = coinData.getCoin((Player) sender);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            sender.sendMessage(">>" + playerCoinValue);
            return true;
        }

        /**
         * Retorna a quantidade de coins que um player possui
         * Comando PUBLICO
         */
        if (Bukkit.getPlayer(args[0]) != null) {
            CoinData coinData = new CoinData();
            double playerCoinValue = 0;
            try {
                playerCoinValue = coinData.getCoin(Bukkit.getPlayer(args[0]));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            sender.sendMessage(">>" + playerCoinValue);
            return true;
        }


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Cria uma lista com comandos para o tab completer
        List<String> completions = new ArrayList<>();
        // Caso seja admin, player vai ter os seguintes comandos como complte

        if (sender.hasPermission("qcoin.admin")) {
            completions.add("add");
            completions.add("set");
            completions.add("take");
        }

        if (plugin.getConfig().getBoolean("pay")) {
            completions.add("pay");
        }

        completions.add("help");

        //Coloca em ordem alfabetica
        Collections.sort(completions);
        return completions;

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
