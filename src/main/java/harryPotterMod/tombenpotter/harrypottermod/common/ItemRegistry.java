package harryPotterMod.tombenpotter.harrypottermod.common;

import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemSpellBook;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry
{
	public static Item spellBook;

	public static void registerItems()
	{
		spellBook = new ItemSpellBook().setUnlocalizedName("spellbook");

	}
}
