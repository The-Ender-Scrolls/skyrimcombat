package com.ryankshah.skyrimcombat.client;

import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientRecipeCache {
    // Thread-safe cache to avoid issues in singleplayer
    private static final Map<RecipeType<?>, Collection> RECIPE_CACHE = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static List<ForgeRecipe> getForgeRecipes(RecipeType<ForgeRecipe> recipeType) {
        Collection<RecipeHolder<?>> holders = RECIPE_CACHE.getOrDefault(recipeType, List.of());
        return holders.stream()
                .map(holder -> (ForgeRecipe) holder.value())
                .toList();
    }

    public static void cacheRecipes(RecipeType<?> recipeType, Collection recipes) {
        RECIPE_CACHE.put(recipeType, recipes);
    }

    public static void clearCache() {
        RECIPE_CACHE.clear();
    }
}