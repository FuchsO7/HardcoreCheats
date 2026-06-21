package de.hardcorecheats.mixin;

import net.minecraft.client.gui.screens.options.WorldOptionsScreen;
import net.minecraft.client.server.IntegratedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(WorldOptionsScreen.class)
public class WorldOptionsScreenMixin {
    @Redirect(method = "createAllowCommandsButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/server/IntegratedServer;isHardcore()Z"))
    private static boolean enableCommandsButtonInHardcore(IntegratedServer instance) {
        return false;
    }

    @Redirect(method = "updateButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/server/IntegratedServer;isHardcore()Z"))
    private static boolean enableGameRuleAndGameModeButtonInHardcore(IntegratedServer instance) {
        return false;
    }
}

