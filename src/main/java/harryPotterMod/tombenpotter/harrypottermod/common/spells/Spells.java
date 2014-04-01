package harryPotterMod.tombenpotter.harrypottermod.common.spells;

public class Spells {
	
	public static Spell wingardiumLeviosa;
	public static Spell finite;
	public static Spell anapneoSelf;
	
	public static void init(){
		wingardiumLeviosa = new SpellWingardiumLeviosa();
		finite = new SpellFinite();
		anapneoSelf = new SpellAnapneoSelf();
		
		SpellHandler.registerSpell(wingardiumLeviosa);
		SpellHandler.registerSpell(finite);
		SpellHandler.registerSpell(anapneoSelf);
	}
}
