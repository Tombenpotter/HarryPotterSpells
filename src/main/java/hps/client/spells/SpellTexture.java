package hps.client.spells;

import net.minecraft.util.ResourceLocation;

public class SpellTexture {

	private ResourceLocation texture;
	private int xSize, ySize, u, v;

	public SpellTexture(ResourceLocation texture, int xSize, int ySize, int u, int v) {
		this.texture = texture;
		this.xSize = xSize;
		this.ySize = ySize;
		this.u = u;
		this.v = v;
	}

	public ResourceLocation getTexture() {
		return texture;
	}

	public int getU() {
		return u;
	}

	public int getV() {
		return v;
	}

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}
}
