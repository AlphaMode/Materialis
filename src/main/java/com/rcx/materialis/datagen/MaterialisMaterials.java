package com.rcx.materialis.datagen;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.modifiers.MaterialisModifiers;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.OrCondition;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.json.ConfigEnabledCondition;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.json.MaterialJson.Redirect;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

public class MaterialisMaterials extends AbstractMaterialDataProvider {

	public static final MaterialId fairy = createMaterial("fairy");

	//general oredict materials
	public static final MaterialId brass = createMaterial("brass");
	public static final MaterialId aluminum = createMaterial("aluminum");
	public static final MaterialId nickel = createMaterial("nickel");
	public static final MaterialId platinum = createMaterial("platinum");
	public static final MaterialId uranium = createMaterial("uranium");
	public static final MaterialId osmium = createMaterial("osmium");
	public static final MaterialId tungsten = createMaterial("tungsten");
	public static final MaterialId invar = createMaterial("invar");

	//create materials
	public static final MaterialId roseQuartz = createMaterial("rose_quartz");
	public static final MaterialId refinedRadiance = createMaterial("refined_radiance");
	public static final MaterialId shadowSteel = createMaterial("shadow_steel");

	//eidolon materials
	public static final MaterialId pewter = createMaterial("pewter");
	public static final MaterialId arcaneGold = createMaterial("arcane_gold");

	//aquaculture materials
	public static final MaterialId neptunium = createMaterial("neptunium");

	//mystical world materials
	public static final MaterialId quicksilver = createMaterial("quicksilver");

	//astral sorcery materials
	public static final MaterialId starmetal = createMaterial("starmetal");

	//industrial foregoing materials
	public static final MaterialId plastic = createMaterial("plastic");
	public static final MaterialId pinkSlime = createMaterial("pink_slime");

	//undergarden materials
	public static final MaterialId cloggrum = createMaterial("cloggrum");
	public static final MaterialId froststeel = createMaterial("froststeel");
	public static final MaterialId utherium = createMaterial("utherium");
	public static final MaterialId forgottenMetal = createMaterial("forgotten_metal");

	//mekanism materials
	public static final MaterialId refinedObsidian = createMaterial("refined_obsidian");
	public static final MaterialId refinedGlowstone = createMaterial("refined_glowstone");

	//psi materials
	public static final MaterialId psimetal = createMaterial("psimetal");
	public static final MaterialId ebonyPsimetal = createMaterial("ebony_psimetal");
	public static final MaterialId ivoryPsimetal = createMaterial("ivory_psimetal");

	//occultism materials
	public static final MaterialId iesnium = createMaterial("iesnium");

	//botania materials
	public static final MaterialId livingwood = createMaterial("livingwood");
	public static final MaterialId dreamwood = createMaterial("dreamwood");
	public static final MaterialId manasteel = createMaterial("manasteel");
	public static final MaterialId elementium = createMaterial("elementium");
	public static final MaterialId terrasteel = createMaterial("terrasteel");

	//mythicbotany materials
	public static final MaterialId alfsteel = createMaterial("alfsteel");

	//draconic evolution materials
	public static final MaterialId draconium = createMaterial("draconium");
	public static final MaterialId awakenedDraconium = createMaterial("draconium_awakened");

	//redstone arsenal materials
	public static final MaterialId fluxInfused = createMaterial("flux_infused");

	public MaterialisMaterials(DataGenerator gen) {
		super(gen);
	}

	@Override
	public String getName() {
		return "Materialis Materials";
	}

