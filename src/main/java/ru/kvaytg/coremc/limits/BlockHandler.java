package ru.kvaytg.coremc.limits;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.kvaytg.coremc.CoreMc;
import ru.kvaytg.coremc.utils.BukkitUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BlockHandler extends LimitHandler {

    private Set<Material> interactableMaterials;

    public BlockHandler(CoreMc plugin) {
        super(plugin, "blocks");
    }

    @Override
    public void onInit() {
        interactableMaterials = new HashSet<>(Arrays.asList(
                // Двери
                Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.DARK_OAK_DOOR,
                Material.JUNGLE_DOOR, Material.SPRUCE_DOOR, Material.WOODEN_DOOR, Material.IRON_DOOR_BLOCK,
                // Калитки
                Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE_GATE, Material.DARK_OAK_FENCE_GATE,
                Material.JUNGLE_FENCE_GATE, Material.SPRUCE_FENCE_GATE, Material.FENCE_GATE,
                // Механизмы и контейнеры
                Material.ANVIL, Material.FLOWER_POT, Material.BEACON, Material.BREWING_STAND,
                Material.CHEST, Material.TRAPPED_CHEST, Material.ENDER_CHEST, Material.HOPPER,
                Material.DISPENSER, Material.DROPPER, Material.FURNACE, Material.BURNING_FURNACE,
                Material.ENCHANTMENT_TABLE, Material.COMMAND, // В 1.12 COMMAND_BLOCK это Material.COMMAND
                // Прочее
                Material.BED_BLOCK,
                Material.DAYLIGHT_DETECTOR, Material.DAYLIGHT_DETECTOR_INVERTED,
                Material.LEVER, Material.WOOD_BUTTON, Material.STONE_BUTTON,
                Material.TRAP_DOOR, Material.IRON_TRAPDOOR,
                Material.NOTE_BLOCK, Material.JUKEBOX,
                Material.REDSTONE_COMPARATOR_OFF, Material.REDSTONE_COMPARATOR_ON,
                Material.DIODE_BLOCK_OFF, Material.DIODE_BLOCK_ON,
                // Таблички
                Material.SIGN_POST, Material.WALL_SIGN
        ));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!getWorlds().contains(player.getWorld())) return;
        if (BukkitUtils.isAdmin(player)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!getWorlds().contains(player.getWorld())) return;
        if (BukkitUtils.isAdmin(player)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        if (!getWorlds().contains(event.getBlock().getWorld())) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockIgnite(final BlockIgniteEvent event) {
        if (!getWorlds().contains(event.getBlock().getWorld())) return;
        if (event.getCause() == BlockIgniteEvent.IgniteCause.SPREAD) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onLeavesDecay(final LeavesDecayEvent event) {
        if (!getWorlds().contains(event.getBlock().getWorld())) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
        Entity entity = event.getEntity();
        if (!getWorlds().contains(entity.getWorld())) return;
        if (event.getRemover() instanceof Player) {
            Player player = (Player) event.getRemover();
            if (BukkitUtils.isAdmin(player)) return;
        }
        if (entity instanceof Painting || entity instanceof ItemFrame) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        if (!getWorlds().contains(entity.getWorld())) return;
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (BukkitUtils.isAdmin(player)) return;
        }
        if (entity instanceof ItemFrame) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (!getWorlds().contains(entity.getWorld())) return;
        if (BukkitUtils.isAdmin(event.getPlayer())) return;
        if (entity instanceof ItemFrame) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!getWorlds().contains(player.getWorld())) return;
        if (BukkitUtils.isAdmin(player)) return;
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Material type = block.getType();
            if (interactableMaterials.contains(type)) {
                event.setCancelled(true);
            }
        } else if (event.getAction() == Action.PHYSICAL) {
            if (block.getType() == Material.SOIL) {
                event.setCancelled(true);
            }
        }
    }

}