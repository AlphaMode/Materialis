package com.rcx.materialis.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class OptionalItem extends Item {

	public boolean hideTab;

	public OptionalItem(Properties prop, boolean hideTab) {
		super(prop);
		this.hideTab = hideTab;
	}

	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		if (!hideTab)
			super.fillItemCategory(group, items);
	}
}
