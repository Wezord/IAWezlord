package com.wezord.iawezlord.registry;

import com.wezord.iawezlord.ia.entity.RLAgentRenderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ModRenderers {

    public static void register(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(
                ModEntities.RL_AGENT.get(),
                RLAgentRenderer::new
        );

    }

}