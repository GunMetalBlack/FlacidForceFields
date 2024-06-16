package net.mcreator.sff.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.sff.network.SffModVariables;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class ForceProjectorUIWhileThisGUIIsOpenTickProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return "";
		double toReturn = 0;
		if ((entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).should_update_force_ui == true
				&& (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).update_force_gui_counter <= 2) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_radius") != -1 && new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsetx") != -1 && new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsety") != -1 && new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "int_offsetz") != -1) {
				if (guistate.get("text:Radius") instanceof EditBox _tf)
					_tf.setValue((new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "int_radius")) + ""));
				if (guistate.get("text:OffsetX") instanceof EditBox _tf)
					_tf.setValue((new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "int_offsetx")) + ""));
				if (guistate.get("text:OffsetY") instanceof EditBox _tf)
					_tf.setValue((new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "int_offsety")) + ""));
				if (guistate.get("text:OffsetZ") instanceof EditBox _tf)
					_tf.setValue((new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "int_offsetz")) + ""));
				{
					double _setval = (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).update_force_gui_counter + 1;
					entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.update_force_gui_counter = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.should_update_force_ui = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		ReturnCurrentUpkeepProcedure.execute(world, x, y, z);
		return new java.text.DecimalFormat("##").format(new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z))) + "";
	}
}
