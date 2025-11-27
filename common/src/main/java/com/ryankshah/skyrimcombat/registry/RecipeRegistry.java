package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.data.recipe.serial.ForgeRecipeSerializer;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeRegistry
{
    public static void init() {}

    public static final RegistrationProvider<RecipeType<?>> RECIPE_TYPES = RegistrationProvider.get(BuiltInRegistries.RECIPE_TYPE, Constants.MOD_ID);

    public static final RegistryObject<RecipeType<?>, ? extends RecipeType<ForgeRecipe>> FORGE = RECIPE_TYPES.register("forge", ForgeRecipeType::new);

    static class ForgeRecipeType implements RecipeType<ForgeRecipe> {
        @Override
        public String toString() { return Constants.MOD_ID + ":forge"; }
    }

    public static final RegistrationProvider<RecipeSerializer<?>> SERIALIZERS = RegistrationProvider.get(Registries.RECIPE_SERIALIZER, Constants.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>, RecipeSerializer<ForgeRecipe>> OVEN_RECIPE_SERIALIZER = SERIALIZERS.register("forge", ForgeRecipeSerializer::new);

}