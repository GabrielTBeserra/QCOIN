package com.quantum.qcoin.data;

import com.quantum.qcoin.core.QCoin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFile {
    public static QCoin plugin;
    private static File file;
    private static FileConfiguration userfile;

    public ConfigFile(QCoin main) {
        ConfigFile.plugin = main;
    }

    public static void setupConfigFile(final QCoin main) {
        ConfigFile.plugin = main;

        if (!ConfigFile.plugin.getDataFolder().exists()) {
            ConfigFile.plugin.getDataFolder().mkdir();
        }

        ConfigFile.file = new File(ConfigFile.plugin.getDataFolder(), "config.yml");

        if (!ConfigFile.file.exists()) {
            try {
                ConfigFile.plugin.saveResource("config.yml", false);
            } catch (Exception localException1) {
                Bukkit.getConsoleSender().sendMessage("\ufffdcN\ufffdo foi poss\ufffdvel criar o arquivo config.yml!");
                localException1.printStackTrace();
            }
        }
        ConfigFile.userfile = YamlConfiguration.loadConfiguration(ConfigFile.file);
    }

    public static void reload() {
        ConfigFile.userfile = YamlConfiguration.loadConfiguration(ConfigFile.file);
    }

    public static FileConfiguration getConfigFile() {
        return ConfigFile.userfile;
    }

    public static void save() {
        try {
            ConfigFile.userfile.save(ConfigFile.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}