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
        Bukkit.getScheduler().runTaskTimer(Coffeeutils.getPlugin(Coffeeutils.class), new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                getData();
            }
        }, 10000L, 10000L);
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
        // TODO database read
        ResultSet rs =  DatabaseUtils.loadData("SELECT * FROM Players" );
        try {
            if (rs == null) {
                DatabaseUtils.pushData("CREATE TABLE IF NOT EXISTS Players(" +
                        "`ID` int NOT NULL AUTO_INCREMENT," +
                        "`Player` TEXT NOT NULL," +
                        "`JSONData` JSON NOT NULL," +
                        "PRIMARY KEY(ID))");
            }
            while (rs.next()) {
                instances.put(rs.getString("Player"),POJOUtils.convert(rs.getString("JSONData")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
