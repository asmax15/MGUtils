package de.asmax.butils.listener;

import de.asmax.butils.utils.GameStateManager;
import de.asmax.butils.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class WitherKillEvent implements Listener {

    @EventHandler
    public void handleWitherKillEvent(EntityDeathEvent event) {
        if(GameStateManager.killWither) {
            if(GameStateManager.timerIsRunning) {
                if(!GameStateManager.timerIsPaused) {
                    if(event.getEntityType() == EntityType.WITHER) {
                        Bukkit.broadcastMessage(" ");
                        Bukkit.broadcastMessage("§8[§6Wither§8] §7Der §6§lWither §7ist gestorben.");
                        Bukkit.broadcastMessage("§8[§6Wither§8] §aDie Challenge ist hiermit absolviert.");
                        Bukkit.broadcastMessage("§8[§6Wither§8] §7Zeit benötigt: §9§l" + Timer.shortInteger(Timer.getTime()));
                        Bukkit.broadcastMessage(" ");

                        Timer.getRunnable().cancel();
                        GameStateManager.timerIsRunning = false;
                    }
                }
            }
        }
    }
}
