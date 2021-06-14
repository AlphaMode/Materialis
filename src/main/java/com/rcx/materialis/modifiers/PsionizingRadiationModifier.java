package com.rcx.materialis.modifiers;

import java.util.List;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.compat.TinkerToolSocketable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.ModList;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.recipe.tinkerstation.ValidatedResult;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.nbt.IModDataReadOnly;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.cad.ISocketable;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.common.core.handler.PlayerDataHandler;
import vazkii.psi.common.core.handler.PlayerDataHandler.PlayerData;
import vazkii.psi.common.item.ItemCAD;
import vazkii.psi.common.item.tool.IPsimetalTool;

public class PsionizingRadiationModifier extends Modifier {

	boolean enabled = ModList.get().isLoaded("psi");
	static final ValidatedResult SLOT_NOT_EMPTY = ValidatedResult.failure(Util.makeDescriptionId("recipe", new ResourceLocation(Materialis.modID, "remove_modifier.spell_slot_not_empty")));

	public PsionizingRadiationModifier() {
		super(0xB6A9E7);
	}

	@Override
	public int getPriority() {
		return 200; //before most other things
	}

	@Override
	public ValidatedResult validate(IModifierToolStack tool, int level) {
		//check if there are still spells in the sockets that are being removed
		if (enabled && tool instanceof ToolStack) {
			for (int l = level; l < ISocketable.MAX_ASSEMBLER_SLOTS; l++) {
				if (tool.getPersistentData().contains(TinkerToolSocketable.SPELL_SLOTS[l], NBT.TAG_COMPOUND))
					return SLOT_NOT_EMPTY;
			}
		}
		//remove tags if modifier is removed
		if (level == 0) {
			tool.getPersistentData().remove(TinkerToolSocketable.SELECTED_SPELL);
		}
		return ValidatedResult.PASS;
	}

	@Override
	public void addVolatileData(ToolDefinition toolDefinition, StatsNBT baseStats, IModDataReadOnly persistentData, int level, ModDataNBT volatileData) {
		if (!enabled)
			return;
		if (volatileData.contains(TinkerToolSocketable.SOCKETS, NBT.TAG_INT)) {
			volatileData.putInt(TinkerToolSocketable.SOCKETS, volatileData.getInt(TinkerToolSocketable.SOCKETS) + level);
		} else {
			volatileData.putInt(TinkerToolSocketable.SOCKETS, level);
		}
	}

	@Override
	public Boolean removeBlock(IModifierToolStack tool, int level, PlayerEntity player, World world, BlockPos pos, BlockState state, boolean canHarvest, boolean isEffective) {
		if (enabled && !tool.isBroken()) {
			BlockRayTraceResult blockLocation = IPsimetalTool.raytraceFromEntity(player.getCommandSenderWorld(), player, RayTraceContext.FluidMode.NONE, player.getAttributes().getValue(ForgeMod.REACH_DISTANCE.get()));
			//level 2 unlocks aoe harvest casting
			if (!blockLocation.getBlockPos().equals(pos)) {
				if (level < 2)
					return null;
				blockLocation = blockLocation.withPosition(pos);
			}
			ItemStack toolStack = player.getMainHandItem();
			if (tool instanceof ToolStack)
				toolStack = ((ToolStack) tool).createStack();
			if (!TinkerTags.Items.HARVEST_PRIMARY.getValues().contains(toolStack.getItem()))
				return null;
			PlayerData data = PlayerDataHandler.get(player);
			ItemStack playerCad = PsiAPI.getPlayerCAD(player);

			if (!playerCad.isEmpty()) {
				ItemStack bullet = ISocketable.socketable(toolStack).getSelectedBullet();
				final ItemStack finalTool = toolStack;
				final BlockRayTraceResult finalLoc = blockLocation;
				ItemCAD.cast(player.getCommandSenderWorld(), player, data, bullet, playerCad, 5, 10, 0.05F, (SpellContext context) -> {
					context.tool = finalTool;
					context.positionBroken = finalLoc;
				});
			}
		}
		return null;
	}

	@Override
	public int afterLivingHit(IModifierToolStack tool, int level, LivingEntity attacker, LivingEntity target, float damageDealt, boolean isCritical, float cooldown) {
		if (enabled && !tool.isBroken() && attacker instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) attacker;
			//level 2 unlocks aoe attack casting
			if (level < 2) {
				EntityRayTraceResult hit = raytraceHitFromEntity(player, player.getAttributes().getValue(ForgeMod.REACH_DISTANCE.get()));
				if (hit != null) {
					if (!hit.getEntity().equals(target))
						return 0;
				} else
					return 0;
			}
			ItemStack toolStack = player.getMainHandItem();
			if (tool instanceof ToolStack)
				toolStack = ((ToolStack) tool).createStack();
			if (!TinkerTags.Items.MELEE_PRIMARY.getValues().contains(toolStack.getItem()))
				return 0;
			PlayerData data = PlayerDataHandler.get(player);
			ItemStack playerCad = PsiAPI.getPlayerCAD(player);

			if (!playerCad.isEmpty()) {
				ItemStack bullet = ISocketable.socketable(toolStack).getSelectedBullet();
				final ItemStack finalTool = toolStack;
				ItemCAD.cast(player.getCommandSenderWorld(), player, data, bullet, playerCad, 5, 10, 0.05F, (SpellContext context) -> {
					context.attackedEntity = target;
					context.tool = finalTool;
				});
			}
		}
		return 0;
	}

	@Override
	public void addInformation(IModifierToolStack tool, int level, List<ITextComponent> tooltip, boolean isAdvanced, boolean detailed) {
		if (enabled && tool instanceof ToolStack) {
			ITextComponent componentName = ISocketable.getSocketedItemName(((ToolStack) tool).createStack(), "psimisc.none");
			tooltip.add(new TranslationTextComponent("psimisc.spell_selected", componentName));
		}
	}

	public static EntityRayTraceResult raytraceHitFromEntity(LivingEntity entity, double range) {
		Vector3d start = entity.getEyePosition(1F);
		Vector3d look = entity.getLookAngle();
		Vector3d direction = start.add(look.x * range, look.y * range, look.z * range);
		AxisAlignedBB bb = entity.getBoundingBox().expandTowards(look.x * range, look.y * range, look.z * range).expandTowards(1, 1, 1);
		return ProjectileHelper.getEntityHitResult(entity.level, entity, start, direction, bb, e -> canHitEntity(entity, e));
	}

	public static boolean canHitEntity(LivingEntity attacker, Entity target) {
		if (!target.isSpectator() && target instanceof LivingEntity && target.isPickable()) {
			return !attacker.isPassengerOfSameVehicle(target) && !target.noPhysics && (attacker.getVehicle() == null || !attacker.getVehicle().equals(target));
		}
		return false;
	}
}