package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.Spell;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellHandler;
import harryPotterMod.tombenpotter.harrypottermod.common.util.TranslationHelper;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicWand extends Item
{
	public ItemMagicWand(String itemName)
	{
		this.setCreativeTab(HPCreativeTab.tabHPMod);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("hp" + "." + "item" + itemName);
		this.setHasSubtypes(true);
		init();
	}

	public void init()
	{
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
	{
		for (Spell spell : SpellHandler.getRegisteredSpells())
		{
			ItemStack stack = new ItemStack(this);

			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("spellID", spell.getId());
			stack.setTagCompound(tag);

			list.add(stack);
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		NBTTagCompound tag = stack.stackTagCompound;
		if (player.isSneaking())
		{
			int spellID = tag.getInteger("spellID");
			if (spellID >= SpellHandler.getRegisteredSpells().length)
				spellID = -1;
			else
				spellID++;
			tag.setInteger("spellID", spellID);
		} else
		{
			if (tag.getInteger("spellID") != -1)
			{
				Spell spell = SpellHandler.getSpellByID(tag.getInteger("spellID"));
				if (spell != null)
					if (spell.useSpell(world, (int) player.posX, (int) player.posY, (int) player.posZ, (EntityLivingBase) player) && spell.isWandFlicked())
						player.swingItem();
			}
		}
		stack.setTagCompound(tag);
		return stack;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player)
	{
		stack.setItemDamage(0);
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("spellID") && stack.getTagCompound().getInteger("spellID") != -1 && stack.getTagCompound().getInteger("spellID") < SpellHandler.getRegisteredSpells().length)
		{
			list.add(TranslationHelper.translate(TranslationHelper.translate(SpellHandler.getSpellByID(stack.getTagCompound().getInteger("spellID")).getSpellUnlocalizedName())));
		}
		super.addInformation(stack, player, list, par4);
	}
}
