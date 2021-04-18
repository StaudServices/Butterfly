package xyz.staudservices.butterfly.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

/**
 * @author GrowlyX
 * @since 3/4/2021
 */

@UtilityClass
public class WoolUtil {

    private static final List<ChatColor> CHAT_COLORS = Arrays.asList(
            ChatColor.WHITE, ChatColor.GOLD, ChatColor.LIGHT_PURPLE,
            ChatColor.AQUA, ChatColor.YELLOW, ChatColor.GREEN,
            ChatColor.LIGHT_PURPLE, ChatColor.DARK_GRAY, ChatColor.GRAY,
            ChatColor.DARK_AQUA, ChatColor.DARK_PURPLE, ChatColor.BLUE,
            ChatColor.BLACK, ChatColor.DARK_GREEN, ChatColor.RED, ChatColor.BLACK
    );

    /**
     * Gets a wool id by a ChatColor
     *
     * @param color ChatColor to convert to wool ID
     * @return a wool ID
     */
    public static int getByColor(ChatColor color) {
        switch (color) {
            case DARK_RED:
                return WoolUtil.CHAT_COLORS.indexOf(ChatColor.RED);
            case DARK_BLUE:
                return WoolUtil.CHAT_COLORS.indexOf(ChatColor.BLUE);
            default:
                return WoolUtil.CHAT_COLORS.indexOf(color);
        }
    }
}
