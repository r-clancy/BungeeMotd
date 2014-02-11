package com.rylinaux.bungeemotd.commands;

import com.rylinaux.bungeemotd.BungeeMotd;
import com.rylinaux.bungeemotd.utilities.StringUtils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class DelCommand {

    private final BungeeMotd plugin;

    private final Command command;

    private final CommandSender sender;

    private final String[] args;

    public DelCommand(BungeeMotd plugin, Command command, CommandSender sender, String[] args) {
        this.plugin = plugin;
        this.command = command;
        this.sender = sender;
        this.args = args;
        run();
    }

    public void run() {

        if (args.length < 2) {
            sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + ChatColor.RED + "You must specify an index to remove."));
            return;
        }

        if (plugin.getDynamic().size() == 0) {
            sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + ChatColor.RED + "No messages to remove."));
            return;
        }

        int index = Integer.parseInt(args[1]);
        String message = plugin.getDynamic().get(index);

        plugin.getDynamic().remove(message);
        plugin.getConfig().getConfig().set("dynamic", plugin.getDynamic());
        plugin.getConfig().save();

        sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + "MOTD '" + StringUtils.colorMessage(message) + ChatColor.GRAY + "' has been deleted."));

    }

}
