package hps.common.spells;

import hps.client.spells.SpellTexture;
import hps.common.lib.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class DummySpell extends Spell {

	@SuppressWarnings("unused")
	private int u, v;

	public DummySpell(String unlocalizedName, int u, int v) {
		super(unlocalizedName);
		this.u = u;
		this.v = v;
		setSpellTexture(new SpellTexture(new ResourceLocation(ModInfo.MODID, "textures/spells/spells.png"), 28, 26, u, v));
	}

	@Override
	public boolean castSpell(EntityPlayer player, ItemStack wand, World world, int x, int y, int z, CastType cast, Object[] pars) {
		System.out.println(cast + " It casted");
		return true;
	}
}
