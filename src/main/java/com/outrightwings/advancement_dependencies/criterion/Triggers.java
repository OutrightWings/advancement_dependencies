package com.outrightwings.advancement_dependencies.criterion;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Triggers {
    public static void register(final FMLCommonSetupEvent event){
        event.enqueueWork((Runnable) CriteriaTriggers.register(new DependsAdvancementTrigger()));
    }
}
