package com.ryankshah.skyrimcombat.data.loot;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class SkyrimcraftLootTableProvider implements LootTableSubProvider
{
    public SkyrimcraftLootTableProvider() {
    }

    public SkyrimcraftLootTableProvider(HolderLookup.Provider provider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput) {
        LootTable.Builder chestPool = LootTable.lootTable().withPool(
                LootPool.lootPool()
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
                        )
        );

        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/abandoned_mineshaft")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/buried_treasure")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/stronghold_corridor")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/piglin_bartering")),
                chestPool
        );
        pOutput.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/sniffer_digging")),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.DAEDRA_HEART.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        )
                        .add(LootItem.lootTableItem(ItemRegistry.LEATHER_STRIPS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.5F, 1.0F)))
                        )
                )
        );
    }
}
