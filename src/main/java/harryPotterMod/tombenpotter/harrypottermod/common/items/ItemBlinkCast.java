package harryPotterMod.tombenpotter.harrypottermod.common.items;

import harryPotterMod.tombenpotter.harrypottermod.common.HPCreativeTab;
import harryPotterMod.tombenpotter.harrypottermod.common.HarryPotterMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlinkCast extends Item{
	
	public ItemBlinkCast(String name)
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
		renderLines(player, world);
			
		return stack;
    }
	
	public void renderLines(EntityPlayer player, World world)
	{
		double x, y, z;
		
		x = player.posX;
		y = player.posY;
		z = player.posZ;
		
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glLineWidth(10F);
		
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2d(x +2D, y + 1D);
		
		GL11.glEnd();
		GL11.glPopMatrix();
	}	
}
