package cn.ksmcbrigade.ncm.mixins;

import net.minecraft.world.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * &#064;Author: KSmc_brigade
 * &#064;Date: 2025/10/19 上午8:46
 */
@Mixin(GameType.class)
public class GameTypeMixin {

    @Inject(method = "isCreative",at = @At("RETURN"),cancellable = true)
    public void creative(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }

    @Inject(method = "parseGameTypeWithDefault(Ljava/lang/String;Lnet/minecraft/world/GameType;)Lnet/minecraft/world/GameType;",at = @At("RETURN"),cancellable = true)
    private static void parseGameTypeWithDefaultByName(String targetName, GameType fallback, CallbackInfoReturnable<GameType> cir){
        if(cir.getReturnValue()==GameType.CREATIVE){
            if(fallback!=GameType.CREATIVE){
                cir.setReturnValue(fallback);
            }
            else{
                cir.setReturnValue(GameType.NOT_SET);
            }
        }
    }

    @Inject(method = "parseGameTypeWithDefault(ILnet/minecraft/world/GameType;)Lnet/minecraft/world/GameType;",at = @At("RETURN"),cancellable = true)
    private static void parseGameTypeWithDefaultById(int targetId, GameType fallback, CallbackInfoReturnable<GameType> cir){
        if(cir.getReturnValue()==GameType.CREATIVE){
            if(fallback!=GameType.CREATIVE){
                cir.setReturnValue(fallback);
            }
            else{
                cir.setReturnValue(GameType.NOT_SET);
            }
        }
    }
}
