package io.github.nosequel.command.executor;

import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class CustomCommandSender implements CommandSender {

    private final CommandSender originalSender;

    public CustomCommandSender(CommandSender sender) {
        this.originalSender = sender;
    }

    public Player toPlayer() {
        return (Player) this.originalSender;
    }

    @Override
    public void sendMessage(String s) {
        originalSender.sendMessage(s);
    }

    @Override
    public void sendMessage(String[] strings) {
        originalSender.sendMessage(strings);
    }

    @Override
    public Server getServer() {
        return originalSender.getServer();
    }

    @Override
    public String getName() {
        return originalSender.getName();
    }

    @Override
    public boolean isPermissionSet(String s) {
        return originalSender.isPermissionSet(s);
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return originalSender.isPermissionSet(permission);
    }

    @Override
    public boolean hasPermission(String s) {
        return originalSender.hasPermission(s);
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return originalSender.hasPermission(permission);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return originalSender.addAttachment(plugin, s, b);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return originalSender.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return originalSender.addAttachment(plugin, s, b, i);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return originalSender.addAttachment(plugin, i);
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {
        originalSender.removeAttachment(permissionAttachment);
    }

    @Override
    public void recalculatePermissions() {
        originalSender.recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return originalSender.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return originalSender.isOp();
    }

    @Override
    public void setOp(boolean b) {
        originalSender.setOp(b);
    }
}
