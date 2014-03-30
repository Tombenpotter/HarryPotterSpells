package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.HarryPotterMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTestCast extends Item
{

	public ItemTestCast(String name)
	{
		this.setUnlocalizedName("hp" + "." + "item" + "." + name);
		this.setMaxStackSize(1);
		this.setCreativeTab(HPCreativeTab.tabHPMod);

		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		itemIcon = ir.registerIcon(HarryPotterMod.modid + ":" + "ingot");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
//		ProjectileDamage spell;
//		spell = new ProjectileDamage(world, player);
//		world.spawnEntityInWorld(spell);
		return stack;
	}

}
