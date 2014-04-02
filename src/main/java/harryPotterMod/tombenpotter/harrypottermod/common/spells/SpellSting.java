package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileSting;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellSting extends Spell
{

	public SpellSting()
	{
		super(SpellInfo.spell_StinginHex);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity)
	{
		ProjectileSting spell = new ProjectileSting(world, entity);
		world.spawnEntityInWorld(spell);
		return true;
	}
}
