
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mfff.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.mfff.block.entity.ForceprojectorBlockEntity;
import net.mcreator.mfff.MfffMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MfffModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MfffMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FORCEPROJECTOR = register("forceprojector", MfffModBlocks.FORCEPROJECTOR, ForceprojectorBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FORCEPROJECTOR.get(), (blockEntity, side) -> ((ForceprojectorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, FORCEPROJECTOR.get(), (blockEntity, side) -> ((ForceprojectorBlockEntity) blockEntity).getEnergyStorage());
	}
}
