package com.outrightwings.advancement_dependencies.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;

public class DependsAdvancementTrigger extends SimpleCriterionTrigger<DependsAdvancementTrigger.TriggerInstance> {
    static ResourceLocation ID = new ResourceLocation("depends_advancement");;

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public DependsAdvancementTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite predicate, DeserializationContext context) {
        ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(json, "advancement"));
        return new DependsAdvancementTrigger.TriggerInstance(resourcelocation,predicate);
    }

    public void trigger(ServerPlayer player, Advancement advancement) {
        this.trigger(player,
                triggerInstance -> triggerInstance.matches(advancement)
        );
    }
    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ResourceLocation advancement;

        public TriggerInstance(ResourceLocation advancement, EntityPredicate.Composite predicate) {
            super(DependsAdvancementTrigger.ID, predicate);
            this.advancement = advancement;
        }

        public JsonObject serializeToJson(SerializationContext context) {
            JsonObject jsonobject = super.serializeToJson(context);
            jsonobject.addProperty("advancement", this.advancement.toString());
            return jsonobject;
        }

        public boolean matches(Advancement advancement) {
            return this.advancement.equals(advancement.getId());
        }
    }
}
