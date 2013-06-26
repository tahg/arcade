package com.tahgcraft.arcade.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPost extends ModelBase {

    public ModelRenderer[] base = new ModelRenderer[4];
    public ModelRenderer post;
    public ModelRenderer[] disks = new ModelRenderer[6];
    
    public ModelPost() {
        for (int i = 0; i < 4; i ++) {
            base[i] = new ModelRenderer(this, 0, i << 4).setTextureSize(64, 64);
        }
        base[0].addBox(1, 0, 1, 14, 2, 14);
        base[1].addBox(0, 0, 1, 15, 2, 14);
        base[2].addBox(1, 0, 1, 15, 2, 14);
        base[3].addBox(0, 0, 1, 16, 2, 14);
        post = new ModelRenderer(this, 56, 0).setTextureSize(64, 64);
        post.addBox(7, 2, 7, 2, 14, 2);
    }
    
    public void renderAll() {
        for (int i = 0; i < 4; i++) {
            base[i].render(0.0625F);
        }
        post.render(0.0625F);
    }
}
