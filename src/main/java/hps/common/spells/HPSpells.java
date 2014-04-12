package hps.common.spells;

public class HPSpells {

	private static Spell accio, expelliarmus, banish, alarteAscendare;

	public static void init() {
		accio = new Accio().setDifficulty(20);
		expelliarmus = new Expelliarmus().setDifficulty(15);
		banish = new BanishingCharm().setDifficulty(25);
		alarteAscendare = new AlarteAscendare().setDifficulty(30);

		SpellHandler.registerSpell(accio);
		SpellHandler.registerSpell(expelliarmus);
		SpellHandler.registerSpell(banish);
		SpellHandler.registerSpell(alarteAscendare);
	}
}
