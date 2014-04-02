package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class Spell
{

	protected int id;
	protected String spell_UnlocalizedName;

	public Spell(String str)
	{
		spell_UnlocalizedName = str;
	}

	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity)
	{
		return false;
	}

	public String getSpellUnlocalizedName()
	{
		return spell_UnlocalizedName;
	}

	public int getId()
	{
		return id;
	}

	public boolean isWandFlicked()
	{
		return true;
	}
}
