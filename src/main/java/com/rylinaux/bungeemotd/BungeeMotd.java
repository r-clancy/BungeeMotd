package com.rylinaux.bungeemotd;

import com.rylinaux.bungeemotd.commands.BungeeMotdCommand;
import com.rylinaux.bungeemotd.configuration.BungeeConfig;
import com.rylinaux.bungeemotd.listeners.PingListener;

import java.util.List;

import lombok.Data;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

@Data
public class BungeeMotd extends Plugin {

    public static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.GREEN + "BungeeMotd" + ChatColor.GRAY + "] ";

    private BungeeConfig config;

    private String main;

    private List<String> dynamic;

    @Override
    public void onEnable() {

        config = new BungeeConfig(this);

        main = config.getConfig().getString("main");
        dynamic = config.getConfig().getStringList("dynamic");

        this.getProxy().getPluginManager().registerListener(this, new PingListener(this));

        this.getProxy().getPluginManager().registerCommand(this, new BungeeMotdCommand(this, "bungeemotd", "bungeemotd.command", "bmotd"));

    }

    @Override
    public void onDisable() {
        this.getProxy().getPluginManager().unregisterCommands(this);
        this.getProxy().getPluginManager().unregisterListeners(this);
    }

}
