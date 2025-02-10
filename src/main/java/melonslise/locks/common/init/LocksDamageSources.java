package melonslise.locks.common.init;


import net.minecraft.world.damagesource.DamageSource;

import net.minecraft.world.level.Level;

public final class LocksDamageSources
{
	public static final DamageSource SHOCK = new DamageSource("shock");

	public static DamageSource getDamageSource(Level level, String type) {
		return new DamageSource(type);
	}

	private LocksDamageSources() {}
}