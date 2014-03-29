package harryPotterMod.tombenpotter.harrypottermod.common;

import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemSpellBook;
import harryPotterMod.tombenpotter.harrypottermod.common.items.ItemTestCast;

public class ItemRegistry
{
	public static ItemSpellBook spellBook;
	public static ItemTestCast test;
	
	public static void registerItems()
	{
		spellBook = new ItemSpellBook("spellbook");
		test = new ItemTestCast("testCast");
	}
}
