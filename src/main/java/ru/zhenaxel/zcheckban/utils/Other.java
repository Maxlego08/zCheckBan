package ru.zhenaxel.zcheckban.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Other {
    private static final Pattern HEX_PATTERN = Pattern.compile("#([A-Fa-f0-9]){6}");

    /**
     * Connecting HEX and default colors
     */
    public static String color(String message) {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = HEX_PATTERN.matcher(message);
        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group()).toString());
        }
        matcher.appendTail(buffer);
        return ChatColor.translateAlternateColorCodes('&', buffer.toString());
    }
}
