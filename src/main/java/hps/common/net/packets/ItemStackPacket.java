package hps.common.net.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemStackPacket implements IPacket {

	public ItemStackPacket() {
	}

	private ItemStack stack;
	private NBTTagCompound tag;
	private EntityPlayer player;
	@SuppressWarnings("unused")
	private String name;
	private int slotIndex;

	public ItemStackPacket(ItemStack stack, EntityPlayer player, int slotIndex) {
		this.stack = stack;
		this.player = player;
		this.slotIndex = slotIndex;
	}

	@Override
	public void readBytes(ByteBuf bytes) throws IOException {
		Short size = bytes.readShort();
		if (size != -1) {
			byte[] user = new byte[size];
			bytes.readBytes(user);
			name = new String(user);
			slotIndex = bytes.readInt();
			tag = PacketHelper.readNBTTagCompoundFromBuffer(bytes);
		}
	}

	@Override
	public void writeBytes(ByteBuf bytes) throws IOException {
		if (stack.getTagCompound() != null) {
			byte[] username = player.getCommandSenderName().getBytes();
			bytes.writeShort(username.length);
			bytes.writeBytes(username);
			bytes.writeInt(slotIndex);
			PacketHelper.writeNBTTagcompountToBuffer(stack.getTagCompound(), bytes);
		} else
			bytes.writeShort(-1);
	}

	@Override
	public void executeClient(EntityPlayer player) throws IOException {
		if (tag != null) {
			ItemStack stack = player.inventory.mainInventory[slotIndex];
			stack.setTagCompound(tag);
			player.inventory.mainInventory[slotIndex] = stack;
		}
	}

	@Override
	public void executeServer(EntityPlayer player) throws IOException {
		if (tag != null) {
			ItemStack stack = player.inventory.mainInventory[slotIndex];
			stack.setTagCompound(tag);
			player.inventory.mainInventory[slotIndex] = stack;
		}
	}

}
