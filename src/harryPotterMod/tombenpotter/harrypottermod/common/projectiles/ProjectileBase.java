package harryPotterMod.tombenpotter.harrypottermod.common.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileBase extends EntityThrowable
{
    public ProjectileBase(World world)
    {
        super(world);
    }
    
    public ProjectileBase(World world, EntityLivingBase livingbase)
    {
        super(world, livingbase);
    }

    public ProjectileBase(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition mop)
    {
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}