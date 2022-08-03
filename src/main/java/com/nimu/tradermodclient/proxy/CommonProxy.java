package com.nimu.tradermodclient.proxy;

import com.nimu.tradermodclient.Main;
import com.nimu.tradermodclient.gui.GuiHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void registerRender(){
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.INSTANCE, new GuiHandler());
    }
    public void registerModel(Item item, int metadata){
    }
    public void initPacket(){}
}
