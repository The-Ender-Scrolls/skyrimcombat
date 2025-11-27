package com.ryankshah.skyrimcombat.data.world;

import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import com.ryankshah.skyrimcombat.registry.FeatureRegistry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

import static com.ryankshah.skyrimcombat.world.WorldGenConstants.*;

public class SCConfiguredFeatures
{
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> corundumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.CORUNDUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get().defaultBlockState()));
        register(context, CORUNDUM_ORE_KEY, Feature.ORE, new OreConfiguration(corundumOres, 3));

        List<OreConfiguration.TargetBlockState> ebonyOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.EBONY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_EBONY_ORE.get().defaultBlockState()));
        register(context, EBONY_ORE_KEY, Feature.ORE, new OreConfiguration(ebonyOres, 2));

        List<OreConfiguration.TargetBlockState> malachiteOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.MALACHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_MALACHITE_ORE.get().defaultBlockState()));
        register(context, MALACHITE_ORE_KEY, Feature.ORE, new OreConfiguration(malachiteOres, 3));

        List<OreConfiguration.TargetBlockState> moonstoneOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.MOONSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get().defaultBlockState()));
        register(context, MOONSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(moonstoneOres, 3));

        List<OreConfiguration.TargetBlockState> orichalcumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.ORICHALCUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get().defaultBlockState()));
        register(context, ORICHALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(orichalcumOres, 3));

        List<OreConfiguration.TargetBlockState> quicksilverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.QUICKSILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get().defaultBlockState()));
        register(context, QUICKSILVER_ORE_KEY, Feature.ORE, new OreConfiguration(quicksilverOres, 4));

        List<OreConfiguration.TargetBlockState> silverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        BlockRegistry.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 5));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}