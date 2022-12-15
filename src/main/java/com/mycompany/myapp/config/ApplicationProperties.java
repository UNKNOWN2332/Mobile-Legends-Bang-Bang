package com.mycompany.myapp.config;

import com.mycompany.myapp.service.telegram.dto.TelegramDto;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Mobile Legends.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link tech.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    @Getter
    TelegramDto bot = new TelegramDto();
    // jhipster-needle-application-properties-property
    // jhipster-needle-application-properties-property-getter
    // jhipster-needle-application-properties-property-class
}
