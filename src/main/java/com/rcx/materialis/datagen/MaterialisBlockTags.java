package com.rcx.materialis.datagen;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.MaterialisResources;
import com.rcx.materialis.MaterialisResources.IngotWithBlockNNugget;
import me.alphamode.forgetags.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import slimeknights.tconstruct.common.TinkerTags;

public class MaterialisBlockTags extends FabricTagProvider.BlockTagProvider {

	public static final TagKey<Block> WRENCH_BLACKLIST = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Materialis.modID, "wrench_blacklist"));
	public static final TagKey<Block> MINABLE_WITH_WRENCH = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Materialis.modID, "mineable/wrench"));

	//astral sorcery stuff
	public static final TagKey<Block> STARMETAL_BLOCK = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("c", "storage_blocks/starmetal"));
	public static final TagKey<Block> STARMETAL_ORE = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("c", "ores/starmetal"));

	public MaterialisBlockTags(FabricDataGenerator gen) {
		super(gen);
	}

	@Override
	protected void generateTags() {
		for (IngotWithBlockNNugget material : MaterialisResources.materialList) {
			addBlockTag(material.BLOCK.get(), TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("c", "storage_blocks/" + material.name)));
		}
		tag(BlockTags.NEEDS_IRON_TOOL).addTag(TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("c", "storage_blocks/fairy")));
		
		//wrench
		getOrCreateTagBuilder(MINABLE_WITH_WRENCH)
		.addOptionalTag(new ResourceLocation("c", "mineable/wrench"))
		.addOptionalTag(new ResourceLocation("c", "mineable/hammer"))
		.forceAddTag(Tags.Blocks.STORAGE_BLOCKS)
		.forceAddTag(Tags.Blocks.BARRELS)
		.forceAddTag(Tags.Blocks.CHESTS)
		.forceAddTag(Tags.Blocks.GLASS)
		.forceAddTag(Tags.Blocks.GLASS_PANES)
		.forceAddTag(BlockTags.BUTTONS)
		.forceAddTag(BlockTags.DOORS)
		.forceAddTag(BlockTags.TRAPDOORS)
		.forceAddTag(BlockTags.PRESSURE_PLATES)
		.forceAddTag(BlockTags.BANNERS)
		.forceAddTag(BlockTags.ANVIL)
		.forceAddTag(BlockTags.RAILS)
		.forceAddTag(BlockTags.BEDS)
		.forceAddTag(BlockTags.SIGNS)
		.forceAddTag(BlockTags.BEACON_BASE_BLOCKS);

		//astral sorcery stuff
		tag(STARMETAL_BLOCK).addOptional(new ResourceLocation("astralsorcery", "starmetal"));
		tag(BlockTags.BEACON_BASE_BLOCKS).addTag(STARMETAL_BLOCK);
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(STARMETAL_BLOCK);

		tag(STARMETAL_ORE).addOptional(new ResourceLocation("astralsorcery", "starmetal_ore"));
		tag(Tags.Blocks.ORES).addTag(STARMETAL_ORE);

		//psi stuff
		tag(TinkerTags.Blocks.ANVIL_METAL).addOptionalTag(new ResourceLocation("c", "storage_blocks/ebony_psimetal"));
		tag(TinkerTags.Blocks.ANVIL_METAL).addOptionalTag(new ResourceLocation("c", "storage_blocks/ivory_psimetal"));

		//immersive engineering stuff
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "workbench"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "circuit_table"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "watermill"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "blastfurnace_preheater"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "fluid_pump"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "sample_drill"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "tesla_coil"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "turret_chem"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "turret_gun"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "cloche"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "coke_oven"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "blast_furnace"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "alloy_smelter"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "advanced_blast_furnace"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "crusher"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "sawmill"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "silo"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "tank"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "arc_furnace"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "assembler"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "auto_workbench"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "bucket_wheel"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "excavator"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "metal_press"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "bottling_machine"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "fermenter"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "squeezer"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "mixer"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "refinery"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "diesel_generator"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "lightning_rod"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "transformer"));
		tag(WRENCH_BLACKLIST).addOptional(new ResourceLocation("immersiveengineering", "transformer_hv"));
	}

	private void addBlockTag(Block block, TagKey<Block> tag) {
		tag(tag).add(block);
		tag(BlockTags.BEACON_BASE_BLOCKS).addTag(tag);
		tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(tag);
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(tag);
		tag(TinkerTags.Blocks.ANVIL_METAL).addTag(tag);
	}
}
