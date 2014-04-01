package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAvadaKedavra;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SpellAvadaKedavra extends Spell {

	public SpellAvadaKedavra(String str) {
		super(str);
	}
	
	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity) {
		ProjectileAvadaKedavra spell = new ProjectileAvadaKedavra(world, entity);
		SpellShootable.useSpell(spell, world, (EntityPlayer) entity);
		entity.attackEntityFrom(DamageSource.magic, 1);
		entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 150, 0, true));
		return super.useSpell(world, x, y, z, entity);
	}

}
