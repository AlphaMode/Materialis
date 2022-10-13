package com.rcx.materialis.modifiers;

import com.rcx.materialis.Materialis;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
//import vazkii.arl.util.ClientTicker;
//import vazkii.quark.api.IRuneColorProvider;

public class RunedModifier extends NoLevelsModifier {

	static boolean enabled = FabricLoader.getInstance().isModLoaded("quark");
	public static final ResourceLocation RUNE = new ResourceLocation(Materialis.modID, "rune");

	@Override
	public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
		volatileData.putBoolean(IModifiable.SHINY, true);
	}

	@Override
	public void onRemoved(IToolStackView tool) {
		tool.getPersistentData().remove(RUNE);
	}

	@Override
	public Component getDisplayName(IToolStackView tool, int level) {
		if (!enabled || !tool.getPersistentData().contains(RUNE, Tag.TAG_COMPOUND))
			return super.getDisplayName();

		int color = getColor(tool);

		final int colorRGB;
//		if (color > 15)
//			colorRGB = java.awt.Color.HSBtoRGB((ClientTicker.total / 100F), 1F, 1F);
//		else
			colorRGB = DyeColor.byId(color).getFireworkColor();

		return new TranslatableComponent(getTranslationKey()).withStyle(style -> style.withColor(TextColor.fromRgb(colorRGB)));
	}

	public static int getColor(IToolStackView tool) {
		if (enabled && FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT && tool.getPersistentData().contains(RUNE, Tag.TAG_COMPOUND)) {
			ItemStack stack = ItemStack.of(tool.getPersistentData().getCompound(RUNE));
//			if (stack.getItem() instanceof IRuneColorProvider)
//				return ((IRuneColorProvider) stack.getItem()).getRuneColor(stack);
		}
		return 16;
	};
}