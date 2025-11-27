package com.ryankshah.skyrimcombat.item;

import com.ryankshah.skyrimcombat.registry.TagsRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ToolMaterial;

public class ItemTier
{
    public static final Holder<ToolMaterial> ANCIENT_NORD = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_ANCIENT_NORD_TOOL,
            250,
            6.0f,
            2.0f,
            14,
            TagsRegistry.ItemTagsInit.EMPTY_INGREDIENT
    ));

    public static final Holder<ToolMaterial> DRAGONBONE = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_DRAGONBONE_TOOL,
            250,
            6.0f,
            2.0f,
            14,
            TagsRegistry.ItemTagsInit.EMPTY_INGREDIENT
    ));

    public static final Holder<ToolMaterial> STEEL = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_STEEL_TOOL,
            275,
            6.5f,
            2.25f,
            20,
            TagsRegistry.ItemTagsInit.REPAIRS_STEEL
    ));

    public static final Holder<ToolMaterial> FALMER = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_FALMER_TOOL,
            250,
            6.0f,
            2.0f,
            14,
            TagsRegistry.ItemTagsInit.EMPTY_INGREDIENT
    ));

    public static final Holder<ToolMaterial> GLASS = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_GLASS_TOOL,
            32,
            12.0f,
            1.0f,
            22,
            TagsRegistry.ItemTagsInit.REPAIRS_GLASS
    ));

    public static final Holder<ToolMaterial> ELVEN = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_ELVEN_TOOL,
        32,
        12.0f,
        1.0f,
        22,
            TagsRegistry.ItemTagsInit.REPAIRS_ELVEN
    ));

    public static final Holder<ToolMaterial> ORCISH = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_ORCISH_TOOL,
            250,
            6.0f,
            2.0f,
            22,
            TagsRegistry.ItemTagsInit.REPAIRS_ORCISH
    ));

    public static final Holder<ToolMaterial> DWARVEN = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_DWARVEN_TOOL,
            450,
            6.5f,
            2.5f,
            22,
            TagsRegistry.ItemTagsInit.REPAIRS_DWARVEN
    ));

    public static final Holder<ToolMaterial> DAEDRIC = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_DAEDRIC_TOOL,
            2031,
            9.0f,
            4.0f,
            22,
            TagsRegistry.ItemTagsInit.REPAIRS_EBONY
    ));

    public static final Holder<ToolMaterial> EBONY = Holder.direct(new ToolMaterial(
            TagsRegistry.BlockTagsInit.NEEDS_EBONY_TOOL,
            1743,
            7.0f,
            2.5f,
            18,
            TagsRegistry.ItemTagsInit.REPAIRS_EBONY
    ));

//    static {
//        ToolMaterialSortingRegistry.registerToolMaterial(
//                COPPER_ToolMaterial,
//                //The name to use for internal resolution. May use the Minecraft namespace if appropriate.
//                new ResourceLocation("minecraft", "copper"),
//                //A list of ToolMaterials that are considered lower than the type being added. For example, stone is lower than copper.
//                //We don't need to add wood and gold here because those are already lower than stone.
//                List.of(ToolMaterials.STONE),
//                //A list of ToolMaterials that are considered higher than the type being added. For example, iron is higher than copper.
//                //We don't need to add diamond and netherite here because those are already higher than iron.
//                List.of(ToolMaterials.IRON)
//        ));
//    }

}