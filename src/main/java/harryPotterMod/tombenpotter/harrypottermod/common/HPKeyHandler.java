package harryPotterMod.tombenpotter.harrypottermod.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class HPKeyHandler
{
	public static KeyBinding keyResetWand = new KeyBinding("key.hp_openBook", Keyboard.KEY_R, "Harry Potter Mod");
	public static boolean keyPressed = false;

	public HPKeyHandler()
	{
		ClientRegistry.registerKeyBinding(keyResetWand);
	}

	@SubscribeEvent
	public void onKeyPress(InputEvent.KeyInputEvent event)
	{
		if (keyResetWand.getIsKeyPressed())
		{
			KeyBinding.setKeyBindState(HPKeyHandler.keyResetWand.getKeyCode(), false);
			if (Minecraft.getMinecraft().thePlayer.inventory.hasItem(ItemRegistry.spellBook))
			{
				Minecraft.getMinecraft().thePlayer.openGui(HarryPotterMod.instance, 0, Minecraft.getMinecraft().theWorld, 0, 0, 0);
			}
		}
	}
}