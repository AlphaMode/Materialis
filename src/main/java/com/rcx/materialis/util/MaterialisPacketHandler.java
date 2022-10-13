package com.rcx.materialis.util;

import com.rcx.materialis.Materialis;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public class MaterialisPacketHandler {
	public static final SimpleChannel INSTANCE = new SimpleChannel(new ResourceLocation(Materialis.modID, "main"));

	static int id = 0;

	public static void init() {
		if (FabricLoader.getInstance().isModLoaded("botania")) {
			INSTANCE.registerC2SPacket(PacketTerraBeam.class, id++);
			INSTANCE.registerC2SPacket(PacketElvenBeam.class, id++);
		}
		if (FabricLoader.getInstance().isModLoaded("ars_nouveau"))
			INSTANCE.registerC2SPacket(PacketReactiveSwing.class, id++);

		INSTANCE.initServerListener();
		EnvExecutor.runWhenOn(EnvType.CLIENT, () -> INSTANCE::initClientListener);
	}
}