package net.zeeraa.entityspawncontrol;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import org.slf4j.Logger;

@Mod(EntitySpawnControl.MODID)
public class EntitySpawnControl {
	public static final String MODID = "entityspawncontrol";
	private static final Logger LOGGER = LogUtils.getLogger();

	public EntitySpawnControl() {
		MinecraftForge.EVENT_BUS.register(this);
		ModLoadingContext.get().registerConfig(Type.COMMON, EntitySpawnControlConfig.SPEC, "entityspawncontrol.toml");
	}

	@SubscribeEvent
	public void onEntityJoinLevel(EntityJoinLevelEvent event) {
		ResourceLocation entityName = EntityType.getKey(event.getEntity().getType());
		if (entityName != null) {
			if (EntitySpawnControlConfig.BLOCKD_ENTITIES.get().contains(entityName.toString().toLowerCase())) {
				event.setCanceled(true);
				if (EntitySpawnControlConfig.DEBUG.get()) {
					LOGGER.info("Blocking spawning of entity type " + entityName.toString());
				}
			} else {
				if (EntitySpawnControlConfig.DEBUG.get()) {
					LOGGER.info("Allow spawning of entity type " + entityName.toString());
				}
			}
		}
	}
}