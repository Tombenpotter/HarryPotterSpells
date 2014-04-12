package hps.common.net.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;

public interface IPacket {
	public void readBytes(ByteBuf bytes) throws IOException;

	public void writeBytes(ByteBuf bytes) throws IOException;

	public void executeClient(EntityPlayer player) throws IOException;

	public void executeServer(EntityPlayer player) throws IOException;
}
