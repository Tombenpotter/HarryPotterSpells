package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import harryPotterMod.tombenpotter.harrypottermod.common.lib.SpellInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class SpellAnapneoSelf extends Spell{
	
	public SpellAnapneoSelf() {
		super(SpellInfo.spell_AnapneoSelf);
	}

	@Override
	public boolean useSpell(World world, int x, int y, int z, EntityLivingBase entity) {
		int currentAir = entity.getAir();
		entity.setAir(currentAir + 300);
		return true;
	}
}
