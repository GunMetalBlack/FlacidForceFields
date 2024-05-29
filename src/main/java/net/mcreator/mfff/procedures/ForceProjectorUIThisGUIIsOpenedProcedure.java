package net.mcreator.mfff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mfff.network.MfffModVariables;

public class ForceProjectorUIThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.should_update_force_ui = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.update_force_gui_counter = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
