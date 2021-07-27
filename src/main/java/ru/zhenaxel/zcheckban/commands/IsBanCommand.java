package ru.zhenaxel.zcheckban.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.zhenaxel.zcheckban.utils.Config;

public class IsBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission(Config.getPermission())) {
            sender.sendMessage(Config.getNoPermission());
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(Config.getInvalidUsage(label));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            Config.reload();
            sender.sendMessage(Config.getReloaded());
            return true;
        }
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);

        if (banList.isBanned(args[0])) {
            sender.sendMessage(Config.getBanned(args[0]));
            return true;
        }

        sender.sendMessage(Config.getNotBanned(args[0]));
        return true;
    }
}
