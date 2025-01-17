package com.rcx.materialis.datagen;

import static slimeknights.tconstruct.common.TinkerTags.Items.ANVIL_METAL;
import static slimeknights.tconstruct.common.TinkerTags.Items.ARMOR;
import static slimeknights.tconstruct.common.TinkerTags.Items.BOOTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.CHESTPLATES;
import static slimeknights.tconstruct.common.TinkerTags.Items.DURABILITY;
import static slimeknights.tconstruct.common.TinkerTags.Items.FOUNDRY_DEBUG;
import static slimeknights.tconstruct.common.TinkerTags.Items.GOLD_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST_PRIMARY;
import static slimeknights.tconstruct.common.TinkerTags.Items.HELMETS;
import static slimeknights.tconstruct.common.TinkerTags.Items.LEGGINGS;
import static slimeknights.tconstruct.common.TinkerTags.Items.MELEE;
import static slimeknights.tconstruct.common.TinkerTags.Items.MELEE_PRIMARY;
import static slimeknights.tconstruct.common.TinkerTags.Items.MULTIPART_TOOL;
import static slimeknights.tconstruct.common.TinkerTags.Items.MULTI_USE_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.ONE_HANDED;
import static slimeknights.tconstruct.common.TinkerTags.Items.RED_SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SINGLE_USE_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SMELTERY_DEBUG;
import static slimeknights.tconstruct.common.TinkerTags.Items.TOOL_PARTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.TWO_HANDED;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.MaterialisResources;
import com.rcx.materialis.MaterialisResources.IngotWithBlockNNugget;

import me.alphamode.forgetags.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.tools.item.ArmorSlotType;

public class MaterialisItemTags extends FabricTagProvider.ItemTagProvider {

