package hps.common.net.packets;

import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.DataHelper;
import hps.common.world.PlayerData;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;

public class SyncSpellPacket implements IPacket{

	public SyncSpellPacket() {}
	
	private EntityPlayer player;
	private Spell spell;
	private int amount;
	
	public SyncSpellPacket(EntityPlayer player, Spell spell) {
		this.player = player;
		this.spell = spell;
	}
	
	@Override
	public void readBytes(ByteBuf bytes) throws IOException {
		spell = SpellHandler.getSpellByID(bytes.readInt());
		amount = bytes.readInt();
	}

	@Override
	public void writeBytes(ByteBuf bytes) throws IOException {
		PlayerData data = DataHelper.getData(player.worldObj);
		bytes.writeInt(spell.getID());
		bytes.writeInt(data.getSpellInfo(player, spell));
	}

	@Override
	public void executeClient(EntityPlayer player) throws IOException {
		if(spell != null){
			System.out.println("Client");
			DataHelper.getData(player.worldObj).setSpellInfo(player, spell, amount);
		}
	}

	@Override
	public void executeServer(EntityPlayer player) throws IOException {}
}
