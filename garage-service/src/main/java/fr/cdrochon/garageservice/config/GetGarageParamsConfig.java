package fr.cdrochon.garageservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "garage.params")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GetGarageParamsConfig {

//    private boolean enabled;
    private String x;
    private String name;
}
