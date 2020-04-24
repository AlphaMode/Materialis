package com.rcx.materialis.modules;

import com.rcx.materialis.MaterialisConfig;
import erebus.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleErebus implements IModule {

	public static Material bamboo = new Material("bamboo", 0x91A043);

	public static Material jade = new Material("jade", 0x60CF7B);

	public static Material flyWing = new Material("fly_wing", 0xA5A5A5);

	public static Material dragonflyWing = new Material("dragonfly_wing", 0x9EC0D5);

	@Override
	public Boolean shouldLoad() {
		return Loader.isModLoaded(this.getName()) && !MaterialisConfig.blacklist.isModuleBlacklisted(this.getName());
	}

	@Override
	public String getName() {
		return "erebus";
	}

	@Override
	public void preInit(FMLPreInitializationEvent preEvent) {}

	@Override
	public void registerItems(Register<Item> event) {}

	@Override
	public void init(FMLInitializationEvent event) {
		TinkerMaterials.bone.addItem(new ItemStack(ModItems.MATERIALS, 1, 2), 1, Material.VALUE_Shard);

		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("bamboo")) {
			bamboo.addItem("bamboo", 1, Material.VALUE_Fragment);
			bamboo.addItem("plankBamboo", 1, Material.VALUE_Ingot);
			bamboo.setRepresentativeItem(new ItemStack(ModItems.MATERIALS, 1, 3));
			bamboo.setCraftable(true);
			bamboo.addTrait(TinkerTraits.ecological);
			TinkerRegistry.addMaterial(bamboo);
			TinkerRegistry.addMaterialStats(bamboo,
					new HeadMaterialStats(100, 3.0F, 3.0F, 0),
					new HandleMaterialStats(1.0F, 50),
					new ExtraMaterialStats(25),
					new BowMaterialStats(0.9F, 1.2F, 0.0F));
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("jade")) {
			jade.addItem("gemJade", 1, Material.VALUE_Ingot);
			jade.addItem("nuggetJade", 1, Material.VALUE_Nugget);
			jade.addItem("blockJade", 1, Material.VALUE_Block);
			jade.setRepresentativeItem(new ItemStack(ModItems.MATERIALS, 1, 1));
			jade.setCraftable(true);
			jade.addTrait(TinkerTraits.established);
			TinkerRegistry.addMaterial(jade);
			TinkerRegistry.addMaterialStats(jade,
					new HeadMaterialStats(495, 10.0F, 4.0F, 2),
					new HandleMaterialStats(0.5F, 0),
					new ExtraMaterialStats(368),
					new BowMaterialStats(0.2F, 0.4F, -1.0F));
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("fly_wing")) {
			flyWing.addItem(new ItemStack(ModItems.MATERIALS, 1, 6), 1, Material.VALUE_Ingot);
			flyWing.setRepresentativeItem(new ItemStack(ModItems.MATERIALS, 1, 6));
			flyWing.setCraftable(true);
			TinkerRegistry.addMaterial(flyWing);
			TinkerRegistry.addMaterialStats(flyWing, new FletchingMaterialStats(0.6F, 1.5F));
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("dragonfly_wing")) {
			dragonflyWing.addItem(new ItemStack(ModItems.MATERIALS, 1, 24), 1, Material.VALUE_Ingot);
			dragonflyWing.setRepresentativeItem(new ItemStack(ModItems.MATERIALS, 1, 24));
			dragonflyWing.setCraftable(true);
			TinkerRegistry.addMaterial(dragonflyWing);
			TinkerRegistry.addMaterialStats(dragonflyWing, new FletchingMaterialStats(1.0F, 1.25F));
		}
	}

	@Override
	public void postInit(FMLPostInitializationEvent postEvent) {}
}