	//custom casts
	public static final TagKey<Item> INLAY_CAST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "casts/multi_use/inlay"));
	public static final TagKey<Item> INLAY_CAST_SINGLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "casts/single_use/inlay"));
	public static final TagKey<Item> WRENCH_HEAD_CAST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "casts/multi_use/wrench_head"));
	public static final TagKey<Item> WRENCH_HEAD_CAST_SINGLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "casts/single_use/wrench_head"));

	public static final TagKey<Item> PLASTIC_MATERIAL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "plastic_material"));

	//wrench
	public static final TagKey<Item> TOOLS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "tools"));
	public static final TagKey<Item> WRENCH = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "tools/wrench"));
	public static final TagKey<Item> WRENCHING = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "wrench"));
	public static final TagKey<Item> GALVANIZABLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "galvanizable"));

	//create stuff
	public static final TagKey<Item> REFINED_RADIANCE_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/refined_radiance"));
	public static final TagKey<Item> SHADOW_STEEL_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/shadow_steel"));
	public static final TagKey<Item> ROSE_QUARTZ_MATERIAL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "rose_quartz_material"));

	//eidolon stuff
	public static final TagKey<Item> INLAYS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "inlays"));
	public static final TagKey<Item> PEWTER_INLAY = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "inlays/pewter"));
	public static final TagKey<Item> ARCANE_GOLD_INLAY = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "inlays/arcane_gold"));

	//astral sorcery stuff
	public static final TagKey<Item> STARMETAL_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/starmetal"));
	public static final TagKey<Item> STARMETAL_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/starmetal"));
	public static final TagKey<Item> STARMETAL_ORE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ores/starmetal"));

	//industrial foregoing stuff
	public static final TagKey<Item> PINK_SLIME_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/pink_slime"));
	public static final TagKey<Item> PINK_SLIME = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "pink_slime"));

	//undergarden stuff
	public static final TagKey<Item> RAW_CLOGGRUM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "raw_materials/cloggrum"));
	public static final TagKey<Item> RAW_CLOGGRUM_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/raw_cloggrum"));
	public static final TagKey<Item> RAW_FROSTSTEEL = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "raw_materials/froststeel"));
	public static final TagKey<Item> RAW_FROSTSTEEL_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/raw_froststeel"));

	//psi stuff
	public static final TagKey<Item> SENSOR_SLOTTABLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "sensor_slottable"));
	public static final TagKey<Item> SENSOR = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Materialis.modID, "psi_sensor"));

	//mythic botany stuff
	public static final TagKey<Item> ALFSTEEL_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/alfsteel"));
	public static final TagKey<Item> ALFSTEEL_NUGGET = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "nuggets/alfsteel"));
	public static final TagKey<Item> ALFSTEEL_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/alfsteel"));
	public static final TagKey<Item> ELEMENTIUM_ORE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ores/elementium"));
	public static final TagKey<Item> RAW_ELEMENTIUM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "raw_materials/elementium"));
	public static final TagKey<Item> RAW_ELEMENTIUM_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/raw_elementium"));

	//redstone arsenal stuff
	public static final TagKey<Item> FLUX_INFUSED_INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/flux_infused"));
	public static final TagKey<Item> FLUX_INFUSED_NUGGET = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "nuggets/flux_infused"));
	public static final TagKey<Item> FLUX_INFUSED_DUST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "dusts/flux_infused"));
	public static final TagKey<Item> FLUX_INFUSED_GEAR = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "gears/flux_infused"));
	public static final TagKey<Item> GEARS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "gears"));
	public static final TagKey<Item> FLUX_INFUSED_BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/flux_infused"));

	public MaterialisItemTags(FabricDataGenerator gen, FabricTagProvider.BlockTagProvider blockTags) {
		super(gen, blockTags);
	}

	@Override
	protected void generateTags() {
		for (IngotWithBlockNNugget material : MaterialisResources.materialList) {
			TagKey<Item> INGOT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "ingots/" + material.name));
			TagKey<Item> BLOCK = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "storage_blocks/" + material.name));
			TagKey<Item> NUGGET = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "nuggets/" + material.name));

			tag(INGOT).add(material.INGOT.get());
			tag(Tags.Items.INGOTS).addTag(INGOT);
			tag(BLOCK).add(material.BLOCK_ITEM.get());
			tag(Tags.Items.STORAGE_BLOCKS).addTag(BLOCK);
			tag(ANVIL_METAL).addTag(BLOCK);
			tag(NUGGET).add(material.NUGGET.get());
			tag(Tags.Items.NUGGETS).addTag(NUGGET);
		}

		//custom casts
		tag(INLAY_CAST).add(MaterialisResources.INLAY_CAST.get());
		tag(INLAY_CAST_SINGLE).add(MaterialisResources.INLAY_CAST.getSand());
		tag(INLAY_CAST_SINGLE).add(MaterialisResources.INLAY_CAST.getRedSand());
		tag(GOLD_CASTS).add(MaterialisResources.INLAY_CAST.get());
		tag(SAND_CASTS).add(MaterialisResources.INLAY_CAST.getSand());
		tag(RED_SAND_CASTS).add(MaterialisResources.INLAY_CAST.getRedSand());
		tag(MULTI_USE_CASTS).addTag(INLAY_CAST);
		tag(SINGLE_USE_CASTS).addTag(INLAY_CAST_SINGLE);
		tag(WRENCH_HEAD_CAST).add(MaterialisResources.WRENCH_HEAD_CAST.get());
		tag(WRENCH_HEAD_CAST_SINGLE).add(MaterialisResources.WRENCH_HEAD_CAST.getSand());
		tag(WRENCH_HEAD_CAST_SINGLE).add(MaterialisResources.WRENCH_HEAD_CAST.getRedSand());
		tag(GOLD_CASTS).add(MaterialisResources.WRENCH_HEAD_CAST.get());
		tag(SAND_CASTS).add(MaterialisResources.WRENCH_HEAD_CAST.getSand());
		tag(RED_SAND_CASTS).add(MaterialisResources.WRENCH_HEAD_CAST.getRedSand());
		tag(MULTI_USE_CASTS).addTag(WRENCH_HEAD_CAST);
		tag(SINGLE_USE_CASTS).addTag(WRENCH_HEAD_CAST_SINGLE);

		//plastic
		tag(PLASTIC_MATERIAL).addOptionalTag(new ResourceLocation("c", "plastic"))
		.addOptionalTag(new ResourceLocation("pneumaticcraft", "plastic_sheets"))
		.addOptional(new ResourceLocation("mekanism", "hdpe_sheet"));

		//wrench
		tag(TOOLS).addTag(WRENCH);
		tag(TOOL_PARTS).add(MaterialisResources.WRENCH_HEAD.get());
		addAllTags(MaterialisResources.WRENCH, MULTIPART_TOOL, DURABILITY, HARVEST_PRIMARY, MELEE, ONE_HANDED, WRENCH, WRENCHING, GALVANIZABLE, SMELTERY_DEBUG, FOUNDRY_DEBUG);
		addAllTags(MaterialisResources.BATTLEWRENCH, MULTIPART_TOOL, DURABILITY, HARVEST_PRIMARY, MELEE_PRIMARY, TWO_HANDED, WRENCH, WRENCHING, SMELTERY_DEBUG, FOUNDRY_DEBUG);

		//create ingots
		tag(REFINED_RADIANCE_INGOT).addOptional(new ResourceLocation("create", "refined_radiance"));
		tag(Tags.Items.INGOTS).addTag(REFINED_RADIANCE_INGOT);
		tag(SHADOW_STEEL_INGOT).addOptional(new ResourceLocation("create", "shadow_steel"));
		tag(Tags.Items.INGOTS).addTag(SHADOW_STEEL_INGOT);
		tag(ROSE_QUARTZ_MATERIAL).addOptional(new ResourceLocation("create", "rose_quartz"))
		.addOptional(new ResourceLocation("create", "polished_rose_quartz"))
		.addOptional(new ResourceLocation("biomesoplenty", "rose_quartz_shard"));

		//eidolon stuff
		tag(PEWTER_INLAY).addOptional(new ResourceLocation("eidolon", "pewter_inlay"));
		tag(INLAYS).addTag(PEWTER_INLAY);
		tag(ARCANE_GOLD_INLAY).addOptional(new ResourceLocation("eidolon", "gold_inlay"));
		tag(INLAYS).addTag(ARCANE_GOLD_INLAY);

		//astral sorcery stuff
		tag(STARMETAL_INGOT).addOptional(new ResourceLocation("astralsorcery", "starmetal_ingot"));
		tag(Tags.Items.INGOTS).addTag(STARMETAL_INGOT);
		tag(STARMETAL_BLOCK).addOptional(new ResourceLocation("astralsorcery", "starmetal"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(STARMETAL_BLOCK);
		tag(STARMETAL_ORE).addOptional(new ResourceLocation("astralsorcery", "starmetal_ore"));
		tag(Tags.Items.ORES).addTag(STARMETAL_ORE);

		//industrial foregoing stuff
		tag(PINK_SLIME_INGOT).addOptional(new ResourceLocation("industrialforegoing", "pink_slime_ingot"));
		tag(Tags.Items.INGOTS).addTag(PINK_SLIME_INGOT);
		tag(PINK_SLIME).addOptional(new ResourceLocation("industrialforegoing", "pink_slime"));

		//undergarden stuff
		tag(RAW_CLOGGRUM).addOptional(new ResourceLocation("undergarden", "raw_cloggrum"));
		tag(Tags.Items.RAW_MATERIALS).addTag(RAW_CLOGGRUM);
		tag(RAW_CLOGGRUM_BLOCK).addOptional(new ResourceLocation("undergarden", "raw_cloggrum_block"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(RAW_CLOGGRUM_BLOCK);
		tag(RAW_FROSTSTEEL).addOptional(new ResourceLocation("undergarden", "raw_froststeel"));
		tag(Tags.Items.RAW_MATERIALS).addTag(RAW_FROSTSTEEL);
		tag(RAW_FROSTSTEEL_BLOCK).addOptional(new ResourceLocation("undergarden", "raw_froststeel_block"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(RAW_FROSTSTEEL_BLOCK);

		//psi stuff
		tag(ANVIL_METAL).addOptionalTag(new ResourceLocation("c", "storage_blocks/ebony_psimetal"));
		tag(ANVIL_METAL).addOptionalTag(new ResourceLocation("c", "storage_blocks/ivory_psimetal"));
		/*addArmorTags(MaterialisResources.PSIMETAL_EXOSUIT, DURABILITY);
		tag(SENSOR_SLOTTABLE).add(MaterialisResources.PSIMETAL_EXOSUIT.get(ArmorSlotType.HELMET));
		tag(SENSOR).addOptional(new ResourceLocation("psi", "exosuit_sensor_light"));
		tag(SENSOR).addOptional(new ResourceLocation("psi", "exosuit_sensor_heat"));
		tag(SENSOR).addOptional(new ResourceLocation("psi", "exosuit_sensor_stress"));
		tag(SENSOR).addOptional(new ResourceLocation("psi", "exosuit_sensor_water"));
		tag(SENSOR).addOptional(new ResourceLocation("psi", "exosuit_sensor_trigger"));*/

		//botania stuff
		tag(ANVIL_METAL).addOptionalTag(new ResourceLocation("c", "storage_blocks/terrasteel"));
		tag(TinkerTags.Items.VARIANT_LOGS).addOptionalTag(new ResourceLocation("botania", "livingwood_logs"))
		.addOptionalTag(new ResourceLocation("botania", "dreamwood_logs"));
		tag(TinkerTags.Items.VARIANT_PLANKS).addOptional(new ResourceLocation("botania", "livingwood_planks"))
		.addOptional(new ResourceLocation("botania", "dreamwood_planks"));

		//mythicbotany stuff
		tag(ALFSTEEL_INGOT).addOptional(new ResourceLocation("mythicbotany", "alfsteel_ingot"));
		tag(Tags.Items.INGOTS).addTag(ALFSTEEL_INGOT);
		tag(ALFSTEEL_NUGGET).addOptional(new ResourceLocation("mythicbotany", "alfsteel_nugget"));
		tag(Tags.Items.NUGGETS).addTag(ALFSTEEL_NUGGET);
		tag(ALFSTEEL_BLOCK).addOptional(new ResourceLocation("mythicbotany", "alfsteel_block"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(ALFSTEEL_BLOCK);
		tag(ANVIL_METAL).addTag(ALFSTEEL_BLOCK);
		tag(ELEMENTIUM_ORE).addOptional(new ResourceLocation("mythicbotany", "elementium_ore"));
		tag(Tags.Items.ORES).addTag(ELEMENTIUM_ORE);
		tag(RAW_ELEMENTIUM).addOptional(new ResourceLocation("mythicbotany", "raw_elementium"));
		tag(Tags.Items.RAW_MATERIALS).addTag(RAW_ELEMENTIUM);
		tag(RAW_ELEMENTIUM_BLOCK).addOptional(new ResourceLocation("mythicbotany", "raw_elementium_block"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(RAW_ELEMENTIUM_BLOCK);

		//redstone arsenal stuff
		tag(FLUX_INFUSED_INGOT).addOptional(new ResourceLocation("redstone_arsenal", "flux_ingot"));
		tag(Tags.Items.INGOTS).addTag(FLUX_INFUSED_INGOT);
		tag(FLUX_INFUSED_NUGGET).addOptional(new ResourceLocation("redstone_arsenal", "flux_nugget"));
		tag(Tags.Items.NUGGETS).addTag(FLUX_INFUSED_NUGGET);
		tag(FLUX_INFUSED_DUST).addOptional(new ResourceLocation("redstone_arsenal", "flux_dust"));
		tag(Tags.Items.DUSTS).addTag(FLUX_INFUSED_DUST);
		tag(FLUX_INFUSED_GEAR).addOptional(new ResourceLocation("redstone_arsenal", "flux_gear"));
		tag(GEARS).addTag(FLUX_INFUSED_GEAR);
		tag(FLUX_INFUSED_BLOCK).addOptional(new ResourceLocation("redstone_arsenal", "flux_metal_block"));
		tag(Tags.Items.STORAGE_BLOCKS).addTag(FLUX_INFUSED_BLOCK);
		tag(ANVIL_METAL).addTag(FLUX_INFUSED_BLOCK);
	}

	@SafeVarargs
	public final void addAllTags(ItemLike provider, TagKey<Item>... tags) {
		Item item = provider.asItem();
		for (TagKey<Item> tag : tags) {
			tag(tag).add(item);
		}
	}

	private TagKey<Item> getArmorTag(ArmorSlotType slotType) {
		switch (slotType) {
		case BOOTS: return BOOTS;
		case LEGGINGS: return LEGGINGS;
		case CHESTPLATE: return CHESTPLATES;
		case HELMET: return HELMETS;
		}
		return ARMOR;
	}

	@SafeVarargs
	private final void addArmorTags(EnumObject<ArmorSlotType, ? extends Item> armor, TagKey<Item>... tags) {
		armor.forEach((type, item) -> {
			for (TagKey<Item> tag : tags) {
				this.tag(tag).add(item);
			}
			this.tag(getArmorTag(type)).add(item);
		});
	}
}
