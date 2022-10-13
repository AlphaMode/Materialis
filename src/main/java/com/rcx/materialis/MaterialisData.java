package com.rcx.materialis;

import com.rcx.materialis.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

public class MaterialisData implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        var existingData = System.getProperty("com.rcx.materialis.existingData").split(";");
        ExistingFileHelper existingFileHelper = new ExistingFileHelper(Arrays.stream(existingData).map(Paths::get).toList(), Collections.singleton("tconstruct"),
                true, null, null);

        gen.addProvider(new MaterialisLang(gen));
        ItemModelProvider itemModels = new MaterialisItemModels(gen, existingFileHelper);
        gen.addProvider(itemModels);
        gen.addProvider(new MaterialisBlockStates(gen, existingFileHelper));
        MaterialisMaterialTextures materialSprites = new MaterialisMaterialTextures();
        MaterialisPartTextures partSprites = new MaterialisPartTextures();
        TinkerMaterialSpriteProvider tinkerMaterialSprites = new TinkerMaterialSpriteProvider();
        gen.addProvider(new MaterialisRenderInfo(gen, materialSprites));
        gen.addProvider(new GeneratorPartTextureJsonGenerator(gen, Materialis.modID, partSprites));
        //generate tinkers parts with materialis materials
//        gen.addProvider(new MaterialPartTextureGenerator(gen, existingFileHelper, new TinkerPartSpriteProvider(), materialSprites));
//        //generate materialis parts with tinkers and materialis materials
//        gen.addProvider(new MaterialPartTextureGenerator(gen, existingFileHelper, partSprites, materialSprites, tinkerMaterialSprites));

        gen.addProvider(new MaterialisLootTables(gen));
        gen.addProvider(new MaterialisRecipes(gen));
        gen.addProvider(new MaterialisModifiers(gen));
        gen.addProvider(new MaterialisFluidSpills(gen));
        FabricTagProvider.BlockTagProvider blockTags = new MaterialisBlockTags(gen);
        gen.addProvider(blockTags);
        gen.addProvider(new MaterialisItemTags(gen, blockTags));
        gen.addProvider(new MaterialisFluidTags(gen));
        AbstractMaterialDataProvider materials = new MaterialisMaterials(gen);
        gen.addProvider(materials);
        gen.addProvider(new MaterialisMaterials.MaterialisMaterialStats(gen, materials));
        gen.addProvider(new MaterialisMaterials.MaterialisMaterialTraits(gen, materials));
        gen.addProvider(new MaterialisToolDefinitions(gen));
        gen.addProvider(new MaterialisToolSlotLayouts(gen));
    }
}
