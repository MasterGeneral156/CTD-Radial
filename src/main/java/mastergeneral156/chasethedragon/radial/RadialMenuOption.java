package mastergeneral156.chasethedragon.radial;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RadialMenuOption {
    private final Runnable action;
    private final ResourceLocation icon;
    private final Component text;

    public RadialMenuOption(Runnable action, ResourceLocation icon, Component text) {
        this.action = action;
        this.icon = icon;
        this.text = text;
    }

    public Runnable getAction() {
        return action;
    }

    public ResourceLocation getIcon() {
        return icon;
    }

    public Component getText() {
        return text;
    }
}
