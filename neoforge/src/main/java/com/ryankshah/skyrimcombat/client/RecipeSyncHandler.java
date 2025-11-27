package com.ryankshah.skyrimcombat.client;

import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.registry.RecipeRegistry;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

import java.util.Collection;

public class RecipeSyncHandler
{
    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        // Request that the server sends our custom recipe type to clients
        event.sendRecipes(RecipeRegistry.FORGE.get());
    }

    @SubscribeEvent
    public static void onRecipesReceived(RecipesReceivedEvent event) {
        // Cache the received recipes on the client
        for (RecipeType<?> recipeType : event.getRecipeTypes()) {
            if (recipeType == RecipeRegistry.FORGE.get()) {
                RecipeType<ForgeRecipe> recipeT = (RecipeType<ForgeRecipe>)recipeType;
                RecipeMap rawRecipeMap = event.getRecipeMap();
                Collection<RecipeHolder<ForgeRecipe>> recipes = rawRecipeMap.byType(recipeT);
                ClientRecipeCache.cacheRecipes(recipeType, recipes);
            }
        }
    }

    @SubscribeEvent
    public static void onClientLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        // Clear the client-side cache when leaving a world/server
        ClientRecipeCache.clearCache();
    }
}
