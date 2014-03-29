package harryPotterMod.tombenpotter.harrypottermod.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.projectiles.spells.ProjectileDamage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTestCast extends Item{
	
	public ItemTestCast(String name)
	{
		this.setUnlocalizedName("hp" + "." + "item" + name);
		this.setMaxStackSize(1);
		this.setCreativeTab(HPCreativeTab.tabHPMod);
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
		if(!world.isRemote)
		{
			ProjectileDamage spell = new ProjectileDamage(world, player);
			world.spawnEntityInWorld(spell);
		}
        return false;
    }
	
}
