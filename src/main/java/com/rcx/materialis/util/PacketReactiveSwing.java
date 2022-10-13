package com.rcx.materialis.util;

import com.rcx.materialis.datagen.MaterialisModifiers;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class PacketReactiveSwing implements C2SPacket {

	public PacketReactiveSwing() {}

	public PacketReactiveSwing(FriendlyByteBuf buf) {}

	public void encode(FriendlyByteBuf buf) {}

	public void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl listener, PacketSender responseSender, SimpleChannel channel) {
		server.execute(() -> MaterialisModifiers.reactiveModifier.get().recieveLeftClick(player));
	}
}
