package com.metacontent.killthemall.forge;

import com.metacontent.killthemall.KillThemAll;
import net.minecraftforge.fml.common.Mod;

@Mod(KillThemAll.MOD_ID)
public class KillThemAllForge {
    public KillThemAllForge() {
		// Submit our event bus to let architectury register our content on the right time
        KillThemAll.init();
    }
}