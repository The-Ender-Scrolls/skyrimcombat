package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class SkyrimCombatBlockLootTables extends BlockLootSubProvider {
    
    public SkyrimCombatBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.CORUNDUM_ORE.get());
        dropSelf(BlockRegistry.EBONY_ORE.get());
        dropSelf(BlockRegistry.MALACHITE_ORE.get());
        dropSelf(BlockRegistry.MOONSTONE_ORE.get());
        dropSelf(BlockRegistry.ORICHALCUM_ORE.get());
        dropSelf(BlockRegistry.QUICKSILVER_ORE.get());
        dropSelf(BlockRegistry.SILVER_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_EBONY_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get());
        dropSelf(BlockRegistry.DEEPSLATE_SILVER_ORE.get());
        dropSelf(BlockRegistry.BLACKSMITH_FORGE.get());
        dropSelf(BlockRegistry.ARCANE_ENCHANTER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
            .filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(Constants.MOD_ID))
            .collect(Collectors.toSet());
    }
}
