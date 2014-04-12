package hps.common.entity.spells;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SpellAlarteAscendare extends BaseSpell {

	public SpellAlarteAscendare(World world) {
		super(world);
	}

	public SpellAlarteAscendare(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public SpellAlarteAscendare(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (!this.worldObj.isRemote && mop.entityHit != null && mop.entityHit instanceof EntityLiving) {
			EntityLiving hit = (EntityLiving) mop.entityHit;
			hit.addPotionEffect(new PotionEffect(Potion.resistance.id, 50, 500, false));
			hit.motionY = 2;
			this.setDead();
		}
	}
}
