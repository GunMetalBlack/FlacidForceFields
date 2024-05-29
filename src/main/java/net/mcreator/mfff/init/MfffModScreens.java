
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mfff.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.mfff.client.gui.ForceProjectorUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MfffModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MfffModMenus.FORCE_PROJECTOR_UI.get(), ForceProjectorUIScreen::new);
	}
}
