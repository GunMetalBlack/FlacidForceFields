package net.mcreator.sff.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.sff.network.SffModVariables;
import net.mcreator.sff.init.SffModBlocks;
import net.mcreator.sff.SffMod;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraftforge.event.level.ExplosionEvent.Detonate;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ReplaceForceBlockOnExplosionProcedure {
	@SubscribeEvent
	public static void onExplode(ExplosionEvent.Detonate event) {
		LevelAccessor world = event.getLevel();
		
		SffMod.LOGGER.info("is found shield block on explo");
		List<BlockPos> toRemove = new ArrayList();
		for(BlockPos affectedPos : event.getAffectedBlocks()) {
			double x = affectedPos.getX();
			double y = affectedPos.getY();
			double z = affectedPos.getZ();
			SffMod.LOGGER.info("I AM THE FUCKING CAPTAIN NOWWWWWWWW");
			SffMod.LOGGER.info("SffModBlocks.FORCE_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() = " + world.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			if (SffModBlocks.FORCE_BLOCK.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				SffMod.LOGGER.info("Sheild");
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_x"), new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_y"), new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_z"))) >= SffModVariables.MapVariables.get(world).force_projector_energy_cost) {
					SffMod.LOGGER.info("If works");
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_x"), new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_y"), new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "force_projector_position_reference_z")));
						int _amount = (int) SffModVariables.MapVariables.get(world).force_projector_energy_cost;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					// world.setBlock(BlockPos.containing(x, y, z), SffModBlocks.FORCE_BLOCK.get().defaultBlockState(), 3);
					toRemove.add(affectedPos);
				}
			}
		}
		for(BlockPos toSave : toRemove) {
			SffMod.LOGGER.info("i will hunt you down and kill you ya worthless piece of shit");
			event.getAffectedBlocks().remove(toSave);
		}
	}
}
