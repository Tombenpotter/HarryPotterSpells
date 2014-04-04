package harryPotterMod.tombenpotter.harrypottermod.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiSpellBook extends GuiScreen
{
	public static GuiSpellBook spellBookGui = new GuiSpellBook();
	public static final ResourceLocation texture = new ResourceLocation("harrypottermod", "/textures/gui/spellbookgui.png");

	int guiWidth = 260;
	int guiHeight = 190;
	int left;
	int top;

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		super.initGui();
		spellBookGui = this;

		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;

		buttonList.clear();

		int x = 5;
		for (int i = 0; i < 10; i++)
		{
			int y = 10 + i * 17;
			buttonList.add(new GuiButton(i, left + x, top + y, 110, 16, ""));
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		drawCenteredString(fontRendererObj, title(), left + guiWidth / 2, top - 12, 99999);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	String title()
	{
		return "Spell Book";
	}
}
