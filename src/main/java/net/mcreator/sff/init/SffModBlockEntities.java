
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.sff.block.entity.ForceprojectorBlockEntity;
import net.mcreator.sff.block.entity.ForceBlockBlockEntity;
import net.mcreator.sff.SffMod;

public class SffModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SffMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> FORCEPROJECTOR = register("forceprojector", SffModBlocks.FORCEPROJECTOR, ForceprojectorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FORCE_BLOCK = register("force_block", SffModBlocks.FORCE_BLOCK, ForceBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
