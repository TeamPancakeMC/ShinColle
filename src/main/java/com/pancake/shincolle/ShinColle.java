package com.pancake.shincolle;

import com.pancake.shincolle.init.SCBlocks;
import com.pancake.shincolle.init.SCEntityTypes;
import com.pancake.shincolle.init.SCItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ShinColle.MOD_ID)
public class ShinColle {

    public static final String MOD_ID = "shin_colle";

    public ShinColle() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SCItems.ITEMS.register(eventBus);
        SCBlocks.BLOCKS.register(eventBus);
        SCEntityTypes.ENTITY_TYPES.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

}