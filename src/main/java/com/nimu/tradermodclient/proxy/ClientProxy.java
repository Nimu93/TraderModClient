package com.nimu.tradermodclient.proxy;

import com.nimu.tradermodclient.packets.PacketCustom;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends CommonProxy{
    public static SimpleNetworkWrapper networkWrapper;
    @Override
    public void registerModel(Item iem, int metadata){
        ModelLoader.setCustomModelResourceLocation(iem, metadata, new ModelResourceLocation(iem.getRegistryName(), "inventory"));
    }
    @Override
    public void initPacket(){
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("TraderPlugin");
        networkWrapper.registerMessage(PacketCustom.Handler.class, PacketCustom.class, 47, Side.CLIENT);

    }
}
