package com.ryankshah.skyrimcombat.data;

import com.google.common.collect.Sets;
import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * TODO: Fix the XP rates for forging!
 */
public abstract class ForgeRecipeProvider {
    protected final HolderLookup.Provider registries;
    protected final RecipeOutput output;

    protected ForgeRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        this.registries = registries;
        this.output = output;
    }

    protected abstract void buildRecipes();

    protected void addForgeRecipe(Item result, ForgeRecipe recipe) {
        ResourceKey<Recipe<?>> recipeKey = ResourceKey.create(Registries.RECIPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "forge/" + BuiltInRegistries.ITEM.getKey(result).getPath()));

        this.output.accept(recipeKey, recipe, null);
    }

    // Static inner class that implements the DataProvider.Runner pattern
    public static abstract class Runner implements DataProvider {
        private final PackOutput packOutput;
        private final CompletableFuture<HolderLookup.Provider> registries;

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            this.packOutput = packOutput;
            this.registries = registries;
        }

        public final CompletableFuture<?> run(CachedOutput cachedOutput) {
            return this.registries.thenCompose((holderLookup) -> {
                final PackOutput.PathProvider recipePathProvider = this.packOutput.createRegistryElementsPathProvider(Registries.RECIPE);
                final Set<ResourceKey<Recipe<?>>> recipeKeys = Sets.newHashSet();
                final List<CompletableFuture<?>> futures = new ArrayList<>();

                RecipeOutput recipeOutput = new RecipeOutput() {
                    @Override
                    public void accept(ResourceKey<Recipe<?>> recipeKey, Recipe<?> recipe, @Nullable net.minecraft.advancements.AdvancementHolder advancement, ICondition... conditions) {
                        if (!recipeKeys.add(recipeKey)) {
                            throw new IllegalStateException("Duplicate recipe " + recipeKey.location());
                        }

                        // Save the recipe
                        futures.add(DataProvider.saveStable(cachedOutput, holderLookup, Recipe.CONDITIONAL_CODEC,
                                Optional.of(new net.neoforged.neoforge.common.conditions.WithConditions<>(recipe, conditions)),
                                recipePathProvider.json(recipeKey.location())));
                    }

                    @Override
                    public net.minecraft.advancements.Advancement.Builder advancement() {
                        return net.minecraft.advancements.Advancement.Builder.recipeAdvancement();
                    }

                    @Override
                    public void includeRootAdvancement() {
                    }
                };

                // Create the recipe provider and build recipes
                this.createForgeRecipeProvider(holderLookup, recipeOutput).buildRecipes();

                return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            });
        }

        protected abstract ForgeRecipeProvider createForgeRecipeProvider(HolderLookup.Provider registries, RecipeOutput output);

        @Override
        public String getName() {
            return Constants.MOD_ID + " Forge Recipes";
        }
    }

    // Concrete implementation class
    public static class SkyrimForgeRecipeProvider extends ForgeRecipeProvider {

        public SkyrimForgeRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            super(registries, output);
        }

        @Override
        protected void buildRecipes() {
            daedricRecipes();
            dwarvenRecipes();
            ebonyRecipes();
            elvenRecipes();
            glassRecipes();
            ironRecipes();
            orcishRecipes();
            steelRecipes();
        }

        private void daedricRecipes() {
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_ARROW.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_ARROW.get(), 8), 90, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_DAGGER.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_DAGGER.get(), 1), 90, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_SWORD.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_SWORD.get(), 1), 90, 13,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_BATTLEAXE.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_BATTLEAXE.get(), 1), 90, 27,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_BOW.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_BOW.get(), 1), 90, 25,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_GREATSWORD.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_GREATSWORD.get(), 1), 90, 25,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_MACE.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_MACE.get(), 1), 90, 18,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_WAR_AXE.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_WAR_AXE.get(), 1), 90, 15,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_WARHAMMER.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_WARHAMMER.get(), 1), 90, 40,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_HELMET.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_HELMET.get(), 1), 90, 16,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_CHESTPLATE.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_CHESTPLATE.get(), 1), 90, 32,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_LEGGINGS.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_LEGGINGS.get(), 1), 90, 32,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_BOOTS.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_BOOTS.get(), 1), 90, 16,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DAEDRIC_SHIELD.get(),
                    new ForgeRecipe("daedric", new ItemStack(ItemRegistry.DAEDRIC_SHIELD.get(), 1), 90, 16,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(ItemRegistry.DAEDRA_HEART.get())
                            ))
            );
        }

        private void dwarvenRecipes() {
            addForgeRecipe(
                    ItemRegistry.DWARVEN_ARROW.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_ARROW.get(), 8), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_DAGGER.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_DAGGER.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_BATTLEAXE.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_BATTLEAXE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_BOW.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_BOW.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(Items.IRON_INGOT)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_GREATSWORD.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_GREATSWORD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_MACE.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_MACE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_SWORD.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_SWORD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_WAR_AXE.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_WAR_AXE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_WARHAMMER.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_WARHAMMER.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_HELMET.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_HELMET.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_CHESTPLATE.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_CHESTPLATE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_LEGGINGS.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_LEGGINGS.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_BOOTS.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_BOOTS.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.DWARVEN_SHIELD.get(),
                    new ForgeRecipe("dwarven", new ItemStack(ItemRegistry.DWARVEN_SHIELD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.DWARVEN_METAL_INGOT.get(), ItemRegistry.DWARVEN_METAL_INGOT.get()),
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get())
                            ))
            );
        }

        private void ebonyRecipes() {
            addForgeRecipe(
                    ItemRegistry.EBONY_ARROW.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_ARROW.get(), 8), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_DAGGER.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_DAGGER.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_SWORD.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_SWORD.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_GREATSWORD.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_GREATSWORD.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_WAR_AXE.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_WAR_AXE.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_BATTLEAXE.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_BATTLEAXE.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_MACE.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_MACE.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_WARHAMMER.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_WARHAMMER.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_BOW.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_BOW.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_HELMET.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_HELMET.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_CHESTPLATE.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_CHESTPLATE.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_LEGGINGS.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_LEGGINGS.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_BOOTS.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_BOOTS.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.EBONY_SHIELD.get(),
                    new ForgeRecipe("ebony", new ItemStack(ItemRegistry.EBONY_SHIELD.get(), 1), 80, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(), ItemRegistry.EBONY_INGOT.get(),
                                            ItemRegistry.EBONY_INGOT.get()))
                    )
            );
        }

        private void elvenRecipes() {
            addForgeRecipe(
                    ItemRegistry.ELVEN_ARROW.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_ARROW.get(), 8), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_DAGGER.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_DAGGER.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_SWORD.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_SWORD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_GREATSWORD.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_GREATSWORD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_WAR_AXE.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_WAR_AXE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_BATTLEAXE.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_BATTLEAXE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_MACE.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_MACE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_WARHAMMER.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_WARHAMMER.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_BOW.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_BOW.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.QUICKSILVER_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_HELMET.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_HELMET.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_CHESTPLATE.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_CHESTPLATE.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get(),
                                            ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_LEGGINGS.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_LEGGINGS.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get(),
                                            ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_BOOTS.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_BOOTS.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ELVEN_SHIELD.get(),
                    new ForgeRecipe("elven", new ItemStack(ItemRegistry.ELVEN_SHIELD.get(), 1), 30, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get(),
                                            ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()))
                    )
            );
        }

        private void glassRecipes() {
            addForgeRecipe(
                    ItemRegistry.GLASS_ARROW.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_ARROW.get(), 8), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_DAGGER.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_DAGGER.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_SWORD.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_SWORD.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_GREATSWORD.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_GREATSWORD.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_WAR_AXE.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_WAR_AXE.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_BATTLEAXE.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_BATTLEAXE.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_MACE.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_MACE.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_WARHAMMER.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_WARHAMMER.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_BOW.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_BOW.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_HELMET.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_HELMET.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_CHESTPLATE.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_CHESTPLATE.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get(),
                                            ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_LEGGINGS.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_LEGGINGS.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get(), ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get(),
                                            ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_BOOTS.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_BOOTS.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.LEATHER),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.GLASS_SHIELD.get(),
                    new ForgeRecipe("glass", new ItemStack(ItemRegistry.GLASS_SHIELD.get(), 1), 70, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(ItemRegistry.MOONSTONE_INGOT.get()),
                                    Ingredient.of(ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get(),
                                            ItemRegistry.MALACHITE_INGOT.get(), ItemRegistry.MALACHITE_INGOT.get()))
                    )
            );
        }

        private void ironRecipes() {
            addForgeRecipe(
                    ItemRegistry.IRON_ARROW.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_ARROW.get(), 8), 1, 5,
                            ingredientList(
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.IRON_DAGGER.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_DAGGER.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_SWORD.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_SWORD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_GREATSWORD.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_GREATSWORD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_WAR_AXE.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_WAR_AXE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_BATTLEAXE.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_BATTLEAXE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_MACE.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_MACE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_WARHAMMER.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_WARHAMMER.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_HELMET.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_HELMET.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_CHESTPLATE.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_CHESTPLATE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_LEGGINGS.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_LEGGINGS.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_BOOTS.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_BOOTS.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.IRON_SHIELD.get(),
                    new ForgeRecipe("iron", new ItemStack(ItemRegistry.IRON_SHIELD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT))
                    )
            );
        }

        private void orcishRecipes() {
            addForgeRecipe(
                    ItemRegistry.ORCISH_ARROW.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_ARROW.get(), 8), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_DAGGER.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_DAGGER.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_SWORD.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_SWORD.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_GREATSWORD.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_GREATSWORD.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_WAR_AXE.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_WAR_AXE.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_BATTLEAXE.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_BATTLEAXE.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_MACE.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_MACE.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_WARHAMMER.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_WARHAMMER.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_BOW.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_BOW.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_HELMET.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_HELMET.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_CHESTPLATE.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_CHESTPLATE.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_LEGGINGS.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_LEGGINGS.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_BOOTS.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_BOOTS.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.ORCISH_SHIELD.get(),
                    new ForgeRecipe("orcish", new ItemStack(ItemRegistry.ORCISH_SHIELD.get(), 1), 50, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.ORICHALCUM_INGOT.get(), ItemRegistry.ORICHALCUM_INGOT.get(),
                                            ItemRegistry.ORICHALCUM_INGOT.get()))
                    )
            );
        }

        private void steelRecipes() {
            addForgeRecipe(
                    ItemRegistry.STEEL_ARROW.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_ARROW.get(), 8), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get()),
                                    Ingredient.of(Items.STICK),
                                    Ingredient.of(Items.FEATHER)
                            ))
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_DAGGER.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_DAGGER.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_SWORD.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_SWORD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_GREATSWORD.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_GREATSWORD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT, Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(),
                                            ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_WAR_AXE.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_WAR_AXE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_BATTLEAXE.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_BATTLEAXE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(),
                                            ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_MACE.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_MACE.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(),
                                            ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_WARHAMMER.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_WARHAMMER.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get(), ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(),
                                            ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get()))
                    )
            );
            addForgeRecipe(
                    ItemRegistry.STEEL_SHIELD.get(),
                    new ForgeRecipe("steel", new ItemStack(ItemRegistry.STEEL_SHIELD.get(), 1), 1, 5,
                            ingredientList(
                                    Ingredient.of(ItemRegistry.LEATHER_STRIPS.get()),
                                    Ingredient.of(Items.IRON_INGOT),
                                    Ingredient.of(ItemRegistry.STEEL_INGOT.get(), ItemRegistry.STEEL_INGOT.get(),
                                            ItemRegistry.STEEL_INGOT.get()))
                    )
            );
        }
    }

    private static NonNullList<Ingredient> ingredientList(Ingredient... ingredients) {
        NonNullList<Ingredient> list = NonNullList.create();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredient);
        }
        return list;
    }
}