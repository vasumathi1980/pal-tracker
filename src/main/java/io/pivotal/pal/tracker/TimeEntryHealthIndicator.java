package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    TimeEntryRepository repository;

    public TimeEntryHealthIndicator(TimeEntryRepository repository){
        this.repository = repository;
    }


    @Override
    public Health health() {

        if(repository.list().size()<5) {
            return Health.up().build();
        }else {
            return Health.down().build();
        }
    }
}
