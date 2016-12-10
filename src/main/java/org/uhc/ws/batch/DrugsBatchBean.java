package org.uhc.ws.batch;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.uhc.ws.model.Drug;
import org.uhc.ws.service.DrugsService;

@Profile("drug")
@Component
public class DrugsBatchBean {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DrugsService drugsService;
	@Scheduled(cron="0,15 * * * * * ")
	public void cronBatch(){
		logger.info(">executing cronJob");
		Collection<Drug> drugs = drugsService.findAllDrugs();
		logger.info("there are {} drug at the moment" , drugs.size());
		logger.info(">end of cronJob");
	}

}
