package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.item.ArmorMaterials;
import com.ryankshah.skyrimcombat.item.ItemTier;
import com.ryankshah.skyrimcombat.item.SkyrimArmor;
import com.ryankshah.skyrimcombat.item.SkyrimTwoHandedSword;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ItemRegistry
{
    public static void init() {}

    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);
    public static List<RegistryObject<Item, ? extends Item>> ITEM_LIST = new ArrayList<>();

    // Materials
    public static final RegistryObject<Item, Item> CORUNDUM_INGOT = registerItem("corundum_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "corundum_ingot")))));
    public static final RegistryObject<Item, Item> DWARVEN_METAL_INGOT = registerItem("dwarven_metal_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_metal_ingot")))));
    public static final RegistryObject<Item, Item> EBONY_INGOT = registerItem("ebony_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_ingot")))));
    public static final RegistryObject<Item, Item> MALACHITE_INGOT = registerItem("malachite_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "malachite_ingot")))));
    public static final RegistryObject<Item, Item> MOONSTONE_INGOT = registerItem("moonstone_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "moonstone_ingot")))));
    public static final RegistryObject<Item, Item> ORICHALCUM_INGOT = registerItem("orichalcum_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orichalcum_ingot")))));
    public static final RegistryObject<Item, Item> QUICKSILVER_INGOT = registerItem("quicksilver_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "quicksilver_ingot")))));
    public static final RegistryObject<Item, Item> SILVER_INGOT = registerItem("silver_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "silver_ingot")))));
    public static final RegistryObject<Item, Item> STEEL_INGOT = registerItem("steel_ingot", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_ingot")))));
    public static final RegistryObject<Item, Item> LEATHER_STRIPS = registerItem("leather_strips", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "leather_strips")))));
    public static final RegistryObject<Item, Item> DAEDRA_HEART = registerItem("daedra_heart", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedra_heart")))));

    // Gems
    public static final RegistryObject<Item, Item> FLAWED_AMETHYST = registerItem("flawed_amethyst", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawed_amethyst")))));
    public static final RegistryObject<Item, Item> FLAWED_DIAMOND = registerItem("flawed_diamond", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawed_diamond")))));
    public static final RegistryObject<Item, Item> FLAWED_EMERALD = registerItem("flawed_emerald", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawed_emerald")))));
    public static final RegistryObject<Item, Item> FLAWED_RUBY = registerItem("flawed_ruby", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawed_ruby")))));
    public static final RegistryObject<Item, Item> FLAWLESS_RUBY = registerItem("flawless_ruby", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawless_ruby")))));
    public static final RegistryObject<Item, Item> FLAWED_GARNET = registerItem("flawed_garnet", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawed_garnet")))));
    public static final RegistryObject<Item, Item> FLAWLESS_GARNET = registerItem("flawless_garnet", () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "flawless_garnet")))));

    // Ancient Nord
    public static final RegistryObject<Item, Item> ANCIENT_NORD_ARROW = registerItem("ancient_nord_arrow", () -> new Item(new Item.Properties()
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> ANCIENT_NORD_HELMET = registerItem("ancient_nord_helmet", () -> new SkyrimArmor(ArmorMaterials.ANCIENT_NORD.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ANCIENT_NORD_CHESTPLATE = registerItem("ancient_nord_chestplate", () -> new SkyrimArmor(ArmorMaterials.ANCIENT_NORD.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ANCIENT_NORD_LEGGINGS = registerItem("ancient_nord_leggings", () -> new SkyrimArmor(ArmorMaterials.ANCIENT_NORD.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ANCIENT_NORD_BOOTS = registerItem("ancient_nord_boots", () -> new SkyrimArmor(ArmorMaterials.ANCIENT_NORD.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_boots"))), true));
    public static final RegistryObject<Item, Item> ANCIENT_NORD_SWORD = registerItem("ancient_nord_sword", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ANCIENT_NORD_BATTLEAXE = registerItem("ancient_nord_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.ANCIENT_NORD, 8, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ANCIENT_NORD_GREATSWORD = registerItem("ancient_nord_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.ANCIENT_NORD, 7, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_greatsword")))));
    public static final RegistryObject<Item, Item> ANCIENT_NORD_WAR_AXE = registerItem("ancient_nord_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.ANCIENT_NORD.value(), 7, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_war_axe")))));
    public static final RegistryObject<Item, BowItem> ANCIENT_NORD_BOW = registerItem("ancient_nord_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ancient_nord_bow")))));

    // Daedric
    public static final RegistryObject<Item, Item> DAEDRIC_ARROW = registerItem("daedric_arrow", () -> new Item(new Item.Properties()
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> DAEDRIC_HELMET = registerItem("daedric_helmet", () -> new SkyrimArmor(ArmorMaterials.DAEDRIC.value(), ArmorType.HELMET, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DAEDRIC_CHESTPLATE = registerItem("daedric_chestplate", () -> new SkyrimArmor(ArmorMaterials.DAEDRIC.value(), ArmorType.CHESTPLATE, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DAEDRIC_LEGGINGS = registerItem("daedric_leggings", () -> new SkyrimArmor(ArmorMaterials.DAEDRIC.value(), ArmorType.LEGGINGS, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DAEDRIC_BOOTS = registerItem("daedric_boots", () -> new SkyrimArmor(ArmorMaterials.DAEDRIC.value(), ArmorType.BOOTS, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> DAEDRIC_SHIELD = registerItem("daedric_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).fireResistant().stacksTo(1).durability(672).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_shield")))));
    public static final RegistryObject<Item, Item> DAEDRIC_DAGGER = registerItem("daedric_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.DAEDRIC.value(), 5, -1.8f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_dagger")))));
    public static final RegistryObject<Item, Item> DAEDRIC_SWORD = registerItem("daedric_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.DAEDRIC.value(), 8, -2.4f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DAEDRIC_BATTLEAXE = registerItem("daedric_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.DAEDRIC, 10, -3.2f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DAEDRIC_GREATSWORD = registerItem("daedric_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.DAEDRIC, 9, -2.8f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_greatsword")))));
    public static final RegistryObject<Item, Item> DAEDRIC_MACE = registerItem("daedric_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.DAEDRIC.value(), 9, -3.0f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_mace")))));
    public static final RegistryObject<Item, Item> DAEDRIC_WAR_AXE = registerItem("daedric_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.DAEDRIC.value(), 9, -2.8f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DAEDRIC_WARHAMMER = registerItem("daedric_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.DAEDRIC, 11, -3.4f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_warhammer")))));
    public static final RegistryObject<Item, BowItem> DAEDRIC_BOW = registerItem("daedric_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "daedric_bow")))));

    // Dragonbone
    public static final RegistryObject<Item, Item> DRAGONBONE_ARROW = registerItem("dragonbone_arrow", () -> new Item(new Item.Properties()
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_arrow")))));
    public static final RegistryObject<Item, Item> DRAGONBONE_DAGGER = registerItem("dragonbone_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.DRAGONBONE.value(), 5, -1.8f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_dagger")))));
    public static final RegistryObject<Item, Item> DRAGONBONE_SWORD = registerItem("dragonbone_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.DRAGONBONE.value(), 8, -2.4f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DRAGONBONE_BATTLEAXE = registerItem("dragonbone_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.DRAGONBONE, 10, -3.2f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DRAGONBONE_GREATSWORD = registerItem("dragonbone_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.DRAGONBONE, 9, -2.8f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_greatsword")))));
    public static final RegistryObject<Item, Item> DRAGONBONE_MACE = registerItem("dragonbone_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.DRAGONBONE.value(), 9, -3.0f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_mace")))));
    public static final RegistryObject<Item, Item> DRAGONBONE_WAR_AXE = registerItem("dragonbone_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.DRAGONBONE.value(), 9, -2.8f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DRAGONBONE_WARHAMMER = registerItem("dragonbone_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.DRAGONBONE, 11, -3.4f, new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_warhammer")))));
    public static final RegistryObject<Item, BowItem> DRAGONBONE_BOW = registerItem("dragonbone_bow", () -> new BowItem(new Item.Properties().fireResistant().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dragonbone_bow")))));

    // Dwarven
    public static final RegistryObject<Item, SkyrimArmor> DWARVEN_HELMET = registerItem("dwarven_helmet", () -> new SkyrimArmor(ArmorMaterials.DWARVEN.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DWARVEN_CHESTPLATE = registerItem("dwarven_chestplate", () -> new SkyrimArmor(ArmorMaterials.DWARVEN.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DWARVEN_LEGGINGS = registerItem("dwarven_leggings", () -> new SkyrimArmor(ArmorMaterials.DWARVEN.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> DWARVEN_BOOTS = registerItem("dwarven_boots", () -> new SkyrimArmor(ArmorMaterials.DWARVEN.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> DWARVEN_SHIELD = registerItem("dwarven_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(336).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_shield")))));
    public static final RegistryObject<Item, Item> DWARVEN_ARROW = registerItem("dwarven_arrow", () -> new Item(new Item.Properties()
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_arrow")))));
    public static final RegistryObject<Item, Item> DWARVEN_DAGGER = registerItem("dwarven_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.DWARVEN.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_dagger")))));
    public static final RegistryObject<Item, Item> DWARVEN_SWORD = registerItem("dwarven_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.DWARVEN.value(), 7, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DWARVEN_BATTLEAXE = registerItem("dwarven_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.DWARVEN, 8, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DWARVEN_GREATSWORD = registerItem("dwarven_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.DWARVEN, 7, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_greatsword")))));
    public static final RegistryObject<Item, Item> DWARVEN_MACE = registerItem("dwarven_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.DWARVEN.value(), 8, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_mace")))));
    public static final RegistryObject<Item, Item> DWARVEN_WAR_AXE = registerItem("dwarven_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.DWARVEN.value(), 8, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> DWARVEN_WARHAMMER = registerItem("dwarven_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.DWARVEN, 9, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_warhammer")))));
    public static final RegistryObject<Item, BowItem> DWARVEN_BOW = registerItem("dwarven_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dwarven_bow")))));

    // Ebony
    public static final RegistryObject<Item, Item> EBONY_ARROW = registerItem("ebony_arrow", () -> new Item(new Item.Properties()
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> EBONY_HELMET = registerItem("ebony_helmet", () -> new SkyrimArmor(ArmorMaterials.EBONY.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> EBONY_CHESTPLATE = registerItem("ebony_chestplate", () -> new SkyrimArmor(ArmorMaterials.EBONY.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> EBONY_LEGGINGS = registerItem("ebony_leggings", () -> new SkyrimArmor(ArmorMaterials.EBONY.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> EBONY_BOOTS = registerItem("ebony_boots", () -> new SkyrimArmor(ArmorMaterials.EBONY.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> EBONY_SHIELD = registerItem("ebony_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(560).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_shield")))));
    public static final RegistryObject<Item, Item> EBONY_DAGGER = registerItem("ebony_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.EBONY.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_dagger")))));
    public static final RegistryObject<Item, Item> EBONY_SWORD = registerItem("ebony_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.EBONY.value(), 8, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> EBONY_BATTLEAXE = registerItem("ebony_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.EBONY, 9, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> EBONY_GREATSWORD = registerItem("ebony_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.EBONY, 8, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_greatsword")))));
    public static final RegistryObject<Item, Item> EBONY_MACE = registerItem("ebony_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.EBONY.value(), 9, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_mace")))));
    public static final RegistryObject<Item, Item> EBONY_WAR_AXE = registerItem("ebony_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.EBONY.value(), 9, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> EBONY_WARHAMMER = registerItem("ebony_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.EBONY, 10, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_warhammer")))));
    public static final RegistryObject<Item, BowItem> EBONY_BOW = registerItem("ebony_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_bow")))));

    // Elven
    public static final RegistryObject<Item, Item> ELVEN_ARROW = registerItem("elven_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> ELVEN_HELMET = registerItem("elven_helmet", () -> new SkyrimArmor(ArmorMaterials.ELVEN.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_helmet"))), false));
    public static final RegistryObject<Item, SkyrimArmor> ELVEN_CHESTPLATE = registerItem("elven_chestplate", () -> new SkyrimArmor(ArmorMaterials.ELVEN.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_chestplate"))), false));
    public static final RegistryObject<Item, SkyrimArmor> ELVEN_LEGGINGS = registerItem("elven_leggings", () -> new SkyrimArmor(ArmorMaterials.ELVEN.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_leggings"))), false));
    public static final RegistryObject<Item, SkyrimArmor> ELVEN_BOOTS = registerItem("elven_boots", () -> new SkyrimArmor(ArmorMaterials.ELVEN.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_boots"))), false));
    public static final RegistryObject<Item, ShieldItem> ELVEN_SHIELD = registerItem("elven_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(336).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_shield")))));
    public static final RegistryObject<Item, Item> ELVEN_DAGGER = registerItem("elven_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.ELVEN.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_dagger")))));
    public static final RegistryObject<Item, Item> ELVEN_SWORD = registerItem("elven_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.ELVEN.value(), 7, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ELVEN_BATTLEAXE = registerItem("elven_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.ELVEN, 8, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ELVEN_GREATSWORD = registerItem("elven_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.ELVEN, 7, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_greatsword")))));
    public static final RegistryObject<Item, Item> ELVEN_MACE = registerItem("elven_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.ELVEN.value(), 8, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_mace")))));
    public static final RegistryObject<Item, Item> ELVEN_WAR_AXE = registerItem("elven_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.ELVEN.value(), 8, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ELVEN_WARHAMMER = registerItem("elven_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.ELVEN, 9, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_warhammer")))));
    public static final RegistryObject<Item, BowItem> ELVEN_BOW = registerItem("elven_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "elven_bow")))));

    // Glass
    public static final RegistryObject<Item, Item> GLASS_ARROW = registerItem("glass_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> GLASS_HELMET = registerItem("glass_helmet", () -> new SkyrimArmor(ArmorMaterials.GLASS.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_helmet"))), false));
    public static final RegistryObject<Item, SkyrimArmor> GLASS_CHESTPLATE = registerItem("glass_chestplate", () -> new SkyrimArmor(ArmorMaterials.GLASS.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_chestplate"))), false));
    public static final RegistryObject<Item, SkyrimArmor> GLASS_LEGGINGS = registerItem("glass_leggings", () -> new SkyrimArmor(ArmorMaterials.GLASS.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_leggings"))), false));
    public static final RegistryObject<Item, SkyrimArmor> GLASS_BOOTS = registerItem("glass_boots", () -> new SkyrimArmor(ArmorMaterials.GLASS.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_boots"))), false));
    public static final RegistryObject<Item, ShieldItem> GLASS_SHIELD = registerItem("glass_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(560).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_shield")))));
    public static final RegistryObject<Item, Item> GLASS_DAGGER = registerItem("glass_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.GLASS.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_dagger")))));
    public static final RegistryObject<Item, Item> GLASS_SWORD = registerItem("glass_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.GLASS.value(), 8, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> GLASS_BATTLEAXE = registerItem("glass_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.GLASS, 9, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> GLASS_GREATSWORD = registerItem("glass_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.GLASS, 8, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_greatsword")))));
    public static final RegistryObject<Item, Item> GLASS_MACE = registerItem("glass_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.GLASS.value(), 9, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_mace")))));
    public static final RegistryObject<Item, Item> GLASS_WAR_AXE = registerItem("glass_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.GLASS.value(), 9, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> GLASS_WARHAMMER = registerItem("glass_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.GLASS, 10, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_warhammer")))));
    public static final RegistryObject<Item, BowItem> GLASS_BOW = registerItem("glass_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "glass_bow")))));

    // Iron
    public static final RegistryObject<Item, Item> IRON_ARROW = registerItem("iron_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> IRON_HELMET = registerItem("iron_helmet", () -> new SkyrimArmor(ArmorMaterials.IRON.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IRON_CHESTPLATE = registerItem("iron_chestplate", () -> new SkyrimArmor(ArmorMaterials.IRON.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IRON_LEGGINGS = registerItem("iron_leggings", () -> new SkyrimArmor(ArmorMaterials.IRON.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IRON_BOOTS = registerItem("iron_boots", () -> new SkyrimArmor(ArmorMaterials.IRON.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> IRON_SHIELD = registerItem("iron_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(168).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_shield")))));
    public static final RegistryObject<Item, Item> IRON_DAGGER = registerItem("iron_dagger", () -> new Item(new Item.Properties()
            .sword(ToolMaterial.IRON, 4, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_dagger")))));
    public static final RegistryObject<Item, Item> IRON_SWORD = registerItem("iron_sword", () -> new Item(new Item.Properties()
            .sword(ToolMaterial.IRON, 6, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> IRON_BATTLEAXE = registerItem("iron_battleaxe", () -> new SkyrimTwoHandedSword(Holder.direct(ToolMaterial.IRON), 7, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> IRON_GREATSWORD = registerItem("iron_greatsword", () -> new SkyrimTwoHandedSword(Holder.direct(ToolMaterial.IRON), 6, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_greatsword")))));
    public static final RegistryObject<Item, Item> IRON_MACE = registerItem("iron_mace", () -> new Item(new Item.Properties()
            .sword(ToolMaterial.IRON, 7, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_mace")))));
    public static final RegistryObject<Item, Item> IRON_WAR_AXE = registerItem("iron_war_axe", () -> new Item(new Item.Properties()
            .sword(ToolMaterial.IRON, 7, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> IRON_WARHAMMER = registerItem("iron_warhammer", () -> new SkyrimTwoHandedSword(Holder.direct(ToolMaterial.IRON), 8, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "iron_warhammer")))));

    // Orcish
    public static final RegistryObject<Item, Item> ORCISH_ARROW = registerItem("orcish_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_arrow")))));
    public static final RegistryObject<Item, SkyrimArmor> ORCISH_HELMET = registerItem("orcish_helmet", () -> new SkyrimArmor(ArmorMaterials.ORCISH.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ORCISH_CHESTPLATE = registerItem("orcish_chestplate", () -> new SkyrimArmor(ArmorMaterials.ORCISH.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ORCISH_LEGGINGS = registerItem("orcish_leggings", () -> new SkyrimArmor(ArmorMaterials.ORCISH.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> ORCISH_BOOTS = registerItem("orcish_boots", () -> new SkyrimArmor(ArmorMaterials.ORCISH.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> ORCISH_SHIELD = registerItem("orcish_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(336).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_shield")))));
    public static final RegistryObject<Item, Item> ORCISH_DAGGER = registerItem("orcish_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.ORCISH.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_dagger")))));
    public static final RegistryObject<Item, Item> ORCISH_SWORD = registerItem("orcish_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.ORCISH.value(), 7, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ORCISH_BATTLEAXE = registerItem("orcish_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.ORCISH, 8, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ORCISH_GREATSWORD = registerItem("orcish_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.ORCISH, 7, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_greatsword")))));
    public static final RegistryObject<Item, Item> ORCISH_MACE = registerItem("orcish_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.ORCISH.value(), 8, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_mace")))));
    public static final RegistryObject<Item, Item> ORCISH_WAR_AXE = registerItem("orcish_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.ORCISH.value(), 8, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> ORCISH_WARHAMMER = registerItem("orcish_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.ORCISH, 9, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_warhammer")))));
    public static final RegistryObject<Item, BowItem> ORCISH_BOW = registerItem("orcish_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orcish_bow")))));

    // Steel
    public static final RegistryObject<Item, SkyrimArmor> STEEL_HELMET = registerItem("steel_helmet", () -> new SkyrimArmor(ArmorMaterials.STEEL.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STEEL_CHESTPLATE = registerItem("steel_chestplate", () -> new SkyrimArmor(ArmorMaterials.STEEL.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STEEL_LEGGINGS = registerItem("steel_leggings", () -> new SkyrimArmor(ArmorMaterials.STEEL.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STEEL_BOOTS = registerItem("steel_boots", () -> new SkyrimArmor(ArmorMaterials.STEEL.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_boots"))), true));
    public static final RegistryObject<Item, ShieldItem> STEEL_SHIELD = registerItem("steel_shield", () -> new ShieldItem(new Item.Properties().equippableUnswappable(EquipmentSlot.OFFHAND)
            .component(
                    DataComponents.BLOCKS_ATTACKS,
                    new BlocksAttacks(
                            0.25F,
                            1.0F,
                            List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                            new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                            Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    )
            ).stacksTo(1).durability(224).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_shield")))));
    public static final RegistryObject<Item, Item> STEEL_ARROW = registerItem("steel_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_arrow")))));
    public static final RegistryObject<Item, Item> STEEL_DAGGER = registerItem("steel_dagger", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 5, -1.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_dagger")))));
    public static final RegistryObject<Item, Item> STEEL_SWORD = registerItem("steel_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 6, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_sword")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> STEEL_BATTLEAXE = registerItem("steel_battleaxe", () -> new SkyrimTwoHandedSword(ItemTier.STEEL, 7, -3.2f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_battleaxe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> STEEL_GREATSWORD = registerItem("steel_greatsword", () -> new SkyrimTwoHandedSword(ItemTier.STEEL, 6, -2.8f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_greatsword")))));
    public static final RegistryObject<Item, Item> STEEL_MACE = registerItem("steel_mace", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 7, -3.0f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_mace")))));
    public static final RegistryObject<Item, Item> STEEL_WAR_AXE = registerItem("steel_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 7, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_war_axe")))));
    public static final RegistryObject<Item, SkyrimTwoHandedSword> STEEL_WARHAMMER = registerItem("steel_warhammer", () -> new SkyrimTwoHandedSword(ItemTier.STEEL, 8, -3.4f, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "steel_warhammer")))));

    // Stormcloak Officer
    public static final RegistryObject<Item, SkyrimArmor> STORMCLOAK_OFFICER_HELMET = registerItem("stormcloak_officer_helmet", () -> new SkyrimArmor(ArmorMaterials.STORMCLOAK.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "stormcloak_officer_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STORMCLOAK_OFFICER_CHESTPLATE = registerItem("stormcloak_officer_chestplate", () -> new SkyrimArmor(ArmorMaterials.STORMCLOAK.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "stormcloak_officer_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STORMCLOAK_OFFICER_LEGGINGS = registerItem("stormcloak_officer_leggings", () -> new SkyrimArmor(ArmorMaterials.STORMCLOAK.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "stormcloak_officer_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> STORMCLOAK_OFFICER_BOOTS = registerItem("stormcloak_officer_boots", () -> new SkyrimArmor(ArmorMaterials.STORMCLOAK.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "stormcloak_officer_boots"))), true));

    // Falmer
    public static final RegistryObject<Item, SkyrimArmor> FALMER_HELMET = registerItem("falmer_helmet", () -> new SkyrimArmor(ArmorMaterials.FALMER.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> FALMER_CHESTPLATE = registerItem("falmer_chestplate", () -> new SkyrimArmor(ArmorMaterials.FALMER.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> FALMER_LEGGINGS = registerItem("falmer_leggings", () -> new SkyrimArmor(ArmorMaterials.FALMER.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> FALMER_BOOTS = registerItem("falmer_boots", () -> new SkyrimArmor(ArmorMaterials.FALMER.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_boots"))), true));
    public static final RegistryObject<Item, Item> FALMER_ARROW = registerItem("falmer_arrow", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_arrow")))));
    public static final RegistryObject<Item, Item> FALMER_SWORD = registerItem("falmer_sword", () -> new Item(new Item.Properties()
            .sword(ItemTier.FALMER.value(), 7, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_sword")))));
    public static final RegistryObject<Item, Item> FALMER_WAR_AXE = registerItem("falmer_war_axe", () -> new Item(new Item.Properties()
            .sword(ItemTier.FALMER.value(), 8, -2.8f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_war_axe")))));
    public static final RegistryObject<Item, BowItem> FALMER_BOW = registerItem("falmer_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "falmer_bow")))));

    // Imperial
    public static final RegistryObject<Item, SkyrimArmor> IMPERIAL_HELMET = registerItem("imperial_helmet", () -> new SkyrimArmor(ArmorMaterials.IMPERIAL.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "imperial_helmet"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IMPERIAL_CHESTPLATE = registerItem("imperial_chestplate", () -> new SkyrimArmor(ArmorMaterials.IMPERIAL.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "imperial_chestplate"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IMPERIAL_LEGGINGS = registerItem("imperial_leggings", () -> new SkyrimArmor(ArmorMaterials.IMPERIAL.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "imperial_leggings"))), true));
    public static final RegistryObject<Item, SkyrimArmor> IMPERIAL_BOOTS = registerItem("imperial_boots", () -> new SkyrimArmor(ArmorMaterials.IMPERIAL.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "imperial_boots"))), true));
    public static final RegistryObject<Item, Item> IMPERIAL_SWORD = registerItem("imperial_sword", () -> new Item(new Item.Properties()
            .sword(ToolMaterial.IRON, 3.0F, -2.4F)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "imperial_sword")))));

    //// MISC ////
    // Hunting bow
    public static final RegistryObject<Item, BowItem> HUNTING_BOW = registerItem("hunting_bow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hunting_bow")))));
    // Longbow
    public static final RegistryObject<Item, BowItem> LONGBOW = registerItem("longbow", () -> new BowItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "longbow")))));
    // Scaled armor
    public static final RegistryObject<Item, SkyrimArmor> SCALED_HELMET = registerItem("scaled_helmet", () -> new SkyrimArmor(ArmorMaterials.SCALED.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "scaled_helmet"))), false));
    public static final RegistryObject<Item, SkyrimArmor> SCALED_CHESTPLATE = registerItem("scaled_chestplate", () -> new SkyrimArmor(ArmorMaterials.SCALED.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "scaled_chestplate"))), false));
    public static final RegistryObject<Item, SkyrimArmor> SCALED_LEGGINGS = registerItem("scaled_leggings", () -> new SkyrimArmor(ArmorMaterials.SCALED.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "scaled_leggings"))), false));
    public static final RegistryObject<Item, SkyrimArmor> SCALED_BOOTS = registerItem("scaled_boots", () -> new SkyrimArmor(ArmorMaterials.SCALED.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "scaled_boots"))), false));
    // Hide armor
    public static final RegistryObject<Item, SkyrimArmor> HIDE_HELMET = registerItem("hide_helmet", () -> new SkyrimArmor(ArmorMaterials.HIDE.value(), ArmorType.HELMET, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hide_helmet"))), false));
    public static final RegistryObject<Item, SkyrimArmor> HIDE_CHESTPLATE = registerItem("hide_chestplate", () -> new SkyrimArmor(ArmorMaterials.HIDE.value(), ArmorType.CHESTPLATE, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hide_chestplate"))), false));
    public static final RegistryObject<Item, SkyrimArmor> HIDE_LEGGINGS = registerItem("hide_leggings", () -> new SkyrimArmor(ArmorMaterials.HIDE.value(), ArmorType.LEGGINGS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hide_leggings"))), false));
    public static final RegistryObject<Item, SkyrimArmor> HIDE_BOOTS = registerItem("hide_boots", () -> new SkyrimArmor(ArmorMaterials.HIDE.value(), ArmorType.BOOTS, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hide_boots"))), false));
    // Special Swords
    public static final RegistryObject<Item, Item> CHILLREND = registerItem("chillrend", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 3.0f, -2.4f)
            .fireResistant()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chillrend")))));
    public static final RegistryObject<Item, Item> DAWNBREAKER = registerItem("dawnbreaker", () -> new Item(new Item.Properties()
            .sword(ItemTier.STEEL.value(), 3.0f, -2.4f)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "dawnbreaker")))));

    private static <T extends Item> RegistryObject<Item, T> registerItem(String id, java.util.function.Supplier<T> item) {
        var i = ITEMS.register(id, item);
        ITEM_LIST.add(i);
        return i;
    }

    public static void registerItemModelProperties() {
//        registerTwoHandedProperties(ANCIENT_NORD_BATTLEAXE.get());
//        registerTwoHandedProperties(ANCIENT_NORD_GREATSWORD.get());
//        registerBowProperties(ANCIENT_NORD_BOW.get());
//
//        registerTwoHandedProperties(DAEDRIC_BATTLEAXE.get());
//        registerTwoHandedProperties(DAEDRIC_GREATSWORD.get());
//        registerTwoHandedProperties(DAEDRIC_WARHAMMER.get());
//        registerBowProperties(DAEDRIC_BOW.get());
//        registerShield(DAEDRIC_SHIELD.get());

        // misc
        // registerBowProperties(HUNTING_BOW.get());
        // registerBowProperties(LONGBOW.get());
    }

//    private static void registerTwoHandedProperties(Item item) {
//        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,  "no_use"), ClientUtil::noUse);
//        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,  "blocking"), ClientUtil::blocking);
//    }
//
//    private static void registerBowProperties(Item item) {
//        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,  "pulling"), ClientUtil::pulling);
//        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,  "pull"), ClientUtil::pull);
//    }
//
//    private static void registerShield(Item item) {
//        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,  "blocking"), ClientUtil::blocking);
//    }
}