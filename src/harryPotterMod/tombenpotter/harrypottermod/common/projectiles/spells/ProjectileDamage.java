package harryPotterMod.tombenpotter.harrypottermod.common.projectiles.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileDamage extends ProjectileBase{

    public ProjectileDamage(World world)
    {
        super(world);
        init();
    }
    
    public ProjectileDamage(World world, EntityLivingBase livingbase)
    {
        super(world, livingbase);
        init();
    }

    public ProjectileDamage(World world, double x, double y, double z)
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
              EntityLivingBase hit = (EntityLivingBase)mop.entityHit;
              hit.setHealth(hit.getHealth() - 2);
         }
    	 
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }

}
