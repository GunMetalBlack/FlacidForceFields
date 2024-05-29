
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mfff.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.mfff.block.ForceprojectorBlock;
import net.mcreator.mfff.block.ForceBlockBlock;
import net.mcreator.mfff.MfffMod;

public class MfffModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, MfffMod.MODID);
	public static final DeferredHolder<Block, Block> FORCEPROJECTOR = REGISTRY.register("forceprojector", () -> new ForceprojectorBlock());
	public static final DeferredHolder<Block, Block> FORCE_BLOCK = REGISTRY.register("force_block", () -> new ForceBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
