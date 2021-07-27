package ru.zhenaxel.zcheckban;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zhenaxel.zcheckban.commands.IsBanCommand;
import ru.zhenaxel.zcheckban.utils.Config;

import java.io.File;

public final class zCheckBan extends JavaPlugin {
    private static zCheckBan instance;

    /**
     * Discord: Zhenaxel#3330
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        /* Register Commands */
        getCommand("isban").setExecutor(new IsBanCommand());

        /* Load Config */
        checkFiles();
        Config.reload();
    }

    public static zCheckBan getInstance() {
        return instance;
    }

    void checkFiles() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            saveDefaultConfig();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
