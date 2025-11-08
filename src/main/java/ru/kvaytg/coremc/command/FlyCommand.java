package ru.kvaytg.coremc.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.kvaytg.coremc.CoreMc;
import ru.kvaytg.coremc.component.AbstractCommand;
import ru.kvaytg.coremc.message.Messages;
import ru.kvaytg.coremc.permission.Permissions;

public class FlyCommand extends AbstractCommand {

    public FlyCommand(CoreMc plugin) {
        super(plugin, "fly");
    }

    @Override
    public void execute(CommandSender sender, String alias, String[] args) {
        if (!(sender instanceof Player player) || Permissions.FLY_USE.hasNo(player)) {
            Messages.NO_ACCESS.send(sender);
            return;
        }
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            Messages.FLY_OFF.send(player);
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            Messages.FLY_ON.send(player);
        }
    }

}
