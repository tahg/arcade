package com.tahgcraft.arcade.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tahgcraft.arcade.Arcade;
import com.tahgcraft.arcade.tileentity.TileEntityPost;

public class Post extends Block {

    public static int[] xOffsets = { -1, 0, 1, 0 };
    public static int[] zOffsets = { 0, -1, 0, 1 };

    public Post(int id) {
        super(id, Material.iron);
        setUnlocalizedName("Post");
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }

    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityPost();
    }

    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return (par1 == 0 || par1 == 3) ? Arcade.itemPost.itemID : 0;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int id) {
    }
    
    @Override
    public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        int xOff = xOffsets[meta >> 2];
        int zOff = zOffsets[meta >> 2];
        switch (meta & 3) {
            case 3:
                if (world.getBlockId(x + xOff, y, z + zOff) == blockID)
                    world.setBlockToAir(x + xOff, y, z + zOff);
                if (world.getBlockId(x - xOff, y, z - zOff) == blockID)
                    world.setBlockToAir(x - xOff, y, z - zOff);
                //fall through
            case 0:
                world.setBlockToAir(x, y, z);
                break;
            case 1:
                if (world.getBlockId(x + xOff, y, z + zOff) == blockID)
                    removeBlockByPlayer(world, player, x + xOff, y, z + zOff);
                break;
            case 2:
                if (world.getBlockId(x - xOff, y, z - zOff) == blockID)
                    removeBlockByPlayer(world, player, x - xOff, y, z - zOff);
                break;
        }
        return true;
    }
}
