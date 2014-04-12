package hps.common.spells;

import hps.client.codechicken.lib.vec.Vector3;
import hps.client.spells.SpellTexture;
import hps.common.lib.ModInfo;
import hps.common.lib.SpellInfo;
import hps.common.util.VectorHelper;

import java.util.Iterator;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Accio extends Spell {

	public Accio() {
		super(SpellInfo.spell_Accio);
		setSpellTexture(new SpellTexture(new ResourceLocation(ModInfo.MODID, "textures/spells/spells.png"), 28, 26, 178, 127));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean castSpell(EntityPlayer player, ItemStack wand, World world, int x, int y, int z, CastType cast, Object[] pars) {
		if (world.isRemote)
			return false;
		if (cast == CastType.rightClick) {
			AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(player.posX - 10, player.posY - 10, player.posZ - 10, player.posX + 10, player.posY + 10, player.posZ + 10);
			Iterator iter = world.getEntitiesWithinAABB(EntityItem.class, bb).iterator();
			if (iter != null) {
				while (iter.hasNext()) {
					EntityItem item = (EntityItem) iter.next();
					VectorHelper.moveEntityTowardsAPoint(item, Vector3.fromEntityCenter(player), 0.2);
				}
			}
		}
		return true;
	}

}
