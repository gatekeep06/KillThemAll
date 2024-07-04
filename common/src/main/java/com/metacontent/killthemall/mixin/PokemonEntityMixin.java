package com.metacontent.killthemall.mixin;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.metacontent.killthemall.KillThemAll;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PokemonEntity.class)
public abstract class PokemonEntityMixin {
    @Redirect(method = "checkDespawn", at = @At(value = "INVOKE", target = "Lcom/cobblemon/mod/common/entity/pokemon/PokemonEntity;discard()V"))
    protected void redirectDiscard(PokemonEntity instance) {
        KillThemAll.CONFIG.despawnType.method.despawn(instance);
    }
}
