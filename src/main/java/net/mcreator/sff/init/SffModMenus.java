
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.sff.world.inventory.ForceProjectorUIMenu;
import net.mcreator.sff.SffMod;

public class SffModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SffMod.MODID);
	public static final RegistryObject<MenuType<ForceProjectorUIMenu>> FORCE_PROJECTOR_UI = REGISTRY.register("force_projector_ui", () -> IForgeMenuType.create(ForceProjectorUIMenu::new));
}
