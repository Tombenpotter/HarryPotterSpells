package harryPotterMod.tombenpotter.harrypottermod.common.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileAvadaKedavra extends ProjectileBase
{

	public ProjectileAvadaKedavra(World world)
	{
		super(world);
		init();
	}

	public ProjectileAvadaKedavra(World world, EntityLivingBase livingbase)
	{
		super(world, livingbase);
		init();
	}

	public ProjectileAvadaKedavra(World world, double x, double y, double z)
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
			EntityLivingBase hit = (EntityLivingBase) mop.entityHit;
			hit.attackEntityFrom(DamageSource.magic, 1999999999);
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}