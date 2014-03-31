package harryPotterMod.tombenpotter.harrypottermod.common;

import harryPotterMod.tombenpotter.harrypottermod.common.packet.ChannelHandler;

import java.util.EnumMap;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = HarryPotterMod.modid, name = "Harry Potter Mod", version = "0.0.1")
public class HarryPotterMod
{
	@SidedProxy(clientSide = "harryPotterMod.tombenpotter.harrypottermod.client.ClientProxy", serverSide = "harryPotterMod.tombenpotter.harrypottermod.common.CommonProxy")
	public static CommonProxy proxy;

	@Instance(HarryPotterMod.modid)
	public static HarryPotterMod instance;

	EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel(CHANNEL, new ChannelHandler());

	public static final String modid = "harrypottermod";
	public static final String modAlias = "HPM";
	public static final String CHANNEL = modid;

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
