package com.zil.seraphim.controller;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zil.seraphim.demo.model.Character;
import com.zil.seraphim.test.MasterControllerTest;

public class CharacterControllerTest extends MasterControllerTest{
	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterControllerTest.class);

	@Test
	public void listAllCharactersTest() throws Exception {
		insertTestData();
				
		executeMockMvc("/character/all", HttpMethod.GET);
		ResultActions result = getResultAction();
		result.andExpect(status().isOk());
				
		List<Character> characterList = (List<Character>)getReadCollectionValue(Character.class);

		assertThat(characterList, not(empty()));
	}
	
	@Test
	public void retrieveSingleCharacterTest() throws Exception {
		insertTestData();
		
		setMediaType(MediaType.APPLICATION_JSON);
		executeMockMvc("/character/all", HttpMethod.GET);

		ResultActions result = getResultAction();
		result.andExpect(status().isOk());
		
		List<Character> characterList = (List<Character>)getReadCollectionValue(Character.class);
	
		assertThat(characterList, not(empty()));

		Character character = characterList.get(0);
		String expectedCharacterId = character.getCharacterId();

		Integer characterTableId = character.getId();
		
		executeMockMvc("/character/{id}", HttpMethod.GET, characterTableId);
		
		result = getResultAction();
		result.andExpect(status().isOk());
		
		Character actualCharacter = getReadValue(Character.class);
	
		String actualCharacterId = actualCharacter.getCharacterId();
		assertThat(actualCharacterId, is(expectedCharacterId));
	}

	
	@Test
	public void createCharacterTest() throws Exception{
		
		Map<String, String> requestParameters = new HashMap<String, String>();
		requestParameters.put("characterId", "Char0002");
		requestParameters.put("characterLevel", "1");
		requestParameters.put("characterName", "Character Abc");
		
		setMediaType(MediaType.APPLICATION_JSON);
		executeMockMvc("/character", HttpMethod.PUT, requestParameters);
		
		ResultActions result = getResultAction();
		result.andExpect(status().isOk());
		
		Boolean isSaved = getReadValue(Boolean.class);
	
		assertTrue(isSaved);
	}

	private void insertTestData() throws Exception{
		Map<String, String> requestParameters = new HashMap<String, String>();
		requestParameters.put("characterId", "Char0001");
		requestParameters.put("characterLevel", "1");
		requestParameters.put("characterName", "Character Abc");
		
		setMediaType(MediaType.APPLICATION_JSON);
		executeMockMvc("/character", HttpMethod.PUT, requestParameters);
		
		ResultActions result = getResultAction();
		result.andExpect(status().isOk());
		
		Boolean isSaved = getReadValue(Boolean.class);
	
		assertTrue(isSaved);
	}
}
