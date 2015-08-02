package com.zil.seraphim.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zil.seraphim.demo.model.Character;
import com.zil.seraphim.demo.service.CharacterService;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class CharacterServiceTest extends MasterTestImpl{

	@Autowired
	CharacterService characterService;
	
	@Override
	public void doSetup() {
		Character character = new Character();
		character.setCharacterId("Char0001");
		character.setCharacterLevel("1");
		character.setCharacterName("Character Abc");
		
		boolean isInserted = characterService.createCharacter(character);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void listAllCharactersTest() {
		List<Character> showAllCharacters = characterService.showAllCharacters();
		assertThat(showAllCharacters, not(empty()));
	}
	
	@Test
	public void createCharacterTest(){
		Character character = new Character();
		character.setCharacterId("Char0002");
		character.setCharacterLevel("1");
		character.setCharacterName("Character Abc");
		
		boolean isInserted = characterService.createCharacter(character);
		assertThat(isInserted, is(true));
	}

	@Test
	public void retrieveSingleCharacterTest(){
		List<Character> showAllCharacters = characterService.showAllCharacters();
		assertThat(showAllCharacters, not(empty()));

		Character character = showAllCharacters.get(0);
		String expectedCharacterId = character.getCharacterId();
		
		Character actualCharacter = characterService.showCharacter(character.getId());
		String actualCharacterId = actualCharacter.getCharacterId();
		assertThat(actualCharacterId, is(expectedCharacterId));
	}

}
