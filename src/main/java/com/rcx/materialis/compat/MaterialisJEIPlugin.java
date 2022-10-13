package com.rcx.materialis.compat;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.MaterialisResources;
import com.rcx.materialis.MaterialisResources.FluidWithBlockNBucket;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.fabric.constants.FabricTypes;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.common.registration.CastItemObject;

@JeiPlugin
public class MaterialisJEIPlugin implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(Materialis.modID, "jei_plugin");
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		IIngredientManager manager = jeiRuntime.getIngredientManager();

		// hide compat that is not present
		for (FluidWithBlockNBucket fluid : MaterialisResources.fluidList) {
			HolderSet.Named<Item> ingot = getTag(new ResourceLocation("c", "ingots/" + fluid.name.replace("molten_", "")));
			if (ingot == null) {
				removeFluid(manager, fluid.FLUID.get(), fluid.FLUID_BUCKET.get());
			}
		}

		optionalCast(manager, MaterialisResources.INLAY_CAST);
	}

	/**
	 * Removes a fluid from JEI
	 * @param manager  Manager
	 * @param fluid    Fluid to remove
	 * @param bucket   Fluid bucket to remove
	 */
	public static void removeFluid(IIngredientManager manager, Fluid fluid, Item bucket) {
//		manager.removeIngredientsAtRuntime(FabricTypes.FLUID_STACK, Collections.singleton(fluid));
		manager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, Collections.singleton(new ItemStack(bucket)));
	}

	/**
	 * Hides casts if the related tag is empty
	 * @param manager  Ingredient manager
	 * @param cast     Cast instance
	 */
	public static void optionalCast(IIngredientManager manager, CastItemObject cast) {
		HolderSet.Named<Item> tag = getTag(new ResourceLocation("c", cast.getName().getPath() + "s"));
		if (tag == null) {
			manager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, cast.values().stream().map(ItemStack::new).collect(Collectors.toList()));
		}
	}

	/** Helper to get an item tag */
	private static HolderSet.Named<Item> getTag(ResourceLocation name) {
		return getTag(TagKey.create(Registry.ITEM_REGISTRY, name));
	}

	/** Helper to get an item tag */
	private static HolderSet.Named<Item> getTag(TagKey<Item> name) {
		return Objects.requireNonNull(Registry.ITEM.getOrCreateTag(name));
	}
}
