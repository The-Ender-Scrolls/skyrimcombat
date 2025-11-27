package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import com.ryankshah.skyrimcombat.world.feature.NbtFeature;
import com.ryankshah.skyrimcombat.world.feature.NbtFeatureConfig;
import com.ryankshah.skyrimcombat.world.feature.PineTreeFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FeatureRegistry
{
    public static void init() {}

    public static final RegistrationProvider<Feature<?>> FEATURES = RegistrationProvider.get(BuiltInRegistries.FEATURE, Constants.MOD_ID);

    public static final RegistryObject<Feature<?>, Feature<NbtFeatureConfig>> NBT_FEATURE = FEATURES.register("nbt_feature", NbtFeature::new);
}
