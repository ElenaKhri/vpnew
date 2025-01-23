package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/config.properties")
public interface DriverConfig extends Config {
    @Key("browser_name")
    @DefaultValue("chrome")
    String browserName();

    @DefaultValue("1920x1080")
    @Key("browser_size")
    String browserSize();

    @DefaultValue("119.0.6045.105")
    @Key("browser_version")
    String browserVersion();

}