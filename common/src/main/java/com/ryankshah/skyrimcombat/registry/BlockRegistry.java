package com.ryankshah.skyrimcombat.registry;

import com.ryankshah.skyrimcombat.Constants;
import com.ryankshah.skyrimcombat.block.ArcaneEnchanterBlock;
import com.ryankshah.skyrimcombat.block.BlacksmithForgeBlock;
import com.ryankshah.skyrimcombat.registration.RegistrationProvider;
import com.ryankshah.skyrimcombat.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class BlockRegistry
{
    public static void init() {}

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    // Crafting Stations
    public static final RegistryObject<Block, Block> BLACKSMITH_FORGE = registerBlock("blacksmith_forge",
            () -> new BlacksmithForgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "blacksmith_forge")))));
//    public static final RegistryObject<Item, BlockItem> BLACKSMITH_FORGE_ITEM = ItemRegistry.ITEMS.register("blacksmith_forge",
//            () -> new BlockItem(BLACKSMITH_FORGE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "blacksmith_forge")))));

    public static final RegistryObject<Block, Block> ARCANE_ENCHANTER = registerBlock("arcane_enchanter",
            () -> new ArcaneEnchanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "arcane_enchanter")))));
//    public static final RegistryObject<Item, BlockItem> ARCANE_ENCHANTER_ITEM = ItemRegistry.ITEMS.register("arcane_enchanter",
//            () -> new BlockItem(ARCANE_ENCHANTER.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "arcane_enchanter")))));

    // Ore Blocks
    public static final RegistryObject<Block, Block> CORUNDUM_ORE = registerBlock("corundum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "corundum_ore")))));
//    public static final RegistryObject<Item, BlockItem> CORUNDUM_ORE_ITEM = ItemRegistry.ITEMS.register("corundum_ore",
//            () -> new BlockItem(CORUNDUM_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "corundum_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_CORUNDUM_ORE = registerBlock("deepslate_corundum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_corundum_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_CORUNDUM_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_corundum_ore",
//            () -> new BlockItem(DEEPSLATE_CORUNDUM_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_corundum_ore")))));

    public static final RegistryObject<Block, Block> EBONY_ORE = registerBlock("ebony_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_ore")))));
//    public static final RegistryObject<Item, BlockItem> EBONY_ORE_ITEM = ItemRegistry.ITEMS.register("ebony_ore",
//            () -> new BlockItem(EBONY_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "ebony_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_EBONY_ORE = registerBlock("deepslate_ebony_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_ebony_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_EBONY_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_ebony_ore",
//            () -> new BlockItem(DEEPSLATE_EBONY_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_ebony_ore")))));

    public static final RegistryObject<Block, Block> MALACHITE_ORE = registerBlock("malachite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "malachite_ore")))));
//    public static final RegistryObject<Item, BlockItem> MALACHITE_ORE_ITEM = ItemRegistry.ITEMS.register("malachite_ore",
//            () -> new BlockItem(MALACHITE_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "malachite_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_MALACHITE_ORE = registerBlock("deepslate_malachite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_malachite_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_MALACHITE_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_malachite_ore",
//            () -> new BlockItem(DEEPSLATE_MALACHITE_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_malachite_ore")))));

    public static final RegistryObject<Block, Block> MOONSTONE_ORE = registerBlock("moonstone_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "moonstone_ore")))));
//    public static final RegistryObject<Item, BlockItem> MOONSTONE_ORE_ITEM = ItemRegistry.ITEMS.register("moonstone_ore",
//            () -> new BlockItem(MOONSTONE_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "moonstone_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_MOONSTONE_ORE = registerBlock("deepslate_moonstone_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_moonstone_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_MOONSTONE_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_moonstone_ore",
//            () -> new BlockItem(DEEPSLATE_MOONSTONE_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_moonstone_ore")))));

    public static final RegistryObject<Block, Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orichalcum_ore")))));
//    public static final RegistryObject<Item, BlockItem> ORICHALCUM_ORE_ITEM = ItemRegistry.ITEMS.register("orichalcum_ore",
//            () -> new BlockItem(ORICHALCUM_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "orichalcum_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_ORICHALCUM_ORE = registerBlock("deepslate_orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_orichalcum_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_ORICHALCUM_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_orichalcum_ore",
//            () -> new BlockItem(DEEPSLATE_ORICHALCUM_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_orichalcum_ore")))));

    public static final RegistryObject<Block, Block> QUICKSILVER_ORE = registerBlock("quicksilver_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "quicksilver_ore")))));
//    public static final RegistryObject<Item, BlockItem> QUICKSILVER_ORE_ITEM = ItemRegistry.ITEMS.register("quicksilver_ore",
//            () -> new BlockItem(QUICKSILVER_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "quicksilver_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_QUICKSILVER_ORE = registerBlock("deepslate_quicksilver_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_quicksilver_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_QUICKSILVER_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_quicksilver_ore",
//            () -> new BlockItem(DEEPSLATE_QUICKSILVER_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_quicksilver_ore")))));

    public static final RegistryObject<Block, Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "silver_ore")))));
//    public static final RegistryObject<Item, BlockItem> SILVER_ORE_ITEM = ItemRegistry.ITEMS.register("silver_ore",
//            () -> new BlockItem(SILVER_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "silver_ore")))));

    public static final RegistryObject<Block, Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_silver_ore")))));
//    public static final RegistryObject<Item, BlockItem> DEEPSLATE_SILVER_ORE_ITEM = ItemRegistry.ITEMS.register("deepslate_silver_ore",
//            () -> new BlockItem(DEEPSLATE_SILVER_ORE.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "deepslate_silver_ore")))));

    private static <T extends Block> RegistryObject<Block, T> registerBlock(String id, Supplier<T> block) {
        RegistryObject<Block, T> temp = BLOCKS.register(id, block);
        registerBlockItem(id, temp);
        return temp;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<Block, T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name)))));
    }
}