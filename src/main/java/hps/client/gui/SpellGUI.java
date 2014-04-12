package hps.client.gui;

import hps.client.spells.SpellTexture;
import hps.common.container.SpellContainer;
import hps.common.lib.ModInfo;
import hps.common.net.ChannelHelper;
import hps.common.net.packets.ItemStackPacket;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.DataHelper;
import hps.common.util.TranslationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class SpellGUI extends GuiContainer {

	private ItemStack stack;
	private EntityPlayer player;

	public SpellGUI(ItemStack stack, EntityPlayer player) {
		super(new SpellContainer());
		xSize = 147;
		ySize = 56;

		this.stack = stack;
		this.player = player;
	}

	private ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/gui/spellGUI.png");
	private Spell[] spells;
	private Spell activeSpell;
	private GuiButton prev, next;

	@Override
	protected void drawGuiContainerBackgroundLayer(float floatPartialTick, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(gui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if (activeSpell != null) {
			SpellTexture spellText = activeSpell.getSpellTexture();
			Minecraft.getMinecraft().renderEngine.bindTexture(spellText.getTexture());
			drawTexturedModalRect(guiLeft + 52, guiTop + 15, spellText.getU(), spellText.getV(), spellText.getxSize(), spellText.getySize());
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		if (activeSpell != null) {
			String spellName = TranslationHelper.translate(activeSpell.getUnlocalizedName());
			fontRendererObj.drawString(spellName, 52 - spellName.length(), 5, Colours.GRAY.toRGB());
			fontRendererObj.drawString(DataHelper.getData(player.worldObj).getSpellInfo(player, activeSpell) + "", 70, 31, Colours.WHITE.toRGB());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		spells = SpellHandler.getSpells();

		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("activeSpell"))
			activeSpell = SpellHandler.getSpellByID(stack.getTagCompound().getInteger("activeSpell"));
		else
			activeSpell = spells[0];

		prev = new GuiButton(0, guiLeft + 6, guiTop + 18, 40, 20, "Prev");
		next = new GuiButton(1, guiLeft + 90, guiTop + 18, 40, 20, "Next");
		buttonList.add(prev);
		buttonList.add(next);

		updateButtons();
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		NBTTagCompound tag = stack.getTagCompound();
		if (tag == null)
			tag = new NBTTagCompound();
		tag.setInteger("activeSpell", activeSpell.getID());
		stack.setTagCompound(tag);
		ChannelHelper.sendToServer(new ItemStackPacket(stack, player, player.inventory.currentItem));
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			activeSpell = spells[activeSpell.getID() - 1];
		} else {
			activeSpell = spells[activeSpell.getID() + 1];
		}
		updateButtons();
	}

	public void updateButtons() {
		if (activeSpell != null) {
			if (activeSpell.getID() == 0) {
				prev.enabled = false;
			} else {
				prev.enabled = true;
			}

			if (activeSpell.getID() != spells.length - 1) {
				next.enabled = true;
			} else {
				next.enabled = false;
			}
		} else {
			prev.enabled = false;
			next.enabled = false;
		}
	}
}
