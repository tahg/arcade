package com.tahgcraft.arcade.client;

import net.minecraft.world.World;

import com.tahgcraft.arcade.CommonProxy;
import com.tahgcraft.arcade.block.Post;
import com.tahgcraft.arcade.tileentity.TileEntityPost;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderInformation()
    {
    }

    @Override
    public void registerTileEntitySpecialRenderer()
    {
        int postRenderId = RenderingRegistry.getNextAvailableRenderId();
        //TileEntityPostRenderer
        Post.renderId = postRenderId;
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPost.class, new TileEntityPostRenderer());
    }

    @Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }

}