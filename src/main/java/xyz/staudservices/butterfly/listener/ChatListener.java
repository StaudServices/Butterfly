package xyz.staudservices.butterfly.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onChat(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final List<MetadataValue> values = player.getMetadata("color");

        if (values != null && !values.isEmpty()) {
            final MetadataValue value = values.get(0);

            if (value != null) {
                final ChatColor color = ChatColor.valueOf(value.asString());
                final String format = event.getFormat();

                final String name = player.getName();
                final String newName = player.getName().replace(event.getMessage(), color + event.getMessage() + ChatColor.RESET);

                String newFormat = format.replace(event.getMessage(), color + event.getMessage() + ChatColor.RESET);

                newFormat = newFormat.replaceFirst(newName, name);

                event.setFormat(newFormat);
            }
        }
    }
}
