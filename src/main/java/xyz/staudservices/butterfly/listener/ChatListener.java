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
            final MetadataValue value = values.iterator().next();

            if (value != null) {
                final ChatColor color = ChatColor.valueOf(value.asString());

                final String format = event.getFormat();
                final String message = event.getMessage().replaceAll("[\\W]", "\\\\$0").replace("%", "%%");

                event.setFormat(format.replaceFirst("(?s)(.*)" + message, "$1" + color.toString() + message));
            }
        }
    }
}