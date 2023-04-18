package me.craftystudios.reputation;

import org.bukkit.plugin.java.JavaPlugin;

import me.craftystudios.reputation.utils.Logger;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.ProtocolLibrary;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
      // ProtocolManager manager = ProtocolLibrary.getProtocolManager();
      // manager.addPacketListener(...);
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      Logger.log(Logger.LogLevel.SUCCESS, "Loading Reputation...");
      Logger.log(Logger.LogLevel.SUCCESS, "Loaded!");
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");

    }   

    @Override
    public void onDisable() {
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      Logger.log(Logger.LogLevel.SUCCESS, "Unloading Reputation...");
      Logger.log(Logger.LogLevel.SUCCESS, "Unloaded!");
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      this.saveConfig();
      }
    }