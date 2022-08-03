package com.nimu.tradermodclient.gui.button;

import com.nimu.tradermodclient.utils.ItemSell;
import com.nimu.tradermodclient.utils.StackRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.Objects;

public class ItemButton extends GuiButton {
    public ItemSell itemname;
    ResourceLocation resourceLocation;
    Minecraft minecraft;
    public ItemButton(int id,int x, int y, int width,int height, String name, ItemSell itemname, Minecraft minecraft){
        super(id,x,y,width, height,name);
        this.itemname = itemname;
        this.minecraft = minecraft;
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft",itemname.getName())) == null){
            resourceLocation = new ResourceLocation("aaa");
        }else {

      // resourceLocation = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemname.getName())).getRegistryName();
        resourceLocation = StackRender.getResourceLocationStack(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft",itemname.getName()))));
        }
    }
    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
        if (this.visible){
            mc.getTextureManager().bindTexture(resourceLocation);
            GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            this.minecraft.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft",itemname.getName()))), x, y);
            // this.drawTexturedModalRect(this.x, this.y, this.x, this.y, this.width-2, this.height-2);
            //this.drawTexturedModalRect(this.x + this.width, this.y + this.height, this.width, this.height, this.width, this.height);
        }
    }
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
        return this.enabled && this.visible && mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
    }

    public boolean getHovered(){
        return this.hovered;
    }
}
