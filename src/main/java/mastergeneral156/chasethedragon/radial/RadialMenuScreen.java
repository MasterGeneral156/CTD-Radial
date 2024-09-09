package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.ComponentPath;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.FocusNavigationEvent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class RadialMenuScreen extends Screen {

    private final List<RadialMenuOption> options;
    private static final int ICON_SIZE = 32;
    private final KeyMapping closeKey;
    private boolean keyPressed;

    public RadialMenuScreen(List<RadialMenuOption> options) {
        super(Component.literal("Radial Menu"));
        this.options = options;
        this.closeKey = RadialClientEvents.openRadial;
        this.keyPressed = false;
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
        Component hoveredText = Component.translatable("gui.ctdradial.info");

        // Render all radial menu options
        for (int i = 0; i < options.size(); i++) {
            RadialMenuOption option = options.get(i);
            double angle = (i / (double) options.size()) * 2 * Math.PI;
            int itemX = centerX + (int)(Mth.cos((float)angle) * radius);
            int itemY = centerY + (int)(Mth.sin((float)angle) * radius);

            RenderSystem.setShaderTexture(0, option.getIcon());
            guiGraphics.blit(option.getIcon(), itemX - ICON_SIZE / 2, itemY - ICON_SIZE / 2, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);

            if (isMouseOverOption(mouseX, mouseY, itemX, itemY)) {
                hoveredText = option.getText();
            }
        }

        if (hoveredText != null)
            guiGraphics.drawCenteredString(this.font, hoveredText, centerX, centerY - radius - 20, Color.WHITE.getRGB());
        // Check if the key is released and close the screen if so
        if (closeKey.isDown()) {
            this.onClose();
            return; // Exit render method to avoid unnecessary rendering
        }

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private boolean isMouseOverOption(int mouseX, int mouseY, int itemX, int itemY) {
        return mouseX >= itemX - ICON_SIZE / 2 && mouseX <= itemX + ICON_SIZE / 2 && mouseY >= itemY - ICON_SIZE / 2 && mouseY <= itemY + ICON_SIZE / 2;
    }

    @Override
    public Optional<GuiEventListener> getChildAt(double p_94730_, double p_94731_) {
        return super.getChildAt(p_94730_, p_94731_);
    }

    @Override
    public void mouseMoved(double p_94758_, double p_94759_) {
        super.mouseMoved(p_94758_, p_94759_);
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

    @Override
    public boolean mouseReleased(double p_94722_, double p_94723_, int p_94724_) {
        return super.mouseReleased(p_94722_, p_94723_, p_94724_);
    }

    @Override
    public boolean mouseDragged(double p_94699_, double p_94700_, int p_94701_, double p_94702_, double p_94703_) {
        return super.mouseDragged(p_94699_, p_94700_, p_94701_, p_94702_, p_94703_);
    }

    @Override
    public boolean mouseScrolled(double p_94686_, double p_94687_, double p_94688_) {
        return super.mouseScrolled(p_94686_, p_94687_, p_94688_);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.closeKey.matches(keyCode, scanCode)) {
            keyPressed = true;
            return true; // Stop further processing
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (this.closeKey.matches(keyCode, scanCode)) {
            keyPressed = false;
            // Optionally handle the action if needed here
            return true; // Stop further processing
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }
}