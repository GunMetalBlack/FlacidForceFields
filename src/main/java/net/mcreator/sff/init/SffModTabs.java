
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.sff.SffMod;

public class SffModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SffMod.MODID);
	public static final RegistryObject<CreativeModeTab> MFFFTAB = REGISTRY.register("mffftab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.sff.mffftab")).icon(() -> new ItemStack(Items.DRAGON_BREATH)).displayItems((parameters, tabData) -> {
				tabData.accept(SffModBlocks.FORCEPROJECTOR.get().asItem());
				tabData.accept(SffModBlocks.FORCE_BLOCK.get().asItem());
			})

					.build());
}
