package org.uhc.ws.service;

import java.util.Collection;

import org.uhc.ws.model.Drug;

public interface DrugsService {
	
	Collection<Drug> findAllDrugs();
	Drug findDrugById(Long id);
	Drug saveDrug(Drug drug);
	Drug modifyDrug(Drug drug);
	void removeDrug(Long id);
	Collection<Drug> saveDrugs(Collection<Drug> drugs);
	void evictCache();

}
