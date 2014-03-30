package harryPotterMod.tombenpotter.harrypottermod.common.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileAnapneo extends ProjectileBase
{

	public ProjectileAnapneo(World world)
	{
		super(world);
		init();
	}

	public ProjectileAnapneo(World world, EntityLivingBase livingbase)
	{
		super(world, livingbase);
		init();
	}

	public ProjectileAnapneo(World world, double x, double y, double z)
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
			int currentAir = entity.getAir();
			entity.setAir(currentAir + 300);
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}