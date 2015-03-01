package com.zil.samwise.controller;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zil.samwise.model.Character;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@TransactionConfiguration(defaultRollback=true)
@WebAppConfiguration
public class CharacterControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterControllerTest.class);

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private MockHttpSession session;
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	@Test
	public void listAllCharacters() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/character/all");
		request.session(session);
		request.accept(MediaType.APPLICATION_JSON);
		
		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		
		MvcResult returnedValue = result.andReturn();
		MockHttpServletResponse response = returnedValue.getResponse();
		
		List<Character> characterList = mapper.readValue(response.getContentAsString(), new TypeReference<List<Character>>(){});
	
		assertThat(characterList, empty());
	}

}
