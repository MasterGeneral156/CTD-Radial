package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RadialMenuScreen extends Screen {

    ResourceLocation yourTexture = new ResourceLocation(CTDRadial.MOD_ID, "textures/gui/empty_radial.png");

    public RadialMenuScreen() {
        super(Component.literal("Radial Menu"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int radius = 50;

        for (int i = 0; i < 8; i++) {
            double angle = (i / 8.0) * 2 * Math.PI;
            int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
            int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

            RenderSystem.setShaderTexture(0, yourTexture);
            guiGraphics.blit(yourTexture, itemX - 16, itemY - 16, 0, 0, 32, 32, 32, 32);
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
}