package com.nimu.tradermodclient.gui;

import com.nimu.tradermodclient.Main;
import com.nimu.tradermodclient.gui.button.ItemButton;
import com.nimu.tradermodclient.packets.ID;
import com.nimu.tradermodclient.packets.PacketCustom;
import com.nimu.tradermodclient.proxy.ClientProxy;
import com.nimu.tradermodclient.utils.ItemSell;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
@SideOnly(Side.CLIENT)
public class NumberBuyGui extends GuiScreen {
    private final ItemSell itemSell;
    private boolean isSelling;
    private static final ResourceLocation CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    private GuiTextField numberguitextfield;

    public NumberBuyGui(ItemSell itemSell, boolean isSelling){
        this.isSelling = isSelling;
        this.itemSell = itemSell;
    }
    @Override
    public void initGui(){
      numberguitextfield = new GuiTextField(0, this.mc.fontRenderer, (this.width/4 ), (this.height/2) - (this.height / 3), (this.width/2) - (this.width/4),20);
    }
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if(keyCode == 1 ||keyCode == mc.gameSettings.keyBindInventory.getKeyCode()){
            mc.player.closeScreen();
        }
        if (numberguitextfield.isFocused() && Character.isDigit(typedChar)){
            numberguitextfield.textboxKeyTyped(typedChar, keyCode);
        }

        if ((keyCode == 28 || keyCode == 156))
        {
            String s = numberguitextfield.getText();
            if (!StringUtils.isEmpty(s)){
                ClientProxy.networkWrapper.sendToServer(new PacketCustom(ID.CHECKVERIF.getType(), s + "!" + itemSell.getName() +"!" + isSelling));
                numberguitextfield.setText("");
                numberguitextfield.setFocused(false);
                this.mc.player.closeScreen();
            }

        }
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        mc.getTextureManager().bindTexture(CREATIVE_INVENTORY_TABS);
        this.drawTexturedModalRect(this.width / 2 - 120, this.height / 2 - 100, 0, 0, 250, 650);
        numberguitextfield.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTick);
    }
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX,mouseY,mouseButton);
        numberguitextfield.mouseClicked(mouseX,mouseY,mouseButton);
    }
}
