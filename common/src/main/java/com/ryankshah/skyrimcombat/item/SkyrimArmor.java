package com.ryankshah.skyrimcombat.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class SkyrimArmor extends Item
{
    private boolean isHeavy;

    public SkyrimArmor(ArmorMaterial pMaterial, ArmorType pType, Item.Properties pProperties, boolean isHeavy) {
        super(pProperties.humanoidArmor(pMaterial, pType));
        this.isHeavy = isHeavy;
    }

    public boolean isHeavy() {
        return isHeavy;
    }
}
