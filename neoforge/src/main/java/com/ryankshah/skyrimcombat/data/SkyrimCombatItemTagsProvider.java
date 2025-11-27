package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import com.ryankshah.skyrimcombat.registry.TagsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class SkyrimCombatItemTagsProvider extends ItemTagsProvider {
    
    public SkyrimCombatItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                        CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, Constants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ores
//        copy(TagsRegistry.BlockTagsInit.CORUNDUM_ORE_TAG, TagsRegistry.ItemTagsInit.CORUNDUM_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.EBONY_ORE_TAG, TagsRegistry.ItemTagsInit.EBONY_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.MALACHITE_ORE_TAG, TagsRegistry.ItemTagsInit.MALACHITE_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.MOONSTONE_ORE_TAG, TagsRegistry.ItemTagsInit.MOONSTONE_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.ORICHALCUM_ORE_TAG, TagsRegistry.ItemTagsInit.ORICHALCUM_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.QUICKSILVER_ORE_TAG, TagsRegistry.ItemTagsInit.QUICKSILVER_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.SILVER_ORE_TAG, TagsRegistry.ItemTagsInit.SILVER_ORE_ITEM_TAG);
//
//        // deepslate ores
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_CORUNDUM_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_CORUNDUM_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_EBONY_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_EBONY_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_MALACHITE_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_MALACHITE_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_MOONSTONE_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_MOONSTONE_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_ORICHALCUM_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_ORICHALCUM_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_QUICKSILVER_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_QUICKSILVER_ORE_ITEM_TAG);
//        copy(TagsRegistry.BlockTagsInit.DEEPSLATE_SILVER_ORE_TAG, TagsRegistry.ItemTagsInit.DEEPSLATE_SILVER_ORE_ITEM_TAG);

        tag(TagsRegistry.ItemTagsInit.REPAIRS_DWARVEN).add(ItemRegistry.DWARVEN_METAL_INGOT.get());
        tag(TagsRegistry.ItemTagsInit.REPAIRS_STEEL).add(ItemRegistry.STEEL_INGOT.get());
        tag(TagsRegistry.ItemTagsInit.REPAIRS_GLASS).add(ItemRegistry.MALACHITE_INGOT.get());
        tag(TagsRegistry.ItemTagsInit.REPAIRS_EBONY).add(ItemRegistry.EBONY_INGOT.get());
        tag(TagsRegistry.ItemTagsInit.REPAIRS_ELVEN).add(ItemRegistry.MOONSTONE_INGOT.get());
        tag(TagsRegistry.ItemTagsInit.REPAIRS_ORCISH).add(ItemRegistry.ORICHALCUM_INGOT.get());

        tag(TagsRegistry.ItemTagsInit.EMPTY_INGREDIENT);

    }
}