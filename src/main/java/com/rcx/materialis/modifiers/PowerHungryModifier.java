package com.rcx.materialis.modifiers;

import javax.annotation.Nullable;

import com.rcx.materialis.util.TinkerToolFluxed;

import io.github.fabricators_of_create.porting_lib.event.common.PlayerBreakSpeedCallback;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class PowerHungryModifier extends CapacitorModifier {

	private static final int ENERGY_COST = 100;

	@Override
	public int getPriority() {
		return 160; //before overslime >:)
	}

	@Override
	public int onDamageTool(IToolStackView tool, int level, int amount, @Nullable LivingEntity holder) {
		TinkerToolFluxed.removeEnergy(tool, ENERGY_COST * level, false, true);
		return amount;
	}

	@Override
	public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
		if (TinkerToolFluxed.removeEnergy(tool, ENERGY_COST * level, true, false)) {
			return damage;
		}
		return damage / 1.5f;
	}

	@Override
	public void onBreakSpeed(IToolStackView tool, int level, PlayerBreakSpeedCallback.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
		if (!TinkerToolFluxed.removeEnergy(tool, ENERGY_COST * level, true, false)) {
			event.newSpeed = event.newSpeed / 1.5f;
		}
	}

	@Override
	public int getCapacity() {
		return 10000;
	}
}