package harryPotterMod.tombenpotter.harrypottermod.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import net.minecraft.item.Item;

public class ItemSpellBook extends Item
{
	public ItemSpellBook(String itemName)
	{
		this.setUnlocalizedName("hp" + "." + "item" + itemName);

		this.setCreativeTab(HPCreativeTab.tabHPMod);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		
		name = itemName;
		init();
	}
	String name;
	
	public void init()
	{
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
}
