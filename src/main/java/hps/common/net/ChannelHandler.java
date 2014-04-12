package hps.common.net;

import hps.common.net.packets.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChannelHandler extends FMLIndexedMessageToMessageCodec<IPacket> {

	public ChannelHandler() {
		addDiscriminator(0, ItemStackPacket.class);
		addDiscriminator(1, SyncWorldData.class);
		addDiscriminator(2, SyncSpellPacket.class);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, IPacket packet, ByteBuf data) throws Exception {
		packet.writeBytes(data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data, IPacket packet) {
		try {
			packet.readBytes(data);
			EntityPlayer player;
			switch (FMLCommonHandler.instance().getEffectiveSide()) {
			case CLIENT:
				player = this.getClientPlayer();
				packet.executeClient(player);
				break;

			case SERVER:
				INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
				player = ((NetHandlerPlayServer) netHandler).playerEntity;
				packet.executeServer(player);
				break;

			default:
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	private EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}
}
