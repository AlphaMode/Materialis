package com.rcx.materialis.modifiers;

import com.rcx.materialis.util.MaterialisUtil;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

public class PsionizingRadiationModifierTick extends Modifier {

	@Override
	public int getPriority() {
		return 200; //before most other things
	}

	@Override
	public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
		MaterialisUtil.addToVolatileInt(PsionizingRadiationModifier.RADIATION_LEVEL, volatileData, level);
	}

	@Override
	public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
		/*if (isCorrectSlot && PsionizingRadiationModifier.enabled && !tool.isBroken() && holder != null && holder instanceof PlayerEntity && !tool.getVolatileData().getBoolean(PsionizingRadiationModifier.SUPPRESS_TOOLCASTING)) {
			PlayerEntity player = (PlayerEntity) holder;
			PlayerData data = PlayerDataHandler.get(player);
			ItemStack playerCad = PsiAPI.getPlayerCAD(player);

			if (!playerCad.isEmpty()) {
				int timesCast = tool.getPersistentData().getInt(TinkerToolSocketable.TIMES_CAST);
				ItemStack bullet = ISocketable.socketable(stack).getSelectedBullet();
				ItemCAD.cast(player.getCommandSenderWorld(), player, data, bullet, playerCad, 0, 0, 0F, (SpellContext spellContext) -> {
					spellContext.tool = stack;
					spellContext.loopcastIndex = timesCast;
				});
				tool.getPersistentData().putInt(TinkerToolSocketable.TIMES_CAST, timesCast + 1);
			}
		}*/
	}
}