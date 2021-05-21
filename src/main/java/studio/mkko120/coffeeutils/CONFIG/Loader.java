package studio.mkko120.coffeeutils.CONFIG;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import studio.mkko120.coffeeutils.Coffeeutils;

import java.io.File;

public class Loader {

    public static YamlConfiguration loadConfig(String filename) {
        File file = new File(Coffeeutils.getInstance().getDataFolder() + filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Coffeeutils.getInstance().saveResource(filename, false);
        }
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
