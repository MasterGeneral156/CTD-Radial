package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RadialMenuScreen extends Screen {

    ResourceLocation yourTexture = new ResourceLocation(CTDRadial.MOD_ID, "textures/gui/empty_radial.png");
    private final Runnable[] actions;

    public RadialMenuScreen(Runnable[] actions) {
        super(Component.literal("Radial Menu"));
        this.actions = actions;
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

        for (int i = 0; i < actions.length; i++) {
            double angle = (i / (double) actions.length) * 2 * Math.PI;
            int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
            int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

            RenderSystem.setShaderTexture(0, yourTexture);
            guiGraphics.blit(yourTexture, itemX - 16, itemY - 16, 0, 0, 32, 32, 32, 32);

            if (isMouseOverOption(mouseX, mouseY, itemX, itemY)) {
                actions[i].run(); // Execute the action when mouse is over this option
                this.onClose();
            }
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private boolean isMouseOverOption(int mouseX, int mouseY, int itemX, int itemY) {
        int size = 32; // Size of the option (width and height)
        return mouseX >= itemX - size / 2 && mouseX <= itemX + size / 2 && mouseY >= itemY - size / 2 && mouseY <= itemY + size / 2;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left-click
            int centerX = this.width / 2;
            int centerY = this.height / 2;
            int radius = 50;

            for (int i = 0; i < actions.length; i++) {
                double angle = (i / (double) actions.length) * 2 * Math.PI;
                int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
                int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

                if (isMouseOverOption((int) mouseX, (int) mouseY, itemX, itemY)) {
                    actions[i].run(); // Execute the action corresponding to the selected option
                    this.onClose();
                    return true; // Stop further processing of this click event
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}