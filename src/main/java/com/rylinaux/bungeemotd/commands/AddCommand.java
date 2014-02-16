package com.rylinaux.bungeemotd.commands;

import com.rylinaux.bungeemotd.BungeeMotd;
import com.rylinaux.bungeemotd.utilities.StringUtil;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class AddCommand {

    private final BungeeMotd plugin;

    private final Command command;

    private final CommandSender sender;

    private final String[] args;

    public AddCommand(BungeeMotd plugin, Command command, CommandSender sender, String[] args) {
        this.plugin = plugin;
        this.command = command;
        this.sender = sender;
        this.args = args;
        run();
    }

    public void run() {

        if (args.length < 2) {
            sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + ChatColor.RED + "You must specify a message to add."));
            return;
        }

        String motd = StringUtil.consolidateStrings(args, 1);

        plugin.getDynamic().add(motd);
        plugin.getConfig().getConfig().set("dynamic", plugin.getDynamic());
        plugin.getConfig().save();

        sender.sendMessage(new TextComponent(BungeeMotd.PREFIX + "MOTD '" + StringUtil.colorMessage(motd) + ChatColor.GRAY + "' has been added."));

    }

}
