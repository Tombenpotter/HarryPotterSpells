package hps.common.entity.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BaseSpell extends EntityThrowable {

	public BaseSpell(World world) {
		super(world);
	}

	public BaseSpell(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public BaseSpell(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0F;
	}

}
