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
