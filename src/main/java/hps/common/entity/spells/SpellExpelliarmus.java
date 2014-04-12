package hps.common.entity.spells;

import hps.client.codechicken.lib.vec.Vector3;
import hps.common.util.VectorHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SpellExpelliarmus extends BaseSpell {

	public SpellExpelliarmus(World world) {
		super(world);
	}

	public SpellExpelliarmus(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public SpellExpelliarmus(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (!this.worldObj.isRemote && mop.entityHit != null && mop.entityHit instanceof EntityLiving) {

			if (mop.entityHit instanceof EntityPlayer) {
				EntityPlayer hit = (EntityPlayer) mop.entityHit;
				ItemStack toDrop = hit.inventory.getCurrentItem();
				if (toDrop != null) {
					hit.entityDropItem(toDrop, 1);
					hit.inventory.consumeInventoryItem(toDrop.getItem());
				}
			}

			mop.entityHit.attackEntityFrom(DamageSource.magic, 1);
			VectorHelper.moveEntityBasedOnVector3(mop.entityHit, new Vector3(this.posX, this.posY, this.posZ), 1F);
			this.setDead();
		}
	}
}
