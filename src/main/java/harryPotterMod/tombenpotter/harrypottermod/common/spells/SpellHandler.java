package harryPotterMod.tombenpotter.harrypottermod.common.spells;

import java.util.ArrayList;

public class SpellHandler
{

	private static ArrayList<Spell> registeredSpells = new ArrayList<Spell>();

	public static void registerSpell(Spell spell)
	{
		if (!registeredSpells.contains(spell))
		{
			spell.id = registeredSpells.size() - 1;
			registeredSpells.add(spell);
			spell.spell_UnlocalizedName = "spell." + spell.spell_UnlocalizedName;
			// TODO GG
		} else
			throw new IllegalArgumentException("Error: The following spell: " + spell.getSpellUnlocalizedName() + " is already registred!");
	}

	public static Spell[] getRegisteredSpells()
	{
		Spell[] spells = new Spell[registeredSpells.size()];
		for (int i = 0; i < registeredSpells.size(); i++)
			spells[i] = registeredSpells.get(i);
		return spells;
	}

	public static Spell getSpellByID(int id)
	{
		if (id != -1 && id < registeredSpells.size() && registeredSpells.get(id) != null)
			return registeredSpells.get(id);
		return null;
	}
}
