package xyz.staudservices.butterfly.command;

import io.github.nosequel.command.annotation.Command;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import xyz.staudservices.butterfly.ButterflyPlugin;
import xyz.staudservices.butterfly.menu.ColorMenu;

@RequiredArgsConstructor
public class ColorCommand {

    private final ButterflyPlugin plugin;

    @Command(label = "color")
    public void color(Player player) {
        new ColorMenu(player, this.plugin).updateMenu();
    }
}
