package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSpellBook extends Item
{
	public ItemSpellBook(String itemName)
	{
		this.setUnlocalizedName("hp" + "." + "item" + itemName);

		this.setCreativeTab(HPCreativeTab.tabHPMod);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);

		name = itemName;
		init();
	}

	String name;

	public void init()
	{
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
}
