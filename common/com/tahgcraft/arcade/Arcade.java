package com.tahgcraft.arcade;

import net.minecraftforge.common.Configuration;

import com.tahgcraft.arcade.block.Post;
import com.tahgcraft.arcade.item.ItemPost;
import com.tahgcraft.arcade.lib.Reference;
import com.tahgcraft.arcade.tileentity.TileEntityPost;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Arcade {
    private int blockIdPost;
    private int itemIdPost;
    public static Post post;
    @SidedProxy(clientSide = "com.tahgcraft.arcade.client.ClientProxy", serverSide = "com.tahgcraft.arcade.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();
            blockIdPost = cfg.getBlock("post", 600).getInt(600);
            itemIdPost = cfg.getItem("post", 5000).getInt(5000);
        }
        finally {
            cfg.save();
        }
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        post = new Post(blockIdPost);
        GameRegistry.registerBlock(post, "BlockPost");
        GameRegistry.registerTileEntity(TileEntityPost.class, "tileArcadePost");
        proxy.registerTileEntitySpecialRenderer();
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        
    }
}
