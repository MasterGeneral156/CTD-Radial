package mastergeneral156.chasethedragon.radial.api;

import mastergeneral156.chasethedragon.radial.RadialMenuOption;
import mastergeneral156.chasethedragon.radial.RadialMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class CTDRadialAPI {
    public static void openRadialMenu(List<RadialMenuOption> options) {
        Minecraft.getInstance().setScreen(new RadialMenuScreen(options));
    }
}
