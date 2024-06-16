
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.sff.block.ForceprojectorBlock;
import net.mcreator.sff.block.ForceBlockBlock;
import net.mcreator.sff.SffMod;

public class SffModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SffMod.MODID);
	public static final RegistryObject<Block> FORCEPROJECTOR = REGISTRY.register("forceprojector", () -> new ForceprojectorBlock());
	public static final RegistryObject<Block> FORCE_BLOCK = REGISTRY.register("force_block", () -> new ForceBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
