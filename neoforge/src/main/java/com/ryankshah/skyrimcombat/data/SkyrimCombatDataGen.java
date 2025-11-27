package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.data.loot.SkyrimcraftLootTableProvider;
import com.ryankshah.skyrimcombat.data.world.SCWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class SkyrimCombatDataGen {
    
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        
        // Block Tags
        SkyrimCombatBlockTagsProvider blockTagsProvider = generator.addProvider(
            true,
            new SkyrimCombatBlockTagsProvider(packOutput, lookupProvider, Constants.MOD_ID)
        );
        
        // Item Tags (depends on block tags)
        generator.addProvider(
                true,
            new SkyrimCombatItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter())
        );
        
        // Loot Tables
        generator.addProvider(
                true,
            new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(SkyrimCombatBlockLootTables::new, LootContextParamSets.BLOCK),
                    new LootTableProvider.SubProviderEntry(SkyrimcraftLootTableProvider::new, LootContextParamSets.CHEST)
            ), lookupProvider)
        );
        
        // Recipes
        generator.addProvider(
                true,
                new SkyrimCombatRecipeProvider.Runner(packOutput, lookupProvider)
        );
        
        // Language
        generator.addProvider(
                true,
            new SkyrimCombatLanguageProvider(packOutput, "en_us")
        );

        // Models
        generator.addProvider(
                true,
                new SkyrimCombatModelProvider(packOutput)
        );

        generator.addProvider(
                true,
                new ForgeRecipeProvider.Runner(packOutput, lookupProvider) {
                    @Override
                    protected ForgeRecipeProvider createForgeRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
                        return new ForgeRecipeProvider.SkyrimForgeRecipeProvider(registries, output);
                    }
                }
        );

        generator.addProvider(
                true,
                new SCWorldGenProvider(packOutput, lookupProvider)
        );
    }
}