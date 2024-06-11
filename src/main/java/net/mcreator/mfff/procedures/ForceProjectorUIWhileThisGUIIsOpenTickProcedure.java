package net.mcreator.mfff.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.mfff.network.MfffModVariables;

import java.util.HashMap;

public class ForceProjectorUIWhileThisGUIIsOpenTickProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return "";
		double toReturn = 0;
		if (entity.getData(MfffModVariables.PLAYER_VARIABLES).should_update_force_ui == true && entity.getData(MfffModVariables.PLAYER_VARIABLES).update_force_gui_counter <= 2) {
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
					MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
					_vars.update_force_gui_counter = entity.getData(MfffModVariables.PLAYER_VARIABLES).update_force_gui_counter + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.should_update_force_ui = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		ReturnCurrentUpkeepProcedure.execute(world, x, y, z);
		return (new java.text.DecimalFormat("##").format(new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)))) + "";
	}
}
