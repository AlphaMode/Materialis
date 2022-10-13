package com.rcx.materialis.util;

import com.rcx.materialis.Materialis;
import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.tools.capability.ToolCapabilityProvider.IToolCapabilityProvider;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import team.reborn.energy.api.EnergyStorage;

import java.util.function.Supplier;

public class TinkerToolFluxed extends SnapshotParticipant<Long> implements IToolCapabilityProvider, EnergyStorage {

	protected final Supplier<? extends IToolStackView> tool;
	public static final String STORED_ENERGY_KEY = "tooltip.materialis.stored_enegry";
	public static final ResourceLocation MAX_ENERGY = new ResourceLocation(Materialis.modID, "max_energy");
	public static final ResourceLocation STORED_ENERGY = new ResourceLocation(Materialis.modID, "stored_energy");
	public static final ResourceLocation ENERGY_OWNER = new ResourceLocation(Materialis.modID, "energy_owner");
	private static final int MAX_TRANSFER_RATE = 1000;

	public TinkerToolFluxed(ItemStack stack, Supplier<? extends IToolStackView> toolStack) {
		this.tool = toolStack;
		registerFallback();
	}

	public void registerFallback() {
		EnergyStorage.ITEM.registerFallback((itemStack, context) -> {
			if ( ToolStack.from(itemStack).getVolatileData().getInt(MAX_ENERGY) > 0) {
				return this;
			}
			return null;
		});
	}

	@Override
	public <T> LazyOptional<T> getCapability(IToolStackView tool, Class<T> cap) {
		return LazyOptional.empty();
	}

	@Override
	public long insert(long maxAmount, TransactionContext transaction) {
		return receiveEnergy(tool.get(), maxAmount, transaction);
	}

	@Override
	public long getAmount() {
		return getEnergyStored(tool.get());
	}

	@Override
	public long getCapacity() {
		return getMaxEnergyStored(tool.get());
	}

	public long receiveEnergy(IToolStackView tool, long maxReceive, TransactionContext simulate) {
		long energyStored = getEnergyStored(tool);
		long energyReceived = Math.min(getMaxEnergyStored(tool) - energyStored, Math.min(MAX_TRANSFER_RATE, maxReceive));
//		if (!simulate) {
		updateSnapshots(simulate);
			ModDataNBT persistentData = tool.getPersistentData();
			persistentData.putLong(STORED_ENERGY, energyStored + energyReceived);
//		}
		return energyReceived;
	}

	public static boolean removeEnergy(IToolStackView tool, int energyRemoved, boolean simulate, boolean drain) {
		long energyStored = getEnergyStored(tool);
		if (energyStored < energyRemoved) {
			if (drain && !simulate) {
				ModDataNBT persistentData = tool.getPersistentData();
				persistentData.putLong(STORED_ENERGY, 0);
			}
			return false;
		}
		if (!simulate) {
			ModDataNBT persistentData = tool.getPersistentData();
			persistentData.putLong(STORED_ENERGY, energyStored - energyRemoved);
		}
		return true;
	}

	public static long getEnergyStored(IToolStackView tool) {
		ModDataNBT persistentData = tool.getPersistentData();
		if (persistentData.contains(STORED_ENERGY, Tag.TAG_LONG))
			return persistentData.get(STORED_ENERGY, CompoundTag::getLong);
		return 0;
	}

	public static long getMaxEnergyStored(IToolStackView tool) {
		IModDataView volatileData = tool.getVolatileData();
		if (volatileData.contains(MAX_ENERGY, Tag.TAG_LONG))
			return volatileData.get(MAX_ENERGY, CompoundTag::getLong);
		return 0;
	}

	@Override
	public boolean supportsInsertion() {
		return true;
	}

	@Override
	public boolean supportsExtraction() {
		return false;
	}

	@Override
	public long extract(long maxAmount, TransactionContext transaction) {
		return 0;
	}

	@Override
	protected Long createSnapshot() {
		return getEnergyStored(tool.get());
	}

	@Override
	protected void readSnapshot(Long snapshot) {
		ModDataNBT persistentData = tool.get().getPersistentData();
		persistentData.putLong(STORED_ENERGY, snapshot);
	}
}
