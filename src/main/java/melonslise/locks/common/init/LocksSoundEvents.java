package melonslise.locks.common.init;

import melonslise.locks.Locks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class LocksSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Locks.ID);

	public static final RegistryObject<SoundEvent> KEY_RING = SOUND_EVENTS.register("key_ring", () -> new SoundEvent(new ResourceLocation(Locks.ID, "key_ring")));

	public static final RegistryObject<SoundEvent> LOCK_CLOSE = SOUND_EVENTS.register("lock.close", () -> new SoundEvent(new ResourceLocation(Locks.ID, "lock.close")));
	public static final RegistryObject<SoundEvent> LOCK_OPEN = SOUND_EVENTS.register("lock.open", () -> new SoundEvent(new ResourceLocation(Locks.ID, "lock.open")));
	public static final RegistryObject<SoundEvent> LOCK_RATTLE = SOUND_EVENTS.register("lock.rattle", () -> new SoundEvent(new ResourceLocation(Locks.ID, "lock.rattle")));

	public static final RegistryObject<SoundEvent> PIN_FAIL = SOUND_EVENTS.register("pin.fail", () -> new SoundEvent(new ResourceLocation(Locks.ID, "pin.fail")));
	public static final RegistryObject<SoundEvent> PIN_MATCH = SOUND_EVENTS.register("pin.match", () -> new SoundEvent(new ResourceLocation(Locks.ID, "pin.match")));

	public static final RegistryObject<SoundEvent> SHOCK = SOUND_EVENTS.register("shock", () -> new SoundEvent(new ResourceLocation(Locks.ID, "shock")));

	private LocksSoundEvents() {}

	public static void register() {
		SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}