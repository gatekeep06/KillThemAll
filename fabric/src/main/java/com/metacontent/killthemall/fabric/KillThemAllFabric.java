package com.metacontent.killthemall.fabric;

import com.metacontent.killthemall.KillThemAll;
import net.fabricmc.api.ModInitializer;

public class KillThemAllFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KillThemAll.init();
    }
}