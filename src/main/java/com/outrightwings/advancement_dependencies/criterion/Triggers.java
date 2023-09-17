package com.outrightwings.advancement_dependencies.criterion;

import net.minecraft.advancements.CriteriaTriggers;

public class Triggers {
    public static DependsAdvancementTrigger DEPENDS_ADVANCEMENT_TRIGGER;

    public static void register(){
        DEPENDS_ADVANCEMENT_TRIGGER = CriteriaTriggers.register(new DependsAdvancementTrigger());
    }

}
