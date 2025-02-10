package melonslise.locks.client.init;

import melonslise.locks.Locks;
import melonslise.locks.common.init.LocksItems;
import melonslise.locks.common.item.LockItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

@OnlyIn(Dist.CLIENT)
public final class LocksItemModelsProperties
{
	private LocksItemModelsProperties() {}

	public static void register()
	{
		ItemProperties.register(LocksItems.KEY_RING.get(), new ResourceLocation(Locks.ID, "keys"), (stack, world, entity, speed) ->
		{
			return stack.getCapability(ForgeCapabilities.ITEM_HANDLER)
				.map(inv ->
				{
					int keys = 0;
					for(int a = 0; a < inv.getSlots(); ++a)
						if(!inv.getStackInSlot(a).isEmpty())
							++keys;
					return (float) keys / inv.getSlots();
				})
				.orElse(0f);
		});
		ResourceLocation id = new ResourceLocation(Locks.ID, "open");
		ItemPropertyFunction getter = (stack, world, entity, speed) -> LockItem.isOpen(stack) ? 1f : 0f;
		ItemProperties.register(LocksItems.WOOD_LOCK.get(), id, getter);
		ItemProperties.register(LocksItems.IRON_LOCK.get(), id, getter);
		ItemProperties.register(LocksItems.STEEL_LOCK.get(), id, getter);
		ItemProperties.register(LocksItems.GOLD_LOCK.get(), id, getter);
		ItemProperties.register(LocksItems.DIAMOND_LOCK.get(), id, getter);
		ItemProperties.register(LocksItems.NETHERITE_LOCK.get(), id, getter);
	}
}