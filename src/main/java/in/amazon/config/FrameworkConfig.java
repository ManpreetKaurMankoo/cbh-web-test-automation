package in.amazon.config;

import java.net.URL;

import org.aeonbits.owner.Config;

import in.amazon.configconverters.StringToBrowserTypeConverter;
import in.amazon.configconverters.StringToRemoteModeTypeConverter;
import in.amazon.configconverters.StringToRunModeTypeConverter;
import in.amazon.configconverters.StringToUrlConverter;
import in.amazon.driver.enums.BrowserType;
import in.amazon.driver.enums.RemoteModeType;
import in.amazon.driver.enums.RunModeType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"file:${user.dir}/src/test/resources/config/FrameworkConfig.properties"
})

public interface FrameworkConfig extends Config {

	@DefaultValue("https://www.amazon.in ")
	@Key("websiteurl")
	String websiteUrl();

	@DefaultValue("CHROME")
	@Key("browsername")
	@ConverterClass(StringToBrowserTypeConverter.class)
	BrowserType browserName();

	@DefaultValue("SELENIUMGRID")
	@Key("remotemode")
	@ConverterClass(StringToRemoteModeTypeConverter.class)
	RemoteModeType remoteMode();

	@DefaultValue("LOCAL")
	@Key("runmode")
	@ConverterClass(StringToRunModeTypeConverter.class)
	RunModeType runMode();

	@Key("selenoidurl")
	@ConverterClass(StringToUrlConverter.class)
	URL selenoidUrl();

	@Key("seleniumgridurl")
	@ConverterClass(StringToUrlConverter.class)
	URL seleniumGridUrl();

}
