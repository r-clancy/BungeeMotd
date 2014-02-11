package com.rylinaux.bungeemotd.commands;

import com.rylinaux.bungeemotd.BungeeMotd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class HelpCommand {

    private final BungeeMotd plugin;

    private final Command command;

    private final CommandSender sender;

    private final String[] args;

    public HelpCommand(BungeeMotd plugin, Command command, CommandSender sender, String[] args) {
        this.plugin = plugin;
        this.command = command;
        this.sender = sender;
        this.args = args;
        run();
    }

    public void run() {
        sender.sendMessage(new TextComponent(ChatColor.WHITE + "------------------- " + ChatColor.GRAY + "[" + ChatColor.GREEN + " BungeeMotd " + ChatColor.GRAY + "]" + ChatColor.WHITE + " -------------------"));
        sender.sendMessage(new TextComponent(ChatColor.GREEN + "/bmotd main [msg]" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Sets the main motd."));
        sender.sendMessage(new TextComponent(ChatColor.GREEN + "/bmotd add [msg]" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Add a new dynamic motd."));
        sender.sendMessage(new TextComponent(ChatColor.GREEN + "/bmotd del [index]" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Deletes a dynamic motd."));
        sender.sendMessage(new TextComponent(ChatColor.GREEN + "/bmotd list" + ChatColor.WHITE + " - " + ChatColor.GRAY + "List dynamic motds."));
    }

}
