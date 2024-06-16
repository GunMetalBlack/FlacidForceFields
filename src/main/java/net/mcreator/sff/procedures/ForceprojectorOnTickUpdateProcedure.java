package net.mcreator.sff.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.sff.network.SffModVariables;
import net.mcreator.sff.init.SffModBlocks;
import net.mcreator.sff.SffMod;

import java.util.concurrent.atomic.AtomicInteger;

public class ForceprojectorOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Direction direction = Direction.NORTH;
		String isCurrentBlockSearched = "";
		double i = 0;
		double j = 0;
		double radius = 0;
		double OffsetX = 0;
		double OffsetY = 0;
		double OffsetZ = 0;
		double sudoBlockPosX = 0;
		double sudoBlockPosY = 0;
		double sudoBlockPosZ = 0;
		double upkeepCost = 0;
		double POWER = 0;
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
		upkeepCost = Math.pow(radius + 1, 2) * 6;
		POWER = new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, BlockPos.containing(x, y, z), (int) upkeepCost);
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			int _amount = (int) POWER;
			if (_ent != null)
				_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		if (upkeepCost * SffModVariables.MapVariables.get(world).force_projector_energy_cost * 3 <= new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) && (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "should_rebuild_force_field")) == false) {
			SffMod.LOGGER.info("Building");
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
						if ((world.getBlockState(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ))))
								.is(BlockTags.create(new ResourceLocation("minecraft:will_force")))) {
							world.setBlock(BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ)), SffModBlocks.FORCE_BLOCK.get().defaultBlockState(), 3);
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ));
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("force_projector_position_reference_x", x);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ));
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("force_projector_position_reference_y", y);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(Math.ceil(x + OffsetX + sudoBlockPosX), Math.ceil(y + OffsetY + sudoBlockPosY), Math.ceil(z + OffsetZ + sudoBlockPosZ));
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("force_projector_position_reference_z", z);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							{
								BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
								int _amount = (int) SffModVariables.MapVariables.get(world).force_projector_energy_cost;
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
							}
						}
						j = j + 1;
					}
					i = i + 1;
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("should_rebuild_force_field", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("should_destroy_force_field", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if (upkeepCost != POWER && (new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "should_destroy_force_field")) == true) {
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
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("should_destroy_force_field", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
