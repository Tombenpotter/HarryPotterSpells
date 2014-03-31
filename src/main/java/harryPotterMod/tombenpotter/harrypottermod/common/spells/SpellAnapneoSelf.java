package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import net.minecraft.entity.Entity;

public class SpellAnapneoSelf
{
	public static void useSpell(Entity entity)
	{
		int currentAir = entity.getAir();
		entity.setAir(currentAir + 300);
	}
}
