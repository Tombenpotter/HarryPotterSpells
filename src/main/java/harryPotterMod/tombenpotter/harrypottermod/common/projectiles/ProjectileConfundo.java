package harryPotterMod.tombenpotter.harrypottermod.common.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileConfundo extends ProjectileBase
{

	public ProjectileConfundo(World world)
	{
		super(world);
		init();
	}

	public ProjectileConfundo(World world, EntityLivingBase livingbase)
	{
		super(world, livingbase);
		init();
	}

	public ProjectileConfundo(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		init();
	}

	public void init()
	{

	}

	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		if (mop.entityHit != null && mop.entityHit instanceof EntityLiving)
		{
			EntityLivingBase entity = (EntityLivingBase) mop.entityHit;
			entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0, true));
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}