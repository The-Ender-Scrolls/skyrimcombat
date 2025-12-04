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
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

import java.util.Optional;
import java.util.stream.Stream;

public class SkyrimCombatModelProvider extends ModelProvider
{
    private static final ModelTemplate GREATSWORD = new ModelTemplate(
            Optional.of(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/greatsword")),
            Optional.empty(),
            TextureSlot.LAYER0
    );

    private static final ModelTemplate GREATSWORD_BLOCKING = new ModelTemplate(
            Optional.of(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/greatsword_blocking")),
            Optional.empty(),
            TextureSlot.LAYER0
    );

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
        generateCustomBow(itemModels, ItemRegistry.ANCIENT_NORD_BOW.get());

        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.DAEDRIC_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.DAEDRIC_DAGGER.get());
        sword(itemModels, ItemRegistry.DAEDRIC_SWORD.get());
        sword(itemModels, ItemRegistry.DAEDRIC_BATTLEAXE.get());
        generateCustomBow(itemModels, ItemRegistry.DAEDRIC_BOW.get());
        greatsword(itemModels, ItemRegistry.DAEDRIC_GREATSWORD.get());
        sword(itemModels, ItemRegistry.DAEDRIC_MACE.get());
        sword(itemModels, ItemRegistry.DAEDRIC_WAR_AXE.get());
        sword(itemModels, ItemRegistry.DAEDRIC_WARHAMMER.get());

        sword(itemModels, ItemRegistry.DRAGONBONE_DAGGER.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_SWORD.get());
        sword(itemModels, ItemRegistry.DRAGONBONE_BATTLEAXE.get());
        generateCustomBow(itemModels, ItemRegistry.DRAGONBONE_BOW.get());
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
        generateCustomBow(itemModels, ItemRegistry.DWARVEN_BOW.get());
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
        generateCustomBow(itemModels, ItemRegistry.EBONY_BOW.get());
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
        generateCustomBow(itemModels, ItemRegistry.ELVEN_BOW.get());
        greatsword(itemModels, ItemRegistry.ELVEN_GREATSWORD.get());
        sword(itemModels, ItemRegistry.ELVEN_MACE.get());
        sword(itemModels, ItemRegistry.ELVEN_WAR_AXE.get());
        sword(itemModels, ItemRegistry.ELVEN_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.FALMER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FALMER_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.FALMER_SWORD.get());
        generateCustomBow(itemModels, ItemRegistry.FALMER_BOW.get());
        sword(itemModels, ItemRegistry.FALMER_WAR_AXE.get());

        itemModels.generateFlatItem(ItemRegistry.GLASS_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.GLASS_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        sword(itemModels, ItemRegistry.GLASS_DAGGER.get());
        sword(itemModels, ItemRegistry.GLASS_SWORD.get());
        sword(itemModels, ItemRegistry.GLASS_BATTLEAXE.get());
        generateCustomBow(itemModels, ItemRegistry.GLASS_BOW.get());
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
        generateCustomBow(itemModels, ItemRegistry.ORCISH_BOW.get());
        greatsword(itemModels, ItemRegistry.ORCISH_GREATSWORD.get());
        sword(itemModels, ItemRegistry.ORCISH_MACE.get());
        sword(itemModels, ItemRegistry.ORCISH_WAR_AXE.get());
        sword(itemModels, ItemRegistry.ORCISH_WARHAMMER.get());

        itemModels.generateFlatItem(ItemRegistry.STEEL_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.STEEL_BOOTS.get(), ModelTemplates.FLAT_ITEM);
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

//        itemModels.generateFlatItem(ItemRegistry.HUNTING_BOW.get(), ModelTemplates.BOW);
        generateCustomBow(itemModels, ItemRegistry.HUNTING_BOW.get());
        generateCustomBow(itemModels, ItemRegistry.LONGBOW.get());

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
        generateSimpleShield(itemModels, ItemRegistry.DAEDRIC_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.DWARVEN_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.EBONY_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.ELVEN_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.GLASS_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.IRON_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.ORCISH_SHIELD.get());
        generateSimpleShield(itemModels, ItemRegistry.STEEL_SHIELD.get());

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

    private void generateCustomBow(ItemModelGenerators generator, Item bowItem) {
        String itemName = bowItem.getDescriptionId().replace("item.skyrimcombat.", "");

        // Create the base model
        ResourceLocation baseModel = generator.createFlatItemModel(bowItem, ModelTemplates.BOW);

        // Create pulling models
        ItemModel.Unbaked pulling0 = ItemModelUtils.plainModel(
                generator.createFlatItemModel(bowItem, "_pulling_0", ModelTemplates.BOW)
        );
        ItemModel.Unbaked pulling1 = ItemModelUtils.plainModel(
                generator.createFlatItemModel(bowItem, "_pulling_1", ModelTemplates.BOW)
        );
        ItemModel.Unbaked pulling2 = ItemModelUtils.plainModel(
                generator.createFlatItemModel(bowItem, "_pulling_2", ModelTemplates.BOW)
        );

        ItemModel.Unbaked baseUnbaked = ItemModelUtils.plainModel(baseModel);

        // Create the conditional model
        generator.itemModelOutput.accept(
                bowItem,
                ItemModelUtils.conditional(
                        ItemModelUtils.isUsingItem(),
                        ItemModelUtils.rangeSelect(
                                new UseDuration(false),
                                0.05F,
                                pulling0,
                                ItemModelUtils.override(pulling1, 0.65F),
                                ItemModelUtils.override(pulling2, 0.9F)
                        ),
                        baseUnbaked
                )
        );
    }

//    private void greatsword(ItemModelGenerators generator, Item item) {
//        String itemName = item.getDescriptionId().replace("item.skyrimcombat.", "");
//
//        // Create the base model
//        ResourceLocation baseModel = generator.createFlatItemModel(
//                item,
//                GREATSWORD
//        );
//
//        // Create the blocking model
//        ResourceLocation blockingModel = generator.createFlatItemModel(
//                item,
//                "_blocking",
//                GREATSWORD_BLOCKING
//        );
//
//        // Set up the conditional switching
//        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(baseModel);
//        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(blockingModel);
//        generator.generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), itemmodel$unbaked1, itemmodel$unbaked);
//    }

    private void greatsword(ItemModelGenerators generator, Item item) {
        String itemName = item.getDescriptionId().replace("item.skyrimcombat.", "");

        // Create the base model
        ResourceLocation baseModel = generator.createFlatItemModel(
                item,
                GREATSWORD
        );

        // Create texture mapping that points to the base texture (without _blocking suffix)
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.LAYER0, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/" + itemName));

        // Create the blocking model with the base texture
        ResourceLocation blockingModel = GREATSWORD_BLOCKING.create(
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "item/" + itemName + "_blocking"),
                textureMapping,
                generator.modelOutput
        );

        // Set up the conditional switching
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(baseModel);
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(blockingModel);
        generator.generateBooleanDispatch(item, ItemModelUtils.isUsingItem(), itemmodel$unbaked1, itemmodel$unbaked);
    }

    private void generateSimpleShield(ItemModelGenerators generator, Item shieldItem) {
        // Reference your existing custom models
        ResourceLocation baseModel = ModelLocationUtils.getModelLocation(shieldItem);
        ResourceLocation blockingModel = ModelLocationUtils.getModelLocation(shieldItem, "_blocking");

        // Set up the conditional switching between your existing models
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(baseModel);
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(blockingModel);
        generator.generateBooleanDispatch(shieldItem, ItemModelUtils.isUsingItem(), itemmodel$unbaked1, itemmodel$unbaked);
    }
}