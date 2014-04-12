package hps.common;

import hps.client.gui.GrimoireGui;
import hps.client.gui.SpellGUI;
import hps.common.container.GrimoireContainer;
import hps.common.container.SpellContainer;
import hps.common.handler.EventContainerHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public void load() {
		registerRenders();
		MinecraftForge.EVENT_BUS.register(new EventContainerHandler());
	}

	public void registerRenders() {
		/** Empty in common proxy **/
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0: return new SpellContainer();
			case 1: return new GrimoireContainer();
			default: return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0: return new SpellGUI(player.getCurrentEquippedItem(), player);
		case 1: return new GrimoireGui();
		default: return null;
	}
	}

}
