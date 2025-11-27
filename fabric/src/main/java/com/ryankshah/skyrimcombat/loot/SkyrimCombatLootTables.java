package com.ryankshah.skyrimcombat.loot;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class SkyrimCombatLootTables
{
    protected static LootPool.Builder villageTable = LootPool.lootPool()
            .setRolls(UniformGenerator.between(1.0F, 2.0F))
            .add(LootItem.lootTableItem(ItemRegistry.DAEDRA_HEART.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 3.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.LEATHER_STRIPS.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_ARROW.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_BATTLEAXE.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_BOOTS.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_BOW.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_CHESTPLATE.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_GREATSWORD.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_WAR_AXE.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_LEGGINGS.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_HELMET.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            )
            .add(LootItem.lootTableItem(ItemRegistry.ANCIENT_NORD_SWORD.get())
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.25F, 1.0F)))
            );

    public static void addLootTables() {
        LootTableEvents.MODIFY.register((lootTableResourceKey, lootTableBuilder, lootTableSource) -> {
            if (lootTableSource.isBuiltin() && (
                    lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/abandoned_mineshaft"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/buried_treasure"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/stronghold_corridor"))) ||
                            lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/piglin_bartering")))
                                    )) {
                    lootTableBuilder.withPool(villageTable);
            }
        });
        LootTableEvents.MODIFY.register((lootTableResourceKey, lootTableBuilder, lootTableSource) -> {
            if (lootTableSource.isBuiltin() && lootTableResourceKey.equals(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/sniffer_digging")))) {
                lootTableBuilder.withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.DAEDRA_HEART.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        ).add(LootItem.lootTableItem(ItemRegistry.LEATHER_STRIPS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        ));
            }
        });
    }
}