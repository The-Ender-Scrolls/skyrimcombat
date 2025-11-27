package com.ryankshah.skyrimcombat.data.recipe.serial;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ForgeRecipeSerializer implements RecipeSerializer<ForgeRecipe>
{
    public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(
            p_311738_ -> p_311738_.group(
                            Codec.STRING.fieldOf("category").forGetter(ForgeRecipe::getCategory),
                            ItemStack.CODEC.fieldOf("result").forGetter(ForgeRecipe::getResult),
                            Codec.INT.fieldOf("level").forGetter(ForgeRecipe::getRequiredLevel),
                            Codec.INT.fieldOf("xp").forGetter(ForgeRecipe::getXpGained),
                            Ingredient.CODEC
                                    .listOf()
                                    .fieldOf("ingredients")
                                    .flatXmap(
                                            p_301021_ -> {
                                                if(p_301021_.isEmpty()) {
                                                    return DataResult.error(() -> "No ingredients for Oven Recipe");
                                                } else {
                                                    // Create NonNullList and add all ingredients directly
                                                    NonNullList<Ingredient> ingredients = NonNullList.create();
                                                    ingredients.addAll(p_301021_);
                                                    return DataResult.success(ingredients);
                                                }
                                            },
                                            DataResult::success
                                    )
                                    .forGetter(ForgeRecipe::getIngredients)
                    )
                    .apply(p_311738_, ForgeRecipe::new)
    );
    private static final StreamCodec<RegistryFriendlyByteBuf, ForgeRecipe> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CODEC.codec());


    public ForgeRecipeSerializer() {
    }

    @Override
    public MapCodec<ForgeRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ForgeRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}