package melonslise.locks.common.init;

import melonslise.locks.Locks;
import melonslise.locks.common.worldgen.feature.LocksFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LocksFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Locks.ID);

    public static final RegistryObject<LocksFeature> BOULDER_TRAP = FEATURES.register("locks", () -> new LocksFeature(NoneFeatureConfiguration.CODEC));
    public static void register()
    {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
