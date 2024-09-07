package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.List;

public class RadialMenuScreen extends Screen {

    private final List<RadialMenuOption> options;
    private static final int ICON_SIZE = 32;

    public RadialMenuScreen(List<RadialMenuOption> options) {
        super(Component.literal("Radial Menu"));
        this.options = options;
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

        boolean closeScreen = false;

        for (int i = 0; i < options.size(); i++) {
            RadialMenuOption option = options.get(i);
            double angle = (i / (double) options.size()) * 2 * Math.PI;
            int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
            int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

            RenderSystem.setShaderTexture(0, option.getIcon());
            guiGraphics.blit(option.getIcon(), itemX - ICON_SIZE / 2, itemY - ICON_SIZE / 2, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);

            if (isMouseOverOption(mouseX, mouseY, itemX, itemY)) {
                closeScreen = true;
                option.getAction().run();
            }
        }

        if (closeScreen) {
            this.onClose();
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private boolean isMouseOverOption(int mouseX, int mouseY, int itemX, int itemY) {
        return mouseX >= itemX - ICON_SIZE / 2 && mouseX <= itemX + ICON_SIZE / 2 && mouseY >= itemY - ICON_SIZE / 2 && mouseY <= itemY + ICON_SIZE / 2;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left-click
            int centerX = this.width / 2;
            int centerY = this.height / 2;
            int radius = 50;

            for (int i = 0; i < options.size(); i++) {
                RadialMenuOption option = options.get(i);
                double angle = (i / (double) options.size()) * 2 * Math.PI;
                int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
                int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

                if (isMouseOverOption((int) mouseX, (int) mouseY, itemX, itemY)) {
                    option.getAction().run();
                    this.onClose();
                    return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}