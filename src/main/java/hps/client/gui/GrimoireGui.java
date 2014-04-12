package hps.client.gui;

import hps.common.container.GrimoireContainer;
import hps.common.lib.ModInfo;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.TranslationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GrimoireGui extends GuiContainer {

	public GrimoireGui() {
		super(new GrimoireContainer());

		xSize = 254;
		ySize = 180;

	}

	private ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/gui/grimoireGUI.png");
	// private GuiButton spell;
	private Spell[] spells;

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(gui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		String title = "Book of Spells";
		fontRendererObj.drawString(title, (int) 100 - title.length(), 5, Colours.PURPLE.toRGB());

		spells = SpellHandler.getSpells();
		if (spells != null) {
			for (int i = 0; i <= spells.length - 1; i++) {
				int yPos = 20 + 10 * i;
				String spellName = TranslationHelper.translate(spells[i].getUnlocalizedName());
				fontRendererObj.drawString(spellName, 10, yPos, Colours.BLACK.toRGB());
			}
		}
	}
}
