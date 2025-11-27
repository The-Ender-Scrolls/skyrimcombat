package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import com.ryankshah.skyrimcombat.registry.TagsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class SkyrimCombatBlockTagsProvider extends BlockTagsProvider {
    
    public SkyrimCombatBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                         String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //ores
        tag(TagsRegistry.BlockTagsInit.CORUNDUM_ORE_TAG).add(BlockRegistry.CORUNDUM_ORE.get());
        tag(TagsRegistry.BlockTagsInit.EBONY_ORE_TAG).add(BlockRegistry.EBONY_ORE.get());
        tag(TagsRegistry.BlockTagsInit.MALACHITE_ORE_TAG).add(BlockRegistry.MALACHITE_ORE.get());
        tag(TagsRegistry.BlockTagsInit.MOONSTONE_ORE_TAG).add(BlockRegistry.MOONSTONE_ORE.get());
        tag(TagsRegistry.BlockTagsInit.ORICHALCUM_ORE_TAG).add(BlockRegistry.ORICHALCUM_ORE.get());
        tag(TagsRegistry.BlockTagsInit.QUICKSILVER_ORE_TAG).add(BlockRegistry.QUICKSILVER_ORE.get());
        tag(TagsRegistry.BlockTagsInit.SILVER_ORE_TAG).add(BlockRegistry.SILVER_ORE.get());

        // deepslate ores
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_CORUNDUM_ORE_TAG).add(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_EBONY_ORE_TAG).add(BlockRegistry.DEEPSLATE_EBONY_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_MALACHITE_ORE_TAG).add(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_MOONSTONE_ORE_TAG).add(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_ORICHALCUM_ORE_TAG).add(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_QUICKSILVER_ORE_TAG).add(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get());
        tag(TagsRegistry.BlockTagsInit.DEEPSLATE_SILVER_ORE_TAG).add(BlockRegistry.DEEPSLATE_SILVER_ORE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.CORUNDUM_ORE.get())
                .add(BlockRegistry.EBONY_ORE.get())
                .add(BlockRegistry.MALACHITE_ORE.get())
                .add(BlockRegistry.MOONSTONE_ORE.get())
                .add(BlockRegistry.ORICHALCUM_ORE.get())
                .add(BlockRegistry.QUICKSILVER_ORE.get())
                .add(BlockRegistry.SILVER_ORE.get())
                .add(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get())
                .add(BlockRegistry.DEEPSLATE_EBONY_ORE.get())
                .add(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get())
                .add(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get())
                .add(BlockRegistry.DEEPSLATE_SILVER_ORE.get())
                .add(BlockRegistry.BLACKSMITH_FORGE.get())
                .add(BlockRegistry.ARCANE_ENCHANTER.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.BLACKSMITH_FORGE.get())
                .add(BlockRegistry.ARCANE_ENCHANTER.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.CORUNDUM_ORE.get())
                .add(BlockRegistry.MALACHITE_ORE.get())
                .add(BlockRegistry.MOONSTONE_ORE.get())
                .add(BlockRegistry.ORICHALCUM_ORE.get())
                .add(BlockRegistry.QUICKSILVER_ORE.get())
                .add(BlockRegistry.SILVER_ORE.get())
                .add(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get())
                .add(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get())
                .add(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get())
                .add(BlockRegistry.DEEPSLATE_SILVER_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.EBONY_ORE.get())
                .add(BlockRegistry.DEEPSLATE_EBONY_ORE.get());
    }
}