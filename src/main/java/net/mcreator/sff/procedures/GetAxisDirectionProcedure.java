package net.mcreator.sff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

import net.mcreator.sff.network.SffModVariables;

public class GetAxisDirectionProcedure {
	public static double execute(LevelAccessor world) {
		if (SffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.NORTH) {
			return 1;
		} else if (SffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.EAST) {
			return 1;
		} else if (SffModVariables.MapVariables.get(world).forceFieldDirectionParamater == Direction.UP) {
			return 1;
		}
		return -1;
	}
}
