package xyz.staudservices.butterfly.menu;

import io.github.nosequel.menus.MenuHandler;
import io.github.nosequel.menus.button.Button;
import io.github.nosequel.menus.button.ButtonBuilder;
import io.github.nosequel.menus.menu.Menu;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import xyz.staudservices.butterfly.ButterflyPlugin;
import xyz.staudservices.butterfly.util.ColorUtil;
import xyz.staudservices.butterfly.util.WoolUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ColorMenu extends Menu {

    private final List<ChatColor> colors = Arrays.asList(
            ChatColor.DARK_RED,
            ChatColor.RED,
            ChatColor.GOLD,
            ChatColor.YELLOW,
            ChatColor.DARK_GREEN,
            ChatColor.GREEN,
            ChatColor.AQUA,
            ChatColor.DARK_AQUA,
            ChatColor.DARK_BLUE,
            ChatColor.BLUE,
            ChatColor.LIGHT_PURPLE,
            ChatColor.DARK_PURPLE,
            ChatColor.WHITE,
            ChatColor.GRAY,
            ChatColor.DARK_GRAY,
            ChatColor.BLACK);

    private final ButterflyPlugin plugin;

    private final String permission = "color.%s";

    public ColorMenu(Player player, ButterflyPlugin plugin) {
        super(player, ColorUtil.translate(plugin.getConfig().getString("CHATCOLOR.MENU.TITLE")), plugin.getConfig().getInt("CHATCOLOR.MENU.SIZE"));

        this.plugin = plugin;
    }

    @Override
    public List<Button> getButtons() {
        final List<Button> buttons = new ArrayList<>();
        final AtomicInteger atomicInteger = new AtomicInteger();

        this.colors.stream()
                .filter(ChatColor::isColor)
                .forEach(color -> {
                    final Function<ClickType, Boolean> action = type -> {

                        if (!this.getPlayer().hasPermission(String.format(this.permission, color.name().toLowerCase()))) {
                            this.getPlayer().sendMessage(ChatColor.RED + "No permission.");
                            return true;
                        }

                        if (this.getPlayer().hasMetadata("color")) {
                            this.getPlayer().removeMetadata("color", this.plugin);
                        }

                        this.getPlayer().setMetadata("color", new FixedMetadataValue(this.plugin, color.name()));
                        this.getPlayer().closeInventory();

                        return true;
                    };

                    buttons.add(new ButtonBuilder(atomicInteger.getAndIncrement(), new ItemStack(Material.WOOL, 1, (short) WoolUtil.getByColor(color)))
                            .displayName(color + StringUtils.capitalize(color.name().toLowerCase()))
                            .lore(
                                    ChatColor.GRAY + "Chat colors change the color",
                                    ChatColor.GRAY + "of your messages in chat.",
                                    "",
                                    ChatColor.GRAY + "Preview: " + ChatColor.WHITE + this.getPlayer() + ": " + color + "Hello world!",
                                    "",
                                    ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "(( " + ChatColor.WHITE + ChatColor.STRIKETHROUGH.toString() + "Left Click " + ChatColor.GRAY + "to equip this color!" + ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + " ))"
                            )
                            .action(action));
                });

        return buttons;
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        MenuHandler.get().getMenus().remove(event.getPlayer());
    }
}
