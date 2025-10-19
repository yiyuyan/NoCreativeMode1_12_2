package cn.ksmcbrigade.ncm.mixins;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandGameMode;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;

/**
 * &#064;Author: KSmc_brigade
 * &#064;Date: 2025/10/19 上午8:26
 */
@Mixin(CommandGameMode.class)
public class CommandGameModeMixin {
    @Inject(method = "getGameModeFromCommand",at = @At("RETURN"),cancellable = true)
    private void gameMode(ICommandSender sender, String gameModeString, CallbackInfoReturnable<GameType> cir){
        if(cir.getReturnValue().equals(GameType.CREATIVE)){
            cir.setReturnValue(GameType.NOT_SET);
        }
    }

    @Inject(method = "getTabCompletions",at = @At(value = "RETURN"),cancellable = true)
    public void getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos,CallbackInfoReturnable<List<String>> cir){
        if(args.length==1){
            cir.setReturnValue(CommandBase.getListOfStringsMatchingLastWord(args,"survival", "adventure", "spectator"));
        }
    }
}
