package hps.client.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderItemWand implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	private ResourceLocation itemModel = new ResourceLocation("harrypottermod", "/textures/items/wand.obj");
	private IModelCustom model = AdvancedModelLoader.loadModel(itemModel);
	private ResourceLocation texture = new ResourceLocation("harrypottermod", "/textures/items/wand.png");

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		switch (type) {
		case INVENTORY:
			GL11.glTranslatef(-0.3F, -0.75F, 0.5F);
			GL11.glScalef(1.1F, 1.1F, 1.1F);
			GL11.glRotatef(-45, 0.5F, 0.5F, 0.5F);
			break;
		case EQUIPPED:
			GL11.glTranslatef(0.72F, 0.7F, 0.70F);
			GL11.glScalef(2F, 1.5F, 2F);
			GL11.glRotatef(45, -2F, 0.8F, 1.2F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(-0.0F, -0.75F, 0.0F);
			GL11.glScalef(2F, 2F, 2F);
			GL11.glRotatef(-45, 0.2F, 0.2F, 0.2F);
			break;
		default:
		}
		GL11.glScalef(3F, 3F, 3F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
}
