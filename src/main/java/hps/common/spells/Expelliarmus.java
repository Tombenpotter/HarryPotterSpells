package hps.common.spells;

import hps.client.spells.SpellTexture;
import hps.common.entity.spells.SpellExpelliarmus;
import hps.common.lib.ModInfo;
import hps.common.lib.SpellInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Expelliarmus extends Spell {

	public Expelliarmus() {
		super(SpellInfo.spell_Expelliarmus);
		setSpellTexture(new SpellTexture(new ResourceLocation(ModInfo.MODID, "textures/spells/spells.png"), 28, 26, 255, 153));
	}

	@Override
	public boolean castSpell(EntityPlayer player, ItemStack wand, World world, int x, int y, int z, CastType cast, Object[] pars) {
		if (world.isRemote)
			return false;
		SpellExpelliarmus spell = new SpellExpelliarmus(world, player);
		world.spawnEntityInWorld(spell);
		return true;
	}
}
