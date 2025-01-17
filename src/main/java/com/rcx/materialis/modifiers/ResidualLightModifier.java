package com.rcx.materialis.modifiers;

import com.rcx.materialis.MaterialisResources;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ResidualLightModifier extends NoLevelsModifier {

	@Override
	public int getPriority() {
		return Short.MIN_VALUE - 30; //after exchanging
	}

	@Override
	public void afterBlockBreak(IToolStackView tool, int level, ToolHarvestContext context) {
		if (context.getWorld().getBlockState(context.getPos()).isAir())
			context.getWorld().setBlock(context.getPos(), MaterialisResources.LIGHT_RESIDUE.get().defaultBlockState(), 3 | 64);
		else if (context.getWorld().getBlockState(context.getPos()).equals(Blocks.WATER.defaultBlockState()))
			context.getWorld().setBlock(context.getPos(), MaterialisResources.LIGHT_RESIDUE.get().defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true), 3 | 64);
	}

	@Override
	public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
		LivingEntity target = context.getLivingTarget();
		if (target != null && context.isFullyCharged() && target.isAlive()) {
			target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400, 0, false, true));
		}
		return 0;
	}
}