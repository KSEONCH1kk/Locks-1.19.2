package melonslise.locks.mixin;

import melonslise.locks.common.util.LocksUtil;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


import net.minecraft.world.level.Level;

@Mixin(Level.class)
public class WorldMixin {
    @Inject(at = @At("HEAD"), method = "hasNeighborSignal(Lnet/minecraft/core/BlockPos;)Z", cancellable = true)
    private void hasNeighborSignal(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if(LocksUtil.locked((Level) (Object) this, pos))
            cir.setReturnValue(false);
    }
}