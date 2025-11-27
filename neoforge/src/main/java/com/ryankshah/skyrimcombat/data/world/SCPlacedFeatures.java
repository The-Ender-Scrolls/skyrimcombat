package com.ryankshah.skyrimcombat.data.world;

import com.ryankshah.skyrimcombat.world.WorldGenConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.ryankshah.skyrimcombat.world.WorldGenConstants.*;

public class SCPlacedFeatures
{
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CORUNDUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.CORUNDUM_ORE_KEY),
                OrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));
        register(context, EBONY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.EBONY_ORE_KEY),
                OrePlacement.rareOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));
        register(context, MALACHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.MALACHITE_ORE_KEY),
                OrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-11), VerticalAnchor.absolute(46))));
        register(context, MOONSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.MOONSTONE_ORE_KEY),
                OrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(22))));
        register(context, ORICHALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.ORICHALCUM_ORE_KEY),
                OrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(8), VerticalAnchor.absolute(64))));
        register(context, QUICKSILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.QUICKSILVER_ORE_KEY),
                OrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(48))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(WorldGenConstants.SILVER_ORE_KEY),
                OrePlacement.commonOrePlacement(24,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        PlacedFeature feature = new PlacedFeature(configuration, List.copyOf(modifiers));
        context.register(key, feature);
    }
}