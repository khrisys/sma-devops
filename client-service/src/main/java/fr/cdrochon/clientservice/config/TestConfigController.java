package fr.cdrochon.clientservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Recuperation des parametres du fichier de configuration via un url
 *
 * @see <a href="https://docs.spring.io/spring-boot/docs/3.2.3/reference/html/configuration-metadata.html#appendix.configuration-metadata.annotation-processor">...</a>
 */
@RestController
@RefreshScope
public class TestConfigController {
   
    private final GetParamsGlobalConfig getParamsGlobalConfig;
    private final GetClientParamsConfig getClientParamsConfig;

    public TestConfigController(GetParamsGlobalConfig getParamsGlobalConfig, GetClientParamsConfig getClientParamsConfig) {
        this.getParamsGlobalConfig = getParamsGlobalConfig;
        this.getClientParamsConfig = getClientParamsConfig;
    }

//    //niveau client-dev
//    @Value("${spring.application.name}")
//    private String name;
//    //niveau service
//    @Value("${spring.cloud.config.enabled}")
//    private boolean enabled;
//
//    @GetMapping("/valuesConfig")
//    public Map<Object, Object> getValues() {
//        return Map.of("enabled", enabled, "name", name);
//    }

    @GetMapping("/globalConfig")
    public GetParamsGlobalConfig getParamsGlobalConfig() {
        return getParamsGlobalConfig;
    }

    @GetMapping("/clientConfig")
    public GetClientParamsConfig getClientParamsConfig() {
        return getClientParamsConfig;
    }
}
