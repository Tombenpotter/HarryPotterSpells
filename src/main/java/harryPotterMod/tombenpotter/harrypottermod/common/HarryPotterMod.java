package harryPotterMod.tombenpotter.harrypottermod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HarryPotterMod.modid, name = "Harry Potter Mod", version = "0.0.1")
public class HarryPotterMod
{
	@Instance(HarryPotterMod.modid)
	public static HarryPotterMod instance;

	public static final String modid = "harrypottermod";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/** Registering the items **/ 
		ItemRegistry.registerItems();
		
		System.out.println("[HPM] Harry Potter Mod: Successful PreInit");
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{

		System.out.println("[HPM] Harry Potter Mod: Successful Init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

		System.out.println("[HPM] Harry Potter Mod: Successful PostInit");
	}
}
