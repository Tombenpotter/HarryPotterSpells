package hps.common.item;

import hps.common.HPCreativeTab;
import hps.common.lib.ItemInfo;
import hps.common.net.ChannelHelper;
import hps.common.net.packets.SyncSpellPacket;
import hps.common.spells.CastType;
import hps.common.spells.Spell;
import hps.common.spells.SpellHandler;
import hps.common.util.LearningHelper;
import hps.common.util.TranslationHelper;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WandItem extends Item {

	public WandItem() {
		setCreativeTab(HPCreativeTab.tabHPMod);
		setUnlocalizedName(ItemInfo.WAND_UNLOACLIZEDNAME);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return false;
		return wandCast(player, stack, world, x, y, z, CastType.block);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		wandCast(player, stack, world, (int) player.posX, (int) player.posY, (int) player.posZ, CastType.rightClick);
		return stack;
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		wandCast(player, stack, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, CastType.block);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return wandCast(player, stack, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, CastType.entityInteraction);
	}

	public boolean wandCast(EntityPlayer player, ItemStack wand, World world, int x, int y, int z, CastType type, Object... pars) {
		NBTTagCompound tag = wand.getTagCompound();
		if (tag != null) {
			if (tag.hasKey("activeSpell")) {
				Spell spell = SpellHandler.getSpellByID(tag.getInteger("activeSpell"));
				if (spell != null && LearningHelper.canCastSpell(player, spell)) {
					if (spell.castSpell(player, wand, world, x, y, z, type, pars)) {
						if(!world.isRemote){
							LearningHelper.incrementSpell(player, spell);
							ChannelHelper.sendTo(new SyncSpellPacket(player, spell), (EntityPlayerMP) player);
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean val) {
		if (GuiScreen.isShiftKeyDown()) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null && tag.hasKey("activeSpell")) {
				Spell spell = SpellHandler.getSpellByID(tag.getInteger("activeSpell"));
				if (spell != null)
					list.add("Active Spell: " + TranslationHelper.translate(spell.getUnlocalizedName()));
			}
		}
	}
}
