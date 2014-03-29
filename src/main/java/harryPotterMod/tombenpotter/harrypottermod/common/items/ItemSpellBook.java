package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import net.minecraft.item.Item;

public class ItemSpellBook extends Item
{
	public ItemSpellBook()
	{
		this.setCreativeTab(HPCreativeTab.tabHPMod);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		init();
	}
	
	/* Making it clean */
	public void init()
	{
		GameRegistry.registerItem(this, "Spell Book");
	}
}
