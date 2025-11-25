package net.b34tzepz.betterbuilding.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TeleporterBlockScreen extends HandledScreen<TeleporterBlockScreenHandler> {
    private static final Identifier TEXTURE =
            Identifier.of(BetterBuilding.MOD_ID, "textures/gui/teleporter_block_gui.png");

    public TeleporterBlockScreen(TeleporterBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX,mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
