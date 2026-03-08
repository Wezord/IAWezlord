package com.wezord.iawezlord.ia.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import com.wezord.iawezlord.IAWezlord;
import com.wezord.iawezlord.ia.entity.RLAgentEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, IAWezlord.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<RLAgentEntity>> RL_AGENT =
    		ENTITIES.register("rl_agent", () -> {

                ResourceKey<EntityType<?>> key =
                        ResourceKey.create(
                                Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(IAWezlord.MODID, "rl_agent")
                    
                        );

                return EntityType.Builder
                        .of(RLAgentEntity::new, MobCategory.CREATURE)
                        .sized(0.6f, 1.8f)
                        .build(key);
            });

}