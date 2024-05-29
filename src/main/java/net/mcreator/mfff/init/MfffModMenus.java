
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mfff.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.mfff.world.inventory.ForceProjectorUIMenu;
import net.mcreator.mfff.MfffMod;

public class MfffModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MfffMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ForceProjectorUIMenu>> FORCE_PROJECTOR_UI = REGISTRY.register("force_projector_ui", () -> IMenuTypeExtension.create(ForceProjectorUIMenu::new));
}
