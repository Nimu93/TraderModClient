package com.nimu.tradermodclient.gui;

import com.nimu.tradermodclient.Main;
import com.nimu.tradermodclient.gui.button.ItemButton;
import com.nimu.tradermodclient.items.ItemList;
import com.nimu.tradermodclient.packets.ID;
import com.nimu.tradermodclient.packets.PacketCustom;
import com.nimu.tradermodclient.utils.ItemSell;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;

public class ShopGui extends GuiScreen {
    List<ItemSell> itemSells;
    private static final ResourceLocation CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    public ShopGui(List<ItemSell> itemSells){
        this.itemSells = itemSells;
    }

    @Override
    public void initGui(){
        int i=0;
        int x =0;
        int y = 0;
        for(ItemSell itemSell: itemSells){
            this.buttonList.add(new ItemButton(i, (this.width/4 )-x, (this.height/2) - (this.height / 3)-y, (this.width/2) - (this.width/4),(this.height/2) - (this.height/4),"", itemSell, mc));
            if (i > 0 && i%4 == 0){
                y +=25;
                x =0;
            }
            x +=25;
            i++;
        }
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        mc.getTextureManager().bindTexture(CREATIVE_INVENTORY_TABS);
        this.drawTexturedModalRect(this.width / 2 - 120, this.height / 2 - 100, 0, 0, 250, 650);
        for (GuiButton guiButton: this.buttonList){
           ItemButton itemButton = (ItemButton)guiButton;
           if (itemButton.getHovered()){
           this.drawHoveringText(itemButton.itemname.getName()+"\n Right click for buying: "+ itemButton.itemname.getPrice_to_buy() +" \n Left click for selling: " + itemButton.itemname.getPrice_to_sell(), mouseX, mouseY);
           }
        }
        super.drawScreen(mouseX, mouseY, partialTick);
    }
    @Override
    public void updateScreen(){
        super.updateScreen();
        if(mc.player.isDead){
            mc.player.closeScreen();
        }
    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 1){
            for (GuiButton guiButton: this.buttonList){
                ItemButton itemButton = (ItemButton)guiButton;
                if (itemButton.mousePressed(mc, mouseX, mouseY)){
                    this.mc.displayGuiScreen(new NumberBuyGui(itemButton.itemname, true));

                }
            }

        }
        else {
            for (GuiButton guiButton: this.buttonList){
                ItemButton itemButton = (ItemButton)guiButton;
                if (itemButton.mousePressed(mc, mouseX, mouseY)){
                    this.mc.displayGuiScreen(new NumberBuyGui(itemButton.itemname, false));

                }
            }
        }
    }
    @Override
    protected void keyTyped(char keytyped, int keyCode){
        if(keyCode == 1 ||keyCode == mc.gameSettings.keyBindInventory.getKeyCode()){
            mc.player.closeScreen();
        }
    }

}
