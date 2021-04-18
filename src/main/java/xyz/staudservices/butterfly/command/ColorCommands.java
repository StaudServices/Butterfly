package xyz.staudservices.butterfly.command;

import io.github.nosequel.command.annotation.Command;
import org.bukkit.entity.Player;
import xyz.staudservices.butterfly.ButterflyPlugin;
import xyz.staudservices.butterfly.menu.ColorMenu;

public class ColorCommands {

    private final ButterflyPlugin plugin;

    public ColorCommands(ButterflyPlugin plugin) {
        this.plugin = plugin;
    }

    @Command(label = "color")
    public void color(Player player) {
        new ColorMenu(player, plugin).updateMenu();
    }
}
