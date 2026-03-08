package com.wezord.iawezlord.registry;

import com.wezord.iawezlord.IAWezlord;
import com.wezord.iawezlord.ia.entity.RLAgentEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, IAWezlord.MODID);

    public static <T extends net.minecraft.world.entity.Mob>
    DeferredHolder<EntityType<?>, EntityType<T>> registerMob(
            String name,
            EntityType.EntityFactory<T> factory,
            float width,
            float height
    ) {

        return ENTITIES.register(name, () -> {

            ResourceKey<EntityType<?>> key =
                    ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath(IAWezlord.MODID, name)
                            
                    );

            return EntityType.Builder
                    .of(factory, MobCategory.CREATURE)
                    .sized(width, height)
                    .build(key);
        });
    }
    
    public static final DeferredHolder<EntityType<?>, EntityType<RLAgentEntity>> RL_AGENT =
            ModEntities.registerMob(
                    "rl_agent",
                    RLAgentEntity::new,
                    0.6f,
                    1.8f
            );
}
