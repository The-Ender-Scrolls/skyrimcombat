package com.ryankshah.skyrimcombat.item;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

//TODO: FIX THIS!!! (the prevent use if has shield etc.)
public class SkyrimTwoHandedSword extends Item
{
    public SkyrimTwoHandedSword(Holder<ToolMaterial> pTier, float attackDamage, float attackSpeed, Properties pProperties) {
        super(pProperties.sword(pTier.value(), attackDamage, attackSpeed));
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (player.getOffhandItem().equals(ItemStack.EMPTY)) {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.FAIL;
        }
    }

//    @Override
//    public boolean canPerformAction(ItemStack stack, ItemAbility toolAction) {
//        return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
//    }
//
//    @Override
//    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, LivingEntity entity) {
//        if(armorType == EquipmentSlot.OFFHAND)
//            return false;
//        else return super.canEquip(stack, armorType, entity);
//    }


    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        return 72000;
    }
}