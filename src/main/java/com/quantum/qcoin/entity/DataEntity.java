package com.quantum.qcoin.entity;

import org.bukkit.entity.Player;

public interface DataEntity {
    /**
     * Adiciona um player no banco de dados
     *
     * @param player Recebe o player que sera adicionado
     */
    void addPlayer(Player player);

    /**
     * Verifica a existencia de um player
     *
     * @param player
     * @return
     */
    boolean hasPlayer(Player player);

    /**
     * Adiciona coins ao player
     *
     * @param player
     * @param amount
     */
    void addCoin(Player player, double amount);

    /**
     * Define coins de um player
     *
     * @param player
     * @param amount
     */
    void setCoin(Player player, double amount);

    /**
     * Retira coins de um player
     *
     * @param player
     * @param amount
     */
    void takeCoin(Player player, double amount);

    /**
     * Verifica quantos um player possui
     *
     * @param player
     * @return retorna a quantidade
     */
    double getCoin(Player player);
}
