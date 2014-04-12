package hps.client;

import hps.client.renderers.RenderBaseSpell;
import hps.client.renderers.RendererEventHandler;
import hps.common.CommonProxy;
import hps.common.entity.spells.SpellExpelliarmus;
import hps.common.handler.EventContainerHandler;
import hps.common.handler.HPKeyHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void load() {
		registerRenders();
		FMLCommonHandler.instance().bus().register(new HPKeyHandler());
		MinecraftForge.EVENT_BUS.register(new RendererEventHandler());
		MinecraftForge.EVENT_BUS.register(new EventContainerHandler());
	}

	@Override
	public void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(SpellExpelliarmus.class, new RenderBaseSpell(1.0F, 1.0F, 1.0F, 1.0F));
	}
}
