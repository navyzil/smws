package com.zil.seraphim.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zil.seraphim.demo.dao.CharacterDao;
import com.zil.seraphim.demo.model.Character;
import com.zil.seraphim.test.impl.MasterTestImpl;

public class CharacterDaoTest extends MasterTestImpl{

	@Autowired
	CharacterDao characterDao;
	
	@Override
	public void doSetup() {
		Character character = new Character();
		character.setCharacterId("Char0001");
		character.setCharacterLevel("1");
		character.setCharacterName("Character Abc");
		
		boolean isInserted = characterDao.createCharacter(character);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void listAllCharacterTest() {
		List<Character> showAllCharacters = characterDao.showAllCharacters();
		assertThat(showAllCharacters, not(empty()));
	}
	
	@Test
	public void createCharacterTest(){
		Character character = new Character();
		character.setCharacterId("Char0002");
		character.setCharacterLevel("1");
		character.setCharacterName("Character Abc");
		
		boolean isInserted = characterDao.createCharacter(character);
		assertThat(isInserted, is(true));
	}
	
	@Test
	public void retrieveSingleCharacterTest(){
		List<Character> showAllCharacters = characterDao.showAllCharacters();
		assertThat(showAllCharacters, not(empty()));

		Character character = showAllCharacters.get(0);
		String expectedCharacterId = character.getCharacterId();
		
		Character actualCharacter = characterDao.showCharacter(character.getId());
		String actualCharacterId = actualCharacter.getCharacterId();
		assertThat(actualCharacterId, is(expectedCharacterId));
	}

}
