package hps.common.net.packets;

import hps.common.util.DataHelper;
import hps.common.world.PlayerData;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SyncWorldData implements IPacket {

	private World world;
	
	private NBTTagCompound tag;
	
	public SyncWorldData() {}
	
	public SyncWorldData(World world) {
		this.world = world;
	}
	
	@Override
	public void readBytes(ByteBuf bytes) throws IOException {
		tag = PacketHelper.readNBTTagCompoundFromBuffer(bytes);
	}

	@Override
	public void writeBytes(ByteBuf bytes) throws IOException {
		PlayerData data = DataHelper.getData(world);
		NBTTagCompound tag = new NBTTagCompound();
		data.writeToNBT(tag);
		PacketHelper.writeNBTTagcompountToBuffer(tag, bytes);
	}

	@Override
	public void executeClient(EntityPlayer player) throws IOException {
		if(tag != null){
			DataHelper.getData(player.worldObj).readFromNBT(tag);
		}
	}

	@Override
	public void executeServer(EntityPlayer player) throws IOException {
		if(tag != null){
			DataHelper.getData(player.worldObj).readFromNBT(tag);
		}
	}

}
