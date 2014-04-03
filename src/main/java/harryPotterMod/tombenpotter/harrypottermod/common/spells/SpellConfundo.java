package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileConfundo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellConfundo extends Spell
{

	public SpellConfundo()
	{
		super(SpellInfo.spell_Confundo);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity)
	{
		ProjectileConfundo spell = new ProjectileConfundo(world, entity);
		world.spawnEntityInWorld(spell);
		return true;
	}
}
