package harryPotterMod.tombenpotter.harrypottermod.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class HPKeyHandler
{
	public static KeyBinding keyResetWand = new KeyBinding("key.hp_reset_wand", Keyboard.KEY_R, "Harry Potter Mod");
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
			ItemStack stack = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();
			ItemRegistry.wand.setDamage(stack, 0);
		}
	}
}