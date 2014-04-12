package hps.common;

import hps.common.block.HPBlocks;
import hps.common.entity.HPEntities;
import hps.common.item.HPItems;
import hps.common.lib.ModInfo;
import hps.common.net.ChannelHandler;
import hps.common.spells.HPSpells;

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

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class HarryPotterMod {
	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;

	@Instance(ModInfo.MODID)
	public static HarryPotterMod instance;

	public static EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel(ModInfo.CHANNEL, new ChannelHandler());

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		HPBlocks.init();
		HPItems.init();
		HPSpells.init();
		HPEntities.init();

		/** Loading the client and server proxies **/
		proxy.load();

		/** Registering the GUI Handler **/
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
