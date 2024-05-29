package net.mcreator.mfff.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.common.PlantType;
import net.neoforged.neoforge.common.IPlantable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.mfff.network.MfffModVariables;
import net.mcreator.mfff.init.MfffModBlocks;

public class ForceprojectorOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Direction direction = Direction.NORTH;
		double i = 0;
		double j = 0;
		double radius = 0;
		double OffsetX = 0;
		double OffsetY = 0;
		double OffsetZ = 0;
		double sudoBlockPosX = 0;
		double sudoBlockPosY = 0;
		double sudoBlockPosZ = 0;
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
					MfffModVariables.MapVariables.get(world).forceFieldDirectionParamater = directioniterator;
					MfffModVariables.MapVariables.get(world).syncData(world);
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
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							if (level instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
								if (_entityStorage != null)
									return _entityStorage.getEnergyStored();
							}
							return 0;
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 10) {
						if ((world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)))).getBlock() == Blocks.AIR
								|| world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))).getBlock() instanceof IPlantable _plant15
										&& _plant15.getPlantType(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))) == PlantType.PLAINS
								|| world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))).getBlock() instanceof IPlantable _plant16
										&& _plant16.getPlantType(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))) == PlantType.DESERT
								|| world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))).getBlock() instanceof IPlantable _plant17
										&& _plant17.getPlantType(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))) == PlantType.BEACH
								|| world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))).getBlock() instanceof IPlantable _plant18
										&& _plant18.getPlantType(world, BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))) == PlantType.CAVE
								|| (world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)))).getBlock() == Blocks.WATER) {
							world.setBlock(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), MfffModBlocks.FORCE_BLOCK.get().defaultBlockState(), 3);
							if (world instanceof ILevelExtension _ext) {
								IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
								if (_entityStorage != null)
									_entityStorage.extractEnergy(10, false);
							}
						}
					}
					j = j + 1;
				}
				i = i + 1;
			}
		}
	}
}
