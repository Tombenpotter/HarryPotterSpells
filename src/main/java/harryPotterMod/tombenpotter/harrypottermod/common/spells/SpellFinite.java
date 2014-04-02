package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpellFinite extends Spell
{

	public SpellFinite() {
		super(SpellInfo.spell_Finite);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity) {
		ItemStack milk = (new ItemStack(Items.milk_bucket));
		entity.curePotionEffects(milk);
		return true;
	}
}
