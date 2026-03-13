/**
 * CTD Radial 26.1
 * File:    mastergeneral156.chasethedragon.radial.RadialMenuScreen
 * Author:  TheMasterGeneral
 * Source:  https://github.com/MasterGeneral156/CTD-Radial
 * License: MIT License
 *
 * Copyright (c) 2026 TheMasterGeneral
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mastergeneral156.chasethedragon.radial;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class RadialMenuScreen extends Screen {

    private final List<RadialMenuOption> options;
    private static final int ICON_SIZE = 32;
    private final KeyMapping closeKey;

    public RadialMenuScreen(List<RadialMenuOption> options) {
        super(Component.translatable("title.ctdradial.radial.default"));
        this.options = options;
        this.closeKey = CTDRadialClient.openRadial;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        if (options.isEmpty()) return;

        this.renderBlurredBackground(graphics);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int radius = 50;

        Component hoveredText = Component.translatable("gui.ctdradial.info");

        for (int i = 0; i < options.size(); i++) {
            RadialMenuOption option = options.get(i);

            //double angle = (i / (double) options.size()) * (Math.PI * 2);
            double angle = ((i + 0.5) / options.size()) * (Math.PI * 2);
            int itemX = centerX + (int)(Mth.cos((float) angle) * radius);
            int itemY = centerY + (int)(Mth.sin((float) angle) * radius);

            graphics.blit(
                    option.icon(),
                    itemX - ICON_SIZE / 2,
                    itemY - ICON_SIZE / 2,
                    0,
                    0,
                    ICON_SIZE,
                    ICON_SIZE,
                    ICON_SIZE,
                    ICON_SIZE
            );

            if (isMouseOverOption(mouseX, mouseY, itemX, itemY)) {
                hoveredText = option.text();
            }
        }

        graphics.drawCenteredString(
                this.font,
                hoveredText,
                centerX,
                centerY + 70,
                0xFFFFFF
        );

        // Close radial when key released
        if (!closeKey.isDown()) {
            this.onClose();
        }

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    private boolean isMouseOverOption(int mouseX, int mouseY, int itemX, int itemY) {
        return mouseX >= itemX - ICON_SIZE / 2 &&
                mouseX <= itemX + ICON_SIZE / 2 &&
                mouseY >= itemY - ICON_SIZE / 2 &&
                mouseY <= itemY + ICON_SIZE / 2;
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean p_434187_) {

        if (event.button() == GLFW.GLFW_MOUSE_BUTTON_LEFT) {

            int centerX = this.width / 2;
            int centerY = this.height / 2;
            int radius = 50;

            for (int i = 0; i < options.size(); i++) {
                RadialMenuOption option = options.get(i);

                //double angle = (i / (double) options.size()) * (Math.PI * 2);
                double angle = ((i + 0.5) / options.size()) * (Math.PI * 2);

                int itemX = centerX + (int)(Mth.cos((float) angle) * radius);
                int itemY = centerY + (int)(Mth.sin((float) angle) * radius);

                if (isMouseOverOption((int) event.x(), (int) event.y(), itemX, itemY)) {
                    option.action().run();
                    this.onClose();
                    return true;
                }
            }
        }

        return super.mouseClicked(event, p_434187_);
    }
}