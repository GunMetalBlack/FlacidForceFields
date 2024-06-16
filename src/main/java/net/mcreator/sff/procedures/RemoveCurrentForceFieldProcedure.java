package net.mcreator.sff.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.sff.network.SffModVariables;
import net.mcreator.sff.init.SffModBlocks;

public class RemoveCurrentForceFieldProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
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
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_radius") > 50) {
			radius = 50;
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_radius") <= 0) {
			radius = 3;
		} else {
			radius = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_radius");
		}
		OffsetX = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_offsetx");
		OffsetY = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_offsety");
		OffsetZ = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_offsetz");
		for (Direction directioniterator : Direction.values()) {
			i = radius * (-1);
			while (i <= radius) {
				j = radius * (-1);
				while (j <= radius) {
					SffModVariables.MapVariables.get(world).forceFieldDirectionParamater = directioniterator;
					SffModVariables.MapVariables.get(world).syncData(world);
					sudoBlockPosX = 0;
					sudoBlockPosY = 0;
					sudoBlockPosZ = 0;
					if (directioniterator.getAxis() == Direction.Axis.X) {
						sudoBlockPosX = radius * GetAxisDirectionProcedure.execute(world);
						sudoBlockPosY = i;
						sudoBlockPosZ = j;
					} else if (directioniterator.getAxis() == Direction.Axis.Y) {
						sudoBlockPosX = i;
						sudoBlockPosY = radius * GetAxisDirectionProcedure.execute(world);
						sudoBlockPosZ = j;
					} else if (directioniterator.getAxis() == Direction.Axis.Z) {
						sudoBlockPosX = i;
						sudoBlockPosY = j;
						sudoBlockPosZ = radius * GetAxisDirectionProcedure.execute(world);
					}
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), "force_projector_position_reference_x") == x && new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), "force_projector_position_reference_y") == y && new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), "force_projector_position_reference_z") == z
							&& (world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)))).getBlock() == SffModBlocks.FORCE_BLOCK.get()) {
						world.setBlock(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), Blocks.AIR.defaultBlockState(), 3);
					}
					j = j + 1;
				}
				i = i + 1;
			}
		}
	}
}
