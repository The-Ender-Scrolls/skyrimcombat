package com.ryankshah.skyrimcombat;

import com.ryankshah.skyrimcombat.network.Networking;
import com.ryankshah.skyrimcombat.registry.*;
import com.ryankshah.skyrimcombat.world.WorldGenConstants;

public class CommonClass
{
    public static void init() {
        EffectRegistry.init();
        ItemRegistry.init();
        BlockRegistry.init();
        RecipeRegistry.init();
        CreativeTabRegistry.init();
        FeatureRegistry.init();
        WorldGenConstants.init();

        Networking.load();
    }
}