package com.tahgcraft.arcade.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPost extends ModelBase {

    public ModelRenderer base;
    public ModelRenderer post;
    public ModelRenderer[] disks = new ModelRenderer[6];
    
    public ModelPost() {
        base = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        base.addBox(1, 0, 1, 14, 2, 14);
    }
    
    public void renderAll() {
        base.render(0.0625F);
    }
}
