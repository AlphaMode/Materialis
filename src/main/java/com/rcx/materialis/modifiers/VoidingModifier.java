package com.rcx.materialis.modifiers;

import java.util.List;

import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class VoidingModifier extends SingleUseModifier {

	public VoidingModifier() {
		super(0x635D71);
		MinecraftForge.EVENT_BUS.addListener(this::onExperienceDrop);
	}

	@Override
	public List<ItemStack> processLoot(ToolStack tool, int level, List<ItemStack> generatedLoot, LootContext context) {
		World world = context.getLevel();
		if (!generatedLoot.isEmpty()) {
			for (ItemStack stack : generatedLoot) {
				world.addFreshEntity(new ExperienceOrbEntity(world, level, level, level, level));
			}
			generatedLoot.removeAll(generatedLoot);
		}
		return generatedLoot;
	}

	private void onExperienceDrop(LivingExperienceDropEvent event) {
		ToolStack tool = getHeldTool(event.getAttackingPlayer());
		if (tool != null) {
			if (tool.getModifierLevel(this) > 0) {
				float modifier = 1 + event.getAttackingPlayer().level.random.nextFloat() * tool.getModifierLevel(TinkerModifiers.luck.get());
				event.setDroppedExperience((int) (event.getDroppedExperience() * modifier + 0.4f));
			}
		}
	}
}