package studio.mkko120.coffeeutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import studio.mkko120.coffeeutils.PAPI.PapiExpansion;
import studio.mkko120.coffeeutils.PVP.PvPManager;

public final class Coffeeutils extends JavaPlugin {

    public PvPManager PvPManager;
    public PvPManager getPvPManager() {
        return PvPManager;
    }

    public static Coffeeutils instance;
    public static Coffeeutils getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("CoffeeUtils Initalizing");

        // Creating instances...
        instance = this;
        PvPManager = new PvPManager();

        // Loading placeholder integration...
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PapiExpansion(this).register();
        } else {
            Bukkit.getLogger().warning("PlaceholderAPI not detected! Placeholders will not work!");
        }

        // End of plugin loading
        Bukkit.getLogger().info("CoffeeUtils Initalized!");
        Bukkit.getLogger().info("Thanks for using it!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
