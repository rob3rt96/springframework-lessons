package com.robertp1.springframeworktheactuator.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// By implementing the HealthIndicator interface, we can extend the default info shown in /actuator/health endpoint
// with some other custom indicators.
@Component
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                .withDetail("abc", "bcd")
                .build();
    }
}
