package org.uhc.ws.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.uhc.ws.model.Drug;
import org.uhc.ws.service.DrugsService;

@Transactional
public class DrugControllerTest extends AbstractControllerTest{

	@Autowired
	private DrugsService drugsService;
	
	@Before
	public void setup(){
		super.setup();
		drugsService.evictCache();
	}
	
	@Test
	public void testgetAllDrugs() throws Exception{
		String uri = "/api/pharma/drugs";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertNotNull("failure - expected response not null" , content);
		Assert.assertTrue("failure - expected result not empty", content.trim().length() > 0);
		Assert.assertEquals("failure - expected status code is 200 ", 200, status);
	}
	
	@Test
	public void testGetDrugByIdSuccess() throws Exception{
		
		String uri = "/api/pharma/drug/{id}";
		Long id = new Long(21);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertNotNull("failure - expected response not null" , content);
		Assert.assertTrue("failure - expected result not empty", content.trim().length() > 0);
		Assert.assertEquals("failure - expected status code is 200 ", 200, status);
		
	}
	
	@Test
	public void testCreateDrug() throws Exception{
		Drug entity = new Drug(null,"Rantac 150", "Wochakrd");
		String jsonInput = mapToJson(entity);
		String uri = "/api/pharma/drug";
		MvcResult result = mvc.perform(
									MockMvcRequestBuilders
									.post(uri)
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON)
									.content(jsonInput)
									).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertNotNull("failure - expected http response not null",content);
		Assert.assertTrue("failure - expcted http should have value",content.trim().length() > 0);
		Assert.assertEquals("failure - expected http status 201", 201,status);
	}
	
	@Test
	public void testRemoveDrug() throws Exception{
		String uri = "/api/pharma/drug/{id}";
		Long id = new Long(2);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri,id).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("failure - expected http response state 204 ", 204, status);
	}

	
}
