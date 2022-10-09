package in.amazon.driver.factories;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import in.amazon.driver.IDriver;
import in.amazon.driver.driveimpl.LocalDriverImpl;
import in.amazon.driver.enums.RunModeType;

public final class DriverFactory {

	private DriverFactory() {}

	private static final Map<RunModeType, Supplier<IDriver>> MAP = new EnumMap<>(RunModeType.class);
	private static final Supplier<IDriver> LOCAL = LocalDriverImpl::new;

	static {
		MAP.put(RunModeType.LOCAL, LOCAL);
	}

	public static IDriver getDriver(RunModeType runMode) {
		return MAP.get(runMode).get();
	}

}
