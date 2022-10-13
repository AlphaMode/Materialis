package com.rcx.materialis.modifiers;

import io.github.fabricators_of_create.porting_lib.event.common.PlayerBreakSpeedCallback;
import net.minecraft.core.Direction;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class DaredevilModifier extends Modifier {

	@Override
	public void onBreakSpeed(IToolStackView tool, int level, PlayerBreakSpeedCallback.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
		float multiplier = level * (event.player.getMaxHealth() - event.player.getHealth()) / event.player.getMaxHealth() + 1.0f;
		event.newSpeed = event.newSpeed * multiplier;
	}
}