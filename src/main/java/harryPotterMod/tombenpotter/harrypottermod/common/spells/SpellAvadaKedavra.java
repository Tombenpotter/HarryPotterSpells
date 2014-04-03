package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAvadaKedavra;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SpellAvadaKedavra extends Spell
{

	public SpellAvadaKedavra()
	{
		super(SpellInfo.spell_AvakaKedavra);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity)
	{
		ProjectileAvadaKedavra spell = new ProjectileAvadaKedavra(world, entity);
		world.spawnEntityInWorld(spell);
		entity.attackEntityFrom(DamageSource.magic, 1);
		entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 150, 0, true));
		return true;
	}
}
