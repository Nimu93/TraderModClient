package com.nimu.tradermodclient.items;

import com.nimu.tradermodclient.Main;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ItemList {
    public static List<Item> ITEM_LIST = new ArrayList<>();
    public static Item SHOP_ITEM = new ShopItem();
    public static void registerModel(Item item, int metadata)
    {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event)
    {
        registerModel(SHOP_ITEM, 0);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e){
        for (Item i: ItemList.ITEM_LIST) {
            e.getRegistry().register(i);
        }
    }

}
