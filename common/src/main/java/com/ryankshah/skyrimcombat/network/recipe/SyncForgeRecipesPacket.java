package com.ryankshah.skyrimcombat.network.recipe;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.client.ClientRecipeCache;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.registry.RecipeRegistry;
import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;
import java.util.List;

public record SyncForgeRecipesPacket(List<RecipeHolder<ForgeRecipe>> recipes) {
    public static final ResourceLocation TYPE = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "sync_forge_recipes");

    public SyncForgeRecipesPacket(final RegistryFriendlyByteBuf buffer) {
        this(readRecipes(buffer));
    }

    private static List<RecipeHolder<ForgeRecipe>> readRecipes(RegistryFriendlyByteBuf buffer) {
        int count = buffer.readVarInt();
        List<RecipeHolder<ForgeRecipe>> recipes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            ResourceLocation recipeId = buffer.readResourceLocation();
            ForgeRecipe recipe = (ForgeRecipe) ForgeRecipe.STREAM_CODEC.decode(buffer);
            recipes.add(new RecipeHolder<>(ResourceKey.create(Registries.RECIPE, recipeId), recipe));
        }

        return recipes;
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, SyncForgeRecipesPacket> CODEC = StreamCodec.of(
        SyncForgeRecipesPacket::encode,
        SyncForgeRecipesPacket::decode
    );

    public static SyncForgeRecipesPacket decode(RegistryFriendlyByteBuf buf) {
        return new SyncForgeRecipesPacket(buf);
    }

    public static void encode(RegistryFriendlyByteBuf buf, SyncForgeRecipesPacket packet) {
        buf.writeVarInt(packet.recipes.size());

        for (RecipeHolder<ForgeRecipe> holder : packet.recipes) {
            buf.writeResourceLocation(holder.id().location());
            ForgeRecipe.STREAM_CODEC.encode(buf, holder.value());
        }
    }

    public static void handle(PacketContext<SyncForgeRecipesPacket> context) {
        if (context.side().equals(Side.CLIENT)) {
            handleClient(context);
        }
        // No server handling needed for this packet
    }

    public static void handleClient(PacketContext<SyncForgeRecipesPacket> context) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            if (Minecraft.getInstance().player != null) {
                ClientRecipeCache.cacheRecipes(RecipeRegistry.FORGE.get(), context.message().recipes);
            }
        });
    }

    public static CustomPacketPayload.Type<CustomPacketPayload> type() {
        return new CustomPacketPayload.Type<>(TYPE);
    }
}