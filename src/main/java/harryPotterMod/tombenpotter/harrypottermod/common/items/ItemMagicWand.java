package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.client.codechicken.lib.vec.Vector3;
import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
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
			name = "avadaKedavraWand";
			break;
		}
		case 2:
		{
			name = "windgardiumLeviosaWand";
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
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
		list.add(new ItemStack(this, 1, 2));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		int meta = stack.getItemDamage();
		if (meta == 0)
		{
			return stack;
		}
		if (meta == 1)
		{

		}
		if (meta == 2)
		{
			/**
			 * Attention: this part originally belongs to the ThaumicTinkerer mod. All I did was modifying it to fulfill my needs.
			 * 
			 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
			 * */
			Vector3 target = Vector3.fromEntityCenter(player);

			final int range = 6;
			final double distance = range - 1;
			if (!player.isSneaking())
				target.add(new Vector3(player.getLookVec()).multiply(distance));

			target.y += 0.5;

			List<Entity> entities = player.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(target.x - range, target.y - range, target.z - range, target.x + range, target.y + range, target.z + range));

			if (!entities.isEmpty())
			{
				for (Entity entity : entities)
				{
					if (!(entity instanceof EntityPlayer))
						moveStuff(entity, target, 0.3333F);
				}
			}

		}
		return stack;
	}

	/**
	 * Attention: this part originally belongs to the ThaumicTinkerer mod. All I did was modifying it to fulfill my needs.
	 * 
	 * ThaumicTinkerer is Open Source and distributed under a Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
	 * */
	public static void moveStuff(Entity entity, Vector3 originalPosVector, float modifier)
	{
		Vector3 entityVector = Vector3.fromEntityCenter(entity);
		Vector3 finalVector = originalPosVector.copy().subtract(entityVector);

		if (finalVector.mag() > 1)
			finalVector.normalize();

		entity.motionX = finalVector.x * modifier;
		entity.motionY = finalVector.y * modifier;
		entity.motionZ = finalVector.z * modifier;
	}
}
