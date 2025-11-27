package com.ryankshah.skyrimcombat;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SkyrimCombatNeo
{
    public SkyrimCombatNeo(ModContainer container, IEventBus eventBus) {
        Constants.LOG.info("Initializing Skyrim Combat");
        CommonClass.init();
        Constants.LOG.info("Finished Initializing Skyrim Combat");
    }
}