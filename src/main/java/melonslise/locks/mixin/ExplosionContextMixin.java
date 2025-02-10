package melonslise.locks.mixin;

import melonslise.locks.common.util.LocksUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;
import java.util.Set;

@Mixin(Explosion.class)
public class ExplosionContextMixin
{
	@Shadow @Final private Level level;

	@Inject(at = @At(value = "INVOKE", target = "Ljava/util/Set;add(Ljava/lang/Object;)Z", shift = At.Shift.AFTER), method = "explode", locals = LocalCapture.CAPTURE_FAILSOFT)
	private void removeBlockSet(CallbackInfo ci, Set<BlockPos> set, int i, int j, int k, int l, double d0, double d1, double d2, double d3, float f, double d4, double d6, double d8, float f1, BlockPos blockpos, BlockState blockstate, FluidState fluidstate, Optional<Float> optional)
	{
		if (LocksUtil.lockedAndRelated(this.level, blockpos)) {
			set.remove(blockpos);
		}
	}
}