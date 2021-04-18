package xyz.staudservices.butterfly;

import io.github.nosequel.command.CommandController;
import io.github.nosequel.menus.MenuHandler;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.staudservices.butterfly.command.ColorCommand;
import xyz.staudservices.butterfly.listener.ChatListener;

@Getter
public class ButterflyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.registerCommands();

        new MenuHandler(this);

        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    private void registerCommands() {
        final CommandController commandController = new CommandController("color");

        commandController.registerCommand(new ColorCommand(this));
    }
}
