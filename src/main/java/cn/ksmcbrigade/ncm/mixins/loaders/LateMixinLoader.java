package cn.ksmcbrigade.ncm.mixins.loaders;

import com.google.common.collect.Lists;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.List;

/**
 * &#064;Author: KSmc_brigade
 * &#064;Date: 2025/10/19 上午8:32
 */
@SuppressWarnings("unused")
public class LateMixinLoader implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Lists.newArrayList("mixins.ncm.json");
    }
}
