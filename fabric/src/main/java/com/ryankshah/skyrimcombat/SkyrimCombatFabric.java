package com.ryankshah.skyrimcombat;

import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.loot.SkyrimCombatLootTables;
import com.ryankshah.skyrimcombat.network.recipe.SyncForgeRecipesPacket;
import com.ryankshah.skyrimcombat.registry.RecipeRegistry;
import com.ryankshah.skyrimcombat.world.WorldGenConstants;
import commonnetwork.api.Dispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.Collection;

public class SkyrimCombatFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Constants.LOG.info("Initializing Skyrim Combat");

        CommonClass.init();

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.getPlayer();
            sendRecipesToClient(player);
        });

        SkyrimCombatLootTables.addLootTables();
        addFeatures();

        Constants.LOG.info("Finished Initializing Skyrim Combat");
    }

    public static void sendRecipesToClient(ServerPlayer player) {
        RecipeManager recipeManager = player.level().recipeAccess();
        Collection<RecipeHolder<ForgeRecipe>> forgeRecipes = recipeManager.getAllOfType(RecipeRegistry.FORGE.get());

        if (!forgeRecipes.isEmpty()) {
            SyncForgeRecipesPacket packet = new SyncForgeRecipesPacket(forgeRecipes.stream().toList());
            Dispatcher.sendToClient(packet, player);
        }
    }

    protected void addFeatures() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.CORUNDUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.EBONY_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.MALACHITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.MOONSTONE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.ORICHALCUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.QUICKSILVER_ORE_PLACED_KEY);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                WorldGenConstants.SILVER_ORE_PLACED_KEY);
    }
}
