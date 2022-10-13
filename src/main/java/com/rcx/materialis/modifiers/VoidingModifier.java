package com.rcx.materialis.modifiers;

import java.util.List;

import io.github.fabricators_of_create.porting_lib.event.common.BlockEvents;
import io.github.fabricators_of_create.porting_lib.event.common.LivingEntityEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.helper.ModifierLootingHandler;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class VoidingModifier extends NoLevelsModifier {

	public VoidingModifier() {
		super();
		BlockEvents.BLOCK_BREAK.register(this::beforeBlockBreak);
		LivingEntityEvents.EXPERIENCE_DROP_WITH_ENTITY.register(this::onExperienceDrop);
	}

	@Override
	public int getPriority() {
		return 93; //hopefully after other loot modifying modifiers, but before melting
	}

	@Override
	public List<ItemStack> processLoot(IToolStackView tool, int level, List<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.clear();
		return generatedLoot;
	}

	public static int boostXP(int xp, int luck) {
		float modifier = 1 + RANDOM.nextFloat() * luck;
		return (int) ((xp + RANDOM.nextFloat()) * modifier);
	}

	private void beforeBlockBreak(BlockEvents.BreakEvent event) {
		ToolStack tool = getHeldTool(event.getPlayer(), InteractionHand.MAIN_HAND);
		if (tool != null && tool.getModifierLevel(this) > 0) {
			event.setExpToDrop(boostXP(event.getExpToDrop(), EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, event.getPlayer().getMainHandItem())));
		}
	}

	private int onExperienceDrop(int i, Player attackingPlayer, LivingEntity entity) {
		ToolStack tool = getHeldTool(attackingPlayer, ModifierLootingHandler.getLootingSlot(attackingPlayer));
		if (tool != null && tool.getModifierLevel(this) > 0) {
			return (boostXP(i, ModifierUtil.getLeggingsLootingLevel(attackingPlayer, entity, null, ModifierUtil.getLootingLevel(tool, attackingPlayer, entity, null))));
		}
		return i;
	}
}