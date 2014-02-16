package com.rylinaux.bungeemotd.utilities;

import net.md_5.bungee.api.ChatColor;

public class StringUtil {

    public static String colorMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String consolidateStrings(String[] args, int start) {
        String ret = args[start];
        if (args.length > (start + 1)) {
            for (int i = (start + 1); i < args.length; i++)
                ret = ret + " " + args[i];
        }
        return ret;
    }

    public static String formatMotd(String main, String dynamic) {
        return StringUtil.colorMessage(main + "\n" + ChatColor.RESET + dynamic);
    }

}
