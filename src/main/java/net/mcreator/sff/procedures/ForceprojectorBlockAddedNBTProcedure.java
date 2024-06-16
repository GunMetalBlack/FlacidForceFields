package net.mcreator.sff.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.sff.network.SffModVariables;
import net.mcreator.sff.SffMod;

public class ForceprojectorBlockAddedNBTProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "int_radius") == 0 && (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_radius == 3)) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_radius") != (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_radius || new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsetx") != (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetx || new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsety") != (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsety || new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsetz") != (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetz) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("should_rebuild_force_field", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				SffMod.LOGGER.info("DEBUGGGGG");
				SffMod.LOGGER.info("----------------------------------");
				SffMod.LOGGER.info(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "int_radius"));
				SffMod.LOGGER.info((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_radius);
				SffMod.LOGGER.info("----------------------------------");
				SffMod.LOGGER.info(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "int_offsetx"));
				SffMod.LOGGER.info((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetx);
				SffMod.LOGGER.info("----------------------------------");
				SffMod.LOGGER.info(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "int_offsety"));
				SffMod.LOGGER.info((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsety);
				RemoveCurrentForceFieldProcedure.execute(world, x, y, z);
			}
		} else {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_radius") == 0 && (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_radius == 3) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("should_rebuild_force_field", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("should_rebuild_force_field", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("int_radius", ((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_radius));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("int_offsetx", ((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetx));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("int_offsety", ((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsety));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("int_offsetz", ((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetz));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			boolean _setval = true;
			entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.is_force_gui_values = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
