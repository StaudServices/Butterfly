package xyz.staudservices.butterfly.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;

public class ItemBuilder {

    private final ItemStack itemStack;

    /**
     * Constructor for ItemBuilder
     *
     * @param material the material
     * @param amount the amount
     */
    public ItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
    }

    /**
     * Constructor for ItemBuilder
     *
     * @param material the material
     */
    public ItemBuilder(Material material) {
        this(material, 1);
    }

    /**
     * Constructor for ItemBuilder
     *
     * @param material the material
     * @param amount the amount
     * @param value the value
     */
    public ItemBuilder(Material material, int amount, short value) {
        this.itemStack = new ItemStack(material, amount, value);
    }

    /**
     * Set the name of an item
     *
     * @param name the name
     * @return the new item name
     */
    public ItemBuilder setName(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the lore of an item
     *
     * @param lore the lore
     * @return the new item lore
     */
    public ItemBuilder setLore(List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add a enchant to an item
     *
     * @param enchantment the enchant
     * @param level the level
     * @return the new item enchant
     */
    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the color of a item
     *
     * @param color the color
     * @return the item color
     */
    public ItemBuilder setColor(Color color) {
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        leatherArmorMeta.setColor(color);
        itemStack.setItemMeta(leatherArmorMeta);
        return this;
    }

    /**
     * Create a itemstack
     *
     * @return the itemstack
     */
    public ItemStack create() {
        return itemStack;
    }
}