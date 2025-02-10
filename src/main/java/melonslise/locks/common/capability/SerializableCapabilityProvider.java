package melonslise.locks.common.capability;

import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

public class SerializableCapabilityProvider<T extends Tag, A extends INBTSerializable<T>> extends CapabilityProvider<A> implements INBTSerializable<T> {
    public SerializableCapabilityProvider(Capability<A> cap, A inst) {
        super(cap, inst);
    }

    @Override
    public T serializeNBT() {

        return this.inst.serializeNBT();
    }

    @Override
    public void deserializeNBT(T nbt) {
        this.inst.deserializeNBT(nbt);
    }
}