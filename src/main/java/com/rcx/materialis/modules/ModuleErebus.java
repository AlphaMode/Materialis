package com.rcx.materialis.modules;

import com.rcx.materialis.MaterialisConfig;
import com.rcx.materialis.MaterialisRegistry;
import com.rcx.materialis.Util;
import c4.conarm.common.armor.modifiers.ArmorModifiers;
import c4.conarm.common.armor.traits.ArmorTraits;
import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleErebus implements IModule {

	public static Material bamboo = new Material("bamboo", 0x91A043);

	public static Material jade = new Material("jade", 0x60CF7B);

	public static Material flyWing = new Material("fly_wing", 0xA5A5A5);

	public static Material dragonflyWing = new Material("dragonfly_wing", 0x9EC0D5);

	public static Material exoskeleton = new Material("exoskeleton", 0xD8D8D2);

	public static Material exoskeletonReinforced = new Material("exoskeleton_reinforced", 0xC1C1B6);

	public static Material exoskeletonRhino = new Material("exoskeleton_rhino", 0x5B5B5B);

	//public static AbstractTrait modWaterStrider;

	@Override
	public Boolean shouldLoad() {
		return Loader.isModLoaded(this.getName()) && !MaterialisConfig.blacklist.isModuleBlacklisted(this.getName());
	}

	@Override
	public String getName() {
		return "erebus";
	}

	@Override
	public void earlyPreInit(FMLPreInitializationEvent preEvent) {
		//register wood materials early
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("bamboo"))
			TinkerRegistry.addMaterial(bamboo);
	}

	@Override
	public void preInit(FMLPreInitializationEvent preEvent) {
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("bamboo")) {
			bamboo.addTrait(TinkerTraits.ecological);
			TinkerRegistry.addMaterialStats(bamboo,
					new HeadMaterialStats(100, 3.0F, 3.0F, 0),
					new HandleMaterialStats(1.0F, 50),
					new ExtraMaterialStats(25),
					new BowMaterialStats(0.9F, 1.2F, 0.0F));
			if (ModuleConarm.loadArmor()) {
				ModuleConarm.generateArmorStats(bamboo, 0.0F);
				bamboo.addTrait(ArmorTraits.ecological, ArmorMaterialType.CORE);
				bamboo.addTrait(ArmorTraits.ecological, ArmorMaterialType.PLATES);
				bamboo.addTrait(ArmorTraits.ecological, ArmorMaterialType.TRIM);
			}
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("jade")) {
			jade.addTrait(TinkerTraits.established);
			TinkerRegistry.addMaterial(jade);
			TinkerRegistry.addMaterialStats(jade,
					new HeadMaterialStats(495, 10.0F, 4.0F, 2),
					new HandleMaterialStats(0.5F, 0),
					new ExtraMaterialStats(368),
					new BowMaterialStats(0.2F, 0.4F, -1.0F));
			if (ModuleConarm.loadArmor()) {
				ModuleConarm.generateArmorStats(jade, 1.0F);
				jade.addTrait(ArmorTraits.ambitious, ArmorMaterialType.CORE);
				jade.addTrait(ArmorTraits.ambitious, ArmorMaterialType.PLATES);
				jade.addTrait(ArmorTraits.ambitious, ArmorMaterialType.TRIM);
			}
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("fly_wing")) {
			TinkerRegistry.addMaterial(flyWing);
			TinkerRegistry.addMaterialStats(flyWing, new FletchingMaterialStats(0.6F, 1.5F));
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("dragonfly_wing")) {
			TinkerRegistry.addMaterial(dragonflyWing);
			TinkerRegistry.addMaterialStats(dragonflyWing, new FletchingMaterialStats(1.0F, 1.25F));
		}

		if (ModuleConarm.loadArmor()) {
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton")) {
				exoskeleton.addTrait(ArmorTraits.skeletal);
				TinkerRegistry.addMaterial(exoskeleton);
				TinkerRegistry.addMaterialStats(exoskeleton,
						new CoreMaterialStats(7, 8.2F),
						new PlatesMaterialStats(1.0F, 4, 1.0F),
						new TrimMaterialStats(17));
			}
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton_reinforced")) {
				exoskeletonReinforced.addTrait(ArmorTraits.heavy);
				exoskeletonReinforced.addTrait(ArmorTraits.dense);
				TinkerRegistry.addMaterial(exoskeletonReinforced);
				TinkerRegistry.addMaterialStats(exoskeletonReinforced,
						new CoreMaterialStats(21, 13.2F),
						new PlatesMaterialStats(1.3F, 7, 3.0F),
						new TrimMaterialStats(27));
			}
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton_rhino")) {
				exoskeletonRhino.addTrait(ArmorTraits.dramatic);
				TinkerRegistry.addMaterial(exoskeletonRhino);
				TinkerRegistry.addMaterialStats(exoskeletonRhino,
						new CoreMaterialStats(21, 13.2F),
						new PlatesMaterialStats(1.3F, 7, 4.0F),
						new TrimMaterialStats(27));
			}

			//modWaterStrider = new ModWaterStrider();
		}
	}

	@Override
	public void registerItems(Register<Item> event) {}

	@Override
	public void init(FMLInitializationEvent event) {
		TinkerMaterials.bone.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 2), 1, Material.VALUE_Shard);

		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("bamboo")) {
			bamboo.addItem("bamboo", 1, Material.VALUE_Fragment);
			bamboo.addItem("plankBamboo", 1, Material.VALUE_Ingot);
			bamboo.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 3));
			bamboo.setCraftable(true);
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("jade")) {
			jade.addItem("gemJade", 1, Material.VALUE_Ingot);
			jade.addItem("nuggetJade", 1, Material.VALUE_Nugget);
			jade.addItem("blockJade", 1, Material.VALUE_Block);
			jade.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 1));
			jade.setCraftable(true);
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("fly_wing")) {
			flyWing.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 6), 1, Material.VALUE_Ingot);
			flyWing.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 6));
			flyWing.setCraftable(true);
		}
		if (!MaterialisConfig.blacklist.isMaterialBlacklisted("dragonfly_wing")) {
			dragonflyWing.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 24), 1, Material.VALUE_Ingot);
			dragonflyWing.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 24));
			dragonflyWing.setCraftable(true);
		}

		TinkerModifiers.modSharpness.addItem(new ItemStack(Util.getItem("erebus", "whetstone"), 1, 1), 1, 72);

		TinkerModifiers.modGlowing.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Util.getItem("erebus", "materials"), 1, 12), new ItemStack(Items.ENDER_EYE), new ItemStack(Util.getItem("erebus", "materials"), 1, 12)));

		if (ModuleConarm.loadArmor()) {
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton")) {
				exoskeleton.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 0), 1, Material.VALUE_Ingot);
				exoskeleton.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 0));
				exoskeleton.setCraftable(true);
			}
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton_reinforced")) {
				exoskeletonReinforced.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 15), 1, Material.VALUE_Ingot);
				exoskeletonReinforced.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 15));
				exoskeletonReinforced.setCraftable(true);
			}
			if (!MaterialisConfig.blacklist.isMaterialBlacklisted("exoskeleton_rhino")) {
				exoskeletonRhino.addItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 35), 1, Material.VALUE_Ingot);
				exoskeletonRhino.setRepresentativeItem(new ItemStack(Util.getItem("erebus", "materials"), 1, 35));
				exoskeletonRhino.setCraftable(true);
			}

			MaterialisRegistry.addRecipe(new ItemStack(Util.getItem("conarm", "travel_night")), "travel_night", "travel_night", new Object[]{"LGL", 'L', new ItemStack(Util.getItem("erebus", "materials"), 1, 5), 'G', new ItemStack(Util.getItem("conarm", "travel_goggles_base"))});

			ArmorModifiers.modGlowing.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(Util.getItem("erebus", "materials"), 1, 12), new ItemStack(Items.ENDER_EYE), new ItemStack(Util.getItem("erebus", "materials"), 1, 12)));

			//modWaterStrider.addItem(new ItemStack(ModuleTConstruct.alumiteIngot), 1, 1);
		}
	}

	@Override
	public void postInit(FMLPostInitializationEvent postEvent) {}
}
