package com.nimu.tradermodclient;

import com.nimu.tradermodclient.event.PlayerEvent;
import com.nimu.tradermodclient.items.ItemList;
import com.nimu.tradermodclient.packets.PacketCustom;
import com.nimu.tradermodclient.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "tradermodclient")
public class Main {
    @Mod.Instance
    public static Main INSTANCE;
    @SidedProxy(clientSide = "com.nimu.tradermodclient.proxy.ClientProxy", serverSide = "com.nimu.tradermodclient.proxy.ServerProxy")
    public static CommonProxy proxy;



    public Main(){
        MinecraftForge.EVENT_BUS.register(new ItemList());
        MinecraftForge.EVENT_BUS.register(new PlayerEvent());
    }

    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent event) {
    //networkWrapper.registerMessage(PacketCustom.Handler.class, PacketCustom.class, 1, Side.SERVER);

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e){
        proxy.registerRender();
        proxy.initPacket();
    }
}
