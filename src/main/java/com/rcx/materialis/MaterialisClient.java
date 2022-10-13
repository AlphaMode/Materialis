package com.rcx.materialis;

import com.rcx.materialis.util.TintedModifierModel;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.client.model.NBTKeyModel;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.library.client.modifiers.ModifierModelManager;

public class MaterialisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        onConstruct();
        itemColors();
        ModifierModelManager.ModifierModelRegistrationEvent.EVENT.register(MaterialisClient::registerModifierModels);
        NBTKeyModel.registerExtraTexture(new ResourceLocation(TConstruct.MOD_ID, "creative_slot"), "sensor", new ResourceLocation(Materialis.modID, "item/sensor_slot"));
    }

    public static void onConstruct() {
			/*if (Minecraft.getInstance() != null) {
				ResourceManager manager = Minecraft.getInstance().getResourceManager();
				if (manager instanceof IReloadableResourceManager) {
					((IReloadableResourceManager) manager).registerReloadListener(ExosuitModel.RELOAD_LISTENER);
				}
			}*/
    }

    static void itemColors() {
        //tint tool and part textures for fallback
        ToolModel.registerItemColors(MaterialisResources.WRENCH);
        ToolModel.registerItemColors(MaterialisResources.BATTLEWRENCH);
			/*ToolModel.registerItemColors(colors, () -> MaterialisResources.PSIMETAL_EXOSUIT.get(ArmorSlotType.HELMET));
			ToolModel.registerItemColors(colors, () -> MaterialisResources.PSIMETAL_EXOSUIT.get(ArmorSlotType.CHESTPLATE));
			ToolModel.registerItemColors(colors, () -> MaterialisResources.PSIMETAL_EXOSUIT.get(ArmorSlotType.LEGGINGS));
			ToolModel.registerItemColors(colors, () -> MaterialisResources.PSIMETAL_EXOSUIT.get(ArmorSlotType.BOOTS));*/
    }

    static void registerModifierModels(ModifierModelManager.ModifierModelRegistrationEvent event) {
        event.registerModel(new ResourceLocation(Materialis.modID, "tinted"), TintedModifierModel.UNBAKED_INSTANCE);
    }
}
