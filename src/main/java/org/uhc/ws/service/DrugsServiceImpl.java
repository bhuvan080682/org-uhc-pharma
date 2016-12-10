package org.uhc.ws.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.uhc.ws.model.Drug;
import org.uhc.ws.repository.DrugRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class DrugsServiceImpl implements DrugsService{
	
	
	@Autowired
	private DrugRepository drugRepository;
	
	@Override
	@Cacheable("drugs")
	public Collection<Drug> findAllDrugs() {
		Collection<Drug> drugs = drugRepository.findAll();
		return drugs;
	}

	@Override
	@Cacheable(value="drugs",key="#id")
	public Drug findDrugById(Long id) {
		Drug drug =drugRepository.findOne(id);
		return drug;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@CachePut(value="drugs",key="#result.id")
	public Drug saveDrug(Drug drug) {
		if(drug.getId() != null){
			return null;
		}
		Drug drugCreated =drugRepository.save(drug);
		if(drug.getId() == 4L){
			throw new RuntimeException("thrown runtime exception");
		}
		return drugCreated;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@CachePut(value="drugs",key="#drug.id")
	public Drug modifyDrug(Drug drug) {
		if(drug.getId() == null){
			return null;
		}
		Drug updatedDrug = drugRepository.save(drug);
		return updatedDrug;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@CacheEvict(value="drugs",key="#id")
	public void removeDrug(Long id) {
		drugRepository.delete(id);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Collection<Drug> saveDrugs(Collection<Drug> drugs){
		Collection<Drug> drugsCreated = new ArrayList<Drug>();
		for(Drug drug : drugs){
			Drug drugCreated = drugRepository.save(drug);
			/*if(drugCreated.getId()==4L){
				throw new RuntimeException("exception thrown when id = 4");
			}*/
			drugsCreated.add(drugCreated);
			
		}
		return drugsCreated;
	}

	@Override
	@CacheEvict(value="drugs",allEntries=true)
	public void evictCache(){
		
	}
}
