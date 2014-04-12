package hps.common.world;

import hps.common.spells.Spell;
import hps.common.util.JavaHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class PlayerData extends WorldSavedData {

	private HashMap<Integer, NBTTagCompound> players = new HashMap<Integer, NBTTagCompound>();
	
	public PlayerData() {
		super("playerData");
	}
	
	public void addPlayer(EntityPlayer player){
		if(!players.containsKey(player.getEntityId())){
			System.out.println("Adding Player");
			players.put(player.getEntityId(), new NBTTagCompound());
		}
	}
	
	public void setSpellInfo(EntityPlayer player, Spell spell, int amount){
		if(players.containsKey(player.getEntityId())){
			NBTTagCompound tag = players.get(player.getEntityId());
			tag.setInteger("CastCount:" + spell.getID(), amount);
		}else{
			addPlayer(player);
			NBTTagCompound tag = players.get(player.getEntityId());
			tag.setInteger("CastCount:" + spell.getID(), amount);
		}
	}
	
	public int getSpellInfo(EntityPlayer player, Spell spell){
		if(players.containsKey(player.getEntityId())){
			NBTTagCompound tag = players.get(player.getEntityId());
			return tag.getInteger("CastCount:" + spell.getID());
		}
		return 0;
	}

	public Integer[] getIDs(){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Iterator iter = players.keySet().iterator();
		if (iter != null) while(iter.hasNext()) ids.add((Integer) iter.next());
		return (Integer[]) JavaHelper.listToArray(ids);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		if(tag.hasKey("size")){
			for(int i = 0; i < tag.getInteger("size"); i++)
				players.put(tag.getInteger("PlayerID:" + i), tag.getCompoundTag("playerNBT:" + i));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		Integer[] users = getIDs();
		if(users != null){
			tag.setInteger("size", users.length);
			for(int i = 0; i < users.length; i++){
				tag.setInteger("PlayerID:" + i, users[i].intValue());
				tag.setTag("playerNBT:" + i, players.get(users[i].intValue()));
			}
		}
	}

}
