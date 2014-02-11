package com.rylinaux.bungeemotd.commands;

import com.rylinaux.bungeemotd.BungeeMotd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class BungeeMotdCommand extends Command {

    private final BungeeMotd plugin;

    public BungeeMotdCommand(BungeeMotd plugin, String name, String permission, String... aliases) {
        super(name, permission, aliases);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(new ComponentBuilder("You don't have permission to do this.").color(ChatColor.RED).create());
            return;
        }

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            new HelpCommand(plugin, this, sender, args);
            return;
        }

        String action = args[0];

        if (action.equalsIgnoreCase("main")) {
            new MainCommand(plugin, this, sender, args);
            return;
        }

        if (action.equalsIgnoreCase("add")) {
            new AddCommand(plugin, this, sender, args);
            return;
        }

        if (action.equalsIgnoreCase("del")) {
            new DelCommand(plugin, this, sender, args);
            return;
        }

        if (action.equalsIgnoreCase("list")) {
            new ListCommand(plugin, this, sender, args);
            return;
        }

        new HelpCommand(plugin, this, sender, args);

    }

}
