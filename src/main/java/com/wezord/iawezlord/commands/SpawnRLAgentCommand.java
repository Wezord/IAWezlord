package com.wezord.iawezlord.commands;

import com.mojang.brigadier.Command;
import com.wezord.iawezlord.ia.entity.RLAgentEntity;
import com.wezord.iawezlord.registry.ModEntities;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class SpawnRLAgentCommand {
    
    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(
            Commands.literal("ia")
                .then(
                    Commands.literal("spawn")
                        .executes(context -> spawnAgent(context.getSource()))
                )
        );
    }
    
    private static int spawnAgent(CommandSourceStack source) {
        if (source.getEntity() == null) {
            source.sendFailure(Component.literal("Cette commande doit être exécutée par une entité"));
            return 0;
        }
        
        RLAgentEntity agent = new RLAgentEntity(
            ModEntities.RL_AGENT.get(),
            source.getLevel()
        );
        
        agent.setPos(source.getPosition().x, source.getPosition().y, source.getPosition().z);
        source.getLevel().addFreshEntity(agent);
        
        source.sendSuccess(
            () -> Component.literal("RL Agent spawné à votre position"),
            true
        );
        
        return Command.SINGLE_SUCCESS;
    }
}
