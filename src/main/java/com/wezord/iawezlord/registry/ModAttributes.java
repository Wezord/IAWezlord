package com.wezord.iawezlord.registry;


import com.wezord.iawezlord.ia.entity.RLAgentEntity;

import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class ModAttributes {

    public static void register(EntityAttributeCreationEvent event) {

        event.put(ModEntities.RL_AGENT.get(), RLAgentEntity.createAttributes().build());

    }

}