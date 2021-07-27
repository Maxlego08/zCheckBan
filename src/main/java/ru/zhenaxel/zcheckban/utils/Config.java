package ru.zhenaxel.zcheckban.utils;

import org.bukkit.configuration.file.FileConfiguration;
import ru.zhenaxel.zcheckban.zCheckBan;

public class Config {
    private static String PERMISSION, NO_PERMISSION, INVALID_USAGE, BANNED, NOT_BANNED, RELOADED;

    private static FileConfiguration config() {
        return zCheckBan.getInstance().getConfig();
    }

    public static void reload() {
        zCheckBan.getInstance().reloadConfig();

        PERMISSION = config().getString("permission");

        NO_PERMISSION = config().getString("no-perms");
        INVALID_USAGE = config().getString("invalid-usage");
        BANNED = config().getString("is-banned");
        NOT_BANNED = config().getString("is-not-banned");
        RELOADED = config().getString("reloaded");
    }


    /**
     * @return Messages from config
     */

    public static String getPermission() {
        return PERMISSION;
    }

    public static String getNoPermission() {
        return Other.color(NO_PERMISSION);
    }

    public static String getInvalidUsage(String label) {
        return Other.color(String.format(INVALID_USAGE, label, label));
    }

    public static String getBanned(String playerName) {
        return Other.color(String.format(BANNED, playerName));
    }

    public static String getNotBanned(String playerName) {
        return Other.color(String.format(NOT_BANNED, playerName));
    }

    public static String getReloaded() {
        return Other.color(RELOADED);
    }

}
