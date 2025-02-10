package melonslise.locks.mixin.addlock;

import melonslise.locks.common.util.LocksUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(WorldGenRegion.class)
public class WorldGenRegionMixin {
    @Shadow
    @Final
    private ServerLevel level;

    @Inject(method = "setBlock", at = @At(value = "RETURN", ordinal = 1), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void lockBlock(BlockPos blockPos, BlockState state, int pFlags, int pRecursionLeft, CallbackInfoReturnable<Boolean> cir, ChunkAccess chunkaccess, BlockState pState) {
        ServerLevel level = this.level;
        RandomSource randomSource = RandomSource.create();
        LocksUtil.lockChunk((LevelAccessor) this, level, blockPos, randomSource, chunkaccess);
    }
}
