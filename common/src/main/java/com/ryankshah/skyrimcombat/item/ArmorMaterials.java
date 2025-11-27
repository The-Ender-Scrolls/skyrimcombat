package com.ryankshah.skyrimcombat.item;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.TagsRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class ArmorMaterials
{
    protected static ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    public static final Holder<ArmorMaterial> ANCIENT_NORD = Holder.direct(new ArmorMaterial(
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 5);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 5);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.5F,
            0.125F,
            ItemTags.REPAIRS_IRON_ARMOR,
            createId("ancient_nord")
    ));

    public static final Holder<ArmorMaterial> DRAGONBONE = Holder.direct(new ArmorMaterial(
            33,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.0F,
            0.25F,
            ItemTags.REPAIRS_IRON_ARMOR,
            createId("dragonbone")
    ));

    public static final Holder<ArmorMaterial> HIDE = Holder.direct(new ArmorMaterial(
            7,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_LEATHER_ARMOR,
            createId("hide")
    ));

    public static final Holder<ArmorMaterial> SCALED = Holder.direct(new ArmorMaterial(
            12,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            TagsRegistry.ItemTagsInit.REPAIRS_STEEL,
            createId("scaled")
    ));

    public static final Holder<ArmorMaterial> STEEL = Holder.direct(new ArmorMaterial(
            18,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 7);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.1F,
            0.0F,
            TagsRegistry.ItemTagsInit.REPAIRS_STEEL,
            createId("steel")
    ));

    public static final Holder<ArmorMaterial> GLASS = Holder.direct(new ArmorMaterial(
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.1F,
            0.0F,
            TagsRegistry.ItemTagsInit.REPAIRS_GLASS,
            createId("glass")
    ));

    public static final Holder<ArmorMaterial> ELVEN = Holder.direct(new ArmorMaterial(
            20,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.2F,
            0.1F,
            TagsRegistry.ItemTagsInit.REPAIRS_ELVEN,
            createId("elven")
    ));

    public static final Holder<ArmorMaterial> DAEDRIC = Holder.direct(new ArmorMaterial(
            40,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 4);
                map.put(ArmorType.LEGGINGS, 8);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 4);
                map.put(ArmorType.BODY, 8);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0F,
            0.25F,
            TagsRegistry.ItemTagsInit.REPAIRS_EBONY,
            createId("daedric")
    ));

    public static final Holder<ArmorMaterial> EBONY = Holder.direct(new ArmorMaterial(
            35,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 8);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0F,
            0.1F,
            TagsRegistry.ItemTagsInit.REPAIRS_EBONY,
            createId("ebony")
    ));

    public static final Holder<ArmorMaterial> ORCISH = Holder.direct(new ArmorMaterial(
            30,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.1F,
            0.0F,
            TagsRegistry.ItemTagsInit.REPAIRS_ORCISH,
            createId("orcish")
    ));

    public static final Holder<ArmorMaterial> DWARVEN = Holder.direct(new ArmorMaterial(
            22,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.1F,
            0.0F,
            TagsRegistry.ItemTagsInit.REPAIRS_DWARVEN,
            createId("dwarven")
    ));

    public static final Holder<ArmorMaterial> IRON = Holder.direct(new ArmorMaterial(
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 6);
            }),
            9,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_IRON_ARMOR,
            createId("iron")
    ));

    public static final Holder<ArmorMaterial> STORMCLOAK = Holder.direct(new ArmorMaterial(
            10,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_LEATHER_ARMOR,
            createId("stormcloak")
    ));

    public static final Holder<ArmorMaterial> IMPERIAL = Holder.direct(new ArmorMaterial(
            10,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_LEATHER_ARMOR,
            createId("imperial")
    ));

    public static final Holder<ArmorMaterial> FALMER = Holder.direct(new ArmorMaterial(
            10,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 3);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_LEATHER_ARMOR,
            createId("falmer")
    ));
}