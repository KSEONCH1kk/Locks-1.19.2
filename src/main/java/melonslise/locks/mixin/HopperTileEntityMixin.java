package melonslise.locks.mixin;

import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HopperBlockEntity.class)
public class HopperTileEntityMixin {
//    @Inject(at = @At("HEAD"), method = "getContainerAt(Lnet/minecraft/world/level/Level;DDD)Lnet/minecraft/world/Container;", cancellable = true)
//    private static void getContainerAt(Level world, double x, double y, double z, CallbackInfoReturnable<Inventory> cir) {
//        if (LocksUtil.locked(world, new BlockPos((int) x, (int) y, (int) z))) {
//			cir.setReturnValue(null);
//		}
//    }
}