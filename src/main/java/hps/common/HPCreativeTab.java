package hps.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class HPCreativeTab {
	public static CreativeTabs tabHPMod = new CreativeTabs("HPModTab") {
		@Override
		public Item getTabIconItem() {
			return Items.arrow;
		}
	};
}
