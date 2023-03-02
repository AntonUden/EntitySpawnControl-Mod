package net.zeeraa.entityspawncontrol;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class EntitySpawnControlConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<List<String>> BLOCKD_ENTITIES;
	public static final ForgeConfigSpec.BooleanValue DEBUG;
	
	static {
		BUILDER.push("Blocked Entities");
		
		BLOCKD_ENTITIES = BUILDER.comment("List of blocked entity namespaces").define("Blacklist", new ArrayList<>());
		DEBUG = BUILDER.comment("Log if entity is blocked or allowed").define("Debug", false);
		
		SPEC = BUILDER.build();
	}
}