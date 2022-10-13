package com.rcx.materialis.modifiers;

import io.github.fabricators_of_create.porting_lib.event.common.PlayerBreakSpeedCallback;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.state.BlockState;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class UnderlordModifier extends Modifier {

	@Override
	public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
		if (Registry.ENTITY_TYPE.getKey(context.getTarget().getType()).getNamespace().equals("undergarden") && context.getTarget().canChangeDimensions())
			return damage * (1.0f + 0.5f * level);
		return damage;
	}

	@Override
	public void onBreakSpeed(IToolStackView tool, int level, PlayerBreakSpeedCallback.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
		BlockState state = event.state;
		if (isEffective && state != null && state.getBlock().getRegistryName().getNamespace().equals("undergarden"))
			event.newSpeed = event.newSpeed * (1.0f + 0.25f * level);
	}
}