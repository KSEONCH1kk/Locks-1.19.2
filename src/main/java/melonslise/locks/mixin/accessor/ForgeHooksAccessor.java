package melonslise.locks.mixin.accessor;

import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Deque;

@Mixin(ForgeHooks.class)
public interface ForgeHooksAccessor
{
	@Accessor(remap = false)
	static ThreadLocal<Deque> getLootContext()
	{
		return null;
	}
}