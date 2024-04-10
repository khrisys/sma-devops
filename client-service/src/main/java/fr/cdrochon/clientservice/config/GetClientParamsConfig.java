package fr.cdrochon.clientservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "client.params")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GetClientParamsConfig {

//    private boolean enabled;
    private String a;
    private String name;
}
