package com.nimu.tradermodclient.event;

import com.nimu.tradermodclient.packets.PacketListener;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = "tradermodclient", value = Side.CLIENT)
public class PlayerEvent {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event){
        PacketListener.json = null;
    }
}
