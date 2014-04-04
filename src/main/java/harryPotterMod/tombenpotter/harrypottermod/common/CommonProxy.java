package harryPotterMod.tombenpotter.harrypottermod.common;

import harryPotterMod.tombenpotter.harrypottermod.client.gui.GuiSpellBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void load()
	{
		registerRenders();
	}

	public void registerRenders()
	{
		/** Empty in common proxy **/
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case 0:
		{
			return GuiSpellBook.spellBookGui;
		}
		default:
			return null;
		}
	}

}
