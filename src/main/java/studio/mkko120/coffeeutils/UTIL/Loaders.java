package studio.mkko120.coffeeutils.UTIL;

import org.bukkit.configuration.file.YamlConfiguration;
import studio.mkko120.coffeeutils.Coffeeutils;
import studio.mkko120.coffeeutils.PVP.PvPUser;

import java.util.HashMap;

import static studio.mkko120.coffeeutils.CONFIG.Loader.loadConfig;
import static studio.mkko120.coffeeutils.DB.DatabaseUtils.loadData;

public class Loaders {

    private static YamlConfiguration config;
    public static YamlConfiguration getConfig() {return config;}

    private static HashMap<String, PvPUser> instances;
    public static HashMap<String, PvPUser> getInstances() {
        return instances;
    }

    public static void loadAll() {
        Coffeeutils.getInstance().getPvPManager().getData();
        config = loadConfig("config.yml");
    }
}
