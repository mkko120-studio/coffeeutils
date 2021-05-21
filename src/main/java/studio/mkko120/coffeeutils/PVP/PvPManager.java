package studio.mkko120.coffeeutils.PVP;

import org.bukkit.Bukkit;
import studio.mkko120.coffeeutils.Coffeeutils;
import studio.mkko120.coffeeutils.DB.DatabaseUtils;
import studio.mkko120.coffeeutils.PVP.POJO.POJOUtils;
import studio.mkko120.coffeeutils.UTIL.Loaders;

import java.sql.ResultSet;

public class PvPManager {

    public PvPManager() {
        getData();
        Bukkit.getScheduler().runTaskTimer(Coffeeutils.getPlugin(Coffeeutils.class), this::getData, 10000L, 10000L);
    }

    public void register(String username, PvPUser user) {
        Loaders.getInstances().put(username,user);
        if (DatabaseUtils.loadData("SELECT * FROM Players WHERE `Player`='" + username + "'") == null) {
            DatabaseUtils.pushData("INSERT INTO " + Loaders.getConfig().getString("Database.name", "Players") + "(`Player`, `JSONData`) VALUES (`" + username + "`, `" + user +"`)");
        }
    }

    public void unregister(String username) {
        Loaders.getInstances().remove(username);
        if (DatabaseUtils.loadData("SELECT * FROM Players WHERE `Player`='" + username + "'") != null) {
            DatabaseUtils.pushData("DELETE FROM Players WHERE `Player`='" + username + "'");
        }
    }

    public void getData() {
        if (DatabaseUtils.loadData("SELECT * FROM Players") != null) {
            ResultSet rs =  DatabaseUtils.loadData("SELECT * FROM Players");
            try {
                if (rs == null) {
                    DatabaseUtils.pushData("CREATE TABLE IF NOT EXISTS Players(" +
                            "`ID` int NOT NULL AUTO_INCREMENT," +
                            "`Player` TEXT NOT NULL," +
                            "`JSONData` JSON NOT NULL," +
                            "PRIMARY KEY(ID))");
                }
                while (rs.next()) {
                    register(rs.getString("Player"),POJOUtils.convert(rs.getString("JSONData")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            register("mkko120", new PvPUser("mkko120", 999, 1));
        }
    }
}
