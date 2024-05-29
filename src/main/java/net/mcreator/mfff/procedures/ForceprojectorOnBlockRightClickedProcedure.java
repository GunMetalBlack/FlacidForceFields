package net.mcreator.mfff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mfff.network.MfffModVariables;

public class ForceprojectorOnBlockRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.transfer_force_radius = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.transfer_force_offsetx = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.transfer_force_offsety = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
			_vars.transfer_force_offsetz = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
