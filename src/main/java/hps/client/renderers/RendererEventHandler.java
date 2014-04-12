package hps.client.renderers;

import hps.client.gui.Colours;
import hps.client.spells.SpellTexture;
import hps.common.item.WandItem;
import hps.common.lib.ModInfo;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.DataHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RendererEventHandler {

	private float hudAlpha, speed = 0.001F;
	private Spell lastKnownSpell;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack stack = player.getHeldItem();
		if (stack != null && stack.getItem() instanceof WandItem) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null && tag.hasKey("activeSpell")) {
				Spell spell = SpellHandler.getSpellByID(tag.getInteger("activeSpell"));
				if (spell != null) {
					if (hudAlpha < 1F)
						hudAlpha += speed;
					renderSpellHUD(player, spell);
				}
			}
		} else {
			if (hudAlpha > 0 && lastKnownSpell != null) {
				hudAlpha -= speed;
				renderSpellHUD(player, lastKnownSpell);
			}
		}
	}

	public void renderSpellHUD(EntityPlayer player, Spell spell) {
		GL11.glColor4f(1F, 1F, 1F, hudAlpha);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInfo.MODID, "textures/gui/spellGUI.png"));
		drawQuad(-105, -25, 0, 0, 137, 56);

		SpellTexture text = spell.getSpellTexture();
		Minecraft.getMinecraft().renderEngine.bindTexture(text.getTexture());

		drawQuad(0, 0, text.getU(), text.getV(), text.getxSize(), text.getySize());
		
		Minecraft.getMinecraft().fontRenderer.drawString(DataHelper.getData(player.worldObj).getSpellInfo(player, spell) + "", 23, 20, Colours.WHITE.toRGB());
		lastKnownSpell = spell;
	}

	public void drawQuad(int x, int y, int u, int v, int w, int h) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();

		tessellator.addVertexWithUV((double) (x + 0), (double) (y + h), 0, (double) ((float) (u + 0) * 0.00390625F), (double) ((float) (v + h) * 0.00390625F));
		tessellator.addVertexWithUV((double) (x + w), (double) (y + h), 0, (double) ((float) (u + w) * 0.00390625F), (double) ((float) (v + h) * 0.00390625F));
		tessellator.addVertexWithUV((double) (x + w), (double) (y + 0), 0, (double) ((float) (u + w) * 0.00390625F), (double) ((float) (v + 0) * 0.00390625F));
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + 0), 0, (double) ((float) (u + 0) * 0.00390625F), (double) ((float) (v + 0) * 0.00390625F));
		tessellator.draw();
	}
}
