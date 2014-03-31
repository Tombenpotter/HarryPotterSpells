package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SpellFinite
{

	public static void useSpell(EntityPlayer entity)
	{
		ItemStack milk = (new ItemStack(Items.milk_bucket));
		entity.curePotionEffects(milk);
	}
}
