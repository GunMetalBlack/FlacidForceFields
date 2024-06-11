package net.mcreator.mfff.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.mfff.network.MfffModVariables;

public class ReturnCurrentUpkeepProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		double upkeepCost = 0;
		double OffsetX = 0;
		double i = 0;
		double OffsetZ = 0;
		double j = 0;
		double OffsetY = 0;
		double radius = 0;
		double sudoBlockPosZ = 0;
		double sudoBlockPosY = 0;
		double sudoBlockPosX = 0;
		upkeepCost = Math.pow(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_radius") + 1, 2) * 6;
		return new java.text.DecimalFormat("##").format(upkeepCost * MfffModVariables.MapVariables.get(world).force_projector_energy_cost);
	}
}
