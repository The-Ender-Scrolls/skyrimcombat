package com.ryankshah.skyrimcombat.network;

import com.ryankshah.skyrimcombat.network.recipe.FinishForgeRecipe;
import com.ryankshah.skyrimcombat.network.recipe.OpenForgeScreen;
import com.ryankshah.skyrimcombat.network.recipe.SyncForgeRecipesPacket;
import commonnetwork.api.Network;

public class Networking
{
    public static void load() {
        Network.registerPacket(FinishForgeRecipe.type(), FinishForgeRecipe.class,  FinishForgeRecipe.CODEC, FinishForgeRecipe::handle);
        Network.registerPacket(OpenForgeScreen.type(), OpenForgeScreen.class, OpenForgeScreen.CODEC, OpenForgeScreen::handle);
        Network.registerPacket(SyncForgeRecipesPacket.type(), SyncForgeRecipesPacket.class, SyncForgeRecipesPacket.CODEC, SyncForgeRecipesPacket::handle);
    }
}