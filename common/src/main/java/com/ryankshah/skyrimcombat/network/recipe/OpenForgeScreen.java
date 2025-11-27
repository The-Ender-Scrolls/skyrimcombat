package com.ryankshah.skyrimcombat.network.recipe;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.client.ClientRecipeCache;
import com.ryankshah.skyrimcombat.data.recipe.ForgeRecipe;
import com.ryankshah.skyrimcombat.registry.RecipeRegistry;
import com.ryankshah.skyrimcombat.screen.ForgeScreen;
import commonnetwork.networking.data.PacketContext;
import commonnetwork.networking.data.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record OpenForgeScreen() {
    public static final ResourceLocation TYPE = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "openforgescreen");

    public OpenForgeScreen(final FriendlyByteBuf buffer) {
        this();
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, OpenForgeScreen> CODEC = StreamCodec.unit(new OpenForgeScreen());

    public static OpenForgeScreen decode(FriendlyByteBuf buf) {
        return new OpenForgeScreen();
    }

    public void encode(FriendlyByteBuf buf) {
    }

    public static void handle(PacketContext<OpenForgeScreen> context) {
        if(context.side().equals(Side.CLIENT))
            handleClient(context);
        else
            handleServer(context);
    }

    public static void handleServer(PacketContext<OpenForgeScreen> context) {
    }

    public static void handleClient(PacketContext<OpenForgeScreen> context) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            if(Minecraft.getInstance().player != null) {
                // Use the cached recipes instead of trying to get them from level
                List<ForgeRecipe> recipes = ClientRecipeCache.getForgeRecipes(RecipeRegistry.FORGE.get());
                Minecraft.getInstance().setScreen(new ForgeScreen(recipes));
            }
        });
    }

    public static CustomPacketPayload.Type<CustomPacketPayload> type() {
        return new CustomPacketPayload.Type<>(TYPE);
    }
}