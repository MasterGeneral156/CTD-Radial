/**
 * Project:     CTD Radial 1.21
 * File:        mastergeneral156.chasethedragon.radial.RadialMenuOption
 * Author:      TheMasterGeneral
 * Website:     https://github.com/MasterGeneral156/CTD-Radial/
 * License:     Copyright (c) 2024 TheMasterGeneral
 *              Permission is hereby granted, free of charge, to any person obtaining a copy
 *              of this software and associated documentation files (the "Software"), to deal
 *              in the Software without restriction, including without limitation the rights
 * 				to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * 				copies of the Software, and to permit persons to whom the Software is
 * 				furnished to do so, subject to the following conditions:
 *
 * 			    The above copyright notice and this permission notice shall be included in all
 * 				copies or substantial portions of the Software.
 *
 * 				THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * 				IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * 				FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * 				AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * 				LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * 				OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * 				SOFTWARE.
 */
package mastergeneral156.chasethedragon.radial;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RadialMenuOption {
    private final Runnable action;
    private final ResourceLocation icon;
    private final Component text;

    /**
     * Used to create a radial menu option for the Radial Menu.
     * @param action Action to run when clicked. (Use packets for data sync)
     * @param icon ResourceLocation Radial menu item's icon
     * @param text Component Radial menu item's text. Will be displayed.
     */
    public RadialMenuOption(Runnable action, ResourceLocation icon, Component text) {
        this.action = action;
        this.icon = icon;
        this.text = text;
    }

    /**
     * Returns the Radial menu item's action.
     * @return
     */
    public Runnable getAction() {
        return action;
    }

    /**
     * Returns the Radial menu item's icon
     * @return
     */
    public ResourceLocation getIcon() {
        return icon;
    }

    /**
     * Returns the Radial menu item's text component.
     * @return
     */
    public Component getText() {
        return text;
    }
}
