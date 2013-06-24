package com.tahgcraft.arcade.block;

import com.tahgcraft.arcade.tileentity.TileEntityPost;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Post extends Block {

    public static int renderId = -1;
    
    public Post(int id) {
        super(id, Material.iron);
        setUnlocalizedName("Post");
        setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    public TileEntity createNewTileEntity(World w) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return renderId;
    }
    
    public TileEntity createTileEntity(World  world, int metadata) {
        return new TileEntityPost();
    }
}
