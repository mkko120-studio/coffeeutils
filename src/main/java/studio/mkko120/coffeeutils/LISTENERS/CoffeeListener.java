package studio.mkko120.coffeeutils.LISTENERS;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class CoffeeListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onLogin(PlayerLoginEvent event) {
        if (event.getResult().equals(PlayerLoginEvent.Result.KICK_FULL)) {
            if (event.getPlayer().hasPermission("coffee.fulloverride") || event.getPlayer().isOp()) {
                event.allow();
            }
        }
        if (event.getResult().equals(PlayerLoginEvent.Result.KICK_BANNED)) {
            if (event.getPlayer().hasPermission("coffee.banoverride")) {
                event.allow();
            }
        }
        if (event.getResult().equals(PlayerLoginEvent.Result.KICK_WHITELIST)) {
            if (event.getPlayer().hasPermission("coffee.whitelistoverride")) {
                event.allow();
            }
        }
    }

}
