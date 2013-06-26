package com.tahgcraft.arcade.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.tahgcraft.arcade.Arcade;
import com.tahgcraft.arcade.block.Post;

public class ItemPost extends Item {

    public ItemPost(int par1) {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,
            World par3World, int x, int y, int z, int face, float par8, float par9, float par10) {
        if (par3World.isRemote) return true;
        else if (face != 1) return false;
        ++y;
        Post post = Arcade.post;
        int dir = MathHelper.floor_double((double) (par2EntityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int xOff = Post.xOffsets[dir];
        int zOff = Post.zOffsets[dir];

        if (par2EntityPlayer.canPlayerEdit(x, y, z, face, par1ItemStack)
            && par2EntityPlayer.canPlayerEdit(x + xOff, y, z + zOff, face, par1ItemStack)
            && par2EntityPlayer.canPlayerEdit(x - xOff, y, z - zOff, face, par1ItemStack)) {
            if (par3World.isAirBlock(x, y, z) && par3World.isAirBlock(x + xOff, y, z + zOff)
                && par3World.isAirBlock(x - xOff, y, z - zOff)
                && par3World.doesBlockHaveSolidTopSurface(x, y - 1, z)
                && par3World.doesBlockHaveSolidTopSurface(x + xOff, y - 1, z + zOff)
                && par3World.doesBlockHaveSolidTopSurface(x - xOff, y - 1, z - zOff)) {
                par3World.setBlock(x, y, z, post.blockID, dir << 2 | 3, 3);

                if (par3World.getBlockId(x, y, z) == post.blockID) {
                    par3World.setBlock(x + xOff, y, z + zOff, post.blockID, dir << 2 | 2, 3);
                    par3World.setBlock(x - xOff, y, z - zOff, post.blockID, dir << 2 | 1, 3);

                    --par1ItemStack.stackSize;
                    return true;
                }
            }
        }
        return false;
    }
}
