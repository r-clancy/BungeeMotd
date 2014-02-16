package com.rylinaux.bungeemotd.commands;

import com.rylinaux.bungeemotd.BungeeMotd;
import com.rylinaux.bungeemotd.utilities.StringUtil;

import java.util.List;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class ListCommand {

    private final BungeeMotd plugin;

    private final Command command;

    private final CommandSender sender;

    private final String[] args;

    public ListCommand(BungeeMotd plugin, Command command, CommandSender sender, String[] args) {
        this.plugin = plugin;
        this.command = command;
        this.sender = sender;
        this.args = args;
        run();
    }

    public void run() {
        List<String> dynamic = plugin.getDynamic();
        sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + ChatColor.translateAlternateColorCodes('&', plugin.getMain())));
        for (String msg : dynamic) {
            sender.sendMessage(new TextComponent(ChatColor.DARK_AQUA + String.valueOf(dynamic.indexOf(msg)) + ") " + ChatColor.RESET + StringUtil.colorMessage(msg)));
        }
    }

}
