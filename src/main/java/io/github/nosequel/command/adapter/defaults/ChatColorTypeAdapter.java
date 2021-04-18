package io.github.nosequel.command.adapter.defaults;

import io.github.nosequel.command.adapter.TypeAdapter;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatColorTypeAdapter implements TypeAdapter<ChatColor> {


    @Override
    public ChatColor convert(CommandSender sender, String source) {
        return ChatColor.valueOf(source);
    }

    @Override
    public Class<ChatColor> getType() {
        return ChatColor.class;
    }
}
