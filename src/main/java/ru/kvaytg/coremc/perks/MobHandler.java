package ru.kvaytg.coremc.perks;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.material.MaterialData;
import ru.kvaytg.coremc.CoreMc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MobHandler extends PerkHandler {

    private List<World.Environment> skippedEnvironments;
    private List<EntityType> blockedEntities;

    private EntityType singleType;
    private boolean fakeDeath;
    private boolean exudeBlood;

    private MaterialData bloodData;

    public MobHandler(CoreMc plugin) {
        super(plugin, "onlyMobs");
    }

    @Override
    public void onInit() {
        skippedEnvironments = Arrays.asList(
                World.Environment.NETHER, World.Environment.THE_END
        );
        blockedEntities = new ArrayList<>();
        blockedEntities.add(EntityType.BAT);
        blockedEntities.add(EntityType.PARROT);
        try {
            singleType = EntityType.valueOf(getConfigString("type"));
        } catch (Exception e) {
            singleType = EntityType.ZOMBIE;
        }
        fakeDeath = getConfigBoolean("fakeDeath");
        exudeBlood = getConfigBoolean("exudeBlood");
        if (exudeBlood) {
            bloodData = new MaterialData(Material.NETHER_WART_BLOCK);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) return;
        Location location = event.getLocation();
        World world = location.getWorld();
        if (world == null || skippedEnvironments.contains(world.getEnvironment())) return;
        EntityType type = event.getEntityType();
        if (blockedEntities.contains(type)) {
            event.setCancelled(true);
            return;
        }
        if (type != singleType) {
            event.setCancelled(true);
            world.spawnEntity(location, singleType);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof LivingEntity)) return;
        LivingEntity damaged = (LivingEntity) entity;
        if (damaged instanceof Player) return;
        if (event.getFinalDamage() < damaged.getHealth()) return;
        if (exudeBlood) {
            damaged.getWorld().spawnParticle(
                    Particle.BLOCK_DUST,
                    damaged.getLocation().add(0, 0.5, 0),
                    15,
                    0.25, 0.25, 0.25,
                    0.0,
                    bloodData
            );
        }
        if (fakeDeath) {
            event.setCancelled(true);
            damaged.remove();
            damaged.getWorld().playSound(
                    damaged.getLocation(),
                    Sound.ENTITY_GENERIC_DEATH,
                    0.9f,
                    0.9f
            );
        }
    }

}