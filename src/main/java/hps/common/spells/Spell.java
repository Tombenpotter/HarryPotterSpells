package hps.common.spells;

import hps.client.spells.SpellTexture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Spell {
	protected int spellID, spellDifficulty;
	private String unlocalizedName;
	private SpellTexture spellTexture;
	
	public Spell(String unlocalizedName) {
		this.unlocalizedName = "hp.spell." + unlocalizedName;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	public boolean castSpell(EntityPlayer player, ItemStack wand, World world, int x, int y, int z, CastType cast, Object[] pars) {
		return false;
	}

	public boolean isWandFlicked() {
		return true;
	}

	public Spell setDifficulty(int val) {
		spellDifficulty = val;
		return this;
	}
	
	public Spell setSpellTexture(SpellTexture texture){
		spellTexture = texture;
		return this;
	}
	
	public SpellTexture getSpellTexture() {
		return spellTexture;
	}

	public int getDifficulty() {
		return spellDifficulty;
	}
	
	public int getID(){
		return spellID;
	}
}
