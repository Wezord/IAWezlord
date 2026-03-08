package com.wezord.iawezlord.ia.entity;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;


public class RLAgentRenderer extends MobRenderer<
        RLAgentEntity,
        ZombieRenderState,
        ZombieModel<ZombieRenderState>> {

    public RLAgentRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new ZombieModel<>(context.bakeLayer(ModelLayers.ZOMBIE)),
                0.5f
        );
    }

    @Override
    public Identifier getTextureLocation(ZombieRenderState state) {
        return Identifier.withDefaultNamespace(
                "textures/entity/zombie/zombie.png"
        );
    }

    @Override
    public ZombieRenderState createRenderState() {
        return new ZombieRenderState();
    }
}