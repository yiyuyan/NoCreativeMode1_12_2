package cn.ksmcbrigade.ncm.mixins.loaders;

import cn.ksmcbrigade.ncm.Tags;
import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * &#064;Author: KSmc_brigade
 * &#064;Date: 2025/10/19 上午8:30
 */
@SuppressWarnings("unused")
@IFMLLoadingPlugin.Name(Tags.MOD_ID)
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class MixinLoader implements IFMLLoadingPlugin, IEarlyMixinLoader {
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return "";
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return "";
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return "";
    }

    @Override
    public List<String> getMixinConfigs() {
        return Lists.newArrayList("mixins.ncm.json");
    }
}
