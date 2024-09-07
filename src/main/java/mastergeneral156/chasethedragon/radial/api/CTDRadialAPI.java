package mastergeneral156.chasethedragon.radial.api;

import mastergeneral156.chasethedragon.radial.RadialMenuScreen;
import net.minecraft.client.Minecraft;

public class CTDRadialAPI {
    public static void openRadialMenu(Runnable[] actions) {
        Minecraft.getInstance().setScreen(new RadialMenuScreen(actions));
    }
}
