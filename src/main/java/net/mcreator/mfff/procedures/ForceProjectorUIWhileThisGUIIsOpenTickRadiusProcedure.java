package net.mcreator.mfff.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.mfff.network.MfffModVariables;

import java.util.HashMap;

public class ForceProjectorUIWhileThisGUIIsOpenTickRadiusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (3 <= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:Radius") ? ((EditBox) guistate.get("text:Radius")).getValue() : "")) {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_radius = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:Radius") ? ((EditBox) guistate.get("text:Radius")).getValue() : "");
				_vars.syncPlayerVariables(entity);
			}
		}
		if (-10 <= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetX") ? ((EditBox) guistate.get("text:OffsetX")).getValue() : "") && 10 >= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetX") ? ((EditBox) guistate.get("text:OffsetX")).getValue() : "")) {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsetx = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetX") ? ((EditBox) guistate.get("text:OffsetX")).getValue() : "");
				_vars.syncPlayerVariables(entity);
			}
			found = true;
		} else {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsetx = entity.getData(MfffModVariables.PLAYER_VARIABLES).transfer_force_offsetx;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (-10 <= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetY") ? ((EditBox) guistate.get("text:OffsetY")).getValue() : "") && 10 >= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetY") ? ((EditBox) guistate.get("text:OffsetY")).getValue() : "") && 0 != new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetY") ? ((EditBox) guistate.get("text:OffsetY")).getValue() : "")) {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsety = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetY") ? ((EditBox) guistate.get("text:OffsetY")).getValue() : "");
				_vars.syncPlayerVariables(entity);
			}
			found = true;
		} else {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsety = entity.getData(MfffModVariables.PLAYER_VARIABLES).transfer_force_offsety;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (-10 <= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetZ") ? ((EditBox) guistate.get("text:OffsetZ")).getValue() : "") && 10 >= new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetZ") ? ((EditBox) guistate.get("text:OffsetZ")).getValue() : "") && 0 != new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:OffsetZ") ? ((EditBox) guistate.get("text:OffsetZ")).getValue() : "")) {
			found = true;
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsetz = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetZ") ? ((EditBox) guistate.get("text:OffsetZ")).getValue() : "");
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				MfffModVariables.PlayerVariables _vars = entity.getData(MfffModVariables.PLAYER_VARIABLES);
				_vars.transfer_force_offsetz = entity.getData(MfffModVariables.PLAYER_VARIABLES).transfer_force_offsetz;
				_vars.syncPlayerVariables(entity);
			}
		}
		ForceprojectorBlockAddedNBTProcedure.execute(world, x, y, z, entity);
	}
}
