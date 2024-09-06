package mastergeneral156.chasethedragon.radial;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jline.keymap.KeyMap;
import org.lwjgl.glfw.GLFW;

@Mod(CTDRadial.MOD_ID)
public class CTDRadial {
    public static final String MOD_ID = "ctdradial";

    public CTDRadial() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}