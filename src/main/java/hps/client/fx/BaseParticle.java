package hps.client.fx;

import hps.common.lib.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BaseParticle extends EntityFX {

	public int particleFacing = IParticleFacing.PLAYER;
	public String textures = ModInfo.MODID + ":textures/particle/particles.png";

	protected BaseParticle(World world, double x, double y, double z) {
		super(world, x, y, z);
		noClip = true;
	}

	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY) {
		tess.draw();

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(textures));

		tess.startDrawingQuads();

		tess.setBrightness(getBrightnessForRender(partialTicks));
		tess.setColorRGBA_F(particleRed, particleGreen, particleBlue, particleAlpha);

		SetTessellatorFacing(tess, partialTicks, rotX, rotXZ, rotZ, rotYZ, rotXY);

		tess.draw();
		tess.startDrawingQuads();

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("textures/particle/particles.png"));
	}

	private void SetTessellatorFacing(Tessellator tess, float partialTicks, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY) {
		float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);

		switch (particleFacing) {
		case IParticleFacing.UP:
			tess.addVertexWithUV(x - 0.5 * particleScale, y, z - 0.5 * particleScale, 0, 0);
			tess.addVertexWithUV(x - 0.5 * particleScale, y, z + 0.5 * particleScale, 1, 0);
			tess.addVertexWithUV(x + 0.5 * particleScale, y, z + 0.5 * particleScale, 1, 1);
			tess.addVertexWithUV(x + 0.5 * particleScale, y, z - 0.5 * particleScale, 0, 1);
			break;

		case IParticleFacing.PLAYER:
			tess.addVertexWithUV(x - rotX * particleScale - rotYZ * particleScale, y - rotXZ * particleScale, z - rotZ * particleScale - rotXY * particleScale, 0, 0);
			tess.addVertexWithUV(x - rotX * particleScale + rotYZ * particleScale, y + rotXZ * particleScale, z - rotZ * particleScale + rotXY * particleScale, 1, 0);
			tess.addVertexWithUV(x + rotX * particleScale + rotYZ * particleScale, y + rotXZ * particleScale, z + rotZ * particleScale + rotXY * particleScale, 1, 1);
			tess.addVertexWithUV(x + rotX * particleScale - rotYZ * particleScale, y - rotXZ * particleScale, z + rotZ * particleScale - rotXY * particleScale, 0, 1);
			break;

		default:
			tess.addVertexWithUV(x, y, z, 0, 0);
			tess.addVertexWithUV(x, y, z, 1, 0);
			tess.addVertexWithUV(x, y, z, 1, 1);
			tess.addVertexWithUV(x, y, z, 0, 1);
			break;
		}
	}

	public void SetParticleColour(int colour) {
		switch (colour) {
		case IColor.WHITE:
			setRBGColorF(0.87f, 0.87f, 0.87f);
			break;

		case IColor.ORANGE:
			setRBGColorF(0.86f, 0.49f, 0.24f);
			break;

		case IColor.MAGENTA:
			setRBGColorF(0.70f, 0.31f, 0.74f);
			break;

		case IColor.LIGHT_BLUE:
			setRBGColorF(0.42f, 0.54f, 0.79f);
			break;

		case IColor.YELLOW:
			setRBGColorF(0.69f, 0.65f, 0.15f);
			break;

		case IColor.LIME:
			setRBGColorF(0.25f, 0.68f, 0.22f);
			break;

		case IColor.PINK:
			setRBGColorF(0.82f, 0.52f, 0.6f);
			break;

		case IColor.GRAY:
			setRBGColorF(0.25f, 0.25f, 0.25f);
			break;

		case IColor.LIGHT_GRAY:
			setRBGColorF(0.60f, 0.63f, 0.63f);
			break;

		case IColor.CYAN:
			setRBGColorF(0.18f, 0.43f, 0.54f);
			break;

		case IColor.PURPLE:
			setRBGColorF(0.49f, 0.24f, 0.71f);
			break;

		case IColor.BLUE:
			setRBGColorF(0.18f, 0.22f, 0.55f);
			break;

		case IColor.BROWN:
			setRBGColorF(0.31f, 0.20f, 0.12f);
			break;

		case IColor.GREEN:
			setRBGColorF(0.21f, 0.27f, 0.11f);
			break;

		case IColor.RED:
			setRBGColorF(0.59f, 0.20f, 0.19f);
			break;

		case IColor.BLACK:
			setRBGColorF(0.10f, 0.09f, 0.09f);
			break;

		default:
			setRBGColorF(1f, 1f, 1f);
			break;
		}
	}
}
