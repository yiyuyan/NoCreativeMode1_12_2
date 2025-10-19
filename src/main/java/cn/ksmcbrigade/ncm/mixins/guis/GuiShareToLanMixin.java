package cn.ksmcbrigade.ncm.mixins.guis;

import net.minecraft.client.gui.GuiShareToLan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * &#064;Author: KSmc_brigade
 * &#064;Date: 2025/10/19 上午9:03
 */
@Mixin(GuiShareToLan.class)
public abstract class GuiShareToLanMixin {

    @Shadow private String gameMode;

    @Inject(method = "updateDisplayNames",at = @At("HEAD"))
    public void update(CallbackInfo ci){
        if(gameMode.equalsIgnoreCase("creative")){
            gameMode = "adventure";
        }
    }
}
