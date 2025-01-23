package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})

public interface ProviderConfig extends Config {
@Key("accoountOek")
    String getAccountOek();

@Key("fio")
    String getFio();

}
