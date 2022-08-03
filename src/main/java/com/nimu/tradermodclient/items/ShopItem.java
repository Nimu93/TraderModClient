package com.nimu.tradermodclient.items;

import com.nimu.tradermodclient.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ShopItem extends Item {
    public ShopItem(){
        setUnlocalizedName("shop_item").setRegistryName("shop_item").setCreativeTab(CreativeTabs.COMBAT);
        ItemList.ITEM_LIST.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (handIn.equals(EnumHand.MAIN_HAND)){
            playerIn.openGui(Main.INSTANCE, 0, worldIn, (int) playerIn.posX,(int) playerIn.posY,(int) playerIn.posZ);
        }
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
