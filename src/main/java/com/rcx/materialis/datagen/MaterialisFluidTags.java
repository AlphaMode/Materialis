package com.rcx.materialis.datagen;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.MaterialisResources;
import com.rcx.materialis.MaterialisResources.FluidWithBlockNBucket;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.common.TinkerTags;

public class MaterialisFluidTags extends FabricTagProvider.FluidTagProvider {

	public static final TagKey<Fluid> LIQUID_PINK_SLIME = TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(Materialis.modID, "pink_slime"));
	public static final TagKey<Fluid> VIRULENT_MIX = TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(Materialis.modID, "virulent_mix"));
	public static final TagKey<Fluid> LIQUID_STARLIGHT = TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(Materialis.modID, "liquid_starlight"));

	public MaterialisFluidTags(FabricDataGenerator gen) {
		super(gen);
	}

	@Override
	public void generateTags() {
		for (FluidWithBlockNBucket fluid : MaterialisResources.fluidList) {
			tag(fluid.OBJECT.getLocalTag()).add(fluid.FLUID.get());
			tag(fluid.OBJECT.getForgeTag()).add(fluid.FLUID.get());
			tag(TinkerTags.Fluids.METAL_TOOLTIPS).addTag(fluid.OBJECT.getForgeTag());
		}

		tag(LIQUID_PINK_SLIME).addOptional(new ResourceLocation("industrialforegoing", "pink_slime"));
		tag(VIRULENT_MIX).addOptional(new ResourceLocation("undergarden", "virulent_mix_source"));
		tag(LIQUID_STARLIGHT).addOptional(new ResourceLocation("astralsorcery", "liquid_starlight"));

		tag(TinkerTags.Fluids.CHEAP_METAL_SPILLING)
		.addTag(MaterialisResources.QUICKSILVER_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.CLOGGRUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.FROSTSTEEL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.UTHERIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.REGALIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.IESNIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.MANASTEEL_FLUID.OBJECT.getForgeTag());
		tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING)
		.addTag(MaterialisResources.ARCANE_GOLD_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.STARMETAL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.PINK_SLIME_FLUID.OBJECT.getForgeTag())
		//.addTag(MaterialisResources.REFINED_OBSIDIAN_FLUID.OBJECT.getForgeTag())
		//.addTag(MaterialisResources.REFINED_GLOWSTONE_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.PSIMETAL_FLUID.OBJECT.getForgeTag());
		tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING)
		.addTag(MaterialisResources.REFINED_RADIANCE_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.SHADOW_STEEL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.NEPTUNIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.FORGOTTEN_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.EBONY_PSIMETAL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.IVORY_PSIMETAL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.ELEMENTIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.TERRASTEEL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.ALFSTEEL_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.DRACONIUM_FLUID.OBJECT.getForgeTag())
		.addTag(MaterialisResources.AWAKENED_DRACONIUM_FLUID.OBJECT.getForgeTag());
	}
}
