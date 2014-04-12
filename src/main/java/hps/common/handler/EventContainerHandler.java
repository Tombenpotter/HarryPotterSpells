package hps.common.handler;

import hps.common.net.ChannelHelper;
import hps.common.net.packets.SyncWorldData;
import hps.common.util.DataHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class EventContainerHandler {
	@SubscribeEvent
	public void EntityJoinWorldEvent(EntityJoinWorldEvent event){
		if(!event.world.isRemote && event.entity instanceof EntityPlayer){
			DataHelper.getData(event.world).addPlayer((EntityPlayer) event.entity);
			ChannelHelper.sendTo(new SyncWorldData(event.world), (EntityPlayerMP) event.entity);
		}
	}
}
