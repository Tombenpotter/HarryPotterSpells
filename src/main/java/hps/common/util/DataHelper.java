package hps.common.util;

import hps.common.world.PlayerData;
import net.minecraft.world.World;

public class DataHelper {
	
	public static PlayerData getData(World world){
		PlayerData data = (PlayerData) world.mapStorage.loadData(PlayerData.class, "playerData");
		if(data == null){
			data = new PlayerData();
			world.mapStorage.setData("playerData", data);
		}
		return data;
	}
	
}
