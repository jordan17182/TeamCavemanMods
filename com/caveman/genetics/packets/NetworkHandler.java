package com.tks.genetics.packets;

import io.netty.channel.ChannelHandler.Sharable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;

@Sharable
public class NetworkHandler {
	 @SubscribeEvent
	 public void onServerPacket(ServerCustomPacketEvent e) {
		 System.out.println("Server received packet from player");
         ProcessPacketServerSide.processPacketOnServer(e.packet.payload(), e.packet.getTarget(), thePlayer);
	 }
	 @SubscribeEvent
	 public void onClientPacket(ClientCustomPacketEvent e) {
		 System.out.println("Client received packet from server");
         ProcessPacketClientSide.processPacketOnClient(e.packet.payload(), e.packet.getTarget());
	 }
}
