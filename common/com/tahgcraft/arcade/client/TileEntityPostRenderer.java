package com.tahgcraft.arcade.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.tahgcraft.arcade.client.model.ModelPost;
import com.tahgcraft.arcade.tileentity.TileEntityPost;

public class TileEntityPostRenderer extends TileEntitySpecialRenderer {

    ModelPost post = new ModelPost();
    
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y,
            double z, float partialTick) {
        render((TileEntityPost) tileentity, x, y, z, partialTick);
    }

    private void render(TileEntityPost tileentity, double x, double y,
            double z, float partialTick) {
        int meta = tileentity.getBlockMetadata();
        int rotation = meta >> 2;
        int type = meta & 3;
        for (int i = 0; i < 4; i++) {
            post.base[i].isHidden = type != i;
        }
        bindTextureByName("/mods/arcade/models/post.png");
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glTranslatef(.5F, .5F, .5F);
        GL11.glRotatef(90 * rotation, 0F, -1F, 0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        post.renderAll();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
