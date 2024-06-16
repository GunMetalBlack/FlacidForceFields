package net.mcreator.sff.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.sff.network.SffModVariables;

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
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:Radius") ? ((EditBox) guistate.get("text:Radius")).getValue() : "");
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_radius = _setval;
					capability.syncPlayerVariables(entity);
				});
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
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetX") ? ((EditBox) guistate.get("text:OffsetX")).getValue() : "");
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsetx = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			found = true;
		} else {
			{
				double _setval = (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetx;
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsetx = _setval;
					capability.syncPlayerVariables(entity);
				});
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
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetY") ? ((EditBox) guistate.get("text:OffsetY")).getValue() : "");
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsety = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			found = true;
		} else {
			{
				double _setval = (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsety;
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsety = _setval;
					capability.syncPlayerVariables(entity);
				});
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
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:OffsetZ") ? ((EditBox) guistate.get("text:OffsetZ")).getValue() : "");
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsetz = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = (entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SffModVariables.PlayerVariables())).transfer_force_offsetz;
				entity.getCapability(SffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.transfer_force_offsetz = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		ForceprojectorBlockAddedNBTProcedure.execute(world, x, y, z, entity);
	}
}
