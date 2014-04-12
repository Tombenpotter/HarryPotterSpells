package hps.common.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class HPItems {

	public static final Item spellBook = new SpellBook();
	public static final Item wand = new WandItem();

	public static void init() {
		GameRegistry.registerItem(spellBook, spellBook.getUnlocalizedName());
		GameRegistry.registerItem(wand, wand.getUnlocalizedName());
	}
}
