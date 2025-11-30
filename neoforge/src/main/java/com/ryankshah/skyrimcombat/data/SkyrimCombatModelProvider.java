package com.ryankshah.skyrimcombat.data;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.block.ArcaneEnchanterBlock;
import com.ryankshah.skyrimcombat.block.BlacksmithForgeBlock;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import com.ryankshah.skyrimcombat.registry.ItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.Damaged;
import net.minecraft.client.renderer.special.ShieldSpecialRenderer;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkyrimCombatModelProvider extends ModelProvider {

    public SkyrimCombatModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ItemRegistry.CORUNDUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DWARVEN_METAL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EBONY_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.MALACHITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.MOONSTONE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ORICHALCUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.QUICKSILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.SILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.LEATHER_STRIPS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRA_HEART.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.FLAWED_AMETHYST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWED_DIAMOND.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWED_EMERALD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWED_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWLESS_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWED_GARNET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FLAWLESS_GARNET.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        greatsword(itemModels, ItemRegistry.ANCIENT_NORD_GREATSWORD.get());
        sword(itemModels, ItemRegistry.ANCIENT_NORD_WAR_AXE.get());
        sword(itemModels, ItemRegistry.ANCIENT_NORD_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.ANCIENT_NORD_BOW.get());

        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.DAEDRIC_DAGGER.get());
        sword(itemModels, ItemRegistry.DAEDRIC_SWORD.get());
        sword(itemModels, ItemRegistry.DAEDRIC_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.DAEDRIC_BOW.get());
        greatsword(itemModels, ItemRegistry.DAEDRIC_GREATSWORD.get());
        sword(itemModels, ItemRegistry.DAEDRIC_MACE.get());
        sword(itemModels, ItemRegistry.DAEDRIC_WAR_AXE.get());
        sword(itemModels, ItemRegistry.DAEDRIC_WARHAMMER.get());

        sword(itemModels, ItemRegistry.DRAGONBONE_DAGGER.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_SWORD.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.DRAGONBONE_BOW.get());
        greatsword(itemModels, ItemRegistry.DRAGONBONE_GREATSWORD.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_MACE.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_WAR_AXE.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.DWARVEN_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DWARVEN_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DWARVEN_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DWARVEN_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.DWARVEN_DAGGER.get());
        sword(itemModels, ItemRegistry.DWARVEN_SWORD.get());
        sword(itemModels, ItemRegistry.DWARVEN_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.DWARVEN_BOW.get());
        greatsword(itemModels, ItemRegistry.DWARVEN_GREATSWORD.get());
        sword(itemModels, ItemRegistry.DWARVEN_MACE.get());
        sword(itemModels, ItemRegistry.DWARVEN_WAR_AXE.get());
        sword(itemModels, ItemRegistry.DWARVEN_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.EBONY_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EBONY_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EBONY_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EBONY_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.EBONY_DAGGER.get());
        sword(itemModels, ItemRegistry.EBONY_SWORD.get());
        sword(itemModels, ItemRegistry.EBONY_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.EBONY_BOW.get());
        greatsword(itemModels, ItemRegistry.EBONY_GREATSWORD.get());
        sword(itemModels, ItemRegistry.EBONY_MACE.get());
        sword(itemModels, ItemRegistry.EBONY_WAR_AXE.get());
        sword(itemModels, ItemRegistry.EBONY_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.ELVEN_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ELVEN_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ELVEN_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ELVEN_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.ELVEN_DAGGER.get());
        sword(itemModels, ItemRegistry.ELVEN_SWORD.get());
        sword(itemModels, ItemRegistry.ELVEN_BATTLEAXE.get());;
        itemModels.generateBow(ItemRegistry.ELVEN_BOW.get());
        greatsword(itemModels, ItemRegistry.ELVEN_GREATSWORD.get());
        sword(itemModels, ItemRegistry.ELVEN_MACE.get());
        sword(itemModels, ItemRegistry.ELVEN_WAR_AXE.get());
        sword(itemModels, ItemRegistry.ELVEN_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.FALMER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.FALMER_SWORD.get());
        itemModels.generateBow(ItemRegistry.FALMER_BOW.get());
        sword(itemModels, ItemRegistry.FALMER_WAR_AXE.get());

        itemModels.generateFlatItem(ItemRegistry.GLASS_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.GLASS_DAGGER.get());
        sword(itemModels, ItemRegistry.GLASS_SWORD.get());
        sword(itemModels, ItemRegistry.GLASS_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.GLASS_BOW.get());
        greatsword(itemModels, ItemRegistry.GLASS_GREATSWORD.get());
        sword(itemModels, ItemRegistry.GLASS_MACE.get());
        sword(itemModels, ItemRegistry.GLASS_WAR_AXE.get());
        sword(itemModels, ItemRegistry.GLASS_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.IMPERIAL_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IMPERIAL_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IMPERIAL_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IMPERIAL_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.IMPERIAL_SWORD.get());

        itemModels.generateFlatItem(ItemRegistry.IRON_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IRON_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IRON_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IRON_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.IRON_DAGGER.get());
        sword(itemModels, ItemRegistry.IRON_SWORD.get());
        sword(itemModels, ItemRegistry.IRON_BATTLEAXE.get());
        greatsword(itemModels, ItemRegistry.IRON_GREATSWORD.get());
        sword(itemModels, ItemRegistry.IRON_MACE.get());
        sword(itemModels, ItemRegistry.IRON_WAR_AXE.get());
        sword(itemModels, ItemRegistry.IRON_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.ORCISH_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ORCISH_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ORCISH_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ORCISH_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.ORCISH_DAGGER.get());
        sword(itemModels, ItemRegistry.ORCISH_SWORD.get());
        sword(itemModels, ItemRegistry.ORCISH_BATTLEAXE.get());
        itemModels.generateBow(ItemRegistry.ORCISH_BOW.get());
        greatsword(itemModels, ItemRegistry.ORCISH_GREATSWORD.get());
        sword(itemModels, ItemRegistry.ORCISH_MACE.get());
        sword(itemModels, ItemRegistry.ORCISH_WAR_AXE.get());
        sword(itemModels, ItemRegistry.ORCISH_WARHAMMER.get());

