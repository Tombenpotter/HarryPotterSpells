package hps.common.entity;

import hps.common.HarryPotterMod;
import hps.common.entity.spells.SpellAlarteAscendare;
import hps.common.entity.spells.SpellExpelliarmus;
import cpw.mods.fml.common.registry.EntityRegistry;

public class HPEntities {
	public static void init() {
		EntityRegistry.registerModEntity(SpellExpelliarmus.class, "SpellExpelliarmus", 1, HarryPotterMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(SpellAlarteAscendare.class, "SpellAlarteAscendare", 1, HarryPotterMod.instance, 80, 3, true);
	}
}
