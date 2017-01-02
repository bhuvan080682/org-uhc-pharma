package org.uhc.ws.service.test;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.uhc.ws.api.DrugsController;
import org.uhc.ws.model.Drug;
import org.uhc.ws.service.DrugsService;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@Transactional
public class DrugsControllerMocksTest extends AbstractControllerTest {
	
	@Mock
	private DrugsService service;
	
	@InjectMocks
	private DrugsController controller;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		setup(controller);
	}

	//simulate the test data
		public Drug getDrugStuData(){
			Drug entity = new Drug(1L, "DOLO 650", "Micro labs");
			return entity;
		}
		
		public Collection<Drug> getDrugListStubData(){
			Collection<Drug> entityList = new ArrayList<Drug>();
			entityList.add(getDrugStuData());
			return entityList;
		}
		
		
	@Test
	public void testGetAllDrugSuccess() throws Exception{
		Collection<Drug> entityList = getDrugListStubData();
		when(service.getAllDrugs()).thenReturn(entityList);
		
		String uri = "/api/pharma/drugs";
		MvcResult result = mvc.perform(
										MockMvcRequestBuilders
										.get(uri)
										.accept(MediaType.APPLICATION_JSON)
										).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		verify(service,times(1)).getAllDrugs();
		
		Assert.assertNotNull("failure - expected http response should not be null" , content);
		Assert.assertEquals("failure -  expected http response state 200",200,status);
		Assert.assertTrue("failure - expected http response body should have value", content.trim().length() > 0);
	}
	
	@Test
	public void testGetDrugByIdSuccess() throws Exception{
		Drug entity = getDrugStuData();
		when(service.getDrugById(1L)).thenReturn(entity);
		String uri = "/api/pharma/drug/{id}";
		Long id = new Long(1);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		verify(service,times(1)).getDrugById(id);
		Assert.assertNotNull("failure -  expected http response not null",content);
		Assert.assertEquals("failure - expected http status code 200",200,status);
	}
	
	@Test
	public void testGetDrugByIdFailure() throws Exception{
		Long id = Long.MAX_VALUE;
		when(service.getDrugById(id)).thenReturn(null);
		String uri = "/api/pharma/drugs/{id}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		//verify(service,times(1)).findDrugById(id);
		Assert.assertNotNull("failure -  expected http response not null",content);
		Assert.assertEquals("failure - expected http status code 404",404,status);
	}
	
	@Test
	public void testGetDrugNotFound() throws Exception{
		Long id = Long.MAX_VALUE;
		when(service.getDrugById(id)).thenReturn(null);
		
		String uri = "/pharma/api/drug/{id}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri,id).
									accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		//verify(service,times(1)).findDrugById(id);
		
		Assert.assertEquals("failure - expected http response code 404", 404 , status);
		Assert.assertTrue("failure - expected http response is null" , content.trim().length() == 0);
	}
	
	
}
