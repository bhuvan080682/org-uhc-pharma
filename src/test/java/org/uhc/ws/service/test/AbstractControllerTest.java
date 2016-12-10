package org.uhc.ws.service.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.uhc.ws.api.DrugsController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
public abstract class AbstractControllerTest extends AbstractTest {
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	protected void setup(){
      mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	protected void setup(DrugsController controller){
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	

}
