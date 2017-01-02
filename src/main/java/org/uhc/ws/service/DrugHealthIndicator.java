package org.uhc.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DrugHealthIndicator implements HealthIndicator {

	@Autowired
	private DrugsService service;
	@Override
	public Health health() {
		int size = service.getAllDrugs().size();
		if(size == 0)
			return Health.down().withDetail("count", 0).build();
		return Health.up().withDetail("count", size).build();
	}

}