	@Override
	protected void addMaterials() {
		addMaterial(fairy, 3, ORDER_NETHER + ORDER_COMPAT, false, 0xFF87BC);
		//general oredict materials
		addCompatMetalMaterial(brass, 3, ORDER_WEAPON + ORDER_COMPAT, 0xFFD359);
		addCompatMetalMaterial(aluminum, 2, ORDER_HARVEST + ORDER_COMPAT, 0xE6B7BF);
		addCompatMetalMaterial(nickel, 2, ORDER_HARVEST + ORDER_COMPAT, 0xF9EA98);
		//addCompatMetalMaterial(platinum, 3, ORDER_HARVEST + ORDER_COMPAT, 0xA1FFFF);
		this.addRedirect(platinum, new Redirect(new ResourceLocation(TConstruct.MOD_ID, "platinum"), null));
		addCompatMetalMaterial(uranium, 2, ORDER_HARVEST + ORDER_COMPAT, 0x42BE30);
		//addCompatMetalMaterial(osmium, 2, ORDER_WEAPON + ORDER_COMPAT, 0xCDE8FD);
		this.addRedirect(osmium, new Redirect(new ResourceLocation(TConstruct.MOD_ID, "osmium"), null));
		//addCompatMetalMaterial(tungsten, 3, ORDER_WEAPON + ORDER_COMPAT, 0xA7A88F);
		this.addRedirect(tungsten, new Redirect(new ResourceLocation(TConstruct.MOD_ID, "tungsten"), null));
		//addCompatMetalMaterial(invar, 3, ORDER_HARVEST + ORDER_COMPAT, 0xBAE6D5);
		this.addRedirect(invar, new Redirect(new ResourceLocation(TConstruct.MOD_ID, "invar"), null));
		//create materials
		addMaterial(roseQuartz, 3, ORDER_NETHER + ORDER_COMPAT, true, 0xFF8C80, false, new OrCondition(ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS, new ModLoadedCondition("create")));
		addCompatMetalMaterial(refinedRadiance, 4, ORDER_SPECIAL + ORDER_COMPAT, 0xFFFFFF);
		addCompatMetalMaterial(shadowSteel, 4, ORDER_SPECIAL + ORDER_COMPAT, 0x635D71);
		//eidolon materials
		addCompatMetalMaterial(pewter, 3, ORDER_HARVEST + ORDER_COMPAT, 0xA1A097);
		addCompatMetalMaterial(arcaneGold, 3, ORDER_WEAPON + ORDER_COMPAT, 0xFFC069);
		//aquaculture materials
		addCompatMetalMaterial(neptunium, 3, ORDER_GENERAL + ORDER_COMPAT, 0x17F1B6);
		//mystical world materials
		addCompatMetalMaterial(quicksilver, 2, ORDER_HARVEST + ORDER_COMPAT, 0xC6B69F);
		//astral sorcery materials
		addCompatMetalMaterial(starmetal, 3, ORDER_HARVEST + ORDER_COMPAT, 0x003CC9);
		//industrial foregoing materials
		addMaterial(plastic, 2, ORDER_HARVEST + ORDER_COMPAT, true, 0xD9D9D9, false, new OrCondition(ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS, new NotCondition(new TagEmptyCondition("forge:plastic"))));
		addCompatMetalMaterial(pinkSlime, 3, ORDER_GENERAL + ORDER_COMPAT, 0xFF9FEF);
		//undergarden materials
		addCompatMetalMaterial(cloggrum, 2, ORDER_HARVEST + ORDER_COMPAT, 0x9C8878);
		addCompatMetalMaterial(froststeel, 2, ORDER_WEAPON + ORDER_COMPAT, 0x95BDE3);
		addCompatMetalMaterial(utherium, 3, ORDER_WEAPON + ORDER_COMPAT, 0xEB515B);
		addMaterial(forgottenMetal, 3, ORDER_GENERAL + ORDER_COMPAT, false, 0x6CD7AA, false, new OrCondition(ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS, new NotCondition(new TagEmptyCondition("forge:ingots/forgotten_metal"))));
		//mekanism materials
		addCompatMetalMaterial(refinedObsidian, 3, ORDER_HARVEST + ORDER_COMPAT, 0xB78FD2);
		addCompatMetalMaterial(refinedGlowstone, 3, ORDER_WEAPON + ORDER_COMPAT, 0xFFE55C);
		//psi materials
		addCompatMetalMaterial(psimetal, 2, ORDER_SPECIAL + ORDER_COMPAT, 0xB6A9E7);
		addCompatMetalMaterial(ebonyPsimetal, 3, ORDER_SPECIAL + ORDER_COMPAT, 0x3D3838);
		addCompatMetalMaterial(ivoryPsimetal, 3, ORDER_SPECIAL + ORDER_COMPAT, 0xF6F9ED);
		//occultism materials
		addCompatMetalMaterial(iesnium, 4, ORDER_HARVEST + ORDER_COMPAT, 0x8ADAE3);
		//botania materials
		addMaterial(livingwood, 1, ORDER_WEAPON + ORDER_COMPAT, true, 0x783519, false, new OrCondition(ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS, new ModLoadedCondition("botania")));
		addMaterial(dreamwood, 2, ORDER_HARVEST + ORDER_COMPAT, true, 0xC1CCCC, false, new OrCondition(ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS, new ModLoadedCondition("botania")));
		addCompatMetalMaterial(manasteel, 2, ORDER_HARVEST + ORDER_COMPAT, 0x3389FF);
		addCompatMetalMaterial(elementium, 3, ORDER_WEAPON + ORDER_COMPAT, 0xF15CAE);
		addCompatMetalMaterial(terrasteel, 4, ORDER_WEAPON + ORDER_COMPAT, 0x53F900);
		//mythicbotany materials
		addCompatMetalMaterial(alfsteel, 4, ORDER_WEAPON + ORDER_COMPAT, 0xFFC74E);
		//draconic evolution materials
		addCompatMetalMaterial(draconium, 4, ORDER_GENERAL + ORDER_COMPAT, 0x905EBE);
		addCompatMetalMaterial(awakenedDraconium, 4, ORDER_GENERAL + ORDER_COMPAT, 0xFF8800);
		//redstone arsenal materials
		addCompatMetalMaterial(fluxInfused, 3, ORDER_GENERAL + ORDER_COMPAT, 0xE68A29);
	}

