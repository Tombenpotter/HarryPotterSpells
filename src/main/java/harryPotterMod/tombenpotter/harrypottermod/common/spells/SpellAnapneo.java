package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAnapneo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellAnapneo extends Spell
{

	public SpellAnapneo()
	{
		super(SpellInfo.spell_Anapneo);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity)
	{
		ProjectileAnapneo spell = new ProjectileAnapneo(world, entity);
		world.spawnEntityInWorld(spell);
		return true;
	}
}
