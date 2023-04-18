package me.craftystudios.reputation.Functions;

import me.craftystudios.reputation.utils.*;
import me.craftystudios.reputation.Functions.*;
import org.bukkit.Bukkit;

public class Leveling {
    public void setLevel(Player player, int level) {
        LocalDB.writeData(player, "level", String.valueOf(level));
    }
    public void checkPlayerLevel(Player player) {
        int reputation = LocalDB.getData(player, "reputation", 0); // Get the player's current reputation from the database
        int currentLevel = LocalDB.getData(player, "level", 1); // Get the player's current level from the database, default to 1 if not set
        
        // Check if the player has enough reputation to level up
        if (reputation >= getRequiredReputation(currentLevel)) {
            int newLevel = currentLevel + 1;
            LocalDB.writeData(player, "level", String.valueOf(newLevel)); // Update the player's level in the database
            player.sendMessage("Congratulations, you have reached level " + newLevel + "!");
        }
    }
    
    private int getRequiredReputation(int level) {
        // Return the required reputation for a given level
        // You can implement your own formula for this
        return 100 * level;
    }
    Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                checkPlayerLevel(player);
                if(playerReputation(player) >= 100) {
                    player.sendMessage("You have reached 100 reputation!");
                }
                
            }
        }
    }, 0, 20);
}


