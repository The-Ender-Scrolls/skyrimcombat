package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabRegistry
{
    public static void init() {}

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    // tab title
    public static String SKYRIMCRAFT_COMBAT_TAB_TITLE = "creativetab.skyrimcombat";

    public static final RegistryObject<CreativeModeTab, CreativeModeTab> SKYRIMCRAFT_ALL_TAB = CREATIVE_MODE_TABS.register("skyrimcombat", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0);

        builder.displayItems((itemDisplayParameters, output) -> {
            // BLOCKS
            output.accept(BlockRegistry.CORUNDUM_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get());
            output.accept(BlockRegistry.EBONY_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_EBONY_ORE.get());
            output.accept(BlockRegistry.MALACHITE_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get());
            output.accept(BlockRegistry.MOONSTONE_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get());
            output.accept(BlockRegistry.ORICHALCUM_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get());
            output.accept(BlockRegistry.QUICKSILVER_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get());
            output.accept(BlockRegistry.SILVER_ORE.get());
            output.accept(BlockRegistry.DEEPSLATE_SILVER_ORE.get());
            output.accept(BlockRegistry.BLACKSMITH_FORGE.get());
            output.accept(BlockRegistry.ARCANE_ENCHANTER.get());

            // MATERIALS
            output.accept(ItemRegistry.CORUNDUM_INGOT.get());
            output.accept(ItemRegistry.DWARVEN_METAL_INGOT.get());
            output.accept(ItemRegistry.EBONY_INGOT.get());
            output.accept(ItemRegistry.MALACHITE_INGOT.get());
            output.accept(ItemRegistry.MOONSTONE_INGOT.get());
            output.accept(ItemRegistry.ORICHALCUM_INGOT.get());
            output.accept(ItemRegistry.QUICKSILVER_INGOT.get());
            output.accept(ItemRegistry.SILVER_INGOT.get());
            output.accept(ItemRegistry.STEEL_INGOT.get());
            output.accept(ItemRegistry.LEATHER_STRIPS.get());
            output.accept(ItemRegistry.DAEDRA_HEART.get());

            // GEMS
            output.accept(ItemRegistry.FLAWED_AMETHYST.get());
            output.accept(ItemRegistry.FLAWED_DIAMOND.get());
            output.accept(ItemRegistry.FLAWED_EMERALD.get());
            output.accept(ItemRegistry.FLAWED_RUBY.get());
            output.accept(ItemRegistry.FLAWLESS_RUBY.get());
            output.accept(ItemRegistry.FLAWED_GARNET.get());
            output.accept(ItemRegistry.FLAWLESS_GARNET.get());

            // ANCIENT NORD
            output.accept(ItemRegistry.ANCIENT_NORD_HELMET.get());
            output.accept(ItemRegistry.ANCIENT_NORD_CHESTPLATE.get());
            output.accept(ItemRegistry.ANCIENT_NORD_LEGGINGS.get());
            output.accept(ItemRegistry.ANCIENT_NORD_BOOTS.get());
            output.accept(ItemRegistry.ANCIENT_NORD_SWORD.get());
            output.accept(ItemRegistry.ANCIENT_NORD_GREATSWORD.get());
            output.accept(ItemRegistry.ANCIENT_NORD_BATTLEAXE.get());
            output.accept(ItemRegistry.ANCIENT_NORD_WAR_AXE.get());
            output.accept(ItemRegistry.ANCIENT_NORD_BOW.get());
            output.accept(ItemRegistry.ANCIENT_NORD_ARROW.get());

            // DAEDRIC
            output.accept(ItemRegistry.DAEDRIC_HELMET.get());
            output.accept(ItemRegistry.DAEDRIC_CHESTPLATE.get());
            output.accept(ItemRegistry.DAEDRIC_LEGGINGS.get());
            output.accept(ItemRegistry.DAEDRIC_BOOTS.get());
            output.accept(ItemRegistry.DAEDRIC_SHIELD.get());
            output.accept(ItemRegistry.DAEDRIC_DAGGER.get());
            output.accept(ItemRegistry.DAEDRIC_SWORD.get());
            output.accept(ItemRegistry.DAEDRIC_GREATSWORD.get());
            output.accept(ItemRegistry.DAEDRIC_BATTLEAXE.get());
            output.accept(ItemRegistry.DAEDRIC_WAR_AXE.get());
            output.accept(ItemRegistry.DAEDRIC_MACE.get());
            output.accept(ItemRegistry.DAEDRIC_WARHAMMER.get());
            output.accept(ItemRegistry.DAEDRIC_BOW.get());
            output.accept(ItemRegistry.DAEDRIC_ARROW.get());

            // DRAGONBONE
            output.accept(ItemRegistry.DRAGONBONE_DAGGER.get());
            output.accept(ItemRegistry.DRAGONBONE_SWORD.get());
            output.accept(ItemRegistry.DRAGONBONE_GREATSWORD.get());
            output.accept(ItemRegistry.DRAGONBONE_BATTLEAXE.get());
            output.accept(ItemRegistry.DRAGONBONE_WAR_AXE.get());
            output.accept(ItemRegistry.DRAGONBONE_MACE.get());
            output.accept(ItemRegistry.DRAGONBONE_WARHAMMER.get());
            output.accept(ItemRegistry.DRAGONBONE_BOW.get());
            output.accept(ItemRegistry.DRAGONBONE_ARROW.get());

            // DWARVEN
            output.accept(ItemRegistry.DWARVEN_HELMET.get());
            output.accept(ItemRegistry.DWARVEN_CHESTPLATE.get());
            output.accept(ItemRegistry.DWARVEN_LEGGINGS.get());
            output.accept(ItemRegistry.DWARVEN_BOOTS.get());
            output.accept(ItemRegistry.DWARVEN_SHIELD.get());
            output.accept(ItemRegistry.DWARVEN_DAGGER.get());
            output.accept(ItemRegistry.DWARVEN_SWORD.get());
            output.accept(ItemRegistry.DWARVEN_GREATSWORD.get());
            output.accept(ItemRegistry.DWARVEN_BATTLEAXE.get());
            output.accept(ItemRegistry.DWARVEN_WAR_AXE.get());
            output.accept(ItemRegistry.DWARVEN_MACE.get());
            output.accept(ItemRegistry.DWARVEN_WARHAMMER.get());
            output.accept(ItemRegistry.DWARVEN_BOW.get());
            output.accept(ItemRegistry.DWARVEN_ARROW.get());

            // EBONY
            output.accept(ItemRegistry.EBONY_HELMET.get());
            output.accept(ItemRegistry.EBONY_CHESTPLATE.get());
            output.accept(ItemRegistry.EBONY_LEGGINGS.get());
            output.accept(ItemRegistry.EBONY_BOOTS.get());
            output.accept(ItemRegistry.EBONY_SHIELD.get());
            output.accept(ItemRegistry.EBONY_DAGGER.get());
            output.accept(ItemRegistry.EBONY_SWORD.get());
            output.accept(ItemRegistry.EBONY_GREATSWORD.get());
            output.accept(ItemRegistry.EBONY_BATTLEAXE.get());
            output.accept(ItemRegistry.EBONY_WAR_AXE.get());
            output.accept(ItemRegistry.EBONY_MACE.get());
            output.accept(ItemRegistry.EBONY_WARHAMMER.get());
            output.accept(ItemRegistry.EBONY_BOW.get());
            output.accept(ItemRegistry.EBONY_ARROW.get());

            // ELVEN
            output.accept(ItemRegistry.ELVEN_HELMET.get());
            output.accept(ItemRegistry.ELVEN_CHESTPLATE.get());
            output.accept(ItemRegistry.ELVEN_LEGGINGS.get());
            output.accept(ItemRegistry.ELVEN_BOOTS.get());
            output.accept(ItemRegistry.ELVEN_SHIELD.get());
            output.accept(ItemRegistry.ELVEN_DAGGER.get());
            output.accept(ItemRegistry.ELVEN_SWORD.get());
            output.accept(ItemRegistry.ELVEN_GREATSWORD.get());
            output.accept(ItemRegistry.ELVEN_BATTLEAXE.get());
            output.accept(ItemRegistry.ELVEN_WAR_AXE.get());
            output.accept(ItemRegistry.ELVEN_MACE.get());
            output.accept(ItemRegistry.ELVEN_WARHAMMER.get());
            output.accept(ItemRegistry.ELVEN_BOW.get());
            output.accept(ItemRegistry.ELVEN_ARROW.get());

            // FALMER
            output.accept(ItemRegistry.FALMER_HELMET.get());
            output.accept(ItemRegistry.FALMER_CHESTPLATE.get());
            output.accept(ItemRegistry.FALMER_LEGGINGS.get());
            output.accept(ItemRegistry.FALMER_BOOTS.get());
            output.accept(ItemRegistry.FALMER_SWORD.get());
            output.accept(ItemRegistry.FALMER_WAR_AXE.get());
            output.accept(ItemRegistry.FALMER_BOW.get());
            output.accept(ItemRegistry.FALMER_ARROW.get());

            // GLASS
            output.accept(ItemRegistry.GLASS_HELMET.get());
            output.accept(ItemRegistry.GLASS_CHESTPLATE.get());
            output.accept(ItemRegistry.GLASS_LEGGINGS.get());
            output.accept(ItemRegistry.GLASS_BOOTS.get());
            output.accept(ItemRegistry.GLASS_SHIELD.get());
            output.accept(ItemRegistry.GLASS_DAGGER.get());
            output.accept(ItemRegistry.GLASS_SWORD.get());
            output.accept(ItemRegistry.GLASS_GREATSWORD.get());
            output.accept(ItemRegistry.GLASS_BATTLEAXE.get());
            output.accept(ItemRegistry.GLASS_WAR_AXE.get());
            output.accept(ItemRegistry.GLASS_MACE.get());
            output.accept(ItemRegistry.GLASS_WARHAMMER.get());
            output.accept(ItemRegistry.GLASS_BOW.get());
            output.accept(ItemRegistry.GLASS_ARROW.get());

            // IRON
            output.accept(ItemRegistry.IRON_HELMET.get());
            output.accept(ItemRegistry.IRON_CHESTPLATE.get());
            output.accept(ItemRegistry.IRON_LEGGINGS.get());
            output.accept(ItemRegistry.IRON_BOOTS.get());
            output.accept(ItemRegistry.IRON_SHIELD.get());
            output.accept(ItemRegistry.IRON_DAGGER.get());
            output.accept(ItemRegistry.IRON_SWORD.get());
            output.accept(ItemRegistry.IRON_GREATSWORD.get());
            output.accept(ItemRegistry.IRON_BATTLEAXE.get());
            output.accept(ItemRegistry.IRON_WAR_AXE.get());
            output.accept(ItemRegistry.IRON_MACE.get());
            output.accept(ItemRegistry.IRON_WARHAMMER.get());
            output.accept(ItemRegistry.IRON_ARROW.get());

            // ORCISH
            output.accept(ItemRegistry.ORCISH_HELMET.get());
            output.accept(ItemRegistry.ORCISH_CHESTPLATE.get());
            output.accept(ItemRegistry.ORCISH_LEGGINGS.get());
            output.accept(ItemRegistry.ORCISH_BOOTS.get());
            output.accept(ItemRegistry.ORCISH_SHIELD.get());
            output.accept(ItemRegistry.ORCISH_DAGGER.get());
            output.accept(ItemRegistry.ORCISH_SWORD.get());
            output.accept(ItemRegistry.ORCISH_GREATSWORD.get());
            output.accept(ItemRegistry.ORCISH_BATTLEAXE.get());
            output.accept(ItemRegistry.ORCISH_WAR_AXE.get());
            output.accept(ItemRegistry.ORCISH_MACE.get());
            output.accept(ItemRegistry.ORCISH_WARHAMMER.get());
            output.accept(ItemRegistry.ORCISH_BOW.get());
            output.accept(ItemRegistry.ORCISH_ARROW.get());

            // STEEL
            output.accept(ItemRegistry.STEEL_HELMET.get());
            output.accept(ItemRegistry.STEEL_CHESTPLATE.get());
            output.accept(ItemRegistry.STEEL_LEGGINGS.get());
            output.accept(ItemRegistry.STEEL_BOOTS.get());
            output.accept(ItemRegistry.STEEL_SHIELD.get());
            output.accept(ItemRegistry.STEEL_DAGGER.get());
            output.accept(ItemRegistry.STEEL_SWORD.get());
            output.accept(ItemRegistry.STEEL_GREATSWORD.get());
            output.accept(ItemRegistry.STEEL_BATTLEAXE.get());
            output.accept(ItemRegistry.STEEL_WAR_AXE.get());
            output.accept(ItemRegistry.STEEL_MACE.get());
            output.accept(ItemRegistry.STEEL_WARHAMMER.get());
            output.accept(ItemRegistry.STEEL_ARROW.get());

            // STORMCLOAK OFFICER
            output.accept(ItemRegistry.STORMCLOAK_OFFICER_HELMET.get());
            output.accept(ItemRegistry.STORMCLOAK_OFFICER_CHESTPLATE.get());
            output.accept(ItemRegistry.STORMCLOAK_OFFICER_LEGGINGS.get());
            output.accept(ItemRegistry.STORMCLOAK_OFFICER_BOOTS.get());

            // IMPERIAL
            output.accept(ItemRegistry.IMPERIAL_HELMET.get());
            output.accept(ItemRegistry.IMPERIAL_CHESTPLATE.get());
            output.accept(ItemRegistry.IMPERIAL_LEGGINGS.get());
            output.accept(ItemRegistry.IMPERIAL_BOOTS.get());
            output.accept(ItemRegistry.IMPERIAL_SWORD.get());

            // SCALED ARMOR
            output.accept(ItemRegistry.SCALED_HELMET.get());
            output.accept(ItemRegistry.SCALED_CHESTPLATE.get());
            output.accept(ItemRegistry.SCALED_LEGGINGS.get());
            output.accept(ItemRegistry.SCALED_BOOTS.get());

            // HIDE ARMOR
            output.accept(ItemRegistry.HIDE_HELMET.get());
            output.accept(ItemRegistry.HIDE_CHESTPLATE.get());
            output.accept(ItemRegistry.HIDE_LEGGINGS.get());
            output.accept(ItemRegistry.HIDE_BOOTS.get());

            // MISC BOWS
            output.accept(ItemRegistry.HUNTING_BOW.get());
            output.accept(ItemRegistry.LONGBOW.get());

            // SPECIAL SWORDS
            output.accept(ItemRegistry.CHILLREND.get());
            output.accept(ItemRegistry.DAWNBREAKER.get());
        });

        builder.icon(() -> new ItemStack(ItemRegistry.DAEDRIC_SWORD.get()));
        builder.title(Component.translatable(SKYRIMCRAFT_COMBAT_TAB_TITLE));

        return builder.build();
    });
}