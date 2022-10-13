package com.rcx.materialis.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class OptionalBucketItem extends BucketItem {

	public boolean hideTab;

	public OptionalBucketItem(Supplier<? extends Fluid> supplier, Properties builder, boolean condition) {
		super(supplier.get(), builder);
		this.hideTab = condition;
	}

	public OptionalBucketItem(Fluid fluid, Properties builder, boolean condition) {
		super(fluid, builder);
		this.hideTab = condition;
	}

	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		if (!hideTab)
			super.fillItemCategory(group, items);
	}

}
