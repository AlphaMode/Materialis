package com.rcx.materialis;

//import com.rcx.materialis.compat.TinkerToolRuneColor;

import com.rcx.materialis.datagen.MaterialisModifiers;
import com.rcx.materialis.modifiers.OtherworldlyModifier;
import com.rcx.materialis.util.MaterialisPacketHandler;
import com.rcx.materialis.util.TinkerToolFluxed;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.tools.capability.ToolCapabilityProvider;

// The value here should match an entry in the META-INF/mods.toml file
public class Materialis implements ModInitializer {

	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String modID = "materialis";

	@Override
	public void onInitialize() {
		this.setup();

		MaterialisResources.FLUIDS.register();
		MaterialisResources.BLOCKS.register();
		MaterialisResources.ITEMS.register();
		MaterialisResources.ITEMS_EXTENDED.register();
		MaterialisResources.RECIPE_SERIALIZERS.register();
		MaterialisModifiers.MODIFIERS.register();

//		if (FabricLoader.getInstance().isModLoaded("ars_nouveau"))
//			ArsNouveauAPI.getInstance().getEnchantingRecipeTypes().add(TinkerSpellWriteRecipe.SPELL_WRITE_TYPE);

		// Register ourselves for server and other game events we are interested in
		registerSerializers();
	}

	private void setup() {
		MaterialisPacketHandler.init();
		//if (ModList.get().isLoaded("psi"))
		//ToolCapabilityProvider.register(TinkerToolSocketable::new);
//		if (FabricLoader.getInstance().isModLoaded("quark"))
//			ToolCapabilityProvider.register(TinkerToolRuneColor::new);
		ToolCapabilityProvider.register(TinkerToolFluxed::new);
	}

	public static void registerSerializers() {
		ModifierManager.MODIFIER_LOADERS.register(new ResourceLocation(modID, "otherworldly"), OtherworldlyModifier.LOADER);
//		if (FabricLoader.getInstance().isModLoaded("ars_nouveau")) {
//			Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(modID, TinkerSpellWriteRecipe.RECIPE_ID), TinkerSpellWriteRecipe.SPELL_WRITE_TYPE);
//			event.getRegistry().register(TinkerSpellWriteRecipe.SERIALIZER.setRegistryName(new ResourceLocation(modID, TinkerSpellWriteRecipe.RECIPE_ID)));
//		}
	}
}
