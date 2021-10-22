package com.rcx.materialis.modifiers;

import net.minecraft.item.Item;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.nbt.IModDataReadOnly;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

public class OverweightModifier extends Modifier {

	public OverweightModifier() {
		super(0xFF9FEF);
	}

	@Override
	public int getPriority() {
		return 80; //after overcast
	}

	@Override
	public void addVolatileData(Item item, ToolDefinition toolDefinition, StatsNBT baseStats, IModDataReadOnly persistentData, int level, ModDataNBT volatileData) {
		OverslimeModifier overslime = TinkerModifiers.overslime.get();
		overslime.setFriend(volatileData);

		float multiplier = 0.1f * level;
		float speedEaten = baseStats.getFloat(ToolStats.ATTACK_SPEED) * 5.0f * multiplier + baseStats.getFloat(ToolStats.MINING_SPEED) * multiplier;

		overslime.addCapacity(volatileData, (int) (speedEaten * 300.0f));
	}

	@Override
	public void addToolStats(Item item, ToolDefinition toolDefinition, StatsNBT baseStats, IModDataReadOnly persistentData, IModDataReadOnly volatileData, int level, ModifierStatsBuilder builder) {
		float multiplier = 1.0f - 0.1f * level;
		ToolStats.ATTACK_SPEED.multiply(builder, multiplier);
		ToolStats.MINING_SPEED.multiply(builder, multiplier);
	}
}