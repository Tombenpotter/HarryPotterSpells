package harryPotterMod.tombenpotter.harrypottermod.client;

import harryPotterMod.tombenpotter.harrypottermod.common.CommonProxy;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.renders.RenderProjectileBase;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.spells.ProjectileDamage;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void load()
	{
		registerRenders();
	}

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(ProjectileDamage.class, new RenderProjectileBase(1.0F, 1.0F, 1.0F, 1.0F));
	}
}
