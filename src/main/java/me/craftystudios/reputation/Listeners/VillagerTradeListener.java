package me.craftystudios.reputation.Listeners;

import org.bukkit.event.Listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.craftystudios.reputation.utils.LocalDB;

public class VillagerTradeListener extends PacketAdapter {
    private final JavaPlugin plugin;

    public afkregion(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public VillagerTradeListener() {
        super(ProtocolLibrary.getProtocolManager(), ListenerPriority.NORMAL, PacketType.Play.Client.TRADING);
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.TRADING) {
            Player player = event.getPlayer(); // Get the player object from the event
    
            // Check if the trade was successful
            boolean tradeAccepted = event.getPacket().getBooleans().read(0);
    
            if (tradeAccepted) {
                reputationPoints = plugin.getConfig().getInt("villager-trade-reputation"); 
                writeData(player.getName(), player.getUniqueId().toString(), 5);
                player.sendMessage(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("villager-trade-success").replace("%reputation%", reputationPoints));
            }
        }
    }    
}