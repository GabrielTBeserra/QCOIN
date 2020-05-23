package com.quantum.qcoin.commands;

import com.quantum.qcoin.core.QCoin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coin implements CommandExecutor, TabCompleter {
    private final QCoin plugin;

    public Coin(QCoin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("coin").setExecutor(this);
        this.plugin.getCommand("coin").setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        return false;
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

        //Coloca em ordem alfabetica
        Collections.sort(completions);
        return completions;

    }
}
