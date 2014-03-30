package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAnapneo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileAvadaKedavra;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileConfundo;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.ProjectileSting;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellAnapneoSelf;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellShootable;
import harryPotterMod.tombenpotter.harrypottermod.common.spells.SpellWingardiumLeviosa;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
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
		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			name = "disabledWand";
			break;
		}
		case 1:
		{
			name = "windgardiumLeviosaWand";
			break;
		}
		case 2:
		{
			name = "anapneoSelfWand";
			break;
		}
		case 3:
		{
			name = "anapneoOtherWand";
			break;
		}
		case 4:
		{
			name = "stingWand";
			break;
		}
		case 5:
		{
			name = "confundusWand";
			break;
		}
		case 15:
		{
			name = "avadaKedavraWand";
			break;
		}
		default:
			name = "wrongMeta";
			break;
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
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		int meta = stack.getItemDamage();
		if (player.isSneaking())
		{
			if (meta == 30)
			{
				stack.setItemDamage(0);
			} else if (meta == 0)
			{
				int i = stack.getItemDamage();
				stack.setItemDamage(i + 1);
			}
		} else
		{
			if (meta == 0)
			{
				return stack;
			}
			if (meta == 1)
			{
				SpellWingardiumLeviosa.useSpell(player);
			}
			if (meta == 2)
			{
				SpellAnapneoSelf.useSpell(player);
				player.swingItem();
			}
			if (meta == 3)
			{
				ProjectileAnapneo spell = new ProjectileAnapneo(world, player);
				SpellShootable.useSpell(spell, world, player);
				player.swingItem();
			}
			if (meta == 4)
			{
				ProjectileSting spell = new ProjectileSting(world, player);
				SpellShootable.useSpell(spell, world, player);
				player.swingItem();
			}
			if (meta == 5)
			{
				ProjectileConfundo spell = new ProjectileConfundo(world, player);
				SpellShootable.useSpell(spell, world, player);
				player.swingItem();
			}

			if (meta == 15)
			{
				ProjectileAvadaKedavra spell = new ProjectileAvadaKedavra(world, player);
				SpellShootable.useSpell(spell, world, player);
				player.attackEntityFrom(DamageSource.magic, 1);
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 150, 0, true));
				player.swingItem();
			}
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
