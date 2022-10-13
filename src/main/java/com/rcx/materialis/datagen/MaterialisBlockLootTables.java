package com.rcx.materialis.datagen;

import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.MaterialisResources;
import com.rcx.materialis.MaterialisResources.IngotWithBlockNNugget;

import io.github.fabricators_of_create.porting_lib.data.ModdedBlockLoot;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

public class MaterialisBlockLootTables extends ModdedBlockLoot {

	@Nonnull
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return Registry.BLOCK.stream()
				.filter((block) -> Materialis.modID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
				.collect(Collectors.toList());
	}

	@Override
	protected void addTables() {
		for (IngotWithBlockNNugget material : MaterialisResources.materialList) {
			this.dropSelf(material.BLOCK.get());
		}
	}
}
