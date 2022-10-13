package com.rcx.materialis.modifiers;

import java.util.Random;

import com.rcx.materialis.datagen.MaterialisModifiers;
import com.rcx.materialis.util.MaterialisPacketHandler;
import com.rcx.materialis.util.PacketTerraBeam;

import io.github.fabricators_of_create.porting_lib.event.common.AttackAirCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.util.OffhandCooldownTracker;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.modifiers.ability.tool.OffhandAttackModifier;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.handler.ModSounds;
import vazkii.botania.common.item.ModItems;

public class TerrabeamModifier extends Modifier {

	public static boolean enabled = FabricLoader.getInstance().isModLoaded("botania");
	public static int MANA_PER_BEAM = 100;
	public static float CHANCE = 0.4f;
	public static Random rand = new Random();

	public TerrabeamModifier() {
		if (enabled)
			AttackAirCallback.EVENT.register(this::leftClick);
	}

	private void leftClick(Player player) {
		if (enabled && !player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
			ToolStack tool = getHeldTool(player, InteractionHand.MAIN_HAND);
			if (tool != null && tool.getModifierLevel(this) > 0) {
				MaterialisPacketHandler.INSTANCE.sendToServer(new PacketTerraBeam());
			}
		}
	}

	@Override
	public InteractionResult onToolUse(IToolStackView tool, int level, Level world, Player player, InteractionHand hand, EquipmentSlot slotType) {
		if (enabled && !tool.isBroken() && hand == InteractionHand.OFF_HAND && OffhandCooldownTracker.isAttackReady(player) && OffhandCooldownTracker.getCooldown(player) == 1 && tool.getVolatileData().getBoolean(OffhandAttackModifier.DUEL_WIELDING)) {
			BurstHandler.trySpawnBurst(player, hand, true, false);
		}
		return InteractionResult.PASS;
	}

	@Override
	public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
		if (enabled && context.getAttacker() instanceof Player && context.isFullyCharged())
			BurstHandler.trySpawnBurst((Player) context.getAttacker(), context.getHand(), false, false);
		return 0;
	}

	public static class BurstHandler { //this is in a separate class to make sure it doesn't try to load botania classes when botania isn't installed

		public static ItemStack sword = new ItemStack(ModItems.terraSword);

		public static void trySpawnBurst(Player player, InteractionHand hand, boolean nothingForFree, boolean checkCooldown) {
			if (enabled && !player.getItemInHand(hand).isEmpty() && (!checkCooldown || player.getAttackStrengthScale(0) == 1)) {
				ToolStack tool = getHeldTool(player, hand);
				if (tool != null && tool.getModifierLevel(MaterialisModifiers.elvenBeamModifier.get()) < 1) {
					int level = tool.getModifierLevel(MaterialisModifiers.terrabeamModifier.get());
					if (level > 0 && (level * CHANCE > 1.0f || rand.nextFloat() < level * CHANCE)) {
						EntityManaBurst burst = BurstHandler.getBurst(player);
						player.level.addFreshEntity(burst);
						if (nothingForFree)
							if (!ManaItemHandler.instance().requestManaExactForTool(player.getMainHandItem(), player, MANA_PER_BEAM, true))
								player.getMainHandItem().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
						player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.terraBlade, SoundSource.PLAYERS, 0.4F, 1.4F);
					}
				}
			}
		}

		public static EntityManaBurst getBurst(Player player) {
			EntityManaBurst burst = new EntityManaBurst(player);
			float motionModifier = 7F;
			burst.setColor(0x20FF20);
			burst.setMana(MANA_PER_BEAM);
			burst.setStartingMana(MANA_PER_BEAM);
			burst.setMinManaLoss(40);
			burst.setManaLossPerTick(4F);
			burst.setGravity(0F);
			burst.setDeltaMovement(burst.getDeltaMovement().scale(motionModifier));
			burst.setSourceLens(sword);
			return burst;
		}
	}
}