	private static MaterialId createMaterial(String name) {
		return new MaterialId(new ResourceLocation(Materialis.modID, name));
	}

	public static class MaterialisMaterialTraits extends AbstractMaterialTraitDataProvider {

		public MaterialisMaterialTraits(DataGenerator gen, AbstractMaterialDataProvider materials) {
			super(gen, materials);
		}

		@Override
		public String getName() {
			return "Materialis Material Traits";
		}

		@Override
		protected void addMaterialTraits() {
			addDefaultTraits(fairy, MaterialisModifiers.daredevilModifier.get());
			//general oredict materials
			addDefaultTraits(brass, MaterialisModifiers.polishedModifier.get());
			addDefaultTraits(aluminum, MaterialisModifiers.featherweightModifier.get());
			addDefaultTraits(nickel, MaterialisModifiers.refuelingModifier.get());
			//addDefaultTraits(platinum, MaterialisModifiers.brittleModifier.get());
			addDefaultTraits(uranium, MaterialisModifiers.halfLifeModifier.get());
			//addDefaultTraits(osmium, MaterialisModifiers.adrenalineModifier.get());
			//addDefaultTraits(tungsten, MaterialisModifiers.workHardenedModifier.get());
			//addDefaultTraits(invar, MaterialisModifiers.quenchingModifier.get());
			//create materials
			addDefaultTraits(roseQuartz, MaterialisModifiers.enhancedQuartzModifier.get());
			addDefaultTraits(refinedRadiance, MaterialisModifiers.residualLightModifier.get());
			addDefaultTraits(shadowSteel, MaterialisModifiers.voidingModifier.get());
			//eidolon materials
			addDefaultTraits(pewter, MaterialisModifiers.inertiaModifier.get());
			addDefaultTraits(arcaneGold, MaterialisModifiers.arcaneModifier.get());
			//aquaculture materials
			addDefaultTraits(neptunium, MaterialisModifiers.neptunesBlessingModifier.get());
			//mystical world materials
			addDefaultTraits(quicksilver, MaterialisModifiers.decayModifier.get());
			//astral sorcery materials
			addDefaultTraits(starmetal, MaterialisModifiers.nocturnalModifier.get());
			//industrial foregoing materials
			addDefaultTraits(plastic, MaterialisModifiers.feebleModifier.get());
			addDefaultTraits(pinkSlime, MaterialisModifiers.overeatingModifier.get(), TinkerModifiers.overslime.get());
			//undergarden materials
			addDefaultTraits(cloggrum, MaterialisModifiers.economicalModifier.get());
			addDefaultTraits(froststeel, MaterialisModifiers.freezingModifier.get());
			addDefaultTraits(utherium, MaterialisModifiers.cleansingModifier.get());
			addDefaultTraits(forgottenMetal, MaterialisModifiers.oldTimerModifier.get(), MaterialisModifiers.underlordModifier.get());
			//mekanism materials
			addDefaultTraits(refinedObsidian, MaterialisModifiers.shortSightedModifier.get());
			addDefaultTraits(refinedGlowstone, MaterialisModifiers.auxiliaryPowerModifier.get());
			//psi materials
			addDefaultTraits(psimetal, MaterialisModifiers.psionizingRadiationModifier.get());
			addDefaultTraits(ebonyPsimetal, MaterialisModifiers.lesserPsionizingRadiationModifier.get(), MaterialisModifiers.psichoKillerModifier.get());
			addDefaultTraits(ivoryPsimetal, MaterialisModifiers.lesserPsionizingRadiationModifier.get(), MaterialisModifiers.psichoDiggerModifier.get());
			//occultism materials
			addDefaultTraits(iesnium, MaterialisModifiers.otherworldly2Modifier.get());
			//botania materials
			addDefaultTraits(livingwood, MaterialisModifiers.manaripperModifier.get());
			addDefaultTraits(dreamwood, MaterialisModifiers.manaburnerModifier.get());
			addDefaultTraits(manasteel, new ModifierEntry(MaterialisModifiers.manashieldModifier.get(), 2));
			addDefaultTraits(elementium, MaterialisModifiers.manashieldModifier.get(), MaterialisModifiers.pixiecallerModifier.get());
			addDefaultTraits(terrasteel, MaterialisModifiers.manashieldModifier.get(), MaterialisModifiers.terrabeamModifier.get());
			//mythicbotany materials
			addDefaultTraits(alfsteel, MaterialisModifiers.manashieldModifier.get(), MaterialisModifiers.elvenBeamModifier.get());
			//draconic evolution materials
			addDefaultTraits(draconium, new ModifierEntry(MaterialisModifiers.powerHungryModifier.get(), 1), new ModifierEntry(MaterialisModifiers.fluxshieldModifier.get(), 2));
			addDefaultTraits(awakenedDraconium, new ModifierEntry(MaterialisModifiers.powerHungryModifier.get(), 2), new ModifierEntry(MaterialisModifiers.fluxripperModifier.get(), 1), new ModifierEntry(MaterialisModifiers.fluxburnerModifier.get(), 1));
			//redstone arsenal materials
			addDefaultTraits(fluxInfused, MaterialisModifiers.fluxripperModifier.get(), MaterialisModifiers.fluxburnerModifier.get());
		}
	}

