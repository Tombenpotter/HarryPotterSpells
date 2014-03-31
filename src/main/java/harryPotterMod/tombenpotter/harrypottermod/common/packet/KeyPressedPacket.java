package harryPotterMod.tombenpotter.harrypottermod.common.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class KeyPressedPacket implements IPacket
{
	public String playerID;
	public int itemDamage;
	public byte bytePlayer;

	public KeyPressedPacket(EntityPlayer player)
	{
		playerID = player.getCommandSenderName();
		itemDamage = player.getCurrentEquippedItem().getItemDamage();
	}

	@Override
	public void readBytes(ByteBuf bytes)
	{
		bytePlayer = bytes.readByte();
		itemDamage = bytes.readInt();
	}

	@Override
	public void writeBytes(ByteBuf bytes)
	{
		bytePlayer = Byte.valueOf(playerID);
		bytes.writeInt(bytePlayer);
		bytes.writeInt(itemDamage);
	}

	@Override
	public void executeClient(EntityPlayer player)
	{
	}

	@Override
	public void executeServer(EntityPlayer player)
	{
	}

}
