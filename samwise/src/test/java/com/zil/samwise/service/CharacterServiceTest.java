package com.zil.samwise.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.empty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.zil.samwise.model.Character;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@TransactionConfiguration(defaultRollback=true)
public class CharacterServiceTest {

	@Autowired
	CharacterService characterService;
	
	@Test
	public void listAllCharacters() {
		List<Character> showAllCharacters = characterService.showAllCharacters();
		assertThat(showAllCharacters, empty());
	}

}