//        itemModels.generateFlatItem(ItemRegistry.STEEL_HELMET.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(ItemRegistry.STEEL_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(ItemRegistry.STEEL_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(ItemRegistry.STEEL_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.STEEL_DAGGER.get());
        sword(itemModels, ItemRegistry.STEEL_SWORD.get());
        sword(itemModels, ItemRegistry.STEEL_BATTLEAXE.get());
        greatsword(itemModels, ItemRegistry.STEEL_GREATSWORD.get());
        sword(itemModels, ItemRegistry.STEEL_MACE.get());
        sword(itemModels, ItemRegistry.STEEL_WAR_AXE.get());
        sword(itemModels, ItemRegistry.STEEL_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.STORMCLOAK_OFFICER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STORMCLOAK_OFFICER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STORMCLOAK_OFFICER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STORMCLOAK_OFFICER_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateBow(ItemRegistry.HUNTING_BOW.get());
        itemModels.generateBow(ItemRegistry.LONGBOW.get());

        itemModels.generateFlatItem(ItemRegistry.SCALED_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.SCALED_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.SCALED_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.SCALED_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.HIDE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.HIDE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.HIDE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.HIDE_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.CHILLREND.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAWNBREAKER.get(), ModelTemplates.FLAT_ITEM);

        // Arrows
        itemModels.generateFlatItem(ItemRegistry.ANCIENT_NORD_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DRAGONBONE_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DWARVEN_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EBONY_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ELVEN_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.IRON_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.ORCISH_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_ARROW.get(), ModelTemplates.FLAT_ITEM);

// Shields
        itemModels.generateShield(ItemRegistry.DAEDRIC_SHIELD.get());
        itemModels.generateShield(ItemRegistry.DWARVEN_SHIELD.get());
        itemModels.generateShield(ItemRegistry.EBONY_SHIELD.get());
        itemModels.generateShield(ItemRegistry.ELVEN_SHIELD.get());
        itemModels.generateShield(ItemRegistry.GLASS_SHIELD.get());
        itemModels.generateShield(ItemRegistry.IRON_SHIELD.get());
        itemModels.generateShield(ItemRegistry.ORCISH_SHIELD.get());
        itemModels.generateShield(ItemRegistry.STEEL_SHIELD.get());

        itemModels.generateFlatItem(ItemRegistry.STEEL_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(BlockRegistry.CORUNDUM_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_CORUNDUM_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.EBONY_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_EBONY_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.MALACHITE_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_MALACHITE_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.MOONSTONE_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_MOONSTONE_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.ORICHALCUM_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_ORICHALCUM_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.QUICKSILVER_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_QUICKSILVER_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.SILVER_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_SILVER_ORE.get());

//        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(BlockRegistry.BLACKSMITH_FORGE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/blacksmith_forge")).with(BlockModelGenerators.createHorizontalFacingDispatchAlt()));
//        blockModels.registerSimpleItemModel(BlockRegistry.BLACKSMITH_FORGE.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/blacksmith_forge"));
//
//        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(BlockRegistry.ARCANE_ENCHANTER.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/arcane_enchanter")).with(BlockModelGenerators.createHorizontalFacingDispatchAlt()));
//        blockModels.registerSimpleItemModel(BlockRegistry.ARCANE_ENCHANTER.get(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "block/arcane_enchanter"));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::asHolder).filter(blockHolder -> !(
                blockHolder.value() instanceof CropBlock ||
                        blockHolder.value() instanceof BlacksmithForgeBlock ||
                        blockHolder.value() instanceof ArcaneEnchanterBlock
        ));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::asHolder).filter(e -> !(e.value() instanceof ShieldItem));
    }

    private void sword(ItemModelGenerators generator, Item item) {
        generator.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    private void greatsword(ItemModelGenerators generator, Item item) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/greatsword"));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/greatsword_blocking"));
        generator.generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), itemmodel$unbaked1, itemmodel$unbaked);
    }
}