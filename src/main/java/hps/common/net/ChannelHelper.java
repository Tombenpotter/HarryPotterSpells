package hps.common.net;

import hps.common.HarryPotterMod;
import hps.common.net.packets.IPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

public class ChannelHelper {
	/**
	 * Send Packet message to everyone.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 * 
	 * @param message
	 *            The message to send
	 */
	public static void sendToAll(IPacket message) {
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		HarryPotterMod.channels.get(Side.SERVER).writeAndFlush(message);
	}

	/**
	 * Send Packet message to the specified player.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 * 
	 * @param message
	 *            The message to send
	 * @param player
	 *            The player to send it to
	 */
	public static void sendTo(IPacket message, EntityPlayerMP player) {
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		HarryPotterMod.channels.get(Side.SERVER).writeAndFlush(message);
	}

	/**
	 * Send Packet message to everyone within a certain range of a point.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 * 
	 * @param message
	 *            The message to send
	 * @param point
	 *            The {@link cpw.mods.fml.common.network.NetworkRegistry.TargetPoint} around which to send
	 */
	public static void sendToAllAround(IPacket message, NetworkRegistry.TargetPoint point) {
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
		HarryPotterMod.channels.get(Side.SERVER).writeAndFlush(message);
	}

	/**
	 * Send Packet message to everyone within the supplied dimension.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 * 
	 * @param message
	 *            The message to send
	 * @param dimensionId
	 *            The dimension id to target
	 */
	public static void sendToDimension(IPacket message, int dimensionId) {
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
		HarryPotterMod.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionId);
		HarryPotterMod.channels.get(Side.SERVER).writeAndFlush(message);
	}

	/**
	 * Send Packet message to the server.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 * 
	 * @param message
	 *            The message to send
	 */
	public static void sendToServer(IPacket message) {
		HarryPotterMod.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		HarryPotterMod.channels.get(Side.CLIENT).writeAndFlush(message);
	}
}
