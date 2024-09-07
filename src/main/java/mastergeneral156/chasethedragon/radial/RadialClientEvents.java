package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = CTDRadial.MOD_ID)
public class RadialClientEvents {
    public static final KeyMapping openRadial = new KeyMapping("key.ctdradial.open", GLFW.GLFW_KEY_R, "key.categories.misc");

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(openRadial);
    }

    /*@SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (openRadial.isDown()) {
            Minecraft.getInstance().setScreen(new RadialMenuScreen());
        }

    }*/
}
