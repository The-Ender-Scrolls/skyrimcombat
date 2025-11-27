package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class EffectRegistry
{
    public static void init() {
    }

    public static final RegistrationProvider<MobEffect> MOB_EFFECTS = RegistrationProvider.get(Registries.MOB_EFFECT, Constants.MOD_ID);

}