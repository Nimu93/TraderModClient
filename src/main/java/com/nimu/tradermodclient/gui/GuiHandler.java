package com.nimu.tradermodclient.gui;

import com.nimu.tradermodclient.json.JsonItemSellLoader;
import com.nimu.tradermodclient.packets.PacketListener;
import com.nimu.tradermodclient.utils.ItemSell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case 0:
                player.getHeldItem(EnumHand.MAIN_HAND);
                if (PacketListener.json != null){
                    List<ItemSell> res = JsonItemSellLoader.LoadItems(PacketListener.json);
                    return new ShopGui(res);
                }
                break;
        }
    return null;
    }

}
