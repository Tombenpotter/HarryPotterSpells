package hps.common.spells;

import hps.common.lib.ModInfo;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLLog;

public class SpellHandler {

	private static ArrayList<Spell> registeredSpells = new ArrayList<Spell>();

	public static void registerSpell(Spell spell) {
		if (!registeredSpells.contains(spell)) {
			spell.spellID = registeredSpells.size();
			registeredSpells.add(spell);
			FMLLog.info("[" + ModInfo.MODID + "] " + spell.getUnlocalizedName() + " ID: " + spell.getID() + " Registered Successfully");
		} else
			throw new IllegalArgumentException("[" + ModInfo.MODID + "] Confilicting Spells: " + spell.getUnlocalizedName());
	}
	
	public static Spell getSpellByID(int spell){
		if(spell >= registeredSpells.size()) return null;
		return registeredSpells.get(spell);
	}
	
	public static Spell[] getSpells(){
		Spell[] spells = new Spell[registeredSpells.size()];
 		for(int i = 0; i < registeredSpells.size(); i++)
 			spells[i] = registeredSpells.get(i);
 		return spells;
	}
}
