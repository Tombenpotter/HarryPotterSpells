package harryPotterMod.tombenpotter.harrypottermod.common.spells;

public class Spells
{

	public static Spell wingardiumLeviosa;
	public static Spell finite;
	public static Spell anapneoSelf;
	public static Spell stingingHex;
	public static Spell anapneo;

	public static void init()
	{
		wingardiumLeviosa = new SpellWingardiumLeviosa();
		finite = new SpellFinite();
		anapneoSelf = new SpellAnapneoSelf();
		stingingHex = new SpellSting();
		anapneo = new SpellAnapneo();

		SpellHandler.registerSpell(wingardiumLeviosa);
		SpellHandler.registerSpell(finite);
		SpellHandler.registerSpell(anapneoSelf);
		SpellHandler.registerSpell(stingingHex);
		SpellHandler.registerSpell(anapneo);
	}
}
