package harryPotterMod.tombenpotter.harrypottermod.common;

import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemMagicWand;
import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemSpellBook;
import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemTestCast;
import net.minecraft.item.Item;

public class ItemRegistry
{
	public static Item spellBook;
	public static Item wand;
	public static Item test;

	public static void registerItems()
	{
		spellBook = new ItemSpellBook("spellbook");
		test = new ItemTestCast("testCast");
		wand = new ItemMagicWand("magicwand");
	}
}
