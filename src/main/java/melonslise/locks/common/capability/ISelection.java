package melonslise.locks.common.capability;

import net.minecraft.core.BlockPos;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public interface ISelection
{
	BlockPos get();

	void set(BlockPos pos);
}