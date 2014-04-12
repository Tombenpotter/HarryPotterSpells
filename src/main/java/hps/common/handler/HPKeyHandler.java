package hps.common.handler;

import hps.common.HarryPotterMod;
import hps.common.item.WandItem;
import hps.common.net.ChannelHelper;
import hps.common.net.packets.ItemStackPacket;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class HPKeyHandler {
	public static KeyBinding keyWandGui = new KeyBinding("key.hp_openBook", Keyboard.KEY_U, "Harry Potter Mod");
	public static KeyBinding keyToggleLeft = new KeyBinding("key.hp_left", Keyboard.KEY_Y, "Harry Potter Mod");
	public static KeyBinding keyToggleRight = new KeyBinding("key.hp_right", Keyboard.KEY_I, "Harry Potter Mod");

	public HPKeyHandler() {
		ClientRegistry.registerKeyBinding(keyWandGui);
		ClientRegistry.registerKeyBinding(keyToggleLeft);
		ClientRegistry.registerKeyBinding(keyToggleRight);
	}

	@SubscribeEvent
	public void onKeyPress(InputEvent.KeyInputEvent event) {
		if (keyWandGui.getIsKeyPressed()) {
			KeyBinding.setKeyBindState(HPKeyHandler.keyWandGui.getKeyCode(), false);
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof WandItem) {
				player.openGui(HarryPotterMod.instance, 0, Minecraft.getMinecraft().theWorld, 0, 0, 0);
			}
		}

		if (keyToggleLeft.getIsKeyPressed()) {
			KeyBinding.setKeyBindState(HPKeyHandler.keyToggleLeft.getKeyCode(), false);
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			toggleThroughSpells(player, false);
		}

		if (keyToggleRight.getIsKeyPressed()) {
			KeyBinding.setKeyBindState(HPKeyHandler.keyToggleRight.getKeyCode(), false);
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			toggleThroughSpells(player, true);
		}
	}

	public void toggleThroughSpells(EntityPlayer player, boolean increment) {
		if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof WandItem && player.getHeldItem().getTagCompound() != null && player.getHeldItem().getTagCompound().hasKey("activeSpell")) {
			Spell spell = SpellHandler.getSpellByID(player.getHeldItem().getTagCompound().getInteger("activeSpell"));
			if (spell != null) {
				if (increment ? spell.getID() != SpellHandler.getSpells().length - 1 : spell.getID() != 0) {
					player.getHeldItem().getTagCompound().setInteger("activeSpell", increment ? spell.getID() + 1 : spell.getID() - 1);
					ChannelHelper.sendToServer(new ItemStackPacket(player.getHeldItem(), player, player.inventory.currentItem));
				}
			}
		}
	}
}