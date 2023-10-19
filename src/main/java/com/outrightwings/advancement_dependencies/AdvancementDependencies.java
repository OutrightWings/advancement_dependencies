package com.outrightwings.advancement_dependencies;

import com.mojang.logging.LogUtils;
import com.outrightwings.advancement_dependencies.criterion.DependsAdvancementTrigger;
import com.outrightwings.advancement_dependencies.criterion.Triggers;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static com.outrightwings.advancement_dependencies.criterion.Triggers.DEPENDS_ADVANCEMENT_TRIGGER;

@Mod(AdvancementDependencies.MODID)
public class AdvancementDependencies
{
    public static final String MODID = "advancement_dependencies";
    private static final Logger LOGGER = LogUtils.getLogger();
    public AdvancementDependencies()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(Triggers.class);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        Triggers.register(event);
    }
}
