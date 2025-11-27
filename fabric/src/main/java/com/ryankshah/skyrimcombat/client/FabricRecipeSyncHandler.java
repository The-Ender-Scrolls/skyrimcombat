package com.ryankshah.skyrimcombat.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class FabricRecipeSyncHandler {

    public static void init() {
        initClient();
    }

    @Environment(EnvType.CLIENT)
    private static void initClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            ClientRecipeCache.clearCache();
        });
    }
}