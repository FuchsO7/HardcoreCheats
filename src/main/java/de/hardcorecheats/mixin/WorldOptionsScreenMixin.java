package de.hardcorecheats.mixin;

import net.minecraft.client.gui.screens.WorldOptionsScreen;
import net.minecraft.client.server.IntegratedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(WorldOptionsScreen.class)
public class WorldOptionsScreenMixin {
    @Redirect(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/server/IntegratedServer;isHardcore()Z"),
            method = "createAllowCommandsButton"
    )
    private static boolean hardcorecheats$enableCommandsButtonInHardcore(IntegratedServer instance) {
        return false;
    }

    @Redirect(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/server/IntegratedServer;isHardcore()Z"),
            method = "updateButton"
    )
    private static boolean hardcorecheats$enableGameRuleAndGameModeButtonInHardcore(IntegratedServer instance) {
        return false;
    }
}

