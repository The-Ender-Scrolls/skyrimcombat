package com.ryankshah.skyrimcombat.data.loot;

import com.ryankshah.skyrimcombat.Constants;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class SkyrimLootModifierProvider extends GlobalLootModifierProvider
{
    protected CompletableFuture<HolderLookup.Provider> registries;
    public SkyrimLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
        this.registries = registries;
    }

    @Override
    protected void start() {
        HolderGetter<EntityType<?>> holdergetter = this.registries.getNow(null).lookupOrThrow(Registries.ENTITY_TYPE);

        this.add("chests/simple_dungeon", new AddTableLootModifier(
            new LootItemCondition[] {
                    LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build()
            }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/simple_dungeon"))
        ));

        this.add("chests/abandoned_mineshaft", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/abandoned_mineshaft"))
        ));
        this.add("chests/buried_treasure", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/buried_treasure")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/buried_treasure"))
        ));
        this.add("chests/desert_pyramid", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/desert_pyramid"))
        ));
        this.add("chests/shipwreck_supply", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/shipwreck_supply"))
        ));
        this.add("chests/stronghold_corridor", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chests/stronghold_corridor"))
        ));
        this.add("gameplay/piglin_bartering", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/piglin_bartering")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/piglin_bartering"))
        ));
        this.add("gameplay/sniffer_digging", new AddTableLootModifier(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build()
                }, ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "gameplay/sniffer_digging"))
        ));
    }
}
