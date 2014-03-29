package harryPotterMod.tombenpotter.harrypottermod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HPCreativeTab
{
	public static CreativeTabs tabHPMod = new CreativeTabs("HPModTab")
	{
		@Override
		public Item getTabIconItem()
		{
			return ItemRegistry.spellBook;
		}
	};
}
