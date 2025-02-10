package melonslise.locks.common.init;

import melonslise.locks.Locks;
import melonslise.locks.common.item.KeyItem;
import melonslise.locks.common.item.KeyRingItem;
import melonslise.locks.common.item.LockItem;
import melonslise.locks.common.item.LockPickItem;
import melonslise.locks.common.item.MasterKeyItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Locks.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class LocksItems {
    @OnlyIn(Dist.CLIENT)
    public static final CreativeModeTab TAB = new CreativeModeTab(Locks.ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(LocksItems.IRON_LOCK.get());
        }
    };

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Locks.ID);

    public static final RegistryObject<Item> SPRING = ITEMS.register("spring", () -> new Item(new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> WOOD_LOCK_MECHANISM = ITEMS.register("wood_lock_mechanism", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> IRON_LOCK_MECHANISM = ITEMS.register("iron_lock_mechanism", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> STEEL_LOCK_MECHANISM = ITEMS.register("steel_lock_mechanism", () -> new Item(new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> KEY_BLANK = ITEMS.register("key_blank", () -> new Item(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> KEY = ITEMS.register("key", () -> new KeyItem(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> MASTER_KEY = ITEMS.register("master_key", () -> new MasterKeyItem(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> KEY_RING = ITEMS.register("key_ring", () -> new KeyRingItem(1, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> WOOD_LOCK = ITEMS.register("wood_lock", () -> new LockItem(5, 15, 4, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> IRON_LOCK = ITEMS.register("iron_lock", () -> new LockItem(7, 14, 12, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> STEEL_LOCK = ITEMS.register("steel_lock", () -> new LockItem(9, 12, 20, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> GOLD_LOCK = ITEMS.register("gold_lock", () -> new LockItem(6, 22, 6, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> DIAMOND_LOCK = ITEMS.register("diamond_lock", () -> new LockItem(11, 10, 100, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> NETHERITE_LOCK = ITEMS.register("netherite_lock", () -> new LockItem(22, 15, 120, new Item.Properties().tab(TAB)));

    public static final RegistryObject<Item> WOOD_LOCK_PICK = ITEMS.register("wood_lock_pick", () -> new LockPickItem(0.2f, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> IRON_LOCK_PICK = ITEMS.register("iron_lock_pick", () -> new LockPickItem(0.35f,  new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> STEEL_LOCK_PICK = ITEMS.register("steel_lock_pick", () -> new LockPickItem(0.7f,  new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> GOLD_LOCK_PICK = ITEMS.register("gold_lock_pick", () -> new LockPickItem(0.25f, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> DIAMOND_LOCK_PICK = ITEMS.register("diamond_lock_pick", () -> new LockPickItem(0.85f,  new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> NETHERITE_LOCK_PICK = ITEMS.register("netherite_lock_pick", () -> new LockPickItem(0.95f,  new Item.Properties().tab(TAB)));

    private LocksItems() {}

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}