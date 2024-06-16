
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.sff.SffMod;

public class SffModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SffMod.MODID);
	public static final RegistryObject<Item> FORCEPROJECTOR = block(SffModBlocks.FORCEPROJECTOR);
	public static final RegistryObject<Item> FORCE_BLOCK = block(SffModBlocks.FORCE_BLOCK);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
