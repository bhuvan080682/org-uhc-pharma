package org.uhc.ws.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.uhc.ws.model.Drug;
import org.uhc.ws.service.DrugsService;
import org.uhc.ws.service.DrugsServiceImpl;
import org.springframework.http.MediaType;

@RestController
public class DrugsController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DrugsService drugsService;
	
	/*static {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@Inside Static Block@@@@@@@@@@@@@@@@@@@@@@@@");
		DrugsService drugsService1 = new DrugsServiceImpl();
		Drug drug = new Drug();
		Collection<Drug> drugs = new ArrayList<Drug>();
		for(int i=0;i<50;i++){
			drug.setCompany("Company " + i);
			drug.setDrugName("Brand "+ i);
			drugs.add(drug);
		}
		drugsService1.saveDrugs(drugs);
	}*/
	@RequestMapping(value="/welcome",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getWelcomeMessage(){
		String welcomeMsg = "Welcome to UHC Pharma";
		return new ResponseEntity<String>(welcomeMsg,HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value="/api/pharma/drugs",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Drug>> getAllDrugs(){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		Collection<Drug> drugs = drugsService.findAllDrugs();
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Collection<Drug>>(drugs,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/api/pharma/drug/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drug> getDrugById(@PathVariable("id") Long id){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		Drug drug = drugsService.findDrugById(id);
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Drug>(drug,HttpStatus.OK);
	}

	
	@RequestMapping(
			value="/api/pharma/drug",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drug> createDrug(@RequestBody Drug drug){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		Drug drugCreated = drugsService.saveDrug(drug);
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Drug>(drugCreated,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="api/pharma/drugs",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Drug>> createDrugs(@RequestBody Collection<Drug> drugs){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		Collection<Drug> drugsCreated = drugsService.saveDrugs(drugs);
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Collection<Drug>>(drugsCreated,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/pharma/drug",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drug> updateDrug(@RequestBody Drug drug){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		Drug updatedDrug = drugsService.modifyDrug(drug);
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Drug>(updatedDrug,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/api/pharma/drug/{id}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drug> deleteDrug(@PathVariable("id") Long id){
		Long start = System.currentTimeMillis();
		logger.info(start.toString() + ">Greeting Service");
		drugsService.removeDrug(id);
		Long end = System.currentTimeMillis();
		logger.info(end.toString() + "<Greeting Service");
		return new ResponseEntity<Drug>(HttpStatus.NO_CONTENT);
	}
	
}
