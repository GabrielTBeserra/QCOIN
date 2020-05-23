package com.quantum.qcoin.Interfaces;

import com.quantum.qcoin.core.QCoin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface SubCommand {
    void execute(String[] args, CommandSender sender) throws Exception;

}
