package cn.ksmcbrigade.ncm;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.GameType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class NCMMod {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Hello From {}!", Tags.MOD_NAME);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event){
        if(event.player instanceof EntityPlayerMP){
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            if(player.interactionManager.getGameType() == GameType.CREATIVE) {
                GameType type = GameType.SURVIVAL;
                if(player.getServer()!=null) type = player.server.getGameType();
                if(type==GameType.CREATIVE) type = GameType.NOT_SET;
                player.setGameType(type);
            }
        }

    }
}
