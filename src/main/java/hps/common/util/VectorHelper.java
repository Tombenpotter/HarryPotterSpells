package hps.common.util;

import hps.client.codechicken.lib.vec.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class VectorHelper {

	public static void moveEntityBasedOnVector3(Entity ent, Vector3 target, float amount) {
		Vector3 entPos = Vector3.fromEntityCenter(ent);
		double rotation = getRotation(entPos, target);
		ent.motionX = (double) (-MathHelper.sin((float) (rotation / 180.0F * (float) Math.PI)) * MathHelper.cos((float) (rotation / 180.0F * (float) Math.PI)) * amount);
		ent.motionZ = (double) (MathHelper.cos((float) (rotation / 180.0F * (float) Math.PI)) * MathHelper.cos((float) (rotation / 180.0F * (float) Math.PI)) * amount);
		ent.motionY = amount / 1.5;
	}

	public static void moveEntityAwayFromPoint(Entity ent, Vector3 target, double speed) {
		double mx = -getBlendDouble(ent.posX, target.x, speed);
		double my = -getBlendDouble(ent.posY, target.y, speed);
		double mz = -getBlendDouble(ent.posZ, target.z, speed);

		ent.velocityChanged = true;
		ent.isAirBorne = true;
		ent.addVelocity(mx, my, mz);
	}

	public static void moveEntityTowardsAPoint(Entity ent, Vector3 target, double speed) {
		double mx = getBlendDouble(ent.posX, target.x, speed);
		double my = getBlendDouble(ent.posY, target.y, speed);
		double mz = getBlendDouble(ent.posZ, target.z, speed);

		ent.velocityChanged = true;
		ent.isAirBorne = true;
		ent.addVelocity(mx, my, mz);
	}

	public static double getRotation(Vector3 pos1, Vector3 pos2) {
		float aX = (float) (pos1.x - pos2.x);
		float aZ = (float) (pos1.z - pos2.z);

		double angle = Math.atan2(aZ, aX) * 180 / Math.PI;

		return angle;
	}

	public static void transformToPoint(Vector3 position, Vector3 target, double blend) {
		position.set(blendPosDouble(position.x, target.x, blend), blendPosDouble(position.y, target.y, blend), blendPosDouble(position.z, target.z, blend));
	}

	public static double blendPosDouble(double var1, double var2, double blend) {
		if (var1 > var2)
			return var1 - blend;
		if (var1 < var2)
			return var1 + blend;
		return var1;
	}

	public static double getBlendDouble(double var1, double var2, double blend) {
		if (var1 > var2)
			return -blend;
		if (var1 < var2)
			return blend;
		return 0;
	}
}
