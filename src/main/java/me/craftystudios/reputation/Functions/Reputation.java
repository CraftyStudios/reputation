package me.craftystudios.reputation.Functions;

import me.craftystudios.reputation.utils.*;

public class Reputation {

    public int playerReputation(Player player) {
        int reputation = LocalDB.getData(player, "reputation", 0); // Get the player's current reputation from the database
        return reputation;
    }


}