package mastergeneral156.chasethedragon.radial;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public record RadialMenuOption(Runnable action, Identifier icon, Component text) {
    public RadialMenuOption {
        if (action == null) throw new IllegalArgumentException("Action cannot be null");
        if (icon == null) throw new IllegalArgumentException("Icon cannot be null");
        if (text == null) throw new IllegalArgumentException("Text cannot be null");
    }
}