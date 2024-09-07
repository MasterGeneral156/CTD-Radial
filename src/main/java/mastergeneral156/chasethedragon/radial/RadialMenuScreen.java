package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RadialMenuScreen extends Screen {
    ResourceLocation yourTexture = new ResourceLocation(CTDRadial.MOD_ID, "textures/gui/empty_radial.png");
    private final Runnable[] actions = new Runnable[8]; // Array to hold actions for each option

    public RadialMenuScreen() {
        super(Component.literal("Radial Menu"));

        // Initialize actions
        actions[0] = () -> doAction("Action 1");
        actions[1] = () -> doAction("Action 2");
        actions[2] = () -> doAction("Action 3");
        actions[3] = () -> doAction("Action 4");
        actions[4] = () -> doAction("Action 5");
        actions[5] = () -> doAction("Action 6");
        actions[6] = () -> doAction("Action 7");
        actions[7] = () -> doAction("Action 8");
    }

    private void doAction(String actionName) {
        System.out.println("Performed: " + actionName);
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

            if (isMouseOverOption(mouseX, mouseY, itemX, itemY)) {
                actions[i].run(); // Execute the action when mouse is over this option
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

            for (int i = 0; i < 8; i++) {
                double angle = (i / 8.0) * 2 * Math.PI;
                int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
                int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

                if (isMouseOverOption((int) mouseX, (int) mouseY, itemX, itemY)) {
                    actions[i].run(); // Execute the action corresponding to the selected option
                    return true; // Stop further processing of this click event
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}