package org.uhc.ws.service.test;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.uhc.ws.model.Drug;
import org.uhc.ws.service.DrugsService;

@Transactional
public class DrugsServiceTest extends AbstractTest{
	
	@Autowired
	private DrugsService service ;
	
	@Before
	public void setup(){
		//evict cache is used to clean up the service before each test method execution
		service.evictCache();
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testGetDrugsSuccess(){
		Collection<Drug> entityList = service.findAllDrugs();
		Assert.assertNotNull("failure - expected drug list not null",entityList);
		Assert.assertEquals("failure - expected drug size is 40", 40,entityList.size());
	}
	
	@Test
	public void testGetDrugByIdSuccess(){
		Long id = new Long(1);
		Drug entity = service.findDrugById(id);
		Assert.assertNotNull("failure - expected drug list not null" , entity);
		Assert.assertEquals("failure - expected drug name is DOLO 650", "DOLO 650" , entity.getDrugName());
	}
	
	//negative scenario
	@Ignore
	@Test
	public void testGetDrugByIdFailure(){
		Drug entity = service.findDrugById(45L);
		Assert.assertNull("failure : expected drug is null", entity);
		Assert.assertEquals("failure - expected id null", null,entity.getId());
		
	}
	
	@Test
	public void testCreateDrugSuccess(){
		Collection<Drug> entityListBefore = service.findAllDrugs();
		int sizeBefore = entityListBefore.size();
		Drug entityToCreate = new Drug(null, "Manforce", "MakKind");
		Drug createdentity = service.saveDrug(entityToCreate);
		Collection<Drug> entityListAfter = service.findAllDrugs();
		Assert.assertNotNull("failed - expected adding one more drug " ,createdentity);
		Assert.assertEquals("failed - max id found in drug list is 40", 40 , sizeBefore);
		Assert.assertTrue("failed - expected is value 41 ", createdentity.getId() > 40);
			
	}
	
	@Test
	public void testRemoveDrug(){
		Collection<Drug> entityListBefore = service.findAllDrugs();
		Assert.assertEquals("failure - expected entity list size 40", 40 , entityListBefore.size());
		service.removeDrug(1L);
		Collection<Drug> entityListAfter = service.findAllDrugs();
		//Assert.assertEquals("failure - expected entity list size 39", 39 , entityListAfter.size());
		
	}

}
