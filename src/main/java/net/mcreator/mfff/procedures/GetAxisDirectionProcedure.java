package net.mcreator.mfff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

import net.mcreator.mfff.network.MfffModVariables;

public class GetAxisDirectionProcedure {
	public static double execute(LevelAccessor world) {
		if (MfffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.NORTH) {
			return 1;
		} else if (MfffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.EAST) {
			return 1;
		} else if (MfffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.UP) {
			return 1;
		}
		return -1;
	}
}
