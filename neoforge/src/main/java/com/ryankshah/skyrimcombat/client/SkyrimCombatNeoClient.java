package com.ryankshah.skyrimcombat.client;

import com.ryankshah.skyrimcombat.Constants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class SkyrimCombatNeoClient
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        NeoForge.EVENT_BUS.register(RecipeSyncHandler.class);
    }
}
