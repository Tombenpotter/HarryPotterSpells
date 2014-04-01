package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAnapneo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAvadaKedavra;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileConfundo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileSting;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.Spell;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellAnapneoSelf;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellFinite;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellHandler;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellShootable;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellWingardiumLeviosa;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
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
		name = itemName;
		init();
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		int id = itemstack.getTagCompound().getInteger("spellID");
		if(id != 0){
			name = SpellHandler.getSpellByID(id).getSpellUnlocalizedName();
		}else{
			name = "disabledWand";
		}
		return getUnlocalizedName() + "." + name;
	}

	String name;

	public void init()
	{
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i <= 15; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if (player.isSneaking()) {
			int spellID = stack.getTagCompound().getInteger("spellID");
			if(spellID > SpellHandler.getRegisteredSpells().length)
				spellID = 0;
			else
				spellID++;
			stack.getTagCompound().setInteger("spellID", spellID);
		} else {
			Spell spell = SpellHandler.getSpellByID(stack.getTagCompound().getInteger("spellID"));
			if(spell != null)
				if(spell.useSpell(world, (int)player.posX, (int)player.posY, (int)player.posZ, (EntityLivingBase)player))
					player.swingItem();
		}
		return stack;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player)
	{
		stack.setItemDamage(0);
		return true;
	}
}
