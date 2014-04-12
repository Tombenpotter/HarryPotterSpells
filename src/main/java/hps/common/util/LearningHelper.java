package hps.common.util;

import hps.common.spells.Spell;
import hps.common.world.PlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class LearningHelper {

	public static boolean canCastSpell(EntityPlayer player, Spell spell) {
		int spellCast = DataHelper.getData(player.worldObj).getSpellInfo(player, spell);
		if (spellCast >= spell.getDifficulty())
			return true;
		else {
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				ItemStack stack = player.inventory.getStackInSlot(i);
				if (stack != null) {
					NBTTagCompound stacktag = stack.getTagCompound();
					if (stacktag != null && stacktag.hasKey("spellID") && stacktag.getInteger("spellID") == spell.getID())
						return true;
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public static void incrementSpell(EntityPlayer player, Spell spell) {
		PlayerData data = DataHelper.getData(player.worldObj);
		int counter = data.getSpellInfo(player, spell) + 1;
		data.setSpellInfo(player, spell, counter);
	}
}
