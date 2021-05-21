package studio.mkko120.coffeeutils.PVP;

import org.bukkit.Bukkit;
import studio.mkko120.coffeeutils.Coffeeutils;
import studio.mkko120.coffeeutils.DB.DatabaseUtils;
import studio.mkko120.coffeeutils.PVP.POJO.POJOUtils;

import java.sql.ResultSet;
import java.util.HashMap;

public class PvPManager {

    private HashMap<String, PvPUser> instances;
    public HashMap<String, PvPUser> getInstances() {
        return instances;
    }

    public PvPManager() {
        instances = new HashMap<>();
        getData();
        Bukkit.getScheduler().runTaskTimer(Coffeeutils.getPlugin(Coffeeutils.class), this::getData, 10000L, 10000L);
    }

    public void register(String username, PvPUser user) {
        instances.put(username,user);
        // TODO database user add
    }

    public void unregister(String username) {
        instances.remove(username);
        // TODO database user remove
    }

    public void getData() {
       /* // TODO better database read
        */

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
            register("mkko120", new PvPUser("mkko120"));
        }
    }
}
