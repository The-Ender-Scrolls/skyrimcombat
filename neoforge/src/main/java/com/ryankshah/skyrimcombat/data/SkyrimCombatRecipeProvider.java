package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SkyrimCombatRecipeProvider extends RecipeProvider
{
    private static final List<ItemLike> CORUNDUM_ORE_SMELTABLE = List.of(BlockRegistry.CORUNDUM_ORE.get(), BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get());
    private static final List<ItemLike> EBONY_ORE_SMELTABLE = List.of(BlockRegistry.EBONY_ORE.get(), BlockRegistry.DEEPSLATE_EBONY_ORE.get());
    private static final List<ItemLike> MALACHITE_ORE_SMELTABLE = List.of(BlockRegistry.MALACHITE_ORE.get(), BlockRegistry.DEEPSLATE_MALACHITE_ORE.get());
    private static final List<ItemLike> MOONSTONE_ORE_SMELTABLE = List.of(BlockRegistry.MOONSTONE_ORE.get(), BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get());
    private static final List<ItemLike> ORICHALCUM_ORE_SMELTABLE = List.of(BlockRegistry.ORICHALCUM_ORE.get(), BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get());
    private static final List<ItemLike> QUICKSILVER_ORE_SMELTABLE = List.of(BlockRegistry.QUICKSILVER_ORE.get(), BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get());
    private static final List<ItemLike> SILVER_ORE_SMELTABLE = List.of(BlockRegistry.SILVER_ORE.get(), BlockRegistry.DEEPSLATE_SILVER_ORE.get());


    public SkyrimCombatRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Oven recipe
        this.shaped(RecipeCategory.MISC, BlockRegistry.BLACKSMITH_FORGE.get())
                .pattern("C C")
                .pattern("CLC")
                .pattern("SSS")
                .define('L', Items.LAVA_BUCKET)
                .define('C', Items.COBBLESTONE)
                .define('S', Items.STONE)
                .unlockedBy("has_iron", has(Blocks.COBBLESTONE))
                .save(this.output);

        oreSmelting(CORUNDUM_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.CORUNDUM_INGOT.get(), 0.25f, 200, "corundum_ingot");
        oreBlasting(CORUNDUM_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.CORUNDUM_INGOT.get(), 0.25f, 100, "corundum_ingot");

        oreSmelting(EBONY_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.EBONY_INGOT.get(), 0.25f, 200, "ebony_ingot");
        oreBlasting(EBONY_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.EBONY_INGOT.get(), 0.25f, 100, "ebony_ingot");

        oreSmelting(MALACHITE_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.MALACHITE_INGOT.get(), 0.25f, 200, "malachite_ingot");
        oreBlasting(MALACHITE_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.MALACHITE_INGOT.get(), 0.25f, 100, "malachite_ingot");

        oreSmelting(MOONSTONE_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.MOONSTONE_INGOT.get(), 0.25f, 200, "moonstone_ingot");
        oreBlasting(MOONSTONE_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.MOONSTONE_INGOT.get(), 0.25f, 100, "moonstone_ingot");

        oreSmelting(ORICHALCUM_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.ORICHALCUM_INGOT.get(), 0.25f, 200, "orichalcum_ingot");
        oreBlasting(ORICHALCUM_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.ORICHALCUM_INGOT.get(), 0.25f, 100, "orichalcum_ingot");

        oreSmelting(QUICKSILVER_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.QUICKSILVER_INGOT.get(), 0.25f, 200, "quicksilver_ingot");
        oreBlasting(QUICKSILVER_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.QUICKSILVER_INGOT.get(), 0.25f, 100, "quicksilver_ingot");

        oreSmelting(SILVER_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.SILVER_INGOT.get(), 0.25f, 200, "silver_ingot");
        oreBlasting(SILVER_ORE_SMELTABLE, RecipeCategory.MISC, ItemRegistry.SILVER_INGOT.get(), 0.25f, 100, "silver_ingot");

        this.shapeless(RecipeCategory.MISC, new ItemStack(ItemRegistry.LEATHER_STRIPS.get(), 2)).requires(Items.LEATHER).unlockedBy("has_leather", has(Items.LEATHER)).save(this.output);

    }

    // Data generation runner class
    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new SkyrimCombatRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return Constants.MOD_ID + "_Recipes";
        }
    }
}