package com.metacontent.killthemall.config;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public enum DespawnType {
    KILL(LivingEntity::kill),
    REMOVE(pokemon -> pokemon.remove(Entity.RemovalReason.DISCARDED)),
    DISCARD(Entity::discard);

    public final DespawnMethod method;

    DespawnType(DespawnMethod method) {
        this.method = method;
    }

    public interface DespawnMethod {
        void despawn(PokemonEntity pokemon);
    }
}
