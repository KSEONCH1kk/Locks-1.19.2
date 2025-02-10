package melonslise.locks.common.network.toserver;

import melonslise.locks.common.container.LockPickingContainer;
import melonslise.locks.common.init.LocksContainerTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TryPinPacket
{
	private final byte pin;

	public TryPinPacket(byte pin)
	{
		this.pin = pin;
	}

	public static TryPinPacket decode(FriendlyByteBuf buf)
	{
		return new TryPinPacket(buf.readByte());
	}

	public static void encode(TryPinPacket pkt, FriendlyByteBuf buf)
	{
		buf.writeByte(pkt.pin);
	}

	public static void handle(TryPinPacket pkt, Supplier<NetworkEvent.Context> ctx)
	{
		// Use runnable, lambda causes issues with class loading
		ctx.get().enqueueWork(new Runnable()
		{
			@Override
			public void run()
			{
				AbstractContainerMenu container = ctx.get().getSender().containerMenu;
				if(container.getType() == LocksContainerTypes.LOCK_PICKING.get())
					((LockPickingContainer) container).tryPin(pkt.pin);
			}
		});
		ctx.get().setPacketHandled(true);
	}
}