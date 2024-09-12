/**
 * Project:     CTD Radial 1.20
 * File:        mastergeneral156.chasethedragon.radial.api.CTDRadialAPI
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
package mastergeneral156.chasethedragon.radial.api;

import mastergeneral156.chasethedragon.radial.RadialMenuOption;
import mastergeneral156.chasethedragon.radial.RadialMenuScreen;
import net.minecraft.client.Minecraft;

import java.util.List;

public class CTDRadialAPI {

    /**
     * Open the Radial Menu with a list of RadialMenuOptions.
     * Ideally, modders call this rather that the in-code one.
     * Syncing data from Radial menu should be handled with packets.
     * @param options List:RadialMenuOption
     * @apiNote Fire on client-side only
     * @since 1.20.1-0.1.6
     */
    public static void openRadialMenu(List<RadialMenuOption> options) {
        Minecraft.getInstance().setScreen(new RadialMenuScreen(options));
    }
}
