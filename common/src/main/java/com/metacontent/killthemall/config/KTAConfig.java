package com.metacontent.killthemall.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.metacontent.killthemall.KillThemAll;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class KTAConfig {
    public final float nearDistance;
    public final float farDistance;
    public final int minAgeTicks;
    public final int maxAgeTicks;
    public final DespawnType despawnType;

    private KTAConfig(
            float nearDistance,
            float farDistance,
            int minAgeTicks,
            int maxAgeTicks,
            DespawnType despawnType) {
        this.nearDistance = nearDistance;
        this.farDistance = farDistance;
        this.minAgeTicks = minAgeTicks;
        this.maxAgeTicks = maxAgeTicks;
        this.despawnType = despawnType;
    }

    private KTAConfig() {
        this(2 * 16f, 6 * 16f, 20 * 60 * 1, 20 * 60 * 3, DespawnType.REMOVE);
    }

    public static KTAConfig init() {
        KillThemAll.LOGGER.info("Initializing " + KillThemAll.ID + " config");
        KTAConfig config;
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        File file = new File(FabricLoader.getInstance().getConfigDir() + KillThemAll.CONFIG_PATH);
        file.getParentFile().mkdirs();
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                config = gson.fromJson(fileReader, KTAConfig.class);
            }
            catch (Throwable throwable) {
                KillThemAll.LOGGER.error(throwable.getMessage(), throwable);
                config = new KTAConfig();
            }
        }
        else {
            config = new KTAConfig();
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            gson.toJson(config, printWriter);
        }
        catch (Throwable throwable) {
            KillThemAll.LOGGER.error(throwable.getMessage(), throwable);
        }

        return config;
    }
}
