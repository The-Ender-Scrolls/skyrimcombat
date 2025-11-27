package com.ryankshah.skyrimcombat.client;

import com.ryankshah.skyrimcombat.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class SkyrimCombatFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        FabricRecipeSyncHandler.init();
        addBlockRenders();
    }

    public void addBlockRenders() {
        BlockRenderLayerMap.putBlock(BlockRegistry.BLACKSMITH_FORGE.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlockRegistry.ARCANE_ENCHANTER.get(), ChunkSectionLayer.CUTOUT);
    }
}
