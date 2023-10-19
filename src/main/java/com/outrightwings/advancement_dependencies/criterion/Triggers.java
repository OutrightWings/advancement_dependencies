package com.outrightwings.advancement_dependencies.criterion;

import com.outrightwings.advancement_dependencies.AdvancementDependencies;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
@Mod(AdvancementDependencies.MODID)
public class Triggers {
    public static final DependsAdvancementTrigger DEPENDS_ADVANCEMENT_TRIGGER = new DependsAdvancementTrigger();
    public static void register(final FMLCommonSetupEvent event){
        event.enqueueWork(()-> CriteriaTriggers.register(DEPENDS_ADVANCEMENT_TRIGGER));
    }
    @SubscribeEvent
    public static void onAdvancement(final AdvancementEvent.AdvancementEarnEvent event){
        DEPENDS_ADVANCEMENT_TRIGGER.trigger((ServerPlayer) event.getEntity(),event.getAdvancement());
    }
}
