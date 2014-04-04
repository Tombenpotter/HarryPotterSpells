package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.HarryPotterMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSpellBook extends Item
{
	public ItemSpellBook(String itemName)
	{
		this.setUnlocalizedName("hp" + "." + "item" + itemName);

		this.setCreativeTab(HPCreativeTab.tabHPMod);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);

		name = itemName;
		init();
	}

	String name;

	public void init()
	{
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.openGui(HarryPotterMod.instance, 0, world, 0, 0, 0);
		return stack;
	}
}
