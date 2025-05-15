package net.hunger_tweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hunger_tweaks.HungerTweaksMod;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = HungerManager.class, priority = 100) // Higher priority so exhaust is modified first
public class HungerManagerMixin {
    @ModifyVariable(method = "addExhaustion", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private float modifyExhaustion(float exhaustion) {
        return exhaustion * HungerTweaksMod.getConfig().exhaust_rate;
    }

    @WrapOperation(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;heal(F)V"))
    private void modifyHealing(PlayerEntity instance, float value, Operation<Void> original) {
        original.call(instance, value * HungerTweaksMod.getConfig().healing_rate);
    }
}
