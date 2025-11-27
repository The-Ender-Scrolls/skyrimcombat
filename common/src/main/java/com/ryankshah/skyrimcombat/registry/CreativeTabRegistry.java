package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.item.SkyrimArmor;
import com.ryankshah.skyrimcombat.item.SkyrimTwoHandedSword;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;

public class CreativeTabRegistry
{
    public static void init() {}

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    // tab title
    public static String SKYRIMCRAFT_COMBAT_TAB_TITLE = "creativetab.skyrimcombat";

    public static final RegistryObject<CreativeModeTab, CreativeModeTab> SKYRIMCRAFT_ALL_TAB = CREATIVE_MODE_TABS.register("skyrimcombat", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0);

        builder.displayItems((itemDisplayParameters, output) -> {
            ItemRegistry.ITEMS.getEntries()
                    .stream()
//                    .filter(item -> item.get().components().has(DataComponents.TOOL) || item.get() instanceof ShieldItem || item.get() instanceof BowItem || item.get() instanceof SkyrimArmor || item.get() instanceof SkyrimTwoHandedSword)
                    .map(RegistryObject::get)
                    .forEach(output::accept);
        });

        builder.icon(() -> new ItemStack(ItemRegistry.DAEDRIC_SWORD.get()));
        builder.title(Component.translatable(SKYRIMCRAFT_COMBAT_TAB_TITLE));

        return builder.build();
    });
}