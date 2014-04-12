package hps.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class SpellContainer extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
}
