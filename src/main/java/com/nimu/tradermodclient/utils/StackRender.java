package com.nimu.tradermodclient.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class StackRender {
    public static ResourceLocation getResourceLocationStack(ItemStack stack)
    {
        TextureAtlasSprite sprite = null;
        Block b = Block.getBlockFromItem(stack.getItem());
        if(b != Blocks.AIR)
        {
            sprite = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(b.getStateFromMeta(stack.getMetadata()));//TODO check
        }
        else
        {
            sprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getItemModel(stack).getParticleTexture();
        }

        if(sprite == null)
        {
            return null;
        }
        String iconName = sprite.getIconName();
        String[] strs = iconName.split(":");
        if(strs.length > 1)
        {
            String resource = strs[0] + ":textures/" + strs[1] + ".png";
            return new ResourceLocation(resource);
        }
        return null;
    }
}
