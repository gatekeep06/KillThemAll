package com.metacontent.killthemall.mixin;

import com.cobblemon.mod.common.api.entity.Despawner;
import com.cobblemon.mod.common.api.spawning.BestSpawner;
import com.cobblemon.mod.common.entity.pokemon.CobblemonAgingDespawner;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.metacontent.killthemall.KillThemAll;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BestSpawner.class)
public abstract class BestSpawnerMixin {
    @SuppressWarnings("unused")
    @Shadow(remap = false)
    private static Despawner<PokemonEntity> defaultPokemonDespawner = new CobblemonAgingDespawner<>(
            KillThemAll.CONFIG.nearDistance, KillThemAll.CONFIG.farDistance,
            KillThemAll.CONFIG.minAgeTicks, KillThemAll.CONFIG.maxAgeTicks,
            PokemonEntity::getTicksLived
    );
}
