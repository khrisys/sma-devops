package fr.cdrochon.garageservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private final GetGarageGlobalConfig getGarageGlobalConfig;
    private final GetGarageParamsConfig getGarageParamsConfig;

    public TestConfigController(GetGarageGlobalConfig getGarageGlobalConfig, GetGarageParamsConfig getGarageParamsConfig) {
        this.getGarageGlobalConfig = getGarageGlobalConfig;
        this.getGarageParamsConfig = getGarageParamsConfig;
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
    public GetGarageGlobalConfig getParamsGlobalConfig() {
        return getGarageGlobalConfig;
    }

    @GetMapping("/garageConfig")
    public GetGarageParamsConfig getClientParamsConfig() {
        return getGarageParamsConfig;
    }

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
