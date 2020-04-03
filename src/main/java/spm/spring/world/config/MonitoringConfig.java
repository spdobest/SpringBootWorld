package spm.spring.world.config;

import io.micrometer.appoptics.AppOpticsConfig;
import io.micrometer.appoptics.AppOpticsMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.lang.Nullable;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfig {
    AppOpticsConfig appopticsConfig = new AppOpticsConfig() {
        @Override
        public String apiToken() {
            return "baZHHtUMITZG30_1wBZvlKRYzV7p14VWquc42ATH9qg4TWSWQ5oHxHoqmAkqi0SjTrc1kH4";
        }

        @Override
        @Nullable
        public String get(String k) {
            return null;
        }
    };
    MeterRegistry registry = new AppOpticsMeterRegistry(appopticsConfig, Clock.SYSTEM);
}
