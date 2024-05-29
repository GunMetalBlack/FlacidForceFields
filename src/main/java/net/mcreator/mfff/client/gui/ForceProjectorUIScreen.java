package net.mcreator.mfff.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.mfff.world.inventory.ForceProjectorUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ForceProjectorUIScreen extends AbstractContainerScreen<ForceProjectorUIMenu> {
	private final static HashMap<String, Object> guistate = ForceProjectorUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Radius;
	EditBox OffsetX;
	EditBox OffsetY;
	EditBox OffsetZ;

	public ForceProjectorUIScreen(ForceProjectorUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 372;
		this.imageHeight = 165;
	}

	private static final ResourceLocation texture = new ResourceLocation("mfff:textures/screens/force_projector_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Radius.render(guiGraphics, mouseX, mouseY, partialTicks);
		OffsetX.render(guiGraphics, mouseX, mouseY, partialTicks);
		OffsetY.render(guiGraphics, mouseX, mouseY, partialTicks);
		OffsetZ.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Radius.isFocused())
			return Radius.keyPressed(key, b, c);
		if (OffsetX.isFocused())
			return OffsetX.keyPressed(key, b, c);
		if (OffsetY.isFocused())
			return OffsetY.keyPressed(key, b, c);
		if (OffsetZ.isFocused())
			return OffsetZ.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.mfff.force_projector_ui.label_force_projector"), 14, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Radius = new EditBox(this.font, this.leftPos + 15, this.topPos + 25, 118, 18, Component.translatable("gui.mfff.force_projector_ui.Radius")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.Radius").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.Radius").getString());
				else
					setSuggestion(null);
			}
		};
		Radius.setMaxLength(32767);
		Radius.setSuggestion(Component.translatable("gui.mfff.force_projector_ui.Radius").getString());
		guistate.put("text:Radius", Radius);
		this.addWidget(this.Radius);
		OffsetX = new EditBox(this.font, this.leftPos + 15, this.topPos + 52, 118, 18, Component.translatable("gui.mfff.force_projector_ui.OffsetX")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetX").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetX").getString());
				else
					setSuggestion(null);
			}
		};
		OffsetX.setMaxLength(32767);
		OffsetX.setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetX").getString());
		guistate.put("text:OffsetX", OffsetX);
		this.addWidget(this.OffsetX);
		OffsetY = new EditBox(this.font, this.leftPos + 15, this.topPos + 79, 118, 18, Component.translatable("gui.mfff.force_projector_ui.OffsetY")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetY").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetY").getString());
				else
					setSuggestion(null);
			}
		};
		OffsetY.setMaxLength(32767);
		OffsetY.setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetY").getString());
		guistate.put("text:OffsetY", OffsetY);
		this.addWidget(this.OffsetY);
		OffsetZ = new EditBox(this.font, this.leftPos + 15, this.topPos + 106, 118, 18, Component.translatable("gui.mfff.force_projector_ui.OffsetZ")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetZ").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetZ").getString());
				else
					setSuggestion(null);
			}
		};
		OffsetZ.setMaxLength(32767);
		OffsetZ.setSuggestion(Component.translatable("gui.mfff.force_projector_ui.OffsetZ").getString());
		guistate.put("text:OffsetZ", OffsetZ);
		this.addWidget(this.OffsetZ);
	}
}