	public static class MaterialisMaterialStats extends AbstractMaterialStatsDataProvider {

		public MaterialisMaterialStats(DataGenerator gen, AbstractMaterialDataProvider materials) {
			super(gen, materials);
		}

		@Override
		public String getName() {
			return "Materialis Material Stats";
		}

		@Override
		protected void addMaterialStats() {
			addMaterialStats(fairy, new HeadMaterialStats(250, 7.5f, 2, 2f), new HandleMaterialStats(0.9f, 1.15f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//general oredict materials
			addMaterialStats(brass, new HeadMaterialStats(450, 7.5f, 2, 2f), new HandleMaterialStats(0.9f, 1.1f, 1.1f, 1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(aluminum, new HeadMaterialStats(220, 5f, 2, 1f), new HandleMaterialStats(0.9f, 1.1f, 1.1f, 0.9f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(nickel, new HeadMaterialStats(520, 5f, 2, 1.5f), new HandleMaterialStats(1f, 0.9f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//(platinum, new HeadMaterialStats(100, 11f, 3, 1.5f), new HandleMaterialStats(0.7f, 1.25f, 1.25f, 0.8f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(uranium, new HeadMaterialStats(689, 7f, 2, 2f), new HandleMaterialStats(0.9f, 0.9f, 0.9f, 1.1f), ExtraMaterialStats.DEFAULT);
			//addMaterialStats(osmium, new HeadMaterialStats(360, 4f, 2, 2f), new HandleMaterialStats(1.1f, 1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//addMaterialStats(tungsten, new HeadMaterialStats(740, 7f, 3, 2.5f), new HandleMaterialStats(1f, 1f, 0.9f, 1.2f), ExtraMaterialStats.DEFAULT);
			//addMaterialStats(invar, new HeadMaterialStats(710, 6f, 3, 2f), new HandleMaterialStats(1.2f, 1f, 0.9f, 1f), ExtraMaterialStats.DEFAULT);
			//create materials
			addMaterialStats(roseQuartz, new HeadMaterialStats(175, 4f, 2, 3f), new HandleMaterialStats(0.5f, 1f, 1f, 1.1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(refinedRadiance, new HeadMaterialStats(999, 9f, 4, 3f), new HandleMaterialStats(0.5f, 1f, 1f, 1.3f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(shadowSteel, new HeadMaterialStats(1300, 10f, 4, 3.5f), new HandleMaterialStats(1f, 1f, 1.1f, 1.1f), ExtraMaterialStats.DEFAULT);
			//eidolon materials
			addMaterialStats(pewter, new HeadMaterialStats(325, 6.5f, 2, 1f), new HandleMaterialStats(1f, 1f, 0.9f, 1.05f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(arcaneGold, new HeadMaterialStats(200, 9f, 2, 2f), new HandleMaterialStats(0.8f, 1.1f, 1.1f, 1f), ExtraMaterialStats.DEFAULT);
			//aquaculture materials
			addMaterialStats(neptunium, new HeadMaterialStats(1450, 8f, 3, 3f), new HandleMaterialStats(1.1f, 0.9f, 1f, 0.9f), ExtraMaterialStats.DEFAULT);
			//mystical world materials
			addMaterialStats(quicksilver, new HeadMaterialStats(75, 6f, 3, 2f), new HandleMaterialStats(0.25f, 1.2f, 1.2f, 1f), ExtraMaterialStats.DEFAULT);
			//astral sorcery materials
			addMaterialStats(starmetal, new HeadMaterialStats(340, 6f, 2, 1.5f), new HandleMaterialStats(1.1f, 1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//industrial foregoing materials
			addMaterialStats(plastic, new HeadMaterialStats(200, 4f, 2, 1f), new HandleMaterialStats(0.8f, 1f, 1.15f, 1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(pinkSlime, new HeadMaterialStats(830, 7f, 3, 2f), new HandleMaterialStats(1f, 1.1f, 1.1f, 1f), ExtraMaterialStats.DEFAULT);
			//undergarden materials
			addMaterialStats(cloggrum, new HeadMaterialStats(286, 5f, 2, 1.5f), new HandleMaterialStats(1f, 1.1f, 0.8f, 1.1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(froststeel, new HeadMaterialStats(575, 6f, 3, 2f), new HandleMaterialStats(1.2f, 0.9f, 1f, 0.9f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(utherium, new HeadMaterialStats(852, 7f, 4, 2.5f), new HandleMaterialStats(1.1f, 1f, 0.9f, 1.1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(forgottenMetal, new HeadMaterialStats(921, 7.5f, 4, 3f), new HandleMaterialStats(1.2f, 0.9f, 1f, 0.9f), ExtraMaterialStats.DEFAULT);
			//mekanism materials
			addMaterialStats(refinedObsidian, new HeadMaterialStats(900, 9f, 3, 2f), new HandleMaterialStats(1.3f, 0.9f, 1f, 0.9f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(refinedGlowstone, new HeadMaterialStats(200, 7f, 2, 2.5f), new HandleMaterialStats(0.7f, 1.1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//psi materials
			addMaterialStats(psimetal, new HeadMaterialStats(330, 6f, 3, 2f), new HandleMaterialStats(1f, 1.05f, 1f, 1.05f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(ebonyPsimetal, new HeadMaterialStats(600, 5f, 4, 3f), new HandleMaterialStats(0.7f, 0.8f, 1f, 1.2f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(ivoryPsimetal, new HeadMaterialStats(600, 8f, 4, 1.5f), new HandleMaterialStats(1.1f, 1.2f, 0.9f, 0.9f), ExtraMaterialStats.DEFAULT);
			//occultism materials
			addMaterialStats(iesnium, new HeadMaterialStats(921, 7f, 3, 2f), new HandleMaterialStats(0.8f, 1.1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			//botania materials
			addMaterialStats(livingwood, new HeadMaterialStats(70, 3f, 1, 1f), new HandleMaterialStats(1.1f, 1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(dreamwood, new HeadMaterialStats(160, 4f, 1, 1.2f), new HandleMaterialStats(1f, 1.1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(manasteel, new HeadMaterialStats(300, 6.2f, 3, 1.5f), new HandleMaterialStats(1.1f, 1.1f, 1f, 1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(elementium, new HeadMaterialStats(720, 5f, 3, 2f), new HandleMaterialStats(0.8f, 1.1f, 1.2f, 0.9f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(terrasteel, new HeadMaterialStats(1000, 9f, 4, 3f), new HandleMaterialStats(0.9f, 1.1f, 1.1f, 1.15f), ExtraMaterialStats.DEFAULT);
			//mythicbotany materials
			addMaterialStats(alfsteel, new HeadMaterialStats(1430, 9f, 4, 3.2f), new HandleMaterialStats(0.9f, 1f, 1.15f, 1f), ExtraMaterialStats.DEFAULT);
			//draconic evolution materials
			addMaterialStats(draconium, new HeadMaterialStats(1000, 7f, 4, 2f), new HandleMaterialStats(0.8f, 1.1f, 1f, 1.1f), ExtraMaterialStats.DEFAULT);
			addMaterialStats(awakenedDraconium, new HeadMaterialStats(1500, 9f, 5, 3f), new HandleMaterialStats(1f, 1f, 1.1f, 1f), ExtraMaterialStats.DEFAULT);
			//redstone arsenal materials
			addMaterialStats(fluxInfused, new HeadMaterialStats(400, 6f, 4, 2.5f), new HandleMaterialStats(1f, 0.7f, 1.1f, 0.7f), ExtraMaterialStats.DEFAULT);
		}
	}
}
