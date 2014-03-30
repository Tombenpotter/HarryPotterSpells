package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public class SpellShootable
{

	public static void useSpell(EntityThrowable projectile, World world, EntityPlayer player)
	{
		world.spawnEntityInWorld(projectile);
	}
}
