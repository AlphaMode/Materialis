package com.rcx.materialis.modifiers;

import javax.annotation.Nullable;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class PsishieldModifier extends Modifier {

	boolean enabled = FabricLoader.getInstance().isModLoaded("psi");

	@Override
	public int getPriority() {
		return 110; //before reinforced
	}

	@Override
	public int onDamageTool(IToolStackView tool, int level, int amount, @Nullable LivingEntity holder) {
		/*if (enabled && !tool.isBroken() && holder instanceof PlayerEntity) {
			PlayerData data = PlayerDataHandler.get((PlayerEntity) holder);
			if (!data.overflowed && (float) data.getAvailablePsi() / (float) data.getTotalPsi() > 0.5F) {
				int dealt = 0;
				for (int i = 0; i < amount; i++) {
					if (RANDOM.nextFloat() >= 0.1f * level) {
						dealt++;
					}
				}
				if (dealt != amount)
					data.deductPsi(150 * (amount - dealt), 0, true);
				return dealt;
			}
		}*/
		return amount;
	}
}