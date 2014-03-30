package harryPotterMod.tombenpotter.harrypottermod.client;

import harryPotterMod.tombenpotter.harrypottermod.client.renderers.RenderItemWand;
import harryPotterMod.tombenpotter.harrypottermod.client.renderers.RenderProjectileBase;
import harryPotterMod.tombenpotter.harrypottermod.common.CommonProxy;
import harryPotterMod.tombenpotter.harrypottermod.common.HPKeyHandler;
import harryPotterMod.tombenpotter.harrypottermod.common.ItemRegistry;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAnapneo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAvadaKedavra;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileConfundo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileSting;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{

	@Override
	public void load()
	{
		registerRenders();
		FMLCommonHandler.instance().bus().register(new HPKeyHandler());
	}

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(ProjectileSting.class, new RenderProjectileBase(1.0F, 1.0F, 1.0F, 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileAnapneo.class, new RenderProjectileBase(1.0F, 1.0F, 1.0F, 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileConfundo.class, new RenderProjectileBase(1.0F, 1.0F, 1.0F, 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileAvadaKedavra.class, new RenderProjectileBase(1.0F, 1.0F, 1.0F, 1.0F));
		MinecraftForgeClient.registerItemRenderer(ItemRegistry.wand, new RenderItemWand());
	}
}
