package net.mcreator.sff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.sff.network.SffModVariables;

public class ForceProjectorUIThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.should_update_force_ui = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.update_force_gui_counter = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
