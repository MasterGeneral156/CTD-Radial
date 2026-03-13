/**
 * CTD Radial 26.1
 * File:    mastergeneral156.chasethedragon.radial.CTDRadialClient
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;


@Mod(value = CTDRadial.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CTDRadial.MODID, value = Dist.CLIENT)
public class CTDRadialClient {
    public CTDRadialClient(ModContainer container) {
    }

    public static final KeyMapping openRadial = new KeyMapping("key.ctdradial.open", GLFW.GLFW_KEY_R, KeyMapping.Category.GAMEPLAY);

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(openRadial);
    }
}
