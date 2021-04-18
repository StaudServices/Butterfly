package io.github.nosequel.command.adapter.defaults;

import io.github.nosequel.command.adapter.TypeAdapter;
import org.bukkit.command.CommandSender;

public class LongTypeAdapter implements TypeAdapter<Long> {

    @Override
    public Long convert(CommandSender sender, String source) {
        return Long.parseLong(source);
    }

    @Override
    public Class<Long> getType() {
        return Long.class;
    }
}
