package harryPotterMod.tombenpotter.harrypottermod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HarryPotterMod.modid, name = "Harry Potter Mod", version = "0.0.1")
public class HarryPotterMod
{
	@SidedProxy(clientSide = "harryPotterMod.tombenpotter.harrypottermod.client.ClientProxy", serverSide = "harryPotterMod.tombenpotter.harrypottermod.common.CommonProxy")
	public static CommonProxy proxy;

	@Instance(HarryPotterMod.modid)
	public static HarryPotterMod instance;

	public static final String modid = "harrypottermod";
	public static final String modAlias = "HPM";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/** Generating the Items **/
		ItemRegistry.registerItems();

		/** Loading the client and server proxies **/
		proxy.load();

		print("Successful Pre-Init");
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		print("Successful Init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

		print("Successful Post-Init");
	}

	public void print(String message)
	{
		System.out.println("[" + modAlias + "] " + "Harry Potter Mod: " + message);
	}
}
