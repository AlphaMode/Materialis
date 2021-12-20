package com.rcx.materialis.item;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.rcx.materialis.Materialis;
import com.rcx.materialis.modifiers.PsionizingRadiationModifierSensor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import slimeknights.tconstruct.library.tools.ToolDefinition;
import slimeknights.tconstruct.library.tools.definition.ModifiableArmorMaterial;
import slimeknights.tconstruct.library.tools.item.ModifiableArmorItem;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.item.ArmorSlotType;
import top.theillusivec4.magipsi.client.FocusingPlateModel;
import vazkii.psi.api.exosuit.IExosuitSensor;
import vazkii.psi.client.model.ModelPsimetalExosuit;

public class ExosuitModelArmorItem extends ModifiableArmorItem implements IDyeableArmorItem {

	private LazyValue<BipedModel<?>> model;
	public String texture;
	public String overlayTexture;

	public ExosuitModelArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn, ToolDefinition toolDefinition) {
		super(materialIn, slot, builderIn, toolDefinition);
		this.initModel(slot);
	}

	public ExosuitModelArmorItem(ModifiableArmorMaterial material, ArmorSlotType slotType, Properties properties) {
		super(material, slotType, properties);
		this.initModel(slotType.getEquipmentSlot());
	}

	protected void initModel(EquipmentSlotType slot) {
		if (ModList.get().isLoaded("psi")) {
			if (ModList.get().isLoaded("magipsi")) {
				this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> MagicalExosuitModel.provideArmorModelForSlot(slot)), () -> () -> null);
				texture = Materialis.modID + ":textures/models/armor/" + new ResourceLocation(this.getMaterial().getName()).getPath() + "_magical.png";
				overlayTexture = Materialis.modID + ":textures/models/armor/" + new ResourceLocation(this.getMaterial().getName()).getPath() + "_magical_sensor.png";
			} else {
				this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> ExosuitModel.provideArmorModelForSlot(slot)), () -> () -> null);
				texture = Materialis.modID + ":textures/models/armor/" + new ResourceLocation(this.getMaterial().getName()).getPath() + ".png";
				overlayTexture = Materialis.modID + ":textures/models/armor/" + new ResourceLocation(this.getMaterial().getName()).getPath() + "_sensor.png";
			}
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		boolean overlay = type != null && type.equals("overlay");
		if (ModList.get().isLoaded("psi"))
			return overlay ? texture : overlayTexture;
		return super.getArmorTexture(stack, entity, slot, type);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getColor(@Nonnull ItemStack stack) {
		ItemStack sensor = ItemStack.of(ToolStack.copyFrom(stack).getVolatileData().getCompound(PsionizingRadiationModifierSensor.SENSOR));
		if (!sensor.isEmpty() && sensor.getItem() instanceof IExosuitSensor) {
			return ((IExosuitSensor) sensor.getItem()).getColor(sensor);
		}
		sensor = ItemStack.of(ToolStack.copyFrom(stack).getPersistentData().getCompound(PsionizingRadiationModifierSensor.SENSOR));
		if (!sensor.isEmpty() && sensor.getItem() instanceof IExosuitSensor) {
			return ((IExosuitSensor) sensor.getItem()).getColor(sensor);
		}
		return 0x82190A;
	}

	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A base) {
		if (ModList.get().isLoaded("psi"))
			return (A) model.get();
		return super.getArmorModel(entityLiving, itemStack, armorSlot, base);
	}

	public static class ExosuitModel {

		@OnlyIn(Dist.CLIENT)
		public static BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
			return new ModelPsimetalExosuit(slot);
		}
	}

	public static class MagicalExosuitModel {

		@OnlyIn(Dist.CLIENT)
		public static BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
			return new FocusingPlateModel(slot);
		}
	}
}