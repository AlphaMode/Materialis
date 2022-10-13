package com.rcx.materialis.util;

import com.rcx.materialis.modifiers.TerrabeamModifier;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.InteractionHand;


public class PacketTerraBeam implements C2SPacket {

	public PacketTerraBeam() {}

	public PacketTerraBeam(FriendlyByteBuf buf) {}

	@Override
	public void encode(FriendlyByteBuf buf) {}

	public void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl listener, PacketSender responseSender, SimpleChannel channel) {
		server.execute(() -> TerrabeamModifier.BurstHandler.trySpawnBurst(player, InteractionHand.MAIN_HAND, true, true));
	}
}
