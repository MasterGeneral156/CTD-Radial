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
