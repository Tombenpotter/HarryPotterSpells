package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.client.codechicken.lib.vec.Vector3;
import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SpellWingardiumLeviosa extends Spell
{
	public SpellWingardiumLeviosa() {
		super(SpellInfo.spell_WingardiumLeviosa);
	}

	/**
	 * Attention: this part originally belongs to the ThaumicTinkerer mod. All I did was modifying it to fulfill my needs.
	 * 
	 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity) {
		Vector3 target = Vector3.fromEntityCenter(entity);

		final int range = 6;
		final double distance = range - 1;
		if (!entity.isSneaking())
			target.add(new Vector3(entity.getLookVec()).multiply(distance));

		target.y += 0.5;

		List<Entity> entities = entity.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(target.x - range, target.y - range, target.z - range, target.x + range, target.y + range, target.z + range));

		if (!entities.isEmpty())
		{
			for (Entity entityToMove : entities)
			{
				if (!(entityToMove instanceof EntityPlayer))
					moveStuff(entityToMove, target, 0.3333F);
			}
		}
		return true;
	}

	/**
	 * Attention: this part originally belongs to the ThaumicTinkerer mod. All I did was modifying it to fulfill my needs.
	 * 
	 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
	 * */
	public static void moveStuff(Entity entity, Vector3 originalPosVector, float modifier)
	{
		Vector3 entityVector = Vector3.fromEntityCenter(entity);
		Vector3 finalVector = originalPosVector.copy().subtract(entityVector);

		if (finalVector.mag() > 1)
			finalVector.normalize();

		entity.motionX = finalVector.x * modifier;
		entity.motionY = finalVector.y * modifier;
		entity.motionZ = finalVector.z * modifier;
	}
	
	@Override
	public boolean isWandFlicked() {
		return false;
	}
}
