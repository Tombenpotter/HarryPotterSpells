package hps.common.net.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;

public class PacketHelper {
	public static void writeNBTTagcompountToBuffer(NBTTagCompound tag, ByteBuf bytes) throws IOException {
		if (tag == null) {
			bytes.writeShort(-1);
		} else {
			byte[] abyte = CompressedStreamTools.compress(tag);
			bytes.writeShort((short) abyte.length);
			bytes.writeBytes(abyte);
		}
	}

	public static NBTTagCompound readNBTTagCompoundFromBuffer(ByteBuf bytes) throws IOException {
		short short1 = bytes.readShort();
		if (short1 < 0) {
			return null;
		} else {
			byte[] abyte = new byte[short1];
			bytes.readBytes(abyte);
			return CompressedStreamTools.decompress(abyte);
		}
	}
}
