package hps.common.item;

import hps.common.HPCreativeTab;
import hps.common.HarryPotterMod;
import hps.common.lib.ItemInfo;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.TranslationHelper;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SpellBook extends Item {

	public SpellBook() {
		setUnlocalizedName(ItemInfo.SPELL_BOOK_UNLOACLIZEDNAME);
		setCreativeTab(HPCreativeTab.tabHPMod);
		setHasSubtypes(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (Spell spell : SpellHandler.getSpells()) {
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("spellID", spell.getID());
			ItemStack stack = new ItemStack(this);
			stack.setTagCompound(tag);
			list.add(stack);
		}
		list.add(new ItemStack(item, 1, 1));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = ItemInfo.SPELL_BOOK_UNLOACLIZEDNAME;
			break;
		}
		case 1: {
			name = ItemInfo.STORAGE_SPELL_BOOK_UNLOCALIZEDNAME;
			break;
		}
		default:
			name = "nothing";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		int meta = stack.getItemDamage();

		if (meta == 1) {
			player.openGui(HarryPotterMod.instance, 1, world, 0, 0, 0);
			return stack;
		} else {
			return stack;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean val) {
		if (GuiScreen.isShiftKeyDown()) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null && tag.hasKey("spellID")) {
				Spell spell = SpellHandler.getSpellByID(tag.getInteger("spellID"));
				if (spell != null)
					list.add("Spell: " + TranslationHelper.translate(spell.getUnlocalizedName()));
			}
		}
	}
}
