package com.ryankshah.skyrimcombat.world;

import com.ryankshah.skyrimcombat.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class WorldGenConstants
{
    public static void init() {}

    public static final ResourceKey<PlacedFeature> CORUNDUM_ORE_PLACED_KEY = registerPlacedFeature("corundum_ore_placed");
    public static final ResourceKey<PlacedFeature> EBONY_ORE_PLACED_KEY = registerPlacedFeature("ebony_ore_placed");
    public static final ResourceKey<PlacedFeature> MALACHITE_ORE_PLACED_KEY = registerPlacedFeature("malachite_ore_placed");
    public static final ResourceKey<PlacedFeature> MOONSTONE_ORE_PLACED_KEY = registerPlacedFeature("moonstone_ore_placed");
    public static final ResourceKey<PlacedFeature> ORICHALCUM_ORE_PLACED_KEY = registerPlacedFeature("orichalcum_ore_placed");
    public static final ResourceKey<PlacedFeature> QUICKSILVER_ORE_PLACED_KEY = registerPlacedFeature("quicksilver_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerPlacedFeature("silver_ore_placed");


    public static final ResourceKey<ConfiguredFeature<?, ?>> CORUNDUM_ORE_KEY = registerConfiguredFeature("corundum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_ORE_KEY = registerConfiguredFeature("ebony_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MALACHITE_ORE_KEY = registerConfiguredFeature("malachite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOONSTONE_ORE_KEY = registerConfiguredFeature("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORICHALCUM_ORE_KEY = registerConfiguredFeature("orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUICKSILVER_ORE_KEY = registerConfiguredFeature("quicksilver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerConfiguredFeature("silver_ore");

    private static ResourceKey<PlacedFeature> registerPlacedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }
}