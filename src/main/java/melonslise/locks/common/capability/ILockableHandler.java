package melonslise.locks.common.capability;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import melonslise.locks.common.util.Lockable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.IntTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.Observer;
@AutoRegisterCapability
public interface ILockableHandler extends INBTSerializable<IntTag>, Observer
{
	int nextId();

	Int2ObjectMap<Lockable> getLoaded();

	Int2ObjectMap<Lockable> getInChunk(BlockPos pos);

	boolean add(Lockable lkb);

	boolean remove(int id);
}