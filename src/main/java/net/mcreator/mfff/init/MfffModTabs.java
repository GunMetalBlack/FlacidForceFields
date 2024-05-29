
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mfff.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.mfff.MfffMod;

public class MfffModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MfffMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MFFFTAB = REGISTRY.register("mffftab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.mfff.mffftab")).icon(() -> new ItemStack(Items.DRAGON_BREATH)).displayItems((parameters, tabData) -> {
				tabData.accept(MfffModBlocks.FORCEPROJECTOR.get().asItem());
				tabData.accept(MfffModBlocks.FORCE_BLOCK.get().asItem());
			})

					.build());
}
