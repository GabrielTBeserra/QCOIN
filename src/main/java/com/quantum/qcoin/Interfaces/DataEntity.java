package com.quantum.qcoin.Interfaces;

import org.bukkit.entity.Player;

import java.sql.SQLException;

public interface DataEntity {
    /**
     * Adiciona um player no banco de dados
     *
     * @param player Recebe o player que sera adicionado
     */
    void addPlayer(Player player) throws SQLException;

    /**
     * Adiciona coins ao player
     *
     * @param player
     * @param amount
     */
    void addCoin(Player player, double amount) throws SQLException;

    /**
     * Define coins de um player
     *
     * @param player
     * @param amount
     */
    void setCoin(Player player, double amount) throws SQLException;

    /**
     * Retira coins de um player
     *
     * @param player
     * @param amount
     */
    void takeCoin(Player player, double amount) throws SQLException;

    /**
     * Verifica quantos um player possui
     *
     * @param player
     * @return retorna a quantidade
     */
    double getCoin(Player player) throws SQLException;
